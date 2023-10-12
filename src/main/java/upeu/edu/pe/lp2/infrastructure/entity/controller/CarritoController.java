/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.entity.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upeu.edu.pe.lp2.app.domain.ItemCart;
import upeu.edu.pe.lp2.app.service.CartService;

/**
 *
 * @author Aarón López
 */

@Controller
@RequestMapping("/carrito")
public class CarritoController {
    private final CartService cartService;

    public CarritoController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public String mostrarCarrito(Model model) {
        List<ItemCart> productosEnCarrito = cartService.getProductosEnCarrito();
        BigDecimal totalCarrito = cartService.getTotalCart();

        model.addAttribute("productosEnCarrito", productosEnCarrito);
        model.addAttribute("totalCarrito", totalCarrito);

        return "carrito";
    }

    @PostMapping("/agregar")
    public String agregarProductoAlCarrito(@RequestParam Integer idProduct, @RequestParam String nameProduct, @RequestParam Integer quantity, @RequestParam BigDecimal price) {
        cartService.addItemCart(idProduct, nameProduct, quantity, price);
        return "redirect:/carrito";
    }

    @PostMapping("/eliminar")
    public String eliminarProductoDelCarrito(@RequestParam Integer idProduct) {
        cartService.removeItemCart(idProduct);
        return "redirect:/carrito";
    }

    @PostMapping("/procesar")
    public String procesarCarrito() {
        // Lógica para procesar la orden y realizar el pago, si es necesario
        
        return "redirect:/home";
    }
}