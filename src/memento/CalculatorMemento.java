package memento;

public class CalculatorMemento {
    private final double state;

    public CalculatorMemento(double state) {
        this.state = state;
    }

    public double getState() {
        return state;
    }
}