/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.lp2.app.repository.OrderDetailsRepository;
import upeu.edu.pe.lp2.infrastructure.entity.OrderDetailsEntity;

/**
 *
 * @author Aarón López
 */

@Repository
public class OrderDetailsRepositoryImpl implements OrderDetailsRepository {
    
    private final OrderDetailsCrudRepository orderDetailsCrudRepository;

    public OrderDetailsRepositoryImpl(OrderDetailsCrudRepository orderDetailsCrudRepository) {
        this.orderDetailsCrudRepository = orderDetailsCrudRepository;
    }
    
    @Override
    public Iterable<OrderDetailsEntity> getOrderDetails() {
        return orderDetailsCrudRepository.findAll();
    }

    @Override
    public OrderDetailsEntity saveOrderDetail(OrderDetailsEntity orderDetails) {
        return orderDetailsCrudRepository.save(orderDetails);
    }

    @Override
    public void deleteOrderDetailById(Integer id) {
        orderDetailsCrudRepository.deleteById(id);
    }

    @Override
    public OrderDetailsEntity getOrderDetailById(Integer id) {

        return orderDetailsCrudRepository.findById(id).get();
    }
    
}