/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.entity.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.lp2.app.repository.OrderRepository;
import upeu.edu.pe.lp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderCrudRepository orderCrudRepository;

    public OrderRepositoryImpl(OrderCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }


    @Override
    public Iterable<OrderEntity> getOrders() {
        return orderCrudRepository.findAll();
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUser(UserEntity user) {
        return orderCrudRepository.findByUserEntity(user);
    }

    @Override
    public OrderEntity getOrderById(Integer id) {
        return orderCrudRepository.findById(id).get();
    }

    @Override
    public OrderEntity saveOrder(OrderEntity order) {
        return orderCrudRepository.save(order);
    }

    @Override
    public void deleteProductById(Integer id) {
        orderCrudRepository.deleteById(id);
    }
}