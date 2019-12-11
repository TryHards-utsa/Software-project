package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import application.model.Customer;
import application.model.Dataset;
import application.model.Item;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class StoreView implements Initializable {
	
	@FXML private ListView<Item> groceryList;
	@FXML private ListView<Item> cartList;
	@FXML private TextField searchField;
	public static Customer currentCustomer;
	public static double totalValue;
	//private Customer currentCustomer;
	
	public void carthandle(ActionEvent event) {
		try {
			addtotal();
			System.out.println("hello");
			FXMLLoader loader = new FXMLLoader( getClass().getResource( "../view/Cart.fxml" ) );
			Parent root1 = loader.load();
			Checkout tmp = (Checkout) loader.getController();
			tmp.setCartList(cartList);
			tmp.setCurrentCustomer(currentCustomer);
			Scene scene1 = new Scene( root1, 600, 350 );
			Main.stage.setScene(scene1);
			Main.stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addtocarthandle(ActionEvent event) {
		try {
			Item selectedItem = groceryList.getSelectionModel().getSelectedItem();
			if(selectedItem!= null) {
				groceryList.getItems().remove(selectedItem);
				cartList.getItems().add(selectedItem);
				currentCustomer.getCart().add(selectedItem);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void searchHandle(ActionEvent event) {
		String searchResult = searchField.getText();
		//ListView<Item> prevItems = groceryList;
		Item tmp = null;
		
		for(Item item : groceryList.getItems() ) {
			if(item.getItemName().equalsIgnoreCase(searchResult)) {
				tmp = item;
			}
		}
		if(tmp!= null) {
			groceryList.getItems().remove(tmp);
			cartList.getItems().add(tmp);
			currentCustomer.getCart().add(tmp);
			searchField.clear(); 
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Dataset stock = new Dataset( "Current stock" );
		try {
			stock.loadItems("csv/items.csv");
			System.out.println(currentCustomer.getCutsomerName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		groceryList.getItems().addAll( stock.getItemsList() );
	}
	
	public void addtotal() {
		double total=0;
		for(int i=0;i<currentCustomer.getCart().size();i++) {
			//System.out.println(currentCustomer.getCart().get(i));
			total += currentCustomer.getCart().get(i).getPrice();
		}
		//System.out.println(total);
		totalValue=total;
	}
	
	public ListView<Item> getGroceryList() {
		return groceryList;
	}

	public void setGroceryList(ListView<Item> groceryList) {
		this.groceryList = groceryList;
	}

	public ListView<Item> getCartList() {
		return cartList;
	}

	public void setCartList(ListView<Item> cartList) {
		this.cartList = cartList;
	}
	public void setCurrentCustomer(Customer tmp) {
		currentCustomer = tmp;
	}
	
}
