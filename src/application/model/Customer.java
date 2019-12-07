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
}
