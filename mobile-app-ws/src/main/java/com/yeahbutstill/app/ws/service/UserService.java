package com.yeahbutstill.app.ws.service;

import com.yeahbutstill.app.ws.ui.model.request.UserDetailsRequestModel;
import com.yeahbutstill.app.ws.ui.model.response.UserRest;

public interface UserService {

    UserRest createUser(UserDetailsRequestModel userDetailsRequestModel);

}
