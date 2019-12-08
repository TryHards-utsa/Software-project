package application.controller;

import application.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class DriverAssign {


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
	
}
