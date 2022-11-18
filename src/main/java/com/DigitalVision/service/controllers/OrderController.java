package com.DigitalVision.service.controllers;

import com.DigitalVision.service.models.OrderEntity;
import com.DigitalVision.service.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderEntity>> getAllOrders(){
        List<OrderEntity> orderEntities = orderService.findAllOrders();
        return new ResponseEntity<>(orderEntities, HttpStatus.OK);
    }

//    @GetMapping("/find/{id}")
//    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id){
//        UserEntity userEntity = userService.findUserById(id);
//        return new ResponseEntity<>(userEntity,HttpStatus.OK);
//    }
//
    @PostMapping("/add")
    public ResponseEntity<OrderEntity> addOrder(@RequestBody OrderEntity orderEntity){
        OrderEntity newOrderEntity = orderService.addOrder(orderEntity);
        return new ResponseEntity<>(newOrderEntity,HttpStatus.CREATED);
    }

//    @PutMapping("/update")
//    public ResponseEntity<UserEntity> updateEmployee(@RequestBody UserEntity userEntity){
//        UserEntity updateUser = userService.updateUser(userEntity);
//        return new ResponseEntity<>(updateUser,HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PostMapping("/add")
//    public ResponseEntity<User> addUser()



}
