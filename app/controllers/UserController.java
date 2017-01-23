package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import services.UserService;

import javax.inject.Inject;

/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class UserController extends Controller {

    @Inject UserService userService;

    public Result findMaxBalance(Long userId){
        return ok();
    }

    public Result findUserWithMoreThanXAmount(){
        return ok();
    }

    public Result getUsers() throws JsonProcessingException {
        return ok(userService.getAllUsers());
    }

    public Result getUser(Long userId) throws JsonProcessingException {
        String user = userService.getUserByuserId(userId);
        if (user.equals("null")) {
            return ok("User with id " + userId + " does not exist");
        }
        return ok(user);
    }
}
