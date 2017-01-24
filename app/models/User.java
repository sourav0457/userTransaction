package models;

import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static Finder<Long, User> find = new Finder<Long, User>(User.class);
}
