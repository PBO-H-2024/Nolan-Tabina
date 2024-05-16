/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.MainController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ReadData {
    private MainController controller;
    
    private JFrame window = new JFrame("Read Data Student");
    private JTable tabel;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private Object columnName[] = {
        "ID", "NIM", "Name", "Age"
    };
    
    private JLabel lTitle = new JLabel("Student Data", JLabel.CENTER);
    
    private JButton btnAdd = new JButton("Add");
    private JButton btnRefresh = new JButton("Refresh");
    
    public ReadData(MainController controller){
        this.controller = controller;
        
        tableModel = new DefaultTableModel(columnName, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        window.setLayout(new GridBagLayout());
        window.setSize(600, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        
        // Title
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        addComponent(window, lTitle, c);
        
        // Table
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        addComponent(window, scrollPane, c);
        
        // Buttons
        styleButton(btnAdd);
        styleButton(btnRefresh);
        
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.weighty = 0;
        addComponent(window, btnAdd, c);
        
        c.gridx = 1;
        c.gridy = 2;
        addComponent(window, btnRefresh, c);
        
        refreshTable();
        
        tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mouseClicked(e);
                int row = tabel.getSelectedRow();
                int id = Integer.parseInt(tabel.getValueAt(row, 0).toString());
                String name = tabel.getValueAt(row, 2).toString();
                
                int input = JOptionPane.showConfirmDialog(null,
                            "Do you want to delete " + name + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                
                if(input == JOptionPane.YES_OPTION){
                    controller.deleteData(id);
                    refreshTable();
                } else {
                    input = JOptionPane.showConfirmDialog(null,
                            "Do you want to update " + name + "?",
                            "Option...",
                            JOptionPane.YES_NO_OPTION);
                    if(input == JOptionPane.YES_OPTION){
                        new UpdateData(id, controller);
                    }
                }
            }
        });
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InputData(controller);
            }
        });
        
        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        
        window.setVisible(true);
    }
    
    private void refreshTable() {
        String[][] data = controller.readData();
        tableModel.setRowCount(0); // Clear existing data
        for (String[] row : data) {
            if (row[0] != null) { // Ensure the row is not empty
                tableModel.addRow(row);
            }
        }
    }
    
    private void addComponent(Container container, Component component, GridBagConstraints constraints) {
        container.add(component, constraints);
    }
    
    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 130, 180)); // Steel Blue
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 12));
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 180)), 
                BorderFactory.createEmptyBorder(5, 10, 5, 10)));
    }
}
