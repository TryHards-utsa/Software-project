package application.model;

import java.util.ArrayList;

/**
 * Item class represents a generic Item with a name key and price.
 *
 */
public class Item {
	String itemName;
	double price;
	
	
	/**
	 * @param itemName name of the item
	 * @param price the amount for a specified item
	 */
	public Item(String itemName, double price){
		this.itemName=itemName;
		this.price=price;
	}


	public String toString(){ 
		String ret ="-"+itemName+"------"+price;
		return ret;
	}
	/**
	 * @return name key of the item
	 */
	public String getItemName() {
		return this.itemName;
	}
	/**
	 * Assign the specified name to the item
	 * @param itemName name of item to be assigned to
	 */
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	
	/**
	 * @return price of unit item
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * @param price amount of the specified item to be set to
	 */
	public void setPrice(double price){
		this.price=price;
	}	
}