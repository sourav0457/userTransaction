package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Transaction;
import models.User;

import javax.inject.Inject;

/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class UserService {

    @Inject ObjectMapper objectMapper;
    @Inject Transaction transaction;

    public String getAllUsers() throws JsonProcessingException {
        return objectMapper.writeValueAsString(User.findu.all());
    }

    public String getUserByuserId(Long userId) throws JsonProcessingException {
        return objectMapper.writeValueAsString(User.findu.byId(userId));
    }

    public String moreThanX(Long x) throws JsonProcessingException {
        return objectMapper.writeValueAsString(Transaction.findt.select("id, amount").where().gt(transaction.amount.toString(), x));
    }
}
