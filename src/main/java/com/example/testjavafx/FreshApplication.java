package com.example.testjavafx;

import com.example.testjavafx.homePage.HomeScene;
import com.example.testjavafx.homePage.HomeStage;
import com.example.testjavafx.loaders.FXMLLoaderWithDI;
import com.example.testjavafx.loaders.HomePageLoader;
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
            Game.freshGame()
        );
        try {
            new HomeStage(
                new HomeScene(
                    new HomePageLoader(factory).load()
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