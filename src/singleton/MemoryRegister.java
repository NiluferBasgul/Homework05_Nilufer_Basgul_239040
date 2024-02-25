package singleton;

public class MemoryRegister {
    private static MemoryRegister instance;
    private double value;

    private MemoryRegister() {}

    public static MemoryRegister getInstance() {
        if (instance == null) {
            instance = new MemoryRegister();
        }
        return instance;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}