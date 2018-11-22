package com.craig.math.tutor.engine;

import lombok.Builder;
import lombok.Getter;

import java.util.function.Function;

@Builder
@Getter
public class AdditionStep implements MathStep {

    private Double num;

    @Override
    public Function<Double, Double> getMathStep () {
        return e -> e + num;
    }

    @Override
    public String print() {
        return " + " + num;
    }
}
