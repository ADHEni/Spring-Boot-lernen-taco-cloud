package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {


}
