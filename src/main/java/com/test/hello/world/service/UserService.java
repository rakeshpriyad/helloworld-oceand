package com.test.hello.world.service;

import com.test.hello.world.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDetails> findAllUser();

    UserDetails save(UserDetails userDetails);

    Optional<UserDetails> findUserById(Integer userId);

    void delete(UserDetails userDetails);
}
