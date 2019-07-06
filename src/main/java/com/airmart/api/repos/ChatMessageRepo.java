package com.airmart.api.repos;

import com.airmart.api.domains.ChatMessage;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChatMessageRepo extends PagingAndSortingRepository<ChatMessage, Long> {

}
