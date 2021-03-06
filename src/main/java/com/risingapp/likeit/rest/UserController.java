package com.risingapp.likeit.rest;

import com.risingapp.likeit.execption.SessionTimeOutException;
import com.risingapp.likeit.execption.UserWithThisEmailExists;
import com.risingapp.likeit.model.common.MessageResponse;
import com.risingapp.likeit.model.request.ChangeProfileRequest;
import com.risingapp.likeit.model.request.ChangeSettingRequest;
import com.risingapp.likeit.model.request.UserRequest;
import com.risingapp.likeit.model.response.ChangeProfileResponse;
import com.risingapp.likeit.model.response.GetMyProfileResponse;
import com.risingapp.likeit.model.response.GetProfileResponse;
import com.risingapp.likeit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zinoviyzubko on 05.04.17
 */
@RestController
@RequestMapping(value = "/rest/users")
public class UserController {

    @Autowired private UserService userService;

    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public MessageResponse getCurrent() throws SessionTimeOutException {
        return userService.getCurrentUser();
    }

    @RequestMapping(method = RequestMethod.GET)
    public MessageResponse getUserByEmail(@RequestParam("email") String email) {
        return userService.getUserByEmail(email);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public MessageResponse getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public MessageResponse registration(@RequestBody UserRequest request) throws UserWithThisEmailExists {
        return userService.saveUser(request);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public MessageResponse updateUser(@PathVariable("id") Long userId, @RequestBody UserRequest request) {
        return userService.updateUser(userId, request);
    }

    @RequestMapping(value = "/current/profile", method = RequestMethod.GET)
    public MessageResponse getMyProfile() throws SessionTimeOutException {
        return userService.getMyProfile();
    }

    @RequestMapping(value = "/{id}/profile", method = RequestMethod.GET)
    public MessageResponse getProfile(@PathVariable("id") Long userId) throws SessionTimeOutException {
        return userService.getProfile(userId);
    }

    @RequestMapping(value = "/profile", method = RequestMethod.PUT)
    public MessageResponse updateProfile(@RequestBody ChangeProfileRequest request) throws SessionTimeOutException {
        return userService.updateProfile(request);
    }

    @RequestMapping(value = "/settings", method = RequestMethod.PUT)
    public MessageResponse updateSettings(@RequestBody ChangeSettingRequest request) throws SessionTimeOutException {
        return userService.updateSettings(request);
    }


}
