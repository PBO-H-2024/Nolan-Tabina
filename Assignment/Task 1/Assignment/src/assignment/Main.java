/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

import BangunRuang.Tabung;
import BangunRuang.LimasSegitiga;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n\tMENU");
            System.out.println("1. Tabung");
            System.out.println("2. Limas Segitiga");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Menu: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.print("Jari-jari tabung: ");
                double jariJari = scanner.nextDouble();
                System.out.print("Tinggi tabung: ");
                double tinggi = scanner.nextDouble();

                Tabung tabung1 = new Tabung(jariJari, tinggi);
                System.out.println("\nHasil perhitungan:");
                System.out.println("Volume: " + tabung1.volume());
                System.out.println("Luas permukaan: " + tabung1.luasPermukaan());
            } else if (pilihan == 2) {
                System.out.print("Alas limas segitiga: ");
                double alas = scanner.nextDouble();
                System.out.print("Tinggi segitiga: ");
                double tinggiSegitiga = scanner.nextDouble();
                System.out.print("Tinggi limas segitiga: ");
                double tinggiLimas = scanner.nextDouble();

                LimasSegitiga limassegitiga1 = new LimasSegitiga(alas, tinggiSegitiga, tinggiLimas);
                System.out.println("Hasil perhitungan:");
                System.out.println("Volume: " + limassegitiga1.volume());
                System.out.println("Luas permukaan: " + limassegitiga1.luasPermukaan());
            } else if (pilihan == 3) {
                System.out.println("\n\tBye.");
                break;
            } else {
                System.out.println("Invalid.");
            }

             System.out.print("\nPress Any Key To Continue...");
            new java.util.Scanner(System.in).nextLine();
        }

        scanner.close();
    }
    
}
