package DAO;

import Criteria.OrderCriteria;
import DTO.OrderDTO;
import DTO.TableDTO;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDAO {
    
    
    public ArrayList<OrderDTO> readByInvoiceID(long id) {
        ArrayList<OrderDTO> list = new ArrayList<>();
        String query = """
                SELECT DISTINCT tb_orders.id, tb_orders.customer_code, tb_orders.total, tb_orders.isdeleted, tb_orders.staffid, tb_orders.tableid, tb_orders.update_time, tb_orders.create_time , tb_orders.note FROM tb_orders
                JOIN tb_detail_order ON  tb_detail_order.orderid = tb_orders.id
                JOIN tb_invoices ON tb_detail_order.invoiceid = ?""";

        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getLong("id"));
                order.setCustomerCode(rs.getString("customer_code"));
                order.setTotal(rs.getLong("total"));
                order.setIsDelete(rs.getBoolean("isdeleted"));
                order.setStaffID(rs.getLong("staffid"));
                order.setTableID(rs.getLong("tableid"));
                order.setUpdateTime(rs.getTimestamp("update_time"));
                order.setCreateTime(rs.getTimestamp("create_time"));
                order.setNote(rs.getString("note"));
                list.add(order);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<OrderDTO> read(OrderCriteria criteria) {
        ArrayList<OrderDTO> list = new ArrayList<>();
        String query = "SELECT tb_orders.*, name FROM tb_orders LEFT JOIN tb_tables ON tb_orders.tableid = tb_tables.id";
        if (criteria.createClause(false).isEmpty()) {
            return null;
        }
        query += " WHERE " + criteria.createClause(false) + " ORDER BY create_time DESC";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            int i = 1;
            if (criteria.getId() != null) {
                pstm.setLong(i++, criteria.getId());
            }
            if (criteria.getCustomerCode() != null) {
                pstm.setString(i++, criteria.getCustomerCode());
            }
            if (criteria.getTotal() != null) {
                pstm.setLong(i++, criteria.getTotal());
            }
            if (criteria.getIsDelete() != null) {
                pstm.setBoolean(i++, criteria.getIsDelete());
            }
            if (criteria.getStaffID() != null) {
                pstm.setLong(i++, criteria.getStaffID());
            }
            if (criteria.getTableID() != null) {
                pstm.setLong(i++, criteria.getTableID());
            }
            if (criteria.getCreateTime() != null) {
                pstm.setTimestamp(i++, new Timestamp(criteria.getCreateTime().getTime()));
            }
            if (criteria.getUpdateTime() != null) {
                pstm.setTimestamp(i++, new Timestamp(criteria.getUpdateTime().getTime()));
            }
            if (criteria.getNote() != null) {
                pstm.setString(i++, criteria.getNote());
            }
            
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getLong("id"));
                order.setCustomerCode(rs.getString("customer_code"));
                order.setTotal(rs.getLong("total"));
                order.setIsDelete(rs.getBoolean("isdeleted"));
                order.setStaffID(rs.getLong("staffid"));
                order.setTableID(rs.getLong("tableid"));
                order.setUpdateTime(rs.getTimestamp("update_time"));
                order.setCreateTime(rs.getTimestamp("create_time"));
                order.setNote(rs.getString("note"));
                TableDTO table = new TableDTO();
                table.setName(rs.getString("name"));
                order.setTableDTO(table);

                list.add(order);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insert(OrderDTO order) {
        String query = "INSERT INTO tb_orders VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, order.getId());
            pstm.setString(2, order.getCustomerCode());
            pstm.setLong(3, order.getTotal());
            pstm.setBoolean(4, order.isIsDelete());
            pstm.setLong(5, order.getStaffID());
            pstm.setLong(6, order.getTableID());

            Timestamp sqlDateUpdate = new Timestamp(order.getUpdateTime().getTime());
            Timestamp sqlDateCreate = new Timestamp(order.getCreateTime().getTime());
            pstm.setTimestamp(7, sqlDateCreate);
            pstm.setTimestamp(8, sqlDateUpdate);
            pstm.setString(9, order.getNote());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(OrderCriteria criteria, String listID) {
        String query = "UPDATE tb_orders";
        if (criteria.createClause(true).isEmpty()) {
            return false;
        } else {
            if (!listID.isEmpty()) {
                query += " SET " + criteria.createClause(true) + " WHERE id IN (" + listID + ")";
            } else {
                query += " SET " + criteria.createClause(true) + " WHERE id IN (?)";
            }
        }

        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            int i = 1;
            if (criteria.getCustomerCode() != null) {
                pstm.setString(i++, criteria.getCustomerCode());
            }
            if (criteria.getTotal() != null) {
                pstm.setLong(i++, criteria.getTotal());
            }
            if (criteria.getIsDelete() != null) {
                pstm.setBoolean(i++, criteria.getIsDelete());
            }
            if (criteria.getStaffID() != null) {
                pstm.setLong(i++, criteria.getStaffID());
            }
            if (criteria.getTableID() != null) {
                pstm.setLong(i++, criteria.getTableID());
            }
            if (criteria.getCreateTime() != null) {
                pstm.setTimestamp(i++, new Timestamp(criteria.getCreateTime().getTime()));
            }
            if (criteria.getUpdateTime() != null) {
                pstm.setTimestamp(i++, new Timestamp(criteria.getUpdateTime().getTime()));
            }
            if (criteria.getNote() != null) {
                pstm.setString(i++, criteria.getNote());
            }
            if (listID.isEmpty()) {
                pstm.setLong(i++, criteria.getId());
            }

            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
