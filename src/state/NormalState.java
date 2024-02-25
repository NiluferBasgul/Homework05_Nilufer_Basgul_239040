package state;

import calculator.Calculator;

public class NormalState implements CalculatorState {
    private final Calculator calculator;

    public NormalState(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void executeOperation(double operand) {
        // Perform operation in normal state
    }
}