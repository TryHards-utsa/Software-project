package application.model;

import java.util.ArrayList;

public class Item {
	String itemName;
	double price;
	
	//edit comments

	public Item(String itemName, double price){
		this.itemName=itemName;
		this.price=price;
	}


	public String toString(){ 
		String ret ="-"+itemName+"------"+price;
		return ret;
	}
	public String getItemName() {
		return this.itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price){
		this.price=price;
	}	
}