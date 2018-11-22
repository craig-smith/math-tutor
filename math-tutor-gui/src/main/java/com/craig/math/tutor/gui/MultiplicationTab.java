package com.craig.math.tutor.gui;

import com.craig.math.tutor.engine.MathProblem;
import com.craig.math.tutor.engine.MathProblemGenerator;

public class MultiplicationTab extends MathTab {

    private MathProblemGenerator mathProblemGenerator;

    public MultiplicationTab() {
        this.mathProblemGenerator = new MathProblemGenerator(MathProblemGenerator.MULTIPLICATION_PROBLEM, 10, 1);
        init();
    }

    @Override
    MathProblem getMathProblem() {
        return mathProblemGenerator.generateProblem();
    }
}
