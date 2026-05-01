package de.eniprojekte.tacocloud.interfaces;


import de.eniprojekte.tacocloud.data.Taco;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TacoRepository extends JpaRepository<Taco, Long> {

}
