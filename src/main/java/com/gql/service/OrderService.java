package com.gql.service;

import com.gql.entities.Order;
import com.gql.exceptionhelper.ExceptionHelper;
import com.gql.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    //create

    public Order createorder(Order order)
    {
        return orderRepo.save(order);
    }
    //delete
    public boolean deleteorder(long id){
        Order order = orderRepo.findById(id).orElseThrow(ExceptionHelper::usernotfound);
        orderRepo.delete(order);
        return true;
    }
    //single id
    public Order getorder(long id){
        return  orderRepo.findById(id).orElseThrow(ExceptionHelper::usernotfound);
    }
    //get all
    public List<Order> getallorders(){
        return orderRepo.findAll();
    }
}
