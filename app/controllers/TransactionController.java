package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;


/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class TransactionController extends Controller {

    public Result getMaxAmount(Date fromDate, Date toDate, Long userId) {
        return ok();
    }

    public Result getMinAmount(Date fromDate, Date toDate, Long userId) {
        return ok();
    }
}
