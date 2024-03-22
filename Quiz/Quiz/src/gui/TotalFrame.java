/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Widows
 */
public class TotalFrame extends JFrame{
    public TotalFrame(String name, String nim, String course, double score, int days, double totalScore){
        setTitle("Total Score");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        JLabel nameLabel = new JLabel("Name: "+ name);
        JLabel nimLabel = new JLabel("NIM: "+ nim);
        JLabel courseLabel = new JLabel("Course: "+ course);
        JLabel daysLabel = new JLabel(" : "+ days);
        JLabel totalScoreLabel = new JLabel("Score: "+ totalScore);;
        JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(e-> System.exit(0));
        JPanel panel = new JPanel(new GridLayout(5, 1));
        panel.add(nameLabel);
        panel.add(nimLabel);
        panel.add(courseLabel);
        panel.add(daysLabel);
        panel.add(totalScoreLabel);
        add(panel, BorderLayout.CENTER);
        add(finishButton, BorderLayout.SOUTH);
        
    }
}
