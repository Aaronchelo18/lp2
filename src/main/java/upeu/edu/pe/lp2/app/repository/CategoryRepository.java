/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package upeu.edu.pe.lp2.app.repository;

import upeu.edu.pe.lp2.infrastructure.entity.CategoryEntity;

/**
 *
 * @author Aarón López
 */

public interface CategoryRepository {
    
    Iterable<CategoryEntity> saveCategory();
    CategoryEntity getCategoryById(Integer id);
    void deleteCategoryById(Integer id);
    
}