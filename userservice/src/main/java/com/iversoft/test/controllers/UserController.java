package com.iversoft.test.controllers;

import com.iversoft.test.persistence.DAO.UserRepository;
import com.iversoft.test.persistence.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(
            value = "/v1/users/{userId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUser(@PathVariable Integer userId) {
        logger.info("Requesting User with ID: ", userId);

        Optional<User> user = userRepository.findById(userId);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/v1/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsers() {
        logger.info("Requesting all users from DataBase");

        List<User> users = userRepository.findAll();

        return new ResponseEntity<>(users, HttpStatus.OK);

    }

    @RequestMapping(
            value = "/v1/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(@RequestBody User user) {
        logger.info("Adding new User");

        userRepository.save(user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/v1/users/{userId}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> changeUser(@RequestBody User user) {
        logger.info("Changing a User");

        userRepository.save(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "/v1/users/{userId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteUser(@PathVariable Integer userId) {
        logger.info("Deleting a User with ID: ", userId);

        userRepository.deleteById(userId);

        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

}
