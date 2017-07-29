package io.egen.entity;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAll",
                query = "SELECT user from User user ORDER BY user.firstname DESC "),
        @NamedQuery(name = "User.findUsingEmail",
                query = "SELECT user from User user WHERE user.email=:paramEmail order by user.firstname ASC")
})

public class User {

    public User(){
        this.id = UUID.randomUUID().
                toString();
    }

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private String id;

    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}

