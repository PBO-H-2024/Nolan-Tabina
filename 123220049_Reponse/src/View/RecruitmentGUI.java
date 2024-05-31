/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author PC PRAKTIKUM
 */
import Controller.CandidateController;
import Model.AndroidDeveloper;
import Model.Candidate;
import Model.WebDeveloper;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RecruitmentGUI extends JFrame {
    private CandidateController candidateController;
    private JTextField nameField;
    private JComboBox<String> pathField;
    private JTextField writingField;
    private JTextField codingField;
    private JTextField interviewField;
    private JTable table;
    private DefaultTableModel tableModel;

    public RecruitmentGUI() {
        candidateController = new CandidateController();

        setTitle("Recruitment System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBackground(Color.LIGHT_GRAY);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Path:"));
        pathField = new JComboBox<>(new String[]{"Android Developer", "Web Developer"});
        panel.add(pathField);

        panel.add(new JLabel("Writing Score:"));
        writingField = new JTextField();
        panel.add(writingField);

        panel.add(new JLabel("Coding Score:"));
        codingField = new JTextField();
        panel.add(codingField);

        panel.add(new JLabel("Interview Score:"));
        interviewField = new JTextField();
        panel.add(interviewField);

        JButton addButton = new JButton("Add");
        addButton.setBackground(Color.GREEN);
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCandidate();
            }
        });
        panel.add(addButton);

        JButton updateButton = new JButton("Update");
        updateButton.setBackground(Color.YELLOW);
        updateButton.setOpaque(true);
        updateButton.setBorderPainted(false);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCandidate();
            }
        });
        panel.add(updateButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(Color.RED);
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCandidate();
            }
        });
        panel.add(deleteButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(Color.CYAN);
        clearButton.setOpaque(true);
        clearButton.setBorderPainted(false);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
        panel.add(clearButton);

        tableModel = new DefaultTableModel(new String[]{"Name", "Path", "Writing", "Coding", "Interview", "Score", "Status"}, 0);
        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(table);

        add(panel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);

        loadCandidates();
    }

    private void addCandidate() {
        String name = nameField.getText();
        String path = (String) pathField.getSelectedItem();
        int writingScore = Integer.parseInt(writingField.getText());
        int codingScore = Integer.parseInt(codingField.getText());
        int interviewScore = Integer.parseInt(interviewField.getText());

        Candidate candidate;
        if (path.equals("Android Developer")) {
            candidate = new AndroidDeveloper(name, writingScore, codingScore, interviewScore);
        } else {
            candidate = new WebDeveloper(name, writingScore, codingScore, interviewScore);
        }

        candidateController.addCandidate(candidate);
        loadCandidates();
        clearFields();
    }

    private void updateCandidate() {
        String name = nameField.getText();
        String path = (String) pathField.getSelectedItem();
        int writingScore = Integer.parseInt(writingField.getText());
        int codingScore = Integer.parseInt(codingField.getText());
        int interviewScore = Integer.parseInt(interviewField.getText());

        Candidate candidate;
        if (path.equals("Android Developer")) {
            candidate = new AndroidDeveloper(name, writingScore, codingScore, interviewScore);
        } else {
            candidate = new WebDeveloper(name, writingScore, codingScore, interviewScore);
        }

        candidateController.updateCandidate(candidate);
        loadCandidates();
        clearFields();
    }

    private void deleteCandidate() {
        String name = nameField.getText();
        String path = (String) pathField.getSelectedItem();
        candidateController.deleteCandidate(name, path);
        loadCandidates();
        clearFields();
    }

    private void clearFields() {
        nameField.setText("");
        pathField.setSelectedIndex(0);
        writingField.setText("");
        codingField.setText("");
        interviewField.setText("");
    }

    private void loadCandidates() {
        tableModel.setRowCount(0);
        List<Candidate> candidates = candidateController.getAllCandidates();
        for (Candidate candidate : candidates) {
            tableModel.addRow(new Object[]{
                candidate.getName(),
                candidate.getPath(),
                candidate.getWritingScore(),
                candidate.getCodingScore(),
                candidate.getInterviewScore(),
                candidate.getFinalScore(),
                candidate.getStatus()
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RecruitmentGUI().setVisible(true);
            }
        });
    }
}
