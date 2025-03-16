package com.example.testjavafx;

import com.example.testjavafx.components.IncomeButton;
import com.example.testjavafx.components.IncomeButtonController;
import domain.Game;
import domain.GameState;
import domain.events.PostTickEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label score_text;

    private final Game game;

    MainController(Game game){
        this.game = game;
        this.game.getClock().getPostTickEvent().addObserver(this::PostTickEventHandler);
    }

    private void PostTickEventHandler(PostTickEvent event){
        if(baseCurrencyHaveChanged(
            event.getPreviousState(),
            event.getCurrentState()
        )) Platform.runLater(this::UpdateScoreText);
    }

    private boolean baseCurrencyHaveChanged(GameState previous, GameState current){
        return previous.baseCurrencyIsDifferentFrom(current.baseCurrency());
    }

    private void UpdateScoreText(){
        score_text.setText(game.getBaseCurrency().format());
        System.out.println("score updated");
    }

}