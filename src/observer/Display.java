package observer;

public class Display implements Observer {
    @Override
    public void update(String notification) {
        System.out.println(notification);
    }
}