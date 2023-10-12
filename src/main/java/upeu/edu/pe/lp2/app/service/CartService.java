/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import upeu.edu.pe.lp2.app.domain.ItemCart;

/**
 *
 * @author Aarón López
 */

@Service
public class CartService {
    
    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;
    
    
    public CartService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }
    
    // metodo que agrega un nuevo producto y lo actualiza en paralelo el fillList
    public void addItemCart(Integer idProduct, String nameProduct, Integer quantity, BigDecimal price) {
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(),itemCart);
        fillList();
    }
    
    
    // metodo que calcular el total del carrito
    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for(ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }
    
    
    // metodo que elimina un producto agregado
    public void removeItemCart(Integer idProduct) {
        itemCartHashMap.remove(idProduct);
        fillList();
    }
    
    
    // metodo que agrega en un forEach los itemCarts
    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach(
            (Integer, itemCart) -> itemCarts.add(itemCart)
        );
    }
    
    // metodo que lista el carrito al procesar la orden
    public void removeAllItemCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    public List<ItemCart> getProductosEnCarrito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
