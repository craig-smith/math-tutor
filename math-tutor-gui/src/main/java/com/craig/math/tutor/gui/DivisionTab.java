package com.craig.math.tutor.gui;

import com.craig.math.tutor.engine.MathProblem;
import com.craig.math.tutor.engine.MathProblemGenerator;

public class DivisionTab extends MathTab {

    private MathProblemGenerator mathProblemGenerator;

    public DivisionTab() {
        this.mathProblemGenerator = new MathProblemGenerator(MathProblemGenerator.DIVISION_PROBLEM, 10, 1);
        init();
    }

    @Override
    MathProblem getMathProblem() {
        return mathProblemGenerator.generateProblem();
    }
}
