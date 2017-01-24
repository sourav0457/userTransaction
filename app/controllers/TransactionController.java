package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.inject.Inject;
import models.Transaction;
import play.mvc.Controller;
import play.mvc.Result;
import services.TransactionService;

import java.util.Date;


/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class TransactionController extends Controller {

    @Inject TransactionService transactionService;

    public Result getMaxAmount(Date fromDate, Date toDate, Long userId) throws JsonProcessingException {
        return ok(transactionService.getMaxAmount(fromDate, toDate, userId));
    }

    public Result getMinAmount(Date fromDate, Date toDate, Long userId) {
        return ok();
    }

    public Result findUserWithMoreThanXAmount(Long x) throws JsonProcessingException {
        return ok(transactionService.moreThanX(x));
    }
}
