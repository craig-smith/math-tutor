package com.craig.math.tutor.engine;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Builder
@Getter
public class MathProblem implements Solvable, Printable {

    private Double num;

    @Singular("step")
    private List<MathStep> steps;

    @Override
    public Double solve() {
        Function<Double, Double> equation = steps.stream()
                .map(MathStep::getMathStep)
                .collect(Collectors.toList()).stream()
                .reduce(Function.identity(), Function::andThen);

        return equation.apply(num);
    }

    @Override
    public String print() {
        StringBuilder equationBuilder = new StringBuilder();
        equationBuilder.append(num);
        steps.forEach(e -> equationBuilder.append(e.print()));
        equationBuilder.append(" = ");
        return equationBuilder.toString();
    }

}
