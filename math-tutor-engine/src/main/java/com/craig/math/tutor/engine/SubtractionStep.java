package com.craig.math.tutor.engine;

import lombok.Builder;
import lombok.Getter;

import java.util.function.Function;

@Getter
@Builder
public class SubtractionStep implements MathStep {

    private Double num;

    @Override
    public Function<Double, Double> getMathStep() {
        return e -> e - num;
    }

    @Override
    public String print() {
        return " - " + num;
    }
}
