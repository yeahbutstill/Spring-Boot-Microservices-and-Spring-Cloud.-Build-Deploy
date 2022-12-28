package com.yeahbutstill.app.ws.ui.controller;

import com.yeahbutstill.app.ws.exceptions.UserServiceException;
import com.yeahbutstill.app.ws.service.UserService;
import com.yeahbutstill.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.yeahbutstill.app.ws.ui.model.request.UserDetailsRequestModel;
import com.yeahbutstill.app.ws.ui.model.response.UserRest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    Map<String, UserRest> stringUserRestMap;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "8") Integer limit,
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

        return "get user was called with page: " + page + " and limit: " + limit + " and sort: " + sort;

    }

    @GetMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserRest> getUser(@Valid @PathVariable String userId) {

        if (true) {
            throw new UserServiceException("A user service exception is thrown");
        }

        if (stringUserRestMap.containsKey(userId)) {
            return new ResponseEntity<>(stringUserRestMap.get(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetailsRequestModel) {

        UserRest userRest = userService.createUser(userDetailsRequestModel);

        return new ResponseEntity<>(userRest, HttpStatus.CREATED);

    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE
    })
    public UserRest updateUser(@Valid @PathVariable String userId,
                               @RequestBody UpdateUserDetailsRequestModel updateUserDetailsRequestModel) {

        UserRest userRest = stringUserRestMap.get(userId);
        userRest.setFirstName(updateUserDetailsRequestModel.getFirstName());
        userRest.setLastName(updateUserDetailsRequestModel.getLastName());

        stringUserRestMap.put(userId, userRest);

        return userRest;

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {

        stringUserRestMap.remove(id);
        return ResponseEntity.noContent().build();

    }

}
