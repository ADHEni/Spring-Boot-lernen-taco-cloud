package de.eniprojekte.tacocloud.controller;


import de.eniprojekte.tacocloud.data.TacoOrder;
import de.eniprojekte.tacocloud.data.User;
import de.eniprojekte.tacocloud.helper.OrderProb;
import de.eniprojekte.tacocloud.interfaces.OrderRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.awt.print.Pageable;
import java.util.Date;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepository;
    private OrderProb orderProb;

    public OrderController(OrderRepository orderRepository, OrderProb orderProb) {
        this.orderProb = orderProb;
        this.orderRepository = orderRepository;

    }

    @GetMapping("/current")
    public String orderForum(){

        return "orderForum";

    }

    @GetMapping
    public String ordersForUser(@AuthenticationPrincipal User user, Model model){

        PageRequest pageable = PageRequest.of(0,orderProb.getPageSize());

        model.addAttribute("orders", orderRepository.findByUserOrderByOrderPlacedAtDesc(user,pageable));
        return "orderList";
    }

    @PostMapping
    public String orderForum(@Valid TacoOrder tacoOrder,
                             Errors error, SessionStatus sessionStatus,
                             @AuthenticationPrincipal User user){



        if(error.hasErrors()){

            return "orderForum";

        }
        tacoOrder.setOrderPlacedAt(new Date());
        tacoOrder.setUser(user);
        orderRepository.save(tacoOrder);
        log.info("Order submitted: {}", tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";

    }

}
