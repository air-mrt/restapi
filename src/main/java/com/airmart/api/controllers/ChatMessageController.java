package com.airmart.api.controllers;

import com.airmart.api.config.ApiConstants;
import com.airmart.api.config.JwtTokenProvider;
import com.airmart.api.domains.ChatMessage;
import com.airmart.api.domains.User;
import com.airmart.api.exception.BaseException;
import com.airmart.api.exception.ChatException;
import com.airmart.api.models.helpers.CustomResponse;
import com.airmart.api.models.helpers.ResponseHelper;
import com.airmart.api.services.ChatMessageService;
import com.airmart.api.services.ChatService;
import com.airmart.api.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/chat/auth", produces="application/json" )
public class ChatMessageController  {

    @Autowired
    private ChatMessageService chatMessageService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    @Autowired
    ChatService chatService;

    @GetMapping("/messages")
    public ResponseEntity<CustomResponse<ChatMessage>> getMessages( @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {
        // Page request number start at 0 not 1
        Pageable pageable = new PageRequest(0, ApiConstants.PER_PAGE);
        Page<ChatMessage> list = chatMessageService.findPaginated(pageable);
        CustomResponse<ChatMessage> result = ResponseHelper.convertFromPage(list, pageable.getPageNumber(),
                pageable.getPageSize());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/messages", params = {"page"})
    public @ResponseBody CustomResponse<ChatMessage> getPageChats(@RequestParam("page") int page,  @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {
        Page<ChatMessage> list = chatMessageService.findSortedPaginatedByDate(page, ApiConstants.PER_PAGE);
        CustomResponse<ChatMessage> result = ResponseHelper.convertFromPage(list, page, ApiConstants.PER_PAGE);

        return result;
    }

    @GetMapping("/messages/{id}")
    public ResponseEntity<ChatMessage> getMessage(@PathVariable("id") long id,  @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws ChatException {
        if (id <= 0 || chatMessageService.getById(id) == null) {
            throw new ChatException("Chat id can not be found!");
        }
        return new ResponseEntity<>(chatMessageService.getById(id), HttpStatus.OK);
    }
    @DeleteMapping("/messages/{id}")
    public ResponseEntity<ChatMessage> deleteMessage(@PathVariable("id") long id,  @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws ChatException {
        if (id <= 0 || chatMessageService.getById(id) == null) {
            throw new ChatException("Chat id can not be found!");
        }
        chatMessageService.remove(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/messages")
    public ResponseEntity<ChatMessage> save(@RequestParam(value = "message")String message,
                                            @RequestParam(value = "chat_id")Long chatId,
                                            @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws BaseException {
        String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setChat(chatService.getById(chatId));
        chatMessage.setMessage(message);
        chatMessage.setUser(userService.findUserByUsername(username));
        return new ResponseEntity<>(chatMessageService.save(chatMessage), HttpStatus.OK);
    }

    @PatchMapping("/messages")
    public ResponseEntity<ChatMessage> update(@Valid @RequestParam(value = "message")String message,
                                              @RequestParam(value = "chat_id")Long chatId,
                                              @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws BaseException {
        String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
        ChatMessage chatMessage = chatMessageService.getById(chatId);
        if (chatMessage == null) {
            throw new ChatException("Failed, chat doesn't exist");
        }
        else{
            chatMessage.setMessage(message);
        }
        return new ResponseEntity<>(chatMessageService.save(chatMessage), HttpStatus.OK);
    }

    @PutMapping("/messages")
    public ResponseEntity<ChatMessage> updateEntity(@Valid @RequestBody ChatMessage message,  @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws BaseException {
        if (message.getId() <= 0 || chatMessageService.getById(message.getId()) == null) {
            throw new ChatException("Failed, chat doesn't exist");
        }
        return new ResponseEntity<>(chatMessageService.save(message), HttpStatus.OK);
    }

}