/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.RoleDAO;
import DTO.RoleDTO;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class RoleBUS {
    private RoleDAO roleDAO = new RoleDAO();
    
    public ArrayList<RoleDTO> getAll() {
        return roleDAO.read();
    }
    
    public RoleDTO getRoleByID(String id) {
        return roleDAO.getRoleByID(id);
    }
}
