package application.model;

import java.util.ArrayList;

public class Customer {
	String customerName;
	String address;
	String password;
	String email;
	ArrayList<Item> cart;
	
	public Customer(String customerName, String address, String password,String email, ArrayList<Item> cart){
		this.customerName=customerName;
		this.address=address;
		this.password=password;
		this.email=email;
		this.cart=cart;
	}
	public String toString(){ 
		String ret =customerName+" thank you for your purchase!\n Your groceries are currently being sent to"+address;
		ret = ret+"\n---YOUR RECIPT---\n"+cart.toString()+"\n Have a nice day!";
		return ret;
	}
	public void addItemToCart(Item name){
		cart.add(name);
		
	}	
	public void removeItemFromCart(Item name){
		int index;
		for(index=0;index<cart.size();index++) {
			if(cart.get(index)==(name)){
				cart.remove(index);
			}
		}
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
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmails(String email){
		this.email=email;
	}		
	public ArrayList<Item> getCart() {
		return this.cart;
	}
	public void setCart(ArrayList<Item> cart){
		this.cart=cart;
	}
}
