package de.eniprojekte.tacocloud.controller;


import de.eniprojekte.tacocloud.data.TacoOrder;
import de.eniprojekte.tacocloud.interfaces.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {

        this.orderRepository = orderRepository;

    }

    @GetMapping("/current")
    public String orderForum(){

        return "orderForum";

    }

    @PostMapping
    public String orderForum(@Valid TacoOrder tacoOrder, Errors error, SessionStatus sessionStatus){



        if(error.hasErrors()){

            return "orderForum";

        }

        orderRepository.save(tacoOrder);
        log.info("Order submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";

    }

}
