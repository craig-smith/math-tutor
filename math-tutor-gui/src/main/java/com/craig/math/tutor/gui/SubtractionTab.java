package com.craig.math.tutor.gui;

import com.craig.math.tutor.engine.MathProblem;
import com.craig.math.tutor.engine.MathProblemGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class SubtractionTab extends MathTab {

    public SubtractionTab() {
        init();
    }

    @Override
    MathProblem getMathProblem() {
        return new MathProblemGenerator(MathProblemGenerator.SUBTRACTION_PROBLEM, 10, getSteps()).generateProblem();
    }

    private static int getSteps() {
        boolean stepBool = ThreadLocalRandom.current().nextBoolean();
        return stepBool ? 1 : 2;
    }
}
