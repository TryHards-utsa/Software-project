package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Dataset;
import application.model.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

public class StoreView implements Initializable {
	
	@FXML private ListView<Dataset> groceryList;
	@FXML private ListView<Dataset> cartList;
	
	public void carthandle(ActionEvent event) {
		try {

			Parent root1 = FXMLLoader.load( getClass().getResource( "../view/Cart.fxml" ) ); 
			Scene scene1 = new Scene( root1, 600, 350 );
			Main.stage.setScene(scene1);
			Main.stage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addtocarthandle(ActionEvent event) {
		try {
			//onClick event so when grocery item is clicked, its added to cartlist
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	//need item data to test
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Dataset stock = new Dataset( "Current stock" );
		try {
			stock.loadItems("csv/drivers.csv");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//for( Item key : stock.getItemsList() ) {
			groceryList.getItems().addAll( stock );
		//}
	}
	
}
