/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.entity.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.StockEntity;

/**
 *
 * @author Aarón López
 */

    
public interface StockCrudRepository extends CrudRepository<StockEntity, Integer>{
       List<StockEntity> getStockByProductEntity(ProductEntity productEntity);  
 
}
