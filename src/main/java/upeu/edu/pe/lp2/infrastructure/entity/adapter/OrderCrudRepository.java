/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.entity.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.lp2.infrastructure.entity.OrderEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */

public interface OrderCrudRepository extends CrudRepository<OrderEntity, Integer> {
    Iterable<OrderEntity>findByUserEntity(UserEntity entity);
}