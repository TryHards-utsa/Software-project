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
import javafx.scene.text.Text;

public class Checkout {
	
	@FXML private ListView<Item> cartList;
	private Customer currentCustomer;
	
	@FXML
	Text totalamt;
	
	public void StoreViewFromCarthandle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/StoreMenu.fxml" ) ); 
			Scene scene = new Scene( root, 600, 355 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e)  {
			e.printStackTrace();
		}
	}
	
	public void paymenthandle(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource( "../view/Payment.fxml" ));
			Parent root = loader.load();
			Scene scene = new Scene( root, 600, 600 );
			Payment tmp = (Payment) loader.getController();
			tmp.setCurrentCustomer(currentCustomer);
			
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addtotal(ListView<Item> givenList ) {
		
	}

	public void setCartList(ListView<Item> givenList) {
		cartList.getItems().addAll( givenList.getItems() );
	}
	public void setCurrentCustomer(Customer tmp) {
		currentCustomer = tmp;
	}
}
