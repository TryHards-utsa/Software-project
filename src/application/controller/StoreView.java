package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StoreView {

	public void carthandle(ActionEvent event) {
		try {

			Parent root1 = FXMLLoader.load( getClass().getResource( "../view/Cart.fxml" ) ); 
			Scene scene1 = new Scene( root1, 600, 600 );
			Main.stage.setScene(scene1);
			Main.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addtocarthandle(ActionEvent event) {
		try {
			//need to add grocery item to cart list here
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
