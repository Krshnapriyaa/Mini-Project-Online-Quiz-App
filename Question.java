/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinequizapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author hp
 */


public class Question {
    private String question;
    private String[] options;
    private int correctAnswerIndex;
    private String explanation;
    private String category;
    private String difficulty;

    public Question(String question, String[] options, int correctAnswerIndex,
                    String explanation, String category, String difficulty) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
        this.explanation = explanation;
        this.category = category;
        this.difficulty = difficulty;
    }

    public void displayQuestion() {
        System.out.println("\n[" + difficulty + " | " + category + "]");
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }

    public void displayExplanation() {
        System.out.println("Explanation: " + explanation);
    }

    public String getCategory() {
        return category;
    }

    // ✅ Add this method to fix the error
    public String[] getOptions() {
        return options;
    }
}
