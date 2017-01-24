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
import java.util.Date;

/**
 * Created by SOURAV SAMANTA on 22-01-2017.
 */

@Entity
public class Transaction extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    @Formats.DateTime(pattern = "dd-MM-yyyy")
    public static Date ddate;

    @Constraints.Required
    public Double amount;

    @ManyToOne
    @JoinTable(name="USER_TRANSACTION",
            joinColumns=@JoinColumn(name="uid",referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name="tid", referencedColumnName="id"))
    public User user;

    public static Finder<Long, Transaction> findt = new Finder<Long, Transaction>(Transaction.class);
}
