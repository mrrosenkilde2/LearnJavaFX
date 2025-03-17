package com.example.testjavafx;

import com.example.testjavafx.components.IncomeButton;
import domain.Game;
import domain.GameState;
import domain.events.GameCurrencyChangedEvent;
import domain.events.PostTickEvent;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label scoreText;

    @FXML
    private IncomeButton incomeButton;

    private final Game game;

    MainController(Game game){
        this.game = game;
        this.game.getEventManager().getBaseCurrencyChangedEvent().addObserver(this::UpdateScoreText);
    }

    private void UpdateScoreText(GameCurrencyChangedEvent gameCurrencyChangedEvent) {
        scoreText.setText(gameCurrencyChangedEvent.getCurrency().format());
        System.out.println("score updated");
    }

}