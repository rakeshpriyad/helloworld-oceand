package com.test.hello.world.web;

import java.util.List;
import java.util.Optional;


import com.test.hello.world.model.UserDetails;
import com.test.hello.world.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

/**
 *
 */
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserServiceController {


    @Autowired
    private UserService userService;
	Logger log = LoggerFactory.getLogger(UserServiceController.class);

    /**
     * Read List of Users
     */
    @GetMapping(value = "/all")
    public List<UserDetails> findAll() {
        return userService.findAllUser();
    }

}
