package models;
import java.util.*;
import javax.persistence.*;

import play.data.validation.*;
import play.db.jpa.*;
@Entity
@Table(name = "blog_user")
public class User extends  Model {
    @Email
    @Required
    public String email;
    @Required
    @Password
    @MinSize(8)
    public String password;
    @Required
    @MaxSize(64)
    public String fullname;
    public boolean isAdmin;

    public User(String email,String password,String fullname){
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

    public static User connect(String email, String password) {
        return find("byFullnameAndPassword", email, password).first();
    }
    @Override
    public String toString(){
        return  fullname;
    }

}
