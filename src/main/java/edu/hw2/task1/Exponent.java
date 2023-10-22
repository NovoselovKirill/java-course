package edu.hw2.task1;

public record Exponent(Expr base, double exponent) implements Expr {
    @Override
    public double evaluate() {
        double evaluated = base.evaluate();
        if (evaluated < 0) {
            throw new IllegalStateException();
        }
        return Math.pow(evaluated, exponent);
    }
}
