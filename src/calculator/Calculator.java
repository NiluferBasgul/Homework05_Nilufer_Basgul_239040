package calculator;

import command.Command;
import iterator.TapeIterator;
import memento.CalculatorCareTaker;
import observer.Observer;
import singleton.MemoryRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Calculator {

    private double currentValue;
    private Stack<Command> history = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();
    private boolean isPaperTapeEnabled = false;
    private List<Observer> observers = new ArrayList<>();
    private boolean isIntegerMode = false;

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double value) {
        double previousValue = currentValue;
        currentValue = value;
        notifyObservers("Set Current Value", previousValue, currentValue, currentValue);
    }

    public void add(double operand) {
        double previousValue = currentValue;
        currentValue += operand;
        notifyObservers("Addition", previousValue, operand, currentValue);
    }

    public void subtract(double operand) {
        double previousValue = currentValue;
        currentValue -= operand;
        notifyObservers("Subtraction", previousValue, operand, currentValue);
    }

    public void multiply(double operand) {
        double previousValue = currentValue;
        currentValue *= operand;
        notifyObservers("Multiplication", previousValue, operand, currentValue);
    }

    public void divide(double operand) {
        double previousValue = currentValue;
        if (operand != 0) {
            currentValue /= operand;
        } else {
            System.out.println("Error: Division by zero");
        }
        notifyObservers("Division", previousValue, operand, currentValue);
    }

    public void memoryStore() {
        MemoryRegister.getInstance().setValue(currentValue);
    }

    public void memoryRecall() {
        double previousValue = currentValue;
        currentValue = MemoryRegister.getInstance().getValue();
        notifyObservers("Memory Recall", previousValue, 0.0, currentValue);
    }


    public void memoryClear() {
        MemoryRegister.getInstance().setValue(0);
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command lastCommand = history.pop();
            lastCommand.undo();
            redoStack.push(lastCommand);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command lastUndoneCommand = redoStack.pop();
            lastUndoneCommand.execute();
            history.push(lastUndoneCommand);
        }
    }

    public void togglePaperTape() {
        isPaperTapeEnabled = !isPaperTapeEnabled;
    }

    public boolean isPaperTapeEnabled() {
        return isPaperTapeEnabled;
    }

    public TapeIterator<String> getPaperTapeIterator(List<String> paperTapeOperations) {
        if (isPaperTapeEnabled) {
            return new TapeIterator<>(paperTapeOperations);
        } else {
            return null;
        }
    }


    public void cos(double operand) {
        double previousValue = currentValue;
        currentValue = Math.cos(operand);
        notifyObservers("Cosine", previousValue, operand, currentValue);
    }

    public void sin(double operand) {
        double previousValue = currentValue;
        currentValue = Math.sin(Math.toRadians(operand)); // Convert degrees to radians
        notifyObservers("Sin", previousValue, operand, currentValue);
    }

    public void tan(double operand) {
        double previousValue = currentValue;
        currentValue = Math.tan(operand);
        notifyObservers("Tangent", previousValue, operand, currentValue);
    }

    public void exponentiation(double base, double exponent) {
        double previousValue = currentValue;
        currentValue = Math.pow(base, exponent);
        notifyObservers("Exponentiation", Double.parseDouble(base + "^" + exponent), previousValue, currentValue);
    }

    public void squareRoot(double operand) {
        double previousValue = currentValue;
        currentValue = Math.sqrt(operand);
        notifyObservers("Square Root", operand, previousValue, currentValue);
    }

    public void logarithm(double operand) {
        double previousValue = currentValue;
        currentValue = Math.log(operand);
        notifyObservers("Logarithm", operand, previousValue, currentValue);
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String operation, double operand1, double operand2, double result) {
        for (Observer observer : observers) {
            observer.update("Operation: " + operation + ", Operand 1: " + operand1 + ", Operand 2: " + operand2 + ", Result: " + result);
        }
    }

}
