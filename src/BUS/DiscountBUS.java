/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DiscountDAO;
import DTO.DiscountDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class DiscountBUS {
    private DiscountDAO discountDAO = new DiscountDAO();
    
    public ArrayList<DiscountDTO> getAllData(boolean isValid) {
        return discountDAO.read(isValid);
    }
    
    public DiscountDTO getDataById(long id) {
        return discountDAO.getDataById(id);
    }
    
    
    public boolean insertDiscount(DiscountDTO discount) {
        return discountDAO.insert(discount);
    }
    
    public boolean updateDiscount(DiscountDTO discount) {
        return discountDAO.update(discount);
    }
    
    public boolean updateRemainingById(long id, int remaining) {
        return discountDAO.updateRemainingById(id, remaining);
    }
    
    public boolean deleteDiscount(DiscountDTO discount) {
        return discountDAO.update(discount);
    }
}
