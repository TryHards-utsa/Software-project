package application.model;

import java.util.ArrayList;

public class Customer {
	String customerName;
	String address;
	ArrayList<Item> cart;
	
	public Customer(String customerName, String address, ArrayList<Item> cart){
		this.customerName=customerName;
		this.address=address;
		this.cart=cart;
	}
	public String toString(){ 
		String ret =customerName+" thank you for your purchase!\n Your groceries are currently being sent to"+address;
		ret = ret+"\n---YOUR RECIPT---\n"+cart.toString()+"\n Have a nice day!";
		return ret;
	}
	public String getCutsomerName() {
		return this.customerName;
	}
	public void setCutsomerName(String customerName){
		this.customerName=customerName;
	}
	
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address){
		this.address=address;
	}	
	public ArrayList<Item> getCart() {
		return this.cart;
	}
	public void setCart(ArrayList<Item> cart){
		this.cart=cart;
	}
}
