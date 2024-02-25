package iterator;

import java.util.ArrayList;
import java.util.List;

public class PaperTape {
    private final List<String> operations = new ArrayList<>();

    public void addOperation(String operation) {
        operations.add(operation);
    }

    public TapeIterator<String> createIterator() {
        return new TapeIterator<>(operations);
    }
}
