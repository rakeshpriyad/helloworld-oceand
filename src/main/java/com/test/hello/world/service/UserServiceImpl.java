package com.test.hello.world.service;

import com.test.hello.world.model.UserDetails;
import com.test.hello.world.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDetails> findAllUser() {
        return userRepository.findAll();
    }


}
