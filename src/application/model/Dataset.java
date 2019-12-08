package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;

public class Dataset {
	String listName;
	ArrayList<Customer> customersList;
	ArrayList<Item> itemsList;
	//edit comments

	public Dataset(String listName){
		this.listName=listName;
	}
	public void addCustomer(Customer name){
		customersList.add(name);
	}
	public String toString(){ 
		String ret ="-"+listName;
		return ret;
	}
	
	public void loadCustomer( String file)throws IOException {
		try {
			Scanner scan = new Scanner(new File(file));
			while(scan.hasNextLine()) {
				String line=scan.nextLine();
				String[] token=line.split(",");
				//System.out.println(token[0]);
			    customersList.add(new Customer(token[0],token[1],token[2], token[3], new ArrayList<Item>()));
			}
			scan.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	public void loadItems( String file)throws IOException{
		try {
			Scanner scan = new Scanner(new File(file));
			while(scan.hasNextLine()) {
				String line=scan.nextLine();
				String[] token=line.split(",");
				//System.out.println(token[0]);
				itemsList.add(new Item(token[0], Double.parseDouble(token[1])));
			}
			scan.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getListName() {
		return this.listName;
	}
	public void setListName(String listName) {
		this.listName=listName;
	}
	public ArrayList<Customer> getCustomerList() {
		return this.customersList;
	}
	public void setCustomersList(ArrayList<Customer> customersList) {
		this.customersList=customersList;
	}
	public ArrayList<Item> getItemsList() {
		return this.itemsList;
	}
}