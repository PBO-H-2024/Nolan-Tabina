/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import Score.Result;
import util.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Widows
 */
public class DetailFrame extends JFrame{
    private JTextField nameField;
    private JTextField nimField;
    private JRadioButton[] courseButtons;
    private JTextField daysField;
    public DetailFrame(String courseType){
        setTitle("Detail Peserta " + courseType);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        JLabel nameLabel = new JLabel("Nama Peserta: ");
        JLabel nimLabel = new JLabel("NIM Peserta: ");
        JLabel courseLabel = new JLabel("Course Peserta: ");
        
        nameField = new JTextField(30);
        nimField = new JTextField(9);
        
        JPanel radioPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        Result[] course = Result.getResult(courseType);
        courseButtons = new JRadioButton[course.length];
        for(int i = 0; i < course.length; i++){
            courseButtons[i] =  new JRadioButton(course[i].getName()+ " " + course[i].getWeight());
            group.add(courseButtons[i]);
            radioPanel.add(courseButtons[i]);
        }
        daysField = new JTextField(5);
        JButton saveButton = new JButton ("Simpan");
        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = nameField.getText();
                String nim = nimField.getText();
                int days = Integer.parseInt(daysField.getText());
                double score = 0;
                for (int i = 0; i < courseButtons.length; i++){
                    if (courseButtons[i].isSelected()){
                        score = course[i].getWeight();
                        break;
                    }
                }
                double totalScore = Calculator.calculateTotal(days,score);
                dispose();
                new TotalFrame(name, nim, courseType, score, days, totalScore).setVisible(true);
            }
        });
        JPanel panel = new JPanel();
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(nimLabel);
        panel.add(nimField);
        panel.add(courseLabel);
        panel.add(radioPanel);
        panel.add(daysLabel);
        panel.add(daysField);
        panel.add(saveButton);
        add(panel);
    }
}
