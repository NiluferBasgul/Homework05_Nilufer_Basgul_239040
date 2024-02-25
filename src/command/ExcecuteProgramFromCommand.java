package command;

import calculator.Calculator;

public class ExcecuteProgramFromCommand implements Command {
    private final Calculator calculator;
    private final double operand;
    private double prevValue;

    public ExcecuteProgramFromCommand(Calculator calculator, double operand) {
        this.calculator = calculator;
        this.operand = operand;
    }

    public void execute() {
        prevValue = calculator.getCurrentValue();
        calculator.subtract(operand);
    }

    public void undo() {
        calculator.setCurrentValue(prevValue);
    }
}