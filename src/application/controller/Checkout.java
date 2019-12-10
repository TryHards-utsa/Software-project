package application.controller;

import application.Main;
import application.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

public class Checkout {
	
	@FXML private ListView<Item> cartList;
	
	public void StoreViewFromCarthandle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/StoreMenu.fxml" ) ); 
			Scene scene = new Scene( root, 600, 355 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void paymenthandle(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load( getClass().getResource( "../view/Payment.fxml" ) ); 
			Scene scene = new Scene( root, 600, 600 );
			Main.stage.setScene(scene);
			Main.stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setCartList(ListView<Item> givenList) {
		cartList.getItems().addAll( givenList.getItems() );
	}
}
