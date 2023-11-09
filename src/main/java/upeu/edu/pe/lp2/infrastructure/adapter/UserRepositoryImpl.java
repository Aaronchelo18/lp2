/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.adapter;

import org.springframework.stereotype.Repository;
import upeu.edu.pe.lp2.app.repository.UserRepository;
import upeu.edu.pe.lp2.infrastructure.adapter.UserCrudRepository;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserType;

/**
 *
 * @author Aarón López
 */


@Repository
public class UserRepositoryImpl implements UserRepository{
    
    private final UserCrudRepository userCrudRepository;

    public UserRepositoryImpl(UserCrudRepository userRepository) {
        this.userCrudRepository = userRepository;
    }

    @Override
    public UserEntity findByUserType(UserType user) {
       return userCrudRepository.findByUserType(user);
    }
    
    @Override
    public UserEntity saveUser(UserEntity user) {
        return userCrudRepository.save(user);
    }

    /*
    @Override
    public UserEntity updateUser(UserEntity user) {
        return userCrudRepository.(user);
    }
    
    @Override
    public void deleteUserById(Integer id) {
       userCrudRepository.deleteById(id);
    }
    */
    @Override
    public UserEntity getUserById(Integer id) {
        return userCrudRepository.findById(id).get();
    }
}
