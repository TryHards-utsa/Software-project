package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Register implements EventHandler<ActionEvent> {
	@FXML
	TextField name;
	@FXML
	PasswordField password;
	@FXML
	TextField userNameField;
	@FXML
	TextField addressField;
	@FXML
	TextField cityFIeld;
	@FXML
	TextField stateField;
	@FXML
	Button homeButton;
	@FXML
	Button signUpButton;

	@Override
	public void handle(ActionEvent arg0) {		
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/Registration.fxml" ) ); 
			Scene scene = new Scene( root, 600, 450 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Registers users info to database with use of model classes
	 * @param event Signal for button clicked
	 */
	public void signupHandle(ActionEvent event) {
		//TODO error checking, model classes etc
		try {
			
			Parent root1 = FXMLLoader.load( getClass().getResource( "../view/Start.fxml" ) ); 
			Scene scene1 = new Scene( root1, 597, 412 );
			Main.stage.setScene(scene1);
			Main.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Returns user back to sign in view
	 * @param event Signal for button clicked
	 */
	public void returnHandle(ActionEvent event) {
		
		try {

			Parent root1 = FXMLLoader.load( getClass().getResource( "../view/Start.fxml" ) ); 
			Scene scene1 = new Scene( root1, 597, 412 );
			Main.stage.setScene(scene1);
			Main.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}

