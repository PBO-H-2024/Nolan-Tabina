/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
        
        
/**
 *
 * @author Widows
 */
public class MainFrame extends JFrame{
    public MainFrame(){
        setTitle("Internship Programs");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,200);
        setLocationRelativeTo(null);
        
        JButton androidButton = new JButton("Android Developer");
        JButton webButton = new JButton("Web Developer");
        
        androidButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            dispose();
            new DetailFrame("Android").setVisible(true);
            }
        });
        
        webButton.addActionListener(new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e){
            dispose();
            new DetailFrame("Android").setVisible(true);
            } 
        });
        
        JPanel panel = new JPanel();
        panel.add(androidButton);
        panel.add(webButton);
        
        add(panel);
    }
}
