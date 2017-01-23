package models;

import com.avaje.ebean.Model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User extends Model{

    @Id
    @GeneratedValue
    public Long id;
    public String name;
    public String phoneNumber;
    public String address;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    public List<Transaction> transactionList = new ArrayList<Transaction>();




}
