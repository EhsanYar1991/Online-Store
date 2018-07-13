package com.yar.onlinestore.controller.rest;


import com.yar.onlinestore.common.bundle.MessageService;
import com.yar.onlinestore.common.exception.RequestException;
import com.yar.onlinestore.common.exception.UserServiceException;
import com.yar.onlinestore.service.domain.UserManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


/**
 * Created by e.yarmohammadi on 9/11/2017.
 */

@RestController
public class UserRestController {



    private final UserManagement userManagement;
    private final MessageService messageService;


    @Autowired
    public UserRestController(UserManagement userManagement, MessageService messageService) {
        this.userManagement = userManagement;
        this.messageService = messageService;
    }


    @RequestMapping(value = "/locale", method = {RequestMethod.GET})
    public ResponseEntity<?> locale(Locale locale) throws UserServiceException, RequestException {
        return new ResponseEntity<>(locale, HttpStatus.OK);
    }
}
