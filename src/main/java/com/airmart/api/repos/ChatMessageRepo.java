package com.airmart.api.repos;

import com.airmart.api.domains.Chat;
import com.airmart.api.domains.ChatMessage;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ChatMessageRepo extends PagingAndSortingRepository<ChatMessage, Long> {
    List<ChatMessage> findByChat(Chat chat);

}
