/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Criteria.OrderCriteria;
import DAO.OrderDAO;
import DTO.DetailOrderDTO;
import DTO.OrderDTO;
import java.util.Date;
import java.util.ArrayList;

public class OrderBUS {
    private OrderDAO orderDAO = new OrderDAO();
    private DetailOrderBUS detailOrderBUS = new DetailOrderBUS();

    public ArrayList<OrderDTO> getAllOrder() {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setIsDelete(false);
        return orderDAO.read(criteria);
    }

    
    
    public ArrayList<OrderDTO> getOrderByInvoiceID(long id) {
        return orderDAO.readByInvoiceID(id);
    }

    public boolean insertOrder(OrderDTO order) {
        ArrayList<DetailOrderDTO> listDetailOrder = order.getListDetailOrder();
        boolean check = orderDAO.insert(order);
        if (check) {
            for (DetailOrderDTO x : listDetailOrder) {
                x.setOrderID(order.getId());
                detailOrderBUS.insertDetailOrder(x);
            }
        }
        return check;
    }

    public ArrayList<OrderDTO> findOrderByCustomerCode(String customerCode) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setCustomerCode(customerCode);
        return orderDAO.read(criteria);
    }

    public OrderDTO findOrderByTableID(long tableID) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setTableID(tableID);
        return orderDAO.read(criteria).size() == 0 ? null : orderDAO.read(criteria).get(0);
    }

    public OrderDTO findOrderByID(long id) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setId(id);
        return orderDAO.read(criteria).size() == 0 ? null : orderDAO.read(criteria).get(0);
    }

    public boolean updateCustomerCode(String listID, String customerCode) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setCustomerCode(customerCode);
        return orderDAO.update(criteria, listID);
    }

    public boolean updateTotal(OrderDTO order) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setId(order.getId());
        criteria.setTotal(order.getTotal());
        criteria.setUpdateTime(new Date());
        return orderDAO.update(criteria, "");
    }
    
    public boolean updateNote(OrderDTO order) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setId(order.getId());
        criteria.setNote(order.getNote());
        return orderDAO.update(criteria, "");
    }

    public boolean updateTableID(OrderDTO order) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setId(order.getId());
        criteria.setTableID(order.getTableID());
        return orderDAO.update(criteria, "");
    }

    public boolean deleteOrder(String listOrderID) {
        OrderCriteria criteria = new OrderCriteria();
        criteria.setIsDelete(true);
        return orderDAO.update(criteria, "");
    }
}
