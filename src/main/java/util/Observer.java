package util;

public interface Observer<T extends Observable> {
    void handleChange(T observable);
}
