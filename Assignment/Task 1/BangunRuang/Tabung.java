/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangunRuang;
import BangunDatar.Lingkaran;

/**
 *
 * @author Widows
 */
public class Tabung implements Hitung_BangunRuang {
    private final double radius;
    private final double TinggiTabung;

    public Tabung(double radius, double TinggiTabung){
        this.radius = radius;
        this.TinggiTabung = TinggiTabung;
    }

    @Override
    public double volume(){
        return Math.PI * Math.pow(radius, 2) * TinggiTabung;
    }

    @Override
    public double luasPermukaan(){
        return 2 * Math.PI * radius * (radius + TinggiTabung);
    }
    
}
