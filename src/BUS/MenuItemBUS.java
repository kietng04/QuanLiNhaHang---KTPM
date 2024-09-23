/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MenuItemDAO;
import DTO.MenuItemDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class MenuItemBUS {
    private MenuItemDAO menuItemDAO = new MenuItemDAO();
    
    public ArrayList<MenuItemDTO> getAllData() {
        return menuItemDAO.readData();
    }
    
    public boolean updateData(MenuItemDTO item) {
        return menuItemDAO.update(item);
    }
    
    public boolean insertData(MenuItemDTO item) {
        return menuItemDAO.insert(item);
    }
    
    public boolean deleteData(String listID) {
        return menuItemDAO.delete(listID);
    }
}
