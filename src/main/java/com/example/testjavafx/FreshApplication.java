package com.example.testjavafx;

import com.example.testjavafx.homePage.HomeScene;
import com.example.testjavafx.homePage.HomeStage;
import domain.Game;
import domain.GameCurrency;
import domain.GameState;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class FreshApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        DependencyResolver factory = new ApplicationControllerFactory(
            new Game(
                new GameState(GameCurrency.Zero(), GameCurrency.One()),
                Optional.empty()
            )
        );
        FXMLLoader loader = new FXMLLoaderWithDI(
            factory,
            FreshApplication.class.getResource("home-view.fxml")
        );
        try {
            new HomeStage(
                new HomeScene(
                    loader.load()
                )
            ).show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        factory.getGame().getClock().start();
    }

    public static void main(String[] args) {
        launch();
    }
}