/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package upeu.edu.pe.lp2.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.slf4j.*;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.lp2.app.repository.ProductRepository;
import upeu.edu.pe.lp2.infrastructure.entity.ProductEntity;
import upeu.edu.pe.lp2.infrastructure.entity.UserEntity;

/**
 *
 * @author Aarón López
 */
public class ProductService {
    
    private final ProductRepository productRepository;
    private final UploadFile uploadFile;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }
    
     //Lista de todos los productos
   public Iterable<ProductEntity> getProducts() {
       return productRepository.getProducts();
   }
   
    //Lista de productos por usuario
   public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
       return productRepository.getProductsByUser(user);
   }
    
   public ProductEntity getProductById (Integer id) {
       return productRepository.getProductById(id);
   }
   
   public ProductEntity saveProduct (ProductEntity product, MultipartFile multipartFile) throws IOException  {
       if (product.getId() == null) {
           UserEntity user = new UserEntity();
            user.setId(1);
            product.setDateCreated(LocalDateTime.now());
            product.setDateUpdated(LocalDateTime.now());
            product.setUserEntity(user);
            product.setImage(uploadFile.upload(multipartFile));
            return productRepository.saveProduct(product);
   }else{ 
           ProductEntity productDB = productRepository.getProductById(product.getId());
           product.setCode(productDB.getCode());
           product.setUserEntity(product.getUserEntity());
           product.setDateCreated(productDB.getDateCreated());
           product.setDateCreated(LocalDateTime.now());
           return productRepository.saveProduct(product);
                   
       }
            
    
            
            
            
       }
       
   public void deleteProductById (Integer id) {
       productRepository.deleteProductById(id);
   }
    
}
