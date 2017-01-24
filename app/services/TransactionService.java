package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Transaction;
import models.User;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class TransactionService {
    @Inject
    ObjectMapper objectMapper;
    String result = "";
    public String getMaxAmount(Date fromDate, Date toDate, Long userId) throws JsonProcessingException {
        return objectMapper.writeValueAsString(Transaction.find.where().between("date",fromDate,toDate).eq("userid",userId));
        // TODO: FINISH THIS FUNCTION
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
