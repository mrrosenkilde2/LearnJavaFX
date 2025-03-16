package com.example.testjavafx.homePage;

import com.example.testjavafx.FreshApplication;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.Objects;

public class HomeScene extends Scene {
    public HomeScene(Parent parent) {
        super(parent);
        getStylesheets().add(
                Objects.requireNonNull(
                        FreshApplication.class.getResource("home-view.css")
                ).toExternalForm()
        );
    }
}
