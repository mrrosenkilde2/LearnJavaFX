package com.example.testjavafx;

import com.example.testjavafx.components.IncomeButtonController;
import domain.Game;
import javafx.util.BuilderFactory;
import javafx.util.Callback;

public abstract class DependencyResolver implements Callback<Class<?>,Object>, BuilderFactory {
    protected final Game game;
    public DependencyResolver(Game game){
        this.game = game;
    }
    public Object getIncomeButtonController() {
        return call(IncomeButtonController.class);
    }
    public Object getMainController() {
        return call(MainController.class);
    }
    public Game getGame() {
        return this.game;
    }
    public abstract Object call(Class<?> aClass);

}
