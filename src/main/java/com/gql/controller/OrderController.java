package com.gql.controller;

import com.gql.entities.Order;
import com.gql.repositories.OrderRepo;
import com.gql.service.OrderService;
import com.gql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @MutationMapping
    public Order createOrder(@Argument String orderDetails, @Argument String address, @Argument int price, @Argument int userid) {
        Order order = new Order();
        order.setOrderDetails(orderDetails);
        order.setAddress(address);
        order.setPrice(price);
        order.setUser(userService.getsingleuser(userid));
        return orderService.createorder(order);
    }

    @MutationMapping
    public boolean deleteOrder(@Argument long orderId) {
        Order getorder = orderService.getorder(orderId);
        orderService.deleteorder(getorder.getOrderId());
        return true;
    }

    @QueryMapping
    public List<Order> getorders( ){
        return orderService.getallorders();
    }

    @QueryMapping
   public Order getsingleorder(@Argument long orderId){
        return orderService.getorder(orderId);
    }
}
