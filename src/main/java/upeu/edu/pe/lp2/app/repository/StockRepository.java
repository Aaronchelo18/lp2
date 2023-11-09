/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.app.repository;

import java.util.List;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.StockEntity;

/**
 *
 * @author Aarón López
 */
public interface StockRepository {

    Iterable<StockEntity> getStock();

    StockEntity getStockByid(Integer id);

    StockEntity saveStock(StockEntity stockEntity);

    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);
}


