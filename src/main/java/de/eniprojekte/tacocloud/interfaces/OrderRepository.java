package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {


}
