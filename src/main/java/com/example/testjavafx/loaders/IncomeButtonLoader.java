package com.example.testjavafx.loaders;

import com.example.testjavafx.DependencyResolver;
import com.example.testjavafx.FreshApplication;

import java.net.URL;

public class IncomeButtonLoader extends FXMLLoaderWithDI
{
  public IncomeButtonLoader(DependencyResolver dependencies)
  {
	super(
		dependencies,
		FreshApplication.class.getResource("/com/example/testjavafx/components/incomeButton-view.fxml")
	);
  }
}
