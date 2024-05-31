/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC PRAKTIKUM
 */
public class AndroidDeveloper extends Candidate {
    private final double writingWeight = 0.2;
    private final double codingWeight = 0.5;
    private final double interviewWeight = 0.3;

    public AndroidDeveloper(String name, int writingScore, int codingScore, int interviewScore) {
        super(name, "Android Developer", writingScore, codingScore, interviewScore);
        calculateFinalScore();
    }

    @Override
    public void calculateFinalScore() {
        this.finalScore = (writingScore * writingWeight) + (codingScore * codingWeight) + (interviewScore * interviewWeight);
        this.status = finalScore >= 85 ? "Accepted" : "Rejected";
    }
}

