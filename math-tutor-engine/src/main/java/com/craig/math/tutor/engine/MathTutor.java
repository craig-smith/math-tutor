package com.craig.math.tutor.engine;

import java.util.Scanner;

public class MathTutor {

    private static Scanner scanner = new Scanner(System.in);
    private static MathProblemGenerator generator = new MathProblemGenerator(0, 10, 2);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            runGame(generator.generateProblem());
        }
    }

    private static void runGame(MathProblem mathProblem) {
        System.out.println("*****************");


        System.out.print(mathProblem.print());

        Double userAnswer = null;
        try {
            userAnswer = scanner.nextDouble();
        } catch (Exception ex) {
            System.out.println("Only numbers allowed!!");
            scanner.nextLine();
        }


        if (userAnswer != null && userAnswer.equals(mathProblem.solve())) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect!!");
            System.out.print("The correct answer is: ");
            System.out.println(mathProblem.solve());
        }

        System.out.println("*****************");
    }
}
