package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CustomerPortal implements EventHandler<ActionEvent> {

	public void handle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/roomOne.fxml" ) ); 
			Scene scene = new Scene( root, 600, 640 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
