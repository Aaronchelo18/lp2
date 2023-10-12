/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.app.repository;

import upeu.edu.pe.lp2.infrastructure.entity.OrderDetailsEntity;

/**
 *
 * @author Aarón López
 */

public interface OrderDetailsRepository {
    Iterable<OrderDetailsEntity> getOrderDetails();
    OrderDetailsEntity saveOrderDetail(OrderDetailsEntity orderDetails);
    OrderDetailsEntity getOrderDetailById(Integer id);
    void deleteOrderDetailById(Integer id);
    
}