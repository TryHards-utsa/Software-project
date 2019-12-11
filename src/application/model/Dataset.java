package application.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 *Utility methods to read and write to database files for a customer and a driver
 */
public class Dataset {
	String listName;
	ArrayList<Customer> customersList;
	ArrayList<Item> itemsList;
	ArrayList<Driver> driversList;

	/**
	 * @param listName name of the list of data
	 */
	public Dataset(String listName){
		this.listName=listName;
		this.itemsList = new ArrayList<Item>();
		this.customersList = new ArrayList<Customer>();
		this.driversList = new ArrayList<Driver>();
	}
	
	/**
	 * Adds the specified customer to the list of customers
	 * @param name Customer to be added 
	 */
	public void addCustomer(Customer name){
		customersList.add(name);
	}
	
	public String toString(){ 
		String ret ="-"+listName;
		return ret;
	}
	
	/**
	 * Reads in customers from the specified file and adds them a list of customers
	 * @param file path of a file to be open and read from
	 * @throws IOException Incompatible file
	 */
	public void loadCustomer( String file)throws IOException {
		try {
			ArrayList<Item> cart= new ArrayList<Item>();
			Scanner scan = new Scanner(new File(file));
			while(scan.hasNextLine()) {
				String line=scan.nextLine();
				String[] token=line.split(",");
				if(!token[4].equals("0")) {
					String[] itemCart = token[4].split("\\+");
					for(int i=0;i<itemsList.size();i++) {
						for(int k=0; k<itemCart.length;k++) {
							if(itemsList.get(i).itemName.equals(itemCart[k])) {
								cart.add(itemsList.get(i));
							}
						}
					}
				}
			    customersList.add(new Customer(token[0],token[1],token[2], token[3],cart));
			}
			scan.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads in items from the specified file and adds them to a list of grocery items
	 * @param file path of a file to be open and read from
	 * @throws IOException Incompatible file
	 */
	public void loadItems( String file)throws IOException{
		try {
			Scanner scan = new Scanner(new File(file));
			while(scan.hasNextLine()) {
				String line=scan.nextLine();
				String[] token=line.split(",");
				//System.out.println(token[0]);
				itemsList.add( new Item(token[0], Double.parseDouble(token[1])) );
			}
			scan.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads in drivers from the specified file and adds them to a list of drivers
	 * @param file path of a file to be open and read from
	 * @throws IOException Incompatible file
	 */
	 public void loadDrivers( String file)throws IOException{
		try {
			Scanner scan = new Scanner(new File(file));
			while(scan.hasNextLine()) {
				String line=scan.nextLine();
				String[] token=line.split(",");
				driversList.add( new Driver(token[0],token[1]) );
			}
			scan.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	 /**
	 *Updates customer database 
	 */
	public void save() {
		try {
			FileWriter customerFile = new FileWriter( new File("data/customers.csv") );
			for (int i=0;i<customersList.size();i++) {
				Customer customerData=customersList.get(i);
				customerFile.write(customerData.customerName+","+customerData.address+","+customerData.password+","+customerData.email+","+cartToStringSave(customerData)+"\n");
			}
			customerFile.close();	
		}catch( IOException e ) {
			e.printStackTrace();
		}	
	}
	
	public String cartToStringSave(Customer customer){
		String cartSave="";
		if (customer.cart.size()!=0 ) {
			for (int i=0;i<customer.cart.size();i++) {
				cartSave += customer.cart.get(i).itemName+"+";
			}
		}else {
			return "0";
		}
		return cartSave;
	}
	
	
	/**
	 * @return name of the current database list
	 */
	public String getListName() {
		return this.listName;
	}
	/**
	 * Assigns the name of the list to the specified value
	 * @param listName specified name to be assigned to
	 */
	public void setListName(String listName) {
		this.listName=listName;
	}
	/**
	 * @return list of customers in database
	 */
	public ArrayList<Customer> getCustomerList() {
		return this.customersList;
	}
	/**
	 * @param customersList ArrayList of customers to be assigned to
	 */
	public void setCustomersList(ArrayList<Customer> customersList) {
		this.customersList=customersList;
	}
	/**
	 * @return list of groceries in database 
	 */
	public ArrayList<Item> getItemsList() {
		return this.itemsList;
	}
	/**
	 * @return list of drivers in databaase
	 */
	public ArrayList<Driver> getDriversList() {
		return this.driversList;
	}
}