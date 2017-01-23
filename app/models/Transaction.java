package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by SOURAV SAMANTA on 22-01-2017.
 */

@Entity
public class Transaction extends Model{

    @Id
    @GeneratedValue
    public Long id;
    public Date date;
    public Double amount;

    @ManyToOne
    public User user;

}
