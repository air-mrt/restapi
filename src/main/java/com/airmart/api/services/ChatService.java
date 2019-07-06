package com.airmart.api.services;

import com.airmart.api.domains.Chat;
import com.airmart.api.repos.ChatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService  {
    @Autowired
    private ChatRepo chatRepository;

    public Chat getById(Long id) {
        return chatRepository.findById(id).get();
    }


    public void remove(Long id) {
        chatRepository.deleteById(id);
    }
    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

    public List<Chat> getAll() {
        return (List<Chat>) chatRepository.findAll();
    }

    public Page<Chat> findPaginated(Pageable pageable) {
        return chatRepository.findAll(pageable);
    }
    @Deprecated
    public Page<Chat> getPageSortByDate(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(new Sort.Order(Sort.Direction.DESC, "postedDate")));
        return chatRepository.findAll(pageable);
    }
}