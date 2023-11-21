package upeu.edu.pe.lp2.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.lp2.app.service.ProductService;
import upeu.edu.pe.lp2.app.service.StockService;
import upeu.edu.pe.lp2.infrastructure.entity.StockEntity;


/**
 *
 * @author Aarón López
 */



@Controller
@RequestMapping("/admin/inventario")
public class StockController {
    public final ProductService productService;
    private final StockService stockService;

    public StockController(ProductService productService, StockService stockService) {
        this.productService = productService;
        this.stockService = stockService;
    }

    @GetMapping("/add-units/{id}")
    public String addUnits(@PathVariable Integer id, Model model){
        StockEntity stock = stockService.getStockByid(id);
        model.addAttribute("stock",stock);
        return "admin/add_units";
    }

    @PostMapping("/add/{id}")
    public String addUnits(@PathVariable Integer id, @RequestParam("cantidad") Integer cantidad) {
        StockEntity stock = stockService.getStockByid(id);
            Integer entradasActuales = stock.getEntradas();
            Integer nuevasEntradas = entradasActuales + cantidad;
            stock.setEntradas(nuevasEntradas);
            stockService.saveStock(stock);
        return "redirect:/admin/inventario"; // Redirecciona a la página de inventario actualizada.
    }


}
