package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import javax.validation.Constraint;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Created by SOURAV SAMANTA on 22-01-2017.
 */

@Entity
public class Transaction extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "transactionid")
    public Long id;

    public LocalDate date;

    @Constraints.Required
    public Double amount;

    @ManyToOne
    public User user;

    public static Finder<Long, Transaction> find = new Finder<Long, Transaction>(Transaction.class);
}
