package com.example.testjavafx;

import com.example.testjavafx.components.IncomeButton;
import com.example.testjavafx.components.IncomeButtonController;
import domain.Game;
import javafx.util.Builder;

public class ApplicationControllerFactory extends DependencyResolver {

    public ApplicationControllerFactory(Game data) {
        super(data);
    }

    @Override
    public Object call(Class<?> aClass) {
        if(aClass == MainController.class)
            return new MainController(this.game);
        else if(aClass == IncomeButtonController.class)
            return new IncomeButtonController(this.game);
        return null;
    }

    @Override
    public Builder<?> getBuilder(Class<?> aClass) {
        if(aClass == IncomeButton.class)
            return () -> new IncomeButton(this);
        return null;
    }
}
