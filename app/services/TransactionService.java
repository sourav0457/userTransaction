package services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Transaction;

import javax.inject.Inject;
import java.util.Date;

/**
 * Created by SOURAV SAMANTA on 23-01-2017.
 */
public class TransactionService {
    @Inject
    ObjectMapper objectMapper;
    public String getMaxAmount(Date fromDate, Date toDate, Long userId) throws JsonProcessingException {
        String trans = objectMapper.writeValueAsString(Transaction.findt.where().gt(Transaction.ddate.toString(), fromDate).lt(Transaction.ddate.toString(), toDate));
        return trans;
    }

}
