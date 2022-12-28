package com.yeahbutstill.app.ws.service.impl;

import com.yeahbutstill.app.ws.service.UserService;
import com.yeahbutstill.app.ws.shared.Utils;
import com.yeahbutstill.app.ws.ui.model.request.UserDetailsRequestModel;
import com.yeahbutstill.app.ws.ui.model.response.UserRest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    Map<String, UserRest> stringUserRestMap;
    Utils utils;

    @Autowired
    public UserServiceImpl(Utils utils) {
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetailsRequestModel) {

        UserRest userRest = new UserRest();
        userRest.setEmail(userDetailsRequestModel.getEmail());
        userRest.setFirstName(userDetailsRequestModel.getFirstName());
        userRest.setLastName(userDetailsRequestModel.getFirstName());

        String userId = utils.generateUserId();
        userRest.setUserId(userId);

        if (stringUserRestMap == null) {
            stringUserRestMap = new HashMap<>();
        }

        stringUserRestMap.put(userId, userRest);

        return userRest;

    }

}
