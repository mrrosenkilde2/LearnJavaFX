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

    protected void notifyObservers(T _this){
        for(Observer<T> obs : observers)
            obs.handleChange(_this);
    }

    @Override
    public void notifyObservers() {
        for(Observer<T> obs : observers)
            //cast is ugly here but its the best way the observers can reserve the right class without breaking the interface
            obs.handleChange((T) this);
    }
}
