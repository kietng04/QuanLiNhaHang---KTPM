/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.CategoriesDAO;
import DTO.CategoriesDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class CategoriesBUS {
    private CategoriesDAO categoriesDAO = new CategoriesDAO();
    
    public ArrayList<CategoriesDTO> getAll() {
        return categoriesDAO.read();
    }
    
    public CategoriesDTO findCategoriByID(long id) {
        return categoriesDAO.findByID(id);
    }
    
    public boolean insertCategories(CategoriesDTO categories) {
        return categoriesDAO.insert(categories);
    }
    
    public boolean updateCategories(CategoriesDTO categories) {
        return categoriesDAO.update(categories);
    }
    
    public boolean deleteCategories(CategoriesDTO categories) {
        return categoriesDAO.update(categories);
    }
}
