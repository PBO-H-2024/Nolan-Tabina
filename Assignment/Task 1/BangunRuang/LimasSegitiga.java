/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BangunRuang;
import BangunDatar.Segitiga;

/**
 *
 * @author Widows
 */
public class LimasSegitiga extends Segitiga implements Hitung_BangunRuang{
    private final double TinggiLimas;
    
    public LimasSegitiga(double TinggiAlas, double Alas, double TinggiLimas) {
        super(TinggiAlas, Alas);
        this.TinggiLimas = TinggiLimas;
    }

    @Override
    public double volume() {
        return 1.0 / 3.0 * hitungLuas() * TinggiLimas;
    }
    
    @Override
    public double luasPermukaan() {
        return 4 * hitungLuas();
    }
    
}
