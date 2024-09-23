/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.InvoicesDAO;
import DTO.InvoicesDTO;
import GUI.Comp.chart.ModelChartPie;
import java.util.List;

/**
 *
 * @author pc
 */
public class InvoicesBUS {
    private InvoicesDAO invoicesDAO = new InvoicesDAO();

    public boolean deleteInvoices(String id) {
        return invoicesDAO.removeInvoice(id);
    }

    public boolean insertInvoices(InvoicesDTO invoices) {
        return invoicesDAO.insertData(invoices);
    }

    public InvoicesDTO getInvoiceByID(long id) {
        return invoicesDAO.readData(id);
    }

    public List<InvoicesDTO> getInvoice() {
        return invoicesDAO.readData();
    }

    public List<ModelChartPie> getDetailByTime(int index) {
        return invoicesDAO.readDetail(index + 1);
    }

}