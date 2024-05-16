/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.MainController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UpdateData extends JFrame {
    private int id;
    private MainController controller;
    
    private JLabel lTitle = new JLabel("Update Student Data", JLabel.CENTER);
    
    private JLabel lNim = new JLabel("NIM:");
    private JTextField fNim = new JTextField(20);
    
    private JLabel lName = new JLabel("Name:");
    private JTextField fName = new JTextField(20);
    
    private JLabel lAge = new JLabel("Age:");
    private JTextField fAge = new JTextField(20);
    
    private JButton btnUpd = new JButton("Update");
    
    public UpdateData(int id, MainController controller){
        this.id = id;
        this.controller = controller;
        
        setTitle("Update Data Student");
        setSize(400, 300);
        setLayout(new GridBagLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        
        // Title
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        add(lTitle, c);
        
        // NIM
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        add(lNim, c);
        
        c.gridx = 1;
        c.gridy = 1;
        add(fNim, c);
        
        // Name
        c.gridx = 0;
        c.gridy = 2;
        add(lName, c);
        
        c.gridx = 1;
        c.gridy = 2;
        add(fName, c);
        
        // Age
        c.gridx = 0;
        c.gridy = 3;
        add(lAge, c);
        
        c.gridx = 1;
        c.gridy = 3;
        add(fAge, c);
        
        // Update Button
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        add(btnUpd, c);
        
        prefillData();
        
        btnUpd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nim = Integer.parseInt(fNim.getText());
                    String name = fName.getText();
                    int age = Integer.parseInt(fAge.getText());
                    
                    if (name.isEmpty() || fNim.getText().isEmpty() || fAge.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        controller.updateData(id, nim, name, age);
                        JOptionPane.showMessageDialog(null, "Data updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setVisible(true);
    }
    
    private void prefillData() {
        String[][] data = controller.readData();
        for (String[] row : data) {
            if (row[0] != null && Integer.parseInt(row[0]) == id) {
                fNim.setText(row[1]);
                fName.setText(row[2]);
                fAge.setText(row[3]);
                break;
            }
        }
    }
}

