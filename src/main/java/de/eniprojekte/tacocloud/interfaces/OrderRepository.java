package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.TacoOrder;
import de.eniprojekte.tacocloud.data.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {


    List<TacoOrder> findByDeliveryZip(String zip);

    List<TacoOrder> readTacoOrdersByDeliveryZipAndOrderPlacedAtBetween(String zip, Date startDate, Date endDate);

    List<TacoOrder> findByUserOrderByOrderPlacedAtDesc(User user, PageRequest pageable);

}
