/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Comp.Panel;

import GUI.Comp.chart.*;
import DTO.InvoicesDTO;
import BUS.InvoicesBUS;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class PanelStatistic extends javax.swing.JPanel {

    private List<InvoicesDTO> listInvoice = new ArrayList<>();
    private InvoicesBUS invoicesBUS = new InvoicesBUS();
    private List<ModelChartPie> listPie = new ArrayList<>();

    public void filter(List<ModelChartPie> arr) {
        while (arr.size() > 6) {
            long min = (long) 1e9;
            int index = -1;
            for (var i : arr) {
                if (i.getValue() < min) {
                    index = arr.indexOf(i);
                    min = (long) i.getValue();
                }
            }
            arr.remove(index);
        }
    }

    public int compareDay(String date1Str, String date2Str) {
        LocalDate date1 = LocalDate.parse(date1Str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate date2 = LocalDate.parse(date2Str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        int dayOfWeek1 = date1.getDayOfWeek().getValue();

        int dayOfWeek2 = date2.getDayOfWeek().getValue();

        int diff = dayOfWeek2 - dayOfWeek1;

        if (diff < 0) {
            diff += 7;
        }

        return diff;
    }

    public boolean isDateInWeek(String date1Str, String date2Str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = dateFormat.parse(date1Str);
            Date date2 = dateFormat.parse(date2Str);

            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date1);
            calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            boolean res = true;
            if (calendar2.before(calendar1)) {
                res = false;
            }
            calendar1.add(Calendar.DAY_OF_WEEK, 7);
            if (calendar2.after(calendar1)) {
                res = false;
            }
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PanelStatistic() {
        initComponents();
        initData();
        initInvoice();
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tableInvoices.getTableHeader()
                .getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
    }

    private void initInvoice() {
        invoicesBUS = new InvoicesBUS();
        listInvoice = invoicesBUS.getInvoice();
    }

    private void initData() {
        // Add data combobox
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        for (int i = 1; i <= 52; i++) {
            Calendar weekCalendar = calendar.getInstance();
            weekCalendar.set(Calendar.YEAR, year);
            weekCalendar.set(Calendar.WEEK_OF_YEAR, i);
            weekCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            Date startDate = weekCalendar.getTime();
            weekCalendar.add(Calendar.DAY_OF_YEAR, 6);
            Date endDate = weekCalendar.getTime();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String weekText = "Tuần " + i + " (" + formatter.format(startDate) + " - " + formatter.format(endDate)
                    + ")";
            comboBoxWeek.addItem(weekText);
        }
        comboBoxWeek.setSelectedIndex(-1);

        tableInvoices.fixTable(jScrollPane1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPie = new GUI.Comp.chart.ChartPie();
        chartLine1 = new GUI.Comp.chart.ChartLine();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInvoices = new GUI.Comp.chart.Table();
        comboBoxWeek = new javax.swing.JComboBox<>();

        chartPie.setBackground(new java.awt.Color(35, 35, 35));

        chartLine1.setBackground(new java.awt.Color(35, 35, 35));

        tableInvoices.setBackground(new java.awt.Color(35, 35, 35));
        tableInvoices.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Time", "ID", "Price", "Discount", "Total"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableInvoices);

        comboBoxWeek.setMaximumRowCount(10);
        comboBoxWeek.setToolTipText("");
        comboBoxWeek.setRenderer(null);
        comboBoxWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxWeekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 513,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, 515,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboBoxWeek, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 202,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxWeek, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567,
                                        Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxWeekActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_comboBoxWeekActionPerformed
        // Get the time selected and load data that match to the table
        double[] arrLine = new double[7];
        int index = comboBoxWeek.getSelectedIndex();
        if (index != -1) {
            DefaultTableModel modelTable = (DefaultTableModel) tableInvoices.getModel();
            if (modelTable.getRowCount() > 0) {
                for (int i = modelTable.getRowCount() - 1; i >= 0; i--) {
                    modelTable.removeRow(i);
                }
            }
            for (int i = 0; i < 7; i++) {
                arrLine[i] = 0;
            }
            listPie = invoicesBUS.getDetailByTime(index);
            filter(listPie);
            chartPie.setModel(listPie);
            modelTable.fireTableDataChanged();
            String str = comboBoxWeek.getSelectedItem().toString();
            String date = str.substring(str.indexOf('(') + 1, str.indexOf('-') - 1);
            List<ModelChartLine> listLine = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            // Add data table and chart line
            for (var i : listInvoice) {
                String createTime = dateFormat.format(i.getCreateTime());
                if (isDateInWeek(date, createTime)) {
                    int dayInWeek = compareDay(date, createTime);
                    double total = i.getTotal();
                    arrLine[dayInWeek] += total;
                    modelTable.addRow(new ModelInvoices(i.getCreateTime(), i.getId(), i.getAmount(), i.getDiscount(),
                            i.getTotal()).toDataTable());

                }
            }
            listLine.add(new ModelChartLine("Monday", arrLine[0]));
            listLine.add(new ModelChartLine("Tuesday", arrLine[1]));
            listLine.add(new ModelChartLine("Wednesday", arrLine[2]));
            listLine.add(new ModelChartLine("Thursday", arrLine[3]));
            listLine.add(new ModelChartLine("Friday", arrLine[4]));
            listLine.add(new ModelChartLine("Saturday", arrLine[5]));
            listLine.add(new ModelChartLine("Sunday", arrLine[6]));
            chartLine1.setModel(listLine);
            // Add data chart pie

        }
    }// GEN-LAST:event_comboBoxWeekActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Comp.chart.ChartLine chartLine1;
    private GUI.Comp.chart.ChartPie chartPie;
    private javax.swing.JComboBox<String> comboBoxWeek;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.Comp.chart.Table tableInvoices;
    // End of variables declaration//GEN-END:variables
}
