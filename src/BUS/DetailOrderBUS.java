/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DetailOrderDAO;
import java.util.ArrayList;
import DTO.DetailOrderDTO;
/**
 *
 * @author quang
 */
public class DetailOrderBUS {
    private DetailOrderDAO detailOrderDAO = new DetailOrderDAO();
    
    public boolean insertDetailOrder(DetailOrderDTO x) {
        return detailOrderDAO.insertData(x);
    }
    
    public ArrayList<DetailOrderDTO> findDetailByOrder(long idOrder) {
        return detailOrderDAO.findDetailByIDOrder(idOrder);
    }
    
    public ArrayList<DetailOrderDTO> findDetailByInvoice(long idinvoice) {
        return detailOrderDAO.findDetailByInvoice(idinvoice);
    }
    
    public long getInvoiceByOrderID(long orderID) {
        return detailOrderDAO.getInvoiceByID(orderID);
    }
    
    public ArrayList<DetailOrderDTO> mergeDetails(String listOrderId) {
        return detailOrderDAO.mergeDetais(listOrderId);
    }
    
     public ArrayList<DetailOrderDTO> mergeDetaisByIDInvoice(String listInvoiceID) {
        return detailOrderDAO.mergeDetaisByIDInvoice(listInvoiceID);
    }
    
    
    
    public boolean updateDetails(String listOrderID, long invoiceid) {
        return detailOrderDAO.updateDetails(listOrderID, invoiceid);
    }
    
    public boolean updateDetails(DetailOrderDTO x) {
        return detailOrderDAO.updateDetails(x);
    }
}
