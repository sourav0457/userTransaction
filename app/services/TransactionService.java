package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Transaction;
import models.User;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

import static com.avaje.ebean.Expr.between;
import static com.avaje.ebean.Expr.eq;
import static play.mvc.Controller.request;

/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class TransactionService {
    @Inject
    ObjectMapper objectMapper;
    String result = "";
    public String getMaxAmount(LocalDate fromDate, LocalDate toDate, Long userId) throws JsonProcessingException {

        return objectMapper.writeValueAsString(Transaction.find.where().and(between("date", fromDate, toDate),eq("user_userid",userId)).orderBy("amount desc").setMaxRows(1).findList());


    }

    public String getMinAmount(LocalDate fromDate, LocalDate toDate, Long userId) throws JsonProcessingException {

        return objectMapper.writeValueAsString(Transaction.find.where().and(between("date", fromDate, toDate),eq("user_userid",userId)).orderBy("amount asc").setMaxRows(1).findList());


    }

    public String moreThanX(Long x) throws JsonProcessingException {

        /*return objectMapper.writeValueAsString(Transaction.find.where().gt("amount", x).findList());*/

        Transaction.find.where().gt("amount", x).findList().forEach(Transaction -> {
            try {
                result+= objectMapper.writeValueAsString(User.find.byId(Transaction.user.id));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return result;
    }

}
