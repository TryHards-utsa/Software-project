package application.model;

import java.util.ArrayList;

/**
 * Customer class represents a generic Customer with a name, address, cart and login credentials
 *
 */
public class Customer {
	String customerName;
	String address;
	String password;
	String email;
	ArrayList<Item> cart;
	
	/**
	 * @param customerName full name of a customer
	 * @param address delivery location 
	 * @param password login password
	 * @param email customer email key
	 * @param cart list of items for the customer
	 */
	public Customer(String customerName, String address, String password,String email, ArrayList<Item> cart){
		this.customerName=customerName;
		this.address=address;
		this.password=password;
		this.email=email;
		this.cart=cart;
	}
	
	public String toString(){ 
		String ret =customerName+" thank you for your purchase!\n Your groceries are currently being sent to"+address;
		ret = ret+"\n---YOUR RECIPT---\n";
		for(int k=0;k<cart.size();k++){
			ret+=cart.get(k).toString()+"\n";
		}
		ret = ret+"\n Have a nice day!";
		return ret;
	}
	/**
	 * Adds the specified item to the cart
	 * @param name the item key
	 */
	public void addItemToCart(Item name){
		cart.add(name);
		
	}	
	/**
	 * @param name the item to key to remove
	 */
	public void removeItemFromCart(Item name){
		int index;
		for(index=0;index<cart.size();index++) {
			if(cart.get(index)==(name)){
				cart.remove(index);
			}
		}
	}
	
	/**
	 * @return full name of customer
	 */
	public String getCutsomerName() {
		return this.customerName;
	}
	/**
	 * @param customerName full name of the customer
	 */
	public void setCutsomerName(String customerName){
		this.customerName=customerName;
	}
	/**
	 * @return address of the delivery location
	 */
	public String getAddress() {
		return this.address;
	}
	/**
	 * @param address the specified delivery location for the customer
	 */
	public void setAddress(String address){
		this.address=address;
	}
	/**
	 * @return the password key of user
	 */
	public String getPassword() {
		return this.password;
	}
	/**
	 * @param password the specified password to be assigned to
	 */
	public void setPassword(String password){
		this.password=password;
	}
	/**
	 * @return email key of Customer
	 */
	public String getEmail() {
		return this.email;
	}
	/**
	 * @param email the email key to be assigned to
	 */
	public void setEmails(String email){
		this.email=email;
	}		
	/**
	 * @return list of items for the customers
	 */
	public ArrayList<Item> getCart() {
		return this.cart;
	}
	
	/**
	 * @param cart list of items to be added
	 */
	public void setCart(ArrayList<Item> cart){
		this.cart=cart;
	}
}
