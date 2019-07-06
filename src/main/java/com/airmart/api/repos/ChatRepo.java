package com.airmart.api.repos;

import com.airmart.api.domains.Chat;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ChatRepo extends PagingAndSortingRepository<Chat, Long> {
}