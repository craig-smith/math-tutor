package com.craig.math.tutor.engine;

import java.util.Random;
import java.util.stream.IntStream;

public class MathProblemGenerator {

    public static int ADDITION_PROBLEM = 0;
    public static final int SUBTRACTION_PROBLEM = 1;
    public static final int MULTIPLICATION_PROBLEM = 2;
    public static final int DIVISION_PROBLEM = 3;

    private int problemType;
    private int problemDifficulty;
    private int steps;

    private Random random = new Random();

    public MathProblemGenerator(int problemType, int problemDifficulty, int steps) {
        this.problemType = problemType;
        this.problemDifficulty = problemDifficulty;
        this.steps = steps;
    }

    public MathProblem generateProblem() {
        MathProblem.MathProblemBuilder builder = MathProblem.builder().num(getRandomNumber());
        IntStream.range(0, steps).forEach(i -> builder.step(getRandomProblem()));
        return builder.build();
    }

    private MathStep getRandomProblem() {
        switch (problemType) {
            case 0:
                return AdditionStep.builder().num(getRandomNumber()).build();
            case 1:
                return SubtractionStep.builder().num(getRandomNumber()).build();
            case 2:
                return MultiplicationStep.builder().num(getRandomNumber()).build();
            case 3:
                return DivisionStep.builder().num(getRandomNumber()).build();
            default:
                return AdditionStep.builder().num(getRandomNumber()).build();
        }
    }

    private Double getRandomNumber() {
        return removeDecimalPlaces(random.nextDouble() * problemDifficulty);
    }

    private Double removeDecimalPlaces(Double num) {
        return new Double(num.intValue());
    }
}
