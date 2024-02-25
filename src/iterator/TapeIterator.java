package iterator;

import java.util.List;

public class TapeIterator<T> {
    private final List<T> tape;
    private int position;

    public TapeIterator(List<T> tape) {
        this.tape = tape;
        this.position = 0;
    }

    public boolean hasNext() {
        return position < tape.size();
    }

    public T next() {
        return tape.get(position++);
    }
}
