package com.example.testjavafx.components;

import domain.Game;
import domain.eventHandlers.AddClickIncomeToScoreOnClick;
import javafx.fxml.FXML;

public class IncomeButtonController {
    private final Game game;

    public IncomeButtonController(Game game) {
        this.game = game;
        game.getEventManager().getIncomeClickEvent().addObserver(
            new AddClickIncomeToScoreOnClick(game.getBaseCurrency(), game.getClickValue())
        );
    }

    @FXML
    public void onIncomeButtonClicked(){
        if(game != null){
            game.getEventManager().getIncomeClickEvent().click();
        }
    }
}
