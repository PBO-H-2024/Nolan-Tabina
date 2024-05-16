/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taskmvc;

import controller.MainController;
import view.ReadData;

public class Main {
    public static void main(String[] args) {
        MainController controller = new MainController();
        new ReadData(controller);
    }
}

