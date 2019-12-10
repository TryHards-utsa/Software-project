package application.controller;

import application.Main;
import application.model.Customer;
import application.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Payment {
	@FXML private TextField cardNumber;
    @FXML private TextField securityCode;
    @FXML private Text error;
    @FXML private RadioButton quickDeliveryButton;
    @FXML private TextField deliveryDate;
    private Customer currentCustomer;

	
	public void driverassignhandle(ActionEvent event) {
		//get cc info and save it to 
		String cardNum = cardNumber.getText();
		String securityNum = securityCode.getText();
		if( cardNum.length() != 19 || securityNum.length() != 3 || cardNum.trim().isEmpty() || securityNum.trim().isEmpty()) {
			error.setText("Enter Card Number: xxxx-xxxx-xxxx-xxxx and Security Code: xxx");
		} else {
			try {
				FXMLLoader loader = new FXMLLoader( getClass().getResource( "../view/DriverAssign.fxml" ) );
				Parent root1 = loader.load();
				DriverAssign tmp = (DriverAssign) loader.getController();
				
				if( !quickDeliveryButton.isSelected() && deliveryDate.getText().trim().isEmpty() ) { 
					error.setText("Select one: quick delivery option or enter a date");
				} else if( quickDeliveryButton.isSelected() && !deliveryDate.getText().trim().isEmpty() ) {
					error.setText("Select only one: quick delivery option or enter a date");
				} else if(quickDeliveryButton.isSelected() && deliveryDate.getText().trim().isEmpty()) {
					tmp.setProgress(0.20);
					Scene scene = new Scene( root1, 600, 450 );
					Main.stage.setScene(scene);
					Main.stage.show();
				}
				
				
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void StoreViewFromCarthandle(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader( getClass().getResource( "../view/Cart.fxml") );
			Parent root1 = loader.load();
			Checkout tmp = (Checkout) loader.getController();
			tmp.setCurrentCustomer(currentCustomer);
			ListView<Item> tmpList = new ListView<Item>();
			tmpList.getItems().addAll(currentCustomer.getCart());
			tmp.setCartList(tmpList);
			
			Scene scene1 = new Scene( root1, 350, 600 );
			Main.stage.setScene(scene1);
			Main.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void setCurrentCustomer(Customer tmp) {
		currentCustomer = tmp;
	}
	
}
