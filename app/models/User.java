package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    public Long id;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String phoneNumber;
    public String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Transaction> transactionList = new ArrayList<Transaction>();

    public static Finder<Long, User> findu = new Finder<Long, User>(User.class);
}
