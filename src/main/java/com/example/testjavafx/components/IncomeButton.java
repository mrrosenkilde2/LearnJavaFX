package com.example.testjavafx.components;

import com.example.testjavafx.DependencyResolver;
import com.example.testjavafx.FXMLLoaderWithDI;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;

import java.io.IOException;

public class IncomeButton extends Region
{
  public IncomeButton(DependencyResolver di) {
        FXMLLoader fxmlLoader = new FXMLLoaderWithDI(
            di,
            getClass().getResource("incomeButton-view.fxml")
        );
        try {
            Button button = fxmlLoader.load();
            getChildren().add(button);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
}
