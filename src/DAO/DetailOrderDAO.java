/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DetailOrderDTO;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class DetailOrderDAO {
    
    public boolean insertData(DetailOrderDTO detailOrder) {
        String query = "INSERT INTO tb_detail_order VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, detailOrder.getId());
            pstm.setLong(2, detailOrder.getPrice());
            pstm.setLong(3, detailOrder.getProfit());
            pstm.setInt(4, detailOrder.getQuantity());
            pstm.setLong(5, detailOrder.getTotal());
            pstm.setBoolean(6, detailOrder.isIsDelete());
            pstm.setLong(7, detailOrder.getItemID());
            pstm.setLong(8, detailOrder.getOrderID());
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
                e.printStackTrace();
            }
        return false;
    }
    
    public ArrayList<DetailOrderDTO> findDetailByIDOrder(long idOrder) {
        ArrayList<DetailOrderDTO> list = new ArrayList<>();
        String query = "SELECT tb_detail_order.*, tb_menu_item.name FROM tb_detail_order JOIN tb_menu_item ON tb_detail_order.itemid = tb_menu_item.id WHERE orderid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, idOrder);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DetailOrderDTO detailOrder = new DetailOrderDTO();
                detailOrder.setId(rs.getLong("id"));
                detailOrder.setPrice(rs.getLong("price"));
                detailOrder.setProfit(rs.getLong("profit"));
                detailOrder.setQuantity(rs.getInt("quantity"));
                detailOrder.setTotal(rs.getLong("total"));
                detailOrder.setIsDelete(rs.getBoolean("isdeleted"));
                detailOrder.setItemID(rs.getLong("itemid"));
                detailOrder.setOrderID(rs.getLong("orderid"));
                detailOrder.setInvoiceID(rs.getLong("invoiceid"));
                detailOrder.setName(rs.getString("name"));
                
                list.add(detailOrder);
            }
            return list;
        }
        catch(Exception e) {
                e.printStackTrace();
            }
        return list;
    }
    
    public ArrayList<DetailOrderDTO> findDetailByInvoice(long idinvoice) {
        ArrayList<DetailOrderDTO> list = new ArrayList<>();
        String query = "SELECT tb_detail_order.*, tb_menu_item.name FROM tb_detail_order JOIN tb_menu_item ON tb_detail_order.itemid = tb_menu_item.id WHERE invoiceid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, idinvoice);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DetailOrderDTO detailOrder = new DetailOrderDTO();
                detailOrder.setId(rs.getLong("id"));
                detailOrder.setPrice(rs.getLong("price"));
                detailOrder.setProfit(rs.getLong("profit"));
                detailOrder.setQuantity(rs.getInt("quantity"));
                detailOrder.setTotal(rs.getLong("total"));
                detailOrder.setIsDelete(rs.getBoolean("isdeleted"));
                detailOrder.setItemID(rs.getLong("itemid"));
                detailOrder.setOrderID(rs.getLong("orderid"));
                detailOrder.setInvoiceID(rs.getLong("invoiceid"));
                detailOrder.setName(rs.getString("name"));
                
                list.add(detailOrder);
            }
            return list;
        }
        catch(Exception e) {
                e.printStackTrace();
            }
        return list;
    }
    
    public long getInvoiceByID(long orderID) {
        
        String query = "SELECT invoiceid FROM tb_detail_order WHERE orderid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, orderID);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getLong("invoiceid");
            }
            
        }
        catch(Exception e) {
                e.printStackTrace();
            }
        return 0;
    }
   
    public ArrayList<DetailOrderDTO> mergeDetais(String listOrderId) {
        ArrayList<DetailOrderDTO> list = new ArrayList<>();
        String query = "SELECT itemid ,name,tb_detail_order.price, SUM(quantity) AS quantity, SUM(total) AS total FROM tb_detail_order JOIN tb_menu_item ON itemid = tb_menu_item.id WHERE orderid IN ";
        query += "(" + listOrderId + ") AND tb_detail_order.isdeleted = false GROUP BY itemid, name, tb_detail_order.price";
//        System.out.println(query);
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DetailOrderDTO detailOrder = new DetailOrderDTO();
                detailOrder.setPrice(rs.getLong("price"));
                detailOrder.setQuantity(rs.getInt("quantity"));
                detailOrder.setTotal(rs.getLong("total"));
                detailOrder.setItemID(rs.getLong("itemid"));
                detailOrder.setName(rs.getString("name"));
                detailOrder.setName(rs.getString("name"));
                
                list.add(detailOrder);
            }
            return list;
        }
        catch(Exception e) {
                e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<DetailOrderDTO> mergeDetaisByIDInvoice(String listInvoiceID) {
        ArrayList<DetailOrderDTO> list = new ArrayList<>();
        String query = "SELECT itemid ,name,tb_detail_order.price, SUM(quantity) AS quantity, SUM(total) AS total FROM tb_detail_order JOIN tb_menu_item ON itemid = tb_menu_item.id WHERE invoiceid IN ";
        query += "(" + listInvoiceID + ")  GROUP BY itemid, name, tb_detail_order.price";
        
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DetailOrderDTO detailOrder = new DetailOrderDTO();
                detailOrder.setPrice(rs.getLong("price"));
                detailOrder.setQuantity(rs.getInt("quantity"));
                detailOrder.setTotal(rs.getLong("total"));
                detailOrder.setItemID(rs.getLong("itemid"));
                detailOrder.setName(rs.getString("name"));
                detailOrder.setName(rs.getString("name"));
                
                list.add(detailOrder);
            }
            return list;
        }
        catch(Exception e) {
                e.printStackTrace();
        }
        return list;
    }
    
    public boolean updateDetails(String listOrderID, long invoiceID) {
        String query = "UPDATE tb_detail_order SET invoiceid = ? WHERE orderid IN";
        query += "(" + listOrderID + ")";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, invoiceID);

            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateDetails(DetailOrderDTO detailOrderDTO) {
        String query = "UPDATE tb_detail_order SET price = ?, profit = ?, quantity = ?, total = ?, isdeleted = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, detailOrderDTO.getPrice());
            pstm.setLong(2, detailOrderDTO.getProfit());
            pstm.setInt(3, detailOrderDTO.getQuantity());
            pstm.setLong(4, detailOrderDTO.getTotal());
            

            pstm.setBoolean(5, detailOrderDTO.isIsDelete());
            pstm.setLong(6, detailOrderDTO.getId());

            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
