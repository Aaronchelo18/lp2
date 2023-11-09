/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.app.repository;

import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserType;

/**
 *
 * @author Aarón López
 */

public interface UserRepository {
    
    UserEntity getUserById(Integer id);
    UserEntity findByUserType(UserType user);
    UserEntity saveUser(UserEntity user);
    //UserEntity updateUser(UserEntity user);
    //void deleteUserById(Integer id);
}
