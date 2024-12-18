package genericTest;

public class Basket<T> {
    private T data;

    public T get() {
        return data;
    }

    public void add(T data) {
        this.data = data;
    }
}
