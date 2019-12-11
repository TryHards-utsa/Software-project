package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.model.Customer;
import application.model.Dataset;
import application.model.Item;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


public class Register implements Initializable, EventHandler<ActionEvent> {
	@FXML
	TextField name;
	@FXML
	PasswordField password;
	@FXML
	TextField emailField;
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
	
	@FXML
	Text error;	
	Dataset customerData;
	private ArrayList<Customer> customerList;
	private Dataset stock;

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
		//TODO add new customer to database; needs model class
				if(isEmpty()) {
					error.setText("All fields must be filled, please try again");
				}else if(!existCustomer(emailField.getText())){
					try {
						ArrayList<Item> tmpList = new ArrayList<Item>();
						Customer tmp = new Customer(name.getText(), addressField.getText(), password.getText(), emailField.getText(), tmpList );
						//write customer to file
						stock.addCustomer(tmp);
						stock.save();
						
						Parent root1 = FXMLLoader.load( getClass().getResource( "../view/Start.fxml" ) ); 
						Scene scene1 = new Scene( root1, 597, 412 );
						Main.stage.setScene(scene1);
						Main.stage.show();
					
					}catch (IOException e) {
						e.printStackTrace();
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					error.setText("Oops! Email in use");
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		stock = new Dataset( "Current Customers" );
		try {
			stock.loadCustomer("data/customers.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		customerList = stock.getCustomerList();
		
	}
	
	/**
	 * Checks customer database for existing customer credentials
	 * @param emailText
	 * @return returns true if customer exist false otherwise
	 */
	public boolean existCustomer(String emailText) {
		for(Customer customer : customerList) {
			if(customer.getEmail().equals(emailText)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return true if any fields are empty false otherwise
	 */
	public boolean isEmpty() {
		return (emailField.getText().trim().isEmpty() ||
				addressField.getText().trim().isEmpty() ||
				cityFIeld.getText().trim().isEmpty() ||
				stateField.getText().trim().isEmpty() ||
				name.getText().trim().isEmpty()||
			    password.getText().trim().isEmpty()); 
	}
}

