package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Dataset;
import application.model.Item;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

public class DriverAssign implements Initializable {

	@FXML private ListView<Item> driverList;

	public void storeviewhandle(ActionEvent event) {
		
		try {
			
			Parent root1 = FXMLLoader.load( getClass().getResource( "../view/StoreMenu.fxml" ) ); 
			Scene scene1 = new Scene( root1, 600, 470 );
			Main.stage.setScene(scene1);
			Main.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void exithandle(ActionEvent event) {
		
		try {
			Platform.exit();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Dataset stock = new Dataset( "Current stock" );
//		try {
//			stock.loadDrivers("csv/items.csv");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		driverList.getItems().addAll( stock.getDriverList() );
	}
	
}
