package util;

public interface Observable <T extends Observable<T>>{
    void addObserver(Observer<T> observer);
    void removeObserver(Observer<T> observer);
    void notifyObservers();
}
