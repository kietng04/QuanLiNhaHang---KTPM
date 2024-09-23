/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TableStatusDAO;
import DTO.TableStatusDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class TableStatusBUS {
    private TableStatusDAO tableStatusDAO = new TableStatusDAO();
    
    public TableStatusDTO getTableStatusByID(String id) {
        return tableStatusDAO.readByID(id);
    }
    
    public ArrayList<TableStatusDTO> getAll() {
        return tableStatusDAO.read();
    }
    
}
