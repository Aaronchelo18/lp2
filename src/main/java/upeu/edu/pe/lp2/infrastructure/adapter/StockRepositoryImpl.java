/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.adapter;

import org.springframework.stereotype.Repository;

import java.util.List;
import upeu.edu.pe.lp2.app.repository.StockRepository;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.StockEntity;


/**
 *
 * @author Aarón López
 */


@Repository
public class StockRepositoryImpl implements StockRepository {
    private final StockCrudRepository stockCrudRepository;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository) {
        this.stockCrudRepository = stockCrudRepository;
    }

    @Override
    public Iterable<StockEntity> getStock() {
        return stockCrudRepository.findAll();
    }

    @Override
    public StockEntity getStockByid(Integer id) {
        return null;
    }

    @Override
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockCrudRepository.save(stockEntity);
    }

    @Override
    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity) {
        return stockCrudRepository.getStockByProductEntity(productEntity);
    }
}
