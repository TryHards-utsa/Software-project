package application.model;

import java.util.ArrayList;

public class Dataset {
	String listName;
	ArrayList<Customer> customers;
	
	//edit comments

	public Dataset(String listName){
		this.listName=listName;
	}
	public void addCustomer(Customer name){
		customers.add(name);
	}
	public String toString(){ 
		String ret ="-"+listName;
		return ret;
	}
	public String getListName() {
		return this.listName;
	}
	public void setListName(String listName) {
		this.listName=listName;
	}
}