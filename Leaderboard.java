/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinequizapp;

/**
 *
 * @author hp
 */
import java.util.*;



public class Leaderboard {
    private Map<String, Integer> scores = new HashMap<>();

    public void addScore(String player, int score) {
        scores.put(player, score);
    }

    public void displayLeaderboard() {
        System.out.println("\n--- Leaderboard ---");
        scores.entrySet()
              .stream()
              .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
              .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        System.out.println("------------------");
    }
}
