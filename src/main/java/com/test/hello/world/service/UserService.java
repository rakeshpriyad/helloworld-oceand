package com.test.hello.world.service;

import com.test.hello.world.model.UserDetails;

import java.util.List;

public interface UserService {
    List<UserDetails> findAllUser();
}
