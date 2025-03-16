package domain.events;

import util.Observable;
import util.Observer;

import java.util.ArrayList;

public abstract class DefaultEventImpl<T extends Observable<T>> implements Observable<T> {
    private final ArrayList<Observer<T>> observers;

    protected DefaultEventImpl() {
        this.observers = new ArrayList<>();
    }
    @Override
    public void addObserver(Observer<T> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer<T> obs : observers)
            obs.handleChange((T) this);
    }
}
