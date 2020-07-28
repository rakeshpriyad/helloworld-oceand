package com.test.hello.world.web;

import java.util.List;
import java.util.Optional;


import com.test.hello.world.dto.UserDetailsRequest;
import com.test.hello.world.model.UserDetails;
import com.test.hello.world.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDetails createUser(@Valid @RequestBody UserDetails userDetails) {
        return userService.save(userDetails);
    }

    @GetMapping(value = "/{userId}")
    public Optional<UserDetails> findUser(@PathVariable("userId") int userId) {
        return userService.findUserById(userId);
    }

    /**
     * Update Branch
     */
    @PutMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@Valid @RequestBody UserDetailsRequest userDetailsRequest) {
        final Optional<UserDetails> user = userService.findUserById(userDetailsRequest.getId());

        final UserDetails userDetails = user.orElseThrow(() -> new ResourceNotFoundException("User "+userDetailsRequest.getId()+" not found"));
        /// log.info("Saving User {}", userDetails);

        setUserDetailsFromRequest(userDetailsRequest, userDetails);
        // This is done by hand for simplicity purpose. In a real life use-case we should consider using MapStruct.
        log.info("Saving user {}", userDetails);

        userService.save(userDetails);
    }

    public void setUserDetailsFromRequest(UserDetailsRequest request, UserDetails userDetails){
        userDetails.setFirstName(request.getFirstName());
        userDetails.setLastName(request.getLastName());
        userDetails.setEmail(request.getEmail());
        userDetails.setPhoneNo(request.getPhoneNo());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deleteUser(@PathVariable Integer userId) {


        final Optional<UserDetails> user = userService.findUserById(userId);

        final UserDetails userDetails = user.orElseThrow(() -> new ResourceNotFoundException("User "+ userId +" not found"));
        userService.delete(userDetails);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

}
