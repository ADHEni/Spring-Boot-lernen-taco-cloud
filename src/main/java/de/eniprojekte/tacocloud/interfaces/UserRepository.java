package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    User findByUsername(String username);

}
