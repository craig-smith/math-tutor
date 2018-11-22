package com.craig.math.tutor.engine;

import java.util.function.Function;

public interface MathStep extends Printable {

    Function<Double, Double> getMathStep();
}
