package com.example.testjavafx;

import com.example.testjavafx.components.IncomeButton;
import com.example.testjavafx.loaders.HomePageLoader;
import com.example.testjavafx.loaders.IncomeButtonLoader;
import domain.Game;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaFXTest extends ApplicationTest
{
  private Game game;

  @Override
  public void start(Stage stage) throws IOException
  {
	this.game = Game.freshGame();
	DependencyResolver di = new ApplicationControllerFactory(game);
	FXMLLoader loader = new HomePageLoader(di);
	stage.setScene(
		new Scene(loader.load())
	);
	stage.show();
  }
  @Test
  void IncomeButtonIncrementsScoreTextWithClickValue()
  {
	Label label = lookup("#scoreText").queryAs(Label.class);
	IncomeButton button = lookup(".incomeButton").queryAs(IncomeButton.class);

	assertEquals("0", label.getText());
	clickOn(button);
	assertEquals("1", label.getText());
  }
}
