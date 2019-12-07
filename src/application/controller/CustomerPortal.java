package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CustomerPortal implements EventHandler<ActionEvent> {

	@FXML
	TextField startemail;
	@FXML
	PasswordField startpassword; 
	@FXML
	Text error;
	

	public void registrationhandle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/Registration.fxml" ) ); 
			Scene scene = new Scene( root, 600, 600 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void signInhandle(ActionEvent event) {
		try {

			if(startemail.getText().trim().isEmpty() && startpassword.getText().trim().isEmpty()) {
				error.setText("Either Email or password was not inputed correctly, please try again");
			
				
			}else {
			
				Parent root1 = FXMLLoader.load( getClass().getResource( "../view/StoreMenu.fxml" ) ); 
				Scene scene1 = new Scene( root1, 600, 600 );
				Main.stage.setScene(scene1);
				Main.stage.show();
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
