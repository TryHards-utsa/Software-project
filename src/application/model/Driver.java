package application.model;

import java.util.ArrayList;

/**
 * Delivery driver with a name and availability status
 *
 */
public class Driver {
	String driverName;
	String status;
	
	/**
	 * @param driverName the delivery driver
	 * @param status availability of the driver
	 */
	public Driver(String driverName, String status){
		this.driverName=driverName;
		this.status=status;
	}


	public String toString(){ 
		String ret ="-"+driverName+" is currently "+status;
		return ret;
	}
	/**
	 * @return name of current driver
	 */
	public String getDriverName() {
		return this.driverName;
	}
	/**
	 * @param driverName specified name of the driver
	 */
	public void setItemName(String driverName){
		this.driverName=driverName;
	}
	
	/**
	 * @return status of a Delivery driver
	 */
	public String getStatus() {
		return this.status;
	}
	/**
	 * @param status current availability  of the driver
	 */
	public void setStatus(String status){
		this.status=status;
	}	
}