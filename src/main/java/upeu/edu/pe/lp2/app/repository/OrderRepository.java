/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.app.repository;

import upeu.edu.pe.lp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */

public interface OrderRepository {
    Iterable<OrderEntity> getOrders();
    Iterable<OrderEntity> getOrdersByUser(UserEntity user);
    OrderEntity getOrderById(Integer id);
    OrderEntity saveOrder(OrderEntity order);
    void deleteProductById(Integer id);
}