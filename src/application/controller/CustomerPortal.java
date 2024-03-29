package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.Main;
import application.model.Customer;
import application.model.Dataset;
import application.model.Item;
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
	private Customer currentCustomer;
	

	public void registrationhandle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/Registration.fxml" ) ); 
			Scene scene = new Scene( root, 600, 450 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	public void signInhandle(ActionEvent event) {
		try {

			Dataset customerList = new Dataset("List");
			customerList.loadItems("csv/items.csv");
			customerList.loadCustomer("data/customers.csv");
			
			/*if(startemail.getText().trim().isEmpty() && startpassword.getText().trim().isEmpty()) {
				error.setText("Either Email or password was not inputed correctly, please try again");
			*/
			for(int i=0;i<customerList.getCustomerList().size();i++) {
				if(startemail.getText().equals(customerList.getCustomerList().get(i).getEmail()) 
						&& startpassword.getText().equals(customerList.getCustomerList().get(i).getPassword())) {
					StoreView.currentCustomer=customerList.getCustomerList().get(i);
					Checkout.currentCustomer=customerList.getCustomerList().get(i);
					Parent root1 = FXMLLoader.load( getClass().getResource( "../view/StoreMenu.fxml" ) ); 
					Scene scene1 = new Scene( root1, 600, 355 );
					Main.stage.setScene(scene1);
					Main.stage.show();
				}else {
					error.setText("Either Email or password was not inputed correctly, please try again");
				}
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			Dataset customerList = new Dataset("List");
			customerList.loadItems("data/items.csv");
			customerList.loadCustomer("data/customers.csv");
		} catch (IOException e) {
			System.out.println( "Error loading the file - please check its location." );
			e.printStackTrace();
		}
	}
	
}
