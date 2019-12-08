package application.model;

import java.util.ArrayList;

public class Item {
	String itemName;
	String price;
	
	//edit comments

	public Item(String itemName, String price){
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
	
	public String getPrice() {
		return this.price;
	}
	public void setPrice(String price){
		this.price=price;
	}	
}