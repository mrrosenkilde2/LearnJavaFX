package util;

public interface Observer<T extends Observable> {
    void handleChange(T observable);
    default int getPriority(){
        return 0;
    }
}
