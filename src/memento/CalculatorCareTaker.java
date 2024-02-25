package memento;

import java.util.Stack;

public class CalculatorCareTaker {
    private final Stack<CalculatorMemento> mementos = new Stack<>();

    public void addMemento(CalculatorMemento memento) {
        mementos.push(memento);
    }

    public CalculatorMemento getMemento() {
        return mementos.pop();
    }
}