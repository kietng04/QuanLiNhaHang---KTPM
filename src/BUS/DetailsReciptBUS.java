/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DetailsRecipeDAO;
import DTO.DetailsRecipeDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class DetailsReciptBUS {
    private DetailsRecipeDAO detailsRecipeDAO = new DetailsRecipeDAO();
    
    public ArrayList<DetailsRecipeDTO> readByIDItem(long itemid) {
        return detailsRecipeDAO.readByIDItem(itemid);
    }
    
    public DetailsRecipeDTO findDetailsByIngreNItem(long ingreid, long itemid) {
        return detailsRecipeDAO.findDetailsByIngreNItem(ingreid, itemid);
    }
    
    public ArrayList<DetailsRecipeDTO> findRecipeByItemid(String listItemID) {
        return detailsRecipeDAO.findRecipeByItemid(listItemID);
    }
    
    public boolean updateDetail(DetailsRecipeDTO x) {
        return detailsRecipeDAO.update(x);
    }
    
    public boolean insertDetail(DetailsRecipeDTO x) {
        return detailsRecipeDAO.insert(x);
    }
    
    
}
