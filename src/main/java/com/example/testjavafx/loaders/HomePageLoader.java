package com.example.testjavafx.loaders;

import com.example.testjavafx.DependencyResolver;
import com.example.testjavafx.FreshApplication;

import java.net.URL;

public class HomePageLoader extends FXMLLoaderWithDI
{
  public HomePageLoader(DependencyResolver dependencies)
  {
	super(
		dependencies,
		FreshApplication.class.getResource("home-view.fxml")
	  );
  }
}
