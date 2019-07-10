package com.airmart.api.repos;

import com.airmart.api.domains.Chat;
import com.airmart.api.domains.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ChatRepo extends PagingAndSortingRepository<Chat, Long> {
    //Chat findByUsers(List<User> users);
}
