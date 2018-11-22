package com.craig.math.tutor.engine;

import lombok.Builder;
import lombok.Getter;

import java.util.function.Function;

@Getter
@Builder
public class DivisionStep implements MathStep {

    private Double num;

    @Override
    public Function<Double, Double> getMathStep() {
        return e -> num != 0 ? (e / num) : 0;
    }

    @Override
    public String print() {
        return " / " + num;
    }
}
