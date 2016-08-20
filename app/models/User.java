package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lubuntu on 8/20/16.
 */
@Entity
public class User extends Model{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    public Long id;
    public String email;
    public String password;

    @OneToMany(mappedBy = "sender")
    public List<ConnectionRequest> ConnectionRequestsSent;

    @OneToMany(mappedBy = "receiver")
    public List<ConnectionRequest> ConnectionRequestsReceived;

    @OneToOne
    public Profile profile;

    @ManyToMany
    @JoinTable(name = "user_connections",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "connection_id")
            }
    )
    public List<User> Connections;
}
