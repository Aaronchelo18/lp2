/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.app.service;


import java.util.List;
import upeu.edu.pe.lp2.app.repository.StockRepository;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.StockEntity;


/**
 *
 * @author Aarón López
 */


public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Iterable<StockEntity> getStock(){
        return stockRepository.getStock();
    }
    public StockEntity getStockByid(Integer id){
        return stockRepository.getStockByid(id);
    }

    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity){
        return stockRepository.getStockByProductEntity(productEntity);
    }
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockRepository.saveStock(stockEntity);
    }

}
