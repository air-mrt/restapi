package com.airmart.api.services;

import com.airmart.api.domains.Chat;
import com.airmart.api.domains.ChatMessage;
import com.airmart.api.repos.ChatMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepo chatMessageRepository;


    public ChatMessage getById(Long id) {
        if (chatMessageRepository.findById(id).isPresent()){
            return chatMessageRepository.findById(id).get();
        }
        return null;
    }


    public void remove(Long id) {
        chatMessageRepository.deleteById(id);
    }


    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }


    public List<ChatMessage> getAll() {
        return (List<ChatMessage>) chatMessageRepository.findAll();
    }


    public Page<ChatMessage> findPaginated(Pageable pageable) {
        return chatMessageRepository.findAll(pageable);
    }
    @Deprecated
    public Page<ChatMessage> findSortedPaginatedByDate(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(new Sort.Order(Sort.Direction.DESC, "postedDate")));
        return chatMessageRepository.findAll(pageable);
    }
    public List<ChatMessage> findAllByChat(Chat chat){
        return chatMessageRepository.findByChat(chat);

    }
}