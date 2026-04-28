package de.eniprojekte.tacocloud.interfaces;

import de.eniprojekte.tacocloud.data.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);

}
