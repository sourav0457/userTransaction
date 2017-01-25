package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import com.google.inject.Inject;
import models.Transaction;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.TransactionService;

import java.time.LocalDate;
import java.util.Date;


/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class TransactionController extends Controller {

    @Inject TransactionService transactionService;

    public Result getMaxAmount() throws JsonProcessingException {

        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() == 0) {
            return badRequest("Expecting some data");
        } else {
            Long userId = Long.parseLong(form.get("userId"));
            LocalDate fromDate = LocalDate.parse(form.get("fromDate"));
            LocalDate toDate = LocalDate.parse(form.get("toDate"));
            return ok(transactionService.getMaxAmount(fromDate, toDate, userId));
        }
    }

    public Result getMinAmount() throws JsonProcessingException {

        DynamicForm form = Form.form().bindFromRequest();
        if (form.data().size() == 0) {
            return badRequest("Expecting some data");
        } else {
            Long userId = Long.parseLong(form.get("userId"));
            LocalDate fromDate = LocalDate.parse(form.get("fromDate"));
            LocalDate toDate = LocalDate.parse(form.get("toDate"));
            return ok(transactionService.getMinAmount(fromDate, toDate, userId));
        }
    }

    public Result findUserWithMoreThanXAmount(Long x) throws JsonProcessingException {
        return ok(transactionService.moreThanX(x));
    }
}
