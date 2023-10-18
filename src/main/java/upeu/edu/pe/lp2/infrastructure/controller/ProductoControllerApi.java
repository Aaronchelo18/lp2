/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.controller;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import upeu.edu.pe.lp2.app.service.ProductService;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */

@Controller
@RequestMapping("/admin/products")
public class ProductoControllerApi {

    private final ProductService productService;
    private final Logger log = LoggerFactory.getLogger(ProductoControllerApi.class);

    public ProductoControllerApi(ProductService productService) {
        this.productService = productService;
    }

    //crear nuevo producto
    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
    }
    //guardar producto
    @PostMapping("/save-product")
    public String saveProduct(ProductEntity product, @RequestParam("img") MultipartFile multipartFile) throws IOException {
        log.info("Nombre de producto: {}", product);
        productService.savProduct(product, multipartFile);

        // Agregar un retraso de 1 segundo (1000 milisegundos) antes de redirigir
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "redirect:/admin";
    }


    @GetMapping("/show")
    public String showProduct(Model model){
        //log.info("id user desde la variable de session: {}");
        UserEntity user = new UserEntity();
        user.setId(1);
        Iterable<ProductEntity> products = productService.getProductsByUser(user);
        model.addAttribute("products", products);
        return "admin/products/show";
    }


    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        ProductEntity product = productService.getProductById(id);
        log.info("Product obtenido: {}", product);
        model.addAttribute("product",product);
        return "admin/products/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin";
    }
}