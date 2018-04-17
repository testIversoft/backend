package com.iversoft.test.controllers;

import com.iversoft.test.persistence.DAO.UserRolesRepository;
import com.iversoft.test.persistence.model.UserRoles;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRolesController {

    @Autowired
    UserRolesRepository userRolesRepository;
    private static final Logger logger = LogManager.getLogger(UserRolesController.class);

    @RequestMapping(
            value = "/v1/roles/{userRoleId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserRole(@PathVariable Integer userRoleId) {
        logger.info("Requesting User's Role with ID: ", userRoleId);

        Optional<UserRoles> userRole = userRolesRepository.findById(userRoleId);

        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/v1/roles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserRole() {
        logger.info("Requesting all User's Roles");

        List<UserRoles> userRole = userRolesRepository.findAll();

        return new ResponseEntity<>(userRole, HttpStatus.OK);
    }

}
