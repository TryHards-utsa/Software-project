package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class Payment {
	@FXML private TextField cardNumber;
    @FXML private TextField securityCode;

	
	public void driverassignhandle(ActionEvent event) {
		//get cc info and save it to 
		int cardNum = Integer.parseInt( cardNumber.getText() );
		int securityNum = Integer.parseInt( securityCode.getText() );
		
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/DriverAssign.fxml" ) ); 
			Scene scene = new Scene( root, 600, 600 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void StoreViewFromCarthandle(ActionEvent event) {
		try {

			Parent root1 = FXMLLoader.load( getClass().getResource( "../view/StoreMenu.fxml" ) ); 
			Scene scene1 = new Scene( root1, 600, 600 );
			Main.stage.setScene(scene1);
			Main.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
