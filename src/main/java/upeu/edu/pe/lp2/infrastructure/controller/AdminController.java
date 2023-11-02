package upeu.edu.pe.lp2.infrastructure.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.lp2.app.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String home (Model model){
        model.addAttribute("products",productService.getProducts());
        return "admin/home_admin";
    }


}
