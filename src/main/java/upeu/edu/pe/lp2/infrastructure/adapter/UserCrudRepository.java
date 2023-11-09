/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserType;

/**
 *
 * @author Aarón López
 */

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer>{
    UserEntity findByUserType(UserType user);
}
