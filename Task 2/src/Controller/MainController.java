/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Connector;

public class MainController {
    private Connector connector;
    
    public MainController() {
        connector = new Connector();
    }
    
    public void insertData(int nim, String name, int age) {
        if (name != null && !name.isEmpty() && nim > 0 && age > 0) {
            connector.insertData(nim, name, age);
        } else {
            System.out.println("Invalid input");
        }
    }
    
    public String[][] readData() {
        return connector.readData();
    }
    
    public void updateData(int id, int nim, String name, int age) {
        if (name != null && !name.isEmpty() && nim > 0 && age > 0 && id > 0) {
            connector.updateData(id, nim, name, age);
        } else {
            System.out.println("Invalid input");
        }
    }
    
    public void deleteData(int id) {
        if (id > 0) {
            connector.deleteData(id);
        } else {
            System.out.println("Invalid id");
        }
    }
}
