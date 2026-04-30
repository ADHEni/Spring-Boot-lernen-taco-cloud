package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {


    List<TacoOrder> findByDeliveryZip(String zip);

    List<TacoOrder> readTacoOrdersByDeliveryZipAndOrderPlacedAtBetween(String zip, Date startDate, Date endDate);

}
