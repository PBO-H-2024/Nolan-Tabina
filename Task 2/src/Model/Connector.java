package model;

import java.sql.*;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/student_db";
    String DBusername = "root";
    String DBpassword = "";
    
    Connection conn;
    
    public Connector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed: " + ex.getMessage());
        }
    }
    
    private Statement createStatement() throws SQLException {
        return conn.createStatement();
    }
    
    public void insertData(int nim, String name, int age){
        try{
            String query = "INSERT INTO student (nim, name, age) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, nim);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.executeUpdate();
            System.out.println("Input Success");
        }catch(Exception ex){
            System.out.println("Input Failed: " + ex.getMessage());
        }
    }
    
    public String[][] readData(){
        String data[][] = new String[10][4]; 
        try{
            int totalData = 0;
            String query = "SELECT * FROM student";
            Statement statement = createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("nim");
                data[totalData][2] = resultSet.getString("name");
                data[totalData][3] = resultSet.getString("age");
                totalData++;
            }
            statement.close();
        }catch(SQLException e){
            System.out.println("SQL Error: " + e.getMessage());
        }
        return data;
    }
    
    public void updateData(int id, int nim, String name, int age){
        try{
            String query = "UPDATE student SET nim = ?, name = ?, age = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, nim);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Update Success");
        }catch(Exception ex){
            System.out.println("Update Failed: " + ex.getMessage());
        }
    }
    
    public void deleteData(int id){
        try{
            String query = "DELETE FROM student WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Delete Success");
        }catch(Exception ex){
            System.out.println("Delete Failed: " + ex.getMessage());
        }
    }
}
