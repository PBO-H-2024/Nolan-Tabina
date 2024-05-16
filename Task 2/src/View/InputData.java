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

public class InputData extends JFrame {
    private MainController controller;
    
    private JLabel lTitle = new JLabel("Add New Student Data", JLabel.CENTER);
    
    private JLabel lNim = new JLabel("NIM:");
    private JTextField fNim = new JTextField(20);
    
    private JLabel lName = new JLabel("Name:");
    private JTextField fName = new JTextField(20);
    
    private JLabel lAge = new JLabel("Age:");
    private JTextField fAge = new JTextField(20);
    
    private JButton btnAdd = new JButton("Add");
    
    public InputData(MainController controller){
        this.controller = controller;
        
        setTitle("Student Input");
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
        
        // Add Button
        styleButton(btnAdd);
        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        add(btnAdd, c);
        
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int nim = Integer.parseInt(fNim.getText());
                    String name = fName.getText();
                    int age = Integer.parseInt(fAge.getText());
                    
                    if (name.isEmpty() || fNim.getText().isEmpty() || fAge.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "All fields must be filled", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        controller.insertData(nim, name, age);
                        JOptionPane.showMessageDialog(null, "Data added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        setVisible(true);
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
