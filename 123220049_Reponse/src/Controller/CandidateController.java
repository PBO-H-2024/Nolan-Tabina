/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author PC PRAKTIKUM
 */
import Model.AndroidDeveloper;
import Model.Candidate;
import Model.WebDeveloper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CandidateController {
    private Connection connection;

    public CandidateController() {
        connection = DatabaseConnection.getConnection();
    }

    public void addCandidate(Candidate candidate) {
        try {
            String query = "INSERT INTO recruitment (name, path, writing, coding, interview, score, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, candidate.getName());
            statement.setString(2, candidate.getPath());
            statement.setInt(3, candidate.getWritingScore());
            statement.setInt(4, candidate.getCodingScore());
            statement.setInt(5, candidate.getInterviewScore());
            statement.setDouble(6, candidate.getFinalScore());
            statement.setString(7, candidate.getStatus());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCandidate(Candidate candidate) {
        try {
            String query = "UPDATE recruitment SET writing = ?, coding = ?, interview = ?, score = ?, status = ? WHERE name = ? AND path = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, candidate.getWritingScore());
            statement.setInt(2, candidate.getCodingScore());
            statement.setInt(3, candidate.getInterviewScore());
            statement.setDouble(4, candidate.getFinalScore());
            statement.setString(5, candidate.getStatus());
            statement.setString(6, candidate.getName());
            statement.setString(7, candidate.getPath());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCandidate(String name, String path) {
        try {
            String query = "DELETE FROM recruitment WHERE name = ? AND path = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, path);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Candidate> getAllCandidates() {
        List<Candidate> candidates = new ArrayList<>();
        try {
            String query = "SELECT * FROM recruitment";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                int writingScore = resultSet.getInt("writing");
                int codingScore = resultSet.getInt("coding");
                int interviewScore = resultSet.getInt("interview");
                double finalScore = resultSet.getDouble("score");
                String status = resultSet.getString("status");

                Candidate candidate = null;
                if (path.equals("Android Developer")) {
                    candidate = new AndroidDeveloper(name, writingScore, codingScore, interviewScore);
                } else if (path.equals("Web Developer")) {
                    candidate = new WebDeveloper(name, writingScore, codingScore, interviewScore);
                }
                candidates.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return candidates;
    }
}

