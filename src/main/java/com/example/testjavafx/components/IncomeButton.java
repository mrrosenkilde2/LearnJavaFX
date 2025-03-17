package com.example.testjavafx.components;

import com.example.testjavafx.DependencyResolver;
import com.example.testjavafx.loaders.FXMLLoaderWithDI;
import com.example.testjavafx.loaders.IncomeButtonLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import java.io.IOException;

public class IncomeButton extends Region
{
  public IncomeButton(DependencyResolver di) {
        FXMLLoader fxmlLoader = new IncomeButtonLoader(di);
        try {
            Button button = fxmlLoader.load();
            getChildren().add(button);
            getStyleClass().add("incomeButton");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
}
