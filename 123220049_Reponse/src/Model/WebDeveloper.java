/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC PRAKTIKUM
 */
public class WebDeveloper extends Candidate {
    private final double writingWeight = 0.4;
    private final double codingWeight = 0.35;
    private final double interviewWeight = 0.25;

    public WebDeveloper(String name, int writingScore, int codingScore, int interviewScore) {
        super(name, "Web Developer", writingScore, codingScore, interviewScore);
        calculateFinalScore();
    }

    @Override
    public void calculateFinalScore() {
        this.finalScore = (writingScore * writingWeight) + (codingScore * codingWeight) + (interviewScore * interviewWeight);
        this.status = finalScore >= 85 ? "Accepted" : "Rejected";
    }
}

