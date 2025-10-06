/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package onlinequizapp;

import java.util.*;

public class Quiz {
    private List<Question> questions;
    private int score;
    private Scanner sc;
    private Leaderboard leaderboard;

    public Quiz() {
        questions = new ArrayList<>();
        sc = new Scanner(System.in);
        leaderboard = new Leaderboard();
        loadQuestions();
    }

    private void loadQuestions() {
        // Java Questions
        questions.add(new Question("What is Java?", new String[]{"A car", "A programming language", "An OS", "A coffee brand"}, 1, "Java is a high-level programming language.", "Java", "Easy"));
        questions.add(new Question("Which keyword is used for inheritance?", new String[]{"extends", "super", "this", "implements"}, 0, "'extends' is used for class inheritance.", "Java", "Medium"));
        questions.add(new Question("Which method is the entry point of Java?", new String[]{"main()", "run()", "start()", "init()"}, 0, "The 'main' method is the entry point.", "Java", "Easy"));
        questions.add(new Question("Which exception occurs when dividing by zero?", new String[]{"ArithmeticException", "IOException", "NullPointerException", "ArrayIndexOutOfBoundsException"}, 0, "Dividing by zero throws ArithmeticException.", "Java", "Medium"));

        // General Knowledge Questions
        questions.add(new Question("Which planet is called the Red Planet?", new String[]{"Mars", "Earth", "Jupiter", "Venus"}, 0, "Mars is the Red Planet.", "GK", "Easy"));
        questions.add(new Question("Who invented the telephone?", new String[]{"Alexander Graham Bell", "Thomas Edison", "Nikola Tesla", "Albert Einstein"}, 0, "Alexander Graham Bell invented the telephone.", "GK", "Medium"));
        questions.add(new Question("Largest ocean on Earth?", new String[]{"Pacific", "Atlantic", "Indian", "Arctic"}, 0, "Pacific Ocean is the largest.", "GK", "Easy"));
        questions.add(new Question("Longest river in the world?", new String[]{"Nile", "Amazon", "Yangtze", "Mississippi"}, 0, "The Nile River is considered the longest.", "GK", "Medium"));

        // Science Questions
        questions.add(new Question("What is H2O commonly known as?", new String[]{"Water", "Oxygen", "Hydrogen", "Salt"}, 0, "H2O is water.", "Science", "Easy"));
        questions.add(new Question("Which gas do plants produce during photosynthesis?", new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"}, 0, "Plants release oxygen during photosynthesis.", "Science", "Medium"));

        Collections.shuffle(questions);
    }

    public void startQuiz() {
        System.out.print("Enter your name: ");
        String player = sc.nextLine();

        do {
            score = 0;
            System.out.println("Select category: Java / GK / Science / All");
            String categoryChoice = sc.nextLine().trim();

            List<Question> selectedQuestions = new ArrayList<>();
            for (Question q : questions) {
                if (categoryChoice.equalsIgnoreCase("All") || q.getCategory().equalsIgnoreCase(categoryChoice)) {
                    selectedQuestions.add(q);
                }
            }

            Collections.shuffle(selectedQuestions);

            for (Question q : selectedQuestions) {
                q.displayQuestion();
                int answer = getValidAnswer(q.getOptions().length);
                if (q.checkAnswer(answer - 1)) { // subtract 1 for 0-based index
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Wrong!");
                }
                q.displayExplanation();
            }

            System.out.println("\nQuiz Over! " + player + ", Your Score: " + score + "/" + selectedQuestions.size());
            leaderboard.addScore(player, score);
            leaderboard.displayLeaderboard();

            System.out.print("Do you want to play again? (yes/no): ");
        } while (sc.nextLine().trim().equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
    }

    private int getValidAnswer(int optionCount) {
        int answer = 0;
        while (true) {
            System.out.print("Enter your answer (1-" + optionCount + "): ");
            String input = sc.nextLine().trim();
            try {
                answer = Integer.parseInt(input);
                if (answer >= 1 && answer <= optionCount) break;
                else System.out.println("Invalid choice! Please select a number between 1 and " + optionCount + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number (1-" + optionCount + ").");
            }
        }
        return answer;
    }
}
