package com.airmart.api.controllers;

import com.airmart.api.config.ApiConstants;
import com.airmart.api.domains.Chat;
import com.airmart.api.exception.BaseException;
import com.airmart.api.exception.ChatException;
import com.airmart.api.models.helpers.CustomResponse;
import com.airmart.api.models.helpers.ResponseHelper;
import com.airmart.api.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/chat/auth", produces="application/json" )
public class ChatController{

    @Autowired
    private ChatService chatService;

    @GetMapping("/chats")
    public ResponseEntity<CustomResponse<Chat>> getChats( @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {
        Pageable pageable = new PageRequest(0, ApiConstants.PER_PAGE);
        Page<Chat> list = chatService.findPaginated(pageable);
        CustomResponse<Chat> result = ResponseHelper.convertFromPage(list, pageable.getPageNumber(),
                pageable.getPageSize());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/chats", params = {"page"})
    public @ResponseBody
    CustomResponse<Chat> getPageChats(@RequestParam("page") int page,  @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {

        Page<Chat> list = chatService.getPageSortByDate(page, ApiConstants.PER_PAGE);
        CustomResponse<Chat> result = ResponseHelper.convertFromPage(list, page, ApiConstants.PER_PAGE);

        return result;
    }

    @GetMapping("/chats/{id}")
    public ResponseEntity<Chat> getChat(@PathVariable("id") long id,  @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws ChatException {
        if (id <= 0 || chatService.getById(id) == null) {
            throw new ChatException("Chat id can not be found!");
        }
        return new ResponseEntity<>(chatService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/chats")
    public ResponseEntity<Chat> save(@Valid @RequestBody Chat chat,  @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws BaseException {
        return new ResponseEntity<>(chatService.save(chat), HttpStatus.OK);
    }

    @PatchMapping("/chats")
    public ResponseEntity<Chat> update(@Valid @RequestBody Chat chat, @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws BaseException {


        if (chat.getId() <= 0 || chatService.getById(chat.getId()) == null) {
            throw new ChatException("Failed, chat doesn't exist");
        }
        return new ResponseEntity<>(chatService.save(chat), HttpStatus.OK);
    }

    @RequestMapping(value = "/chats", method = RequestMethod.PUT)
    public ResponseEntity<Chat> updateEntity(@Valid @RequestBody Chat chat, @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) throws BaseException {
        if (chat.getId() <= 0 || chatService.getById(chat.getId()) == null) {
            throw new ChatException("Failed, chat doesn't exist");
        }
        return new ResponseEntity<>(chatService.save(chat), HttpStatus.OK);
    }
}