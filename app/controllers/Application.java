package controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import forms.LoginForm;
import forms.SignupForm;
import models.Profile;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * Created by lubuntu on 8/21/16.
 */

public class Application extends Controller {

    @Inject
    FormFactory formFactory;
    @Inject
    ObjectMapper objectMapper;

    public Result signup()
    {
        Form<SignupForm> form = formFactory.form(SignupForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return ok(form.errorsAsJson());
        }

        User user = new User(form.data().get("email"), form.data().get("password"));
        Profile profile = new Profile(form.data().get("firstName"), form.data().get("lastName"));
        user.profile = profile;
        Profile.db().save(profile);
        User.db().save(user);
        return ok(String.valueOf(objectMapper.valueToTree(user)));
    }

    public Result login()
    {
        Form<LoginForm> form = formFactory.form(LoginForm.class).bindFromRequest();
        if (form.hasErrors()) {
            return ok(form.errorsAsJson());
        }

        return ok();
    }
}
