package command;

import calculator.Calculator;

public class AddCommand implements Command {
    private final Calculator calculator;
    private final double operand;
    private double prevValue;

    public AddCommand(Calculator calculator, double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        prevValue = calculator.getCurrentValue();
        calculator.add(operand);
    }

    public void undo() {
        calculator.setCurrentValue(prevValue);
    }
}
