package com.example.testjavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.net.URL;
import java.io.IOException;

public class FXMLLoaderWithDI extends FXMLLoader {
    private final DependencyResolver dependencies;

    public FXMLLoaderWithDI(DependencyResolver dependencies, URL url){
        super(url);
        this.dependencies = dependencies;
        setControllerFactory(dependencies);
        setBuilderFactory(dependencies);
    }

    public FXMLLoaderWithDI(DependencyResolver dependencies) {
        this.dependencies = dependencies;
    }

    public FXMLLoader createLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        loader.setControllerFactory(dependencies);
        return loader;
    }

    public Parent load(String fxmlPath) throws IOException {
        return createLoader(fxmlPath).load();
    }
}
