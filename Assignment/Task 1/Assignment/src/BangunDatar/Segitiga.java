/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangunDatar;

/**
 *
 * @author Widows
 */
public class Segitiga implements Hitung_BangunDatar{
    private final double TinggiAlas;
    private final double Alas;
    
    public Segitiga(double TinggiAlas, double Alas){
        this.TinggiAlas = TinggiAlas;
        this.Alas = Alas;
    }
    
    @Override
    public double hitungLuas(){
        return Alas * TinggiAlas / 2.0;
    }
    
    @Override
    public double hitungKeliling(){
        double Pythagoras = Math.sqrt((1/2 * (Alas) * 1/2 * (Alas) + (TinggiAlas * TinggiAlas)));
        return (2 * Pythagoras) + Alas;
    }
}
