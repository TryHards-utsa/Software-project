package application.model;

import java.util.ArrayList;

public class Driver {
	String driverName;
	String status;
	
	//edit comments

	public Driver(String driverName, String status){
		this.driverName=driverName;
		this.status=status;
	}


	public String toString(){ 
		String ret ="-"+driverName+" is currently "+status;
		return ret;
	}
	public String getDriverName() {
		return this.driverName;
	}
	public void setItemName(String driverName){
		this.driverName=driverName;
	}
	
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status){
		this.status=status;
	}	
}