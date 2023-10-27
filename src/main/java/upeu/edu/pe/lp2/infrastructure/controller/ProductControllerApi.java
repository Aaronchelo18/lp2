/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.infrastructure.controller;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp2.app.service.ProductService;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author LAB-2
 */

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api")
public class ProductControllerApi {
    private final ProductService productService;

    public ProductControllerApi(ProductService productService) {
        this.productService = productService;
    }
    //guardar product
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity) throws IOException{
      productService.savProductApi(productEntity);
      return null;
    }
    //ver productos
    @GetMapping("/product")
    public Iterable <ProductEntity> showProduct(){
        UserEntity user = new UserEntity();
        user.setId(1);
        return productService.getProductsByUser(user);
    }
     
     @GetMapping("/product/{id}")
    public ProductEntity show(@PathVariable Integer id){
       return productService.getProductById(id);
    }
    
    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity editProduct(@RequestBody ProductEntity product, @PathVariable Integer id) throws IOException {
        ProductEntity productActual = productService.getProductById(id);
        productActual.setDescription(product.getDescription());
        productActual.setName(product.getName());
        productActual.setPrice(product.getPrice());
        productActual.setUserEntity(product.getUserEntity());
        return productService.savProductApi(productActual);
       // log.info("Product obtenido: {}", product);
        //model.addAttribute("product", product);
        //return "admin/products/edit";
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
       // return "redirect:/admin/products/show";
    }
    

    
}