package de.eniprojekte.tacocloud.data;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import de.eniprojekte.tacocloud.data.User;
@Data
public class RegistrationForum {

    private String username;
    private String password;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder encoder){

        return new User(username,encoder.encode(password),fullname,street,city,state,zip,phone,"ROLE_USER");

    }


}
