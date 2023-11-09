/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.app.repository;

import java.util.Optional;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */
public interface ProductRepository {

    //Lista de todos los productos
    Iterable<ProductEntity> getProducts();

    //Lista de productos por usuario
    Iterable<ProductEntity> getProductsByUser(UserEntity user);

    Optional<ProductEntity> getProductByid(Integer id);

    ProductEntity getProductById(Integer id);

    ProductEntity saveProduct(ProductEntity product);

    void deleteProductById(Integer id);
}
