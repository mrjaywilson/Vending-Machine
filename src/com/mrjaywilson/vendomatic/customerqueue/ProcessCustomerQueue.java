/**  
* ProcessCustomerQueue.java - Class to handle the queue of customers to interact with the vending machine.
* @author  Jay Wilson
* @version 1.0
*/

package com.mrjaywilson.vendomatic.customerqueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

import com.mrjaywilson.vendomatic.inventory.Dispenser;
import com.mrjaywilson.vendomatic.inventory.Product;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProcessCustomerQueue {
	/**
	 * Public static member
	 */
	public static Queue<Customer> customerList = new LinkedList<Customer>();
	
	/**
	 * Load the Customer info from the CSV file
	 * @param file path to the location
	 * @param dispenser
	 */
	public void loadCustomerList(String file, Dispenser dispenser) {
		BufferedReader reader = null;
		String line = "";
		String splitter = ",";
		
		String headLocation = "images\\heads\\";

		try {
			reader = new BufferedReader(new FileReader(file));

			while ((line = reader.readLine()) != null) {
				String[] singleCustomer = line.split(splitter);
				
				int x = 100;
				
				for (Product product : dispenser.getInventoryList()) {
					if (product.getName().equals(singleCustomer[1].toString())) {
						in(
								new Customer(
										singleCustomer[0],
										product,
										new Image(headLocation + singleCustomer[2]),
										new Image(headLocation + singleCustomer[3]),
										new ImageView(headLocation + singleCustomer[2]),
										x += 75,
										100));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	

	// methods for handling the queue
	public Customer First() {
		if (!this.isEmpty()) {
			return customerList.element();
		}
		return null;
	}
	
	public int length() {
		return customerList.size();
	}
	
	public boolean isEmpty() {
		return customerList.isEmpty();
	}
	
	public void in(Customer customer) {
		customerList.add(customer);
	}
	
	public Customer out() {
		return this.customerList.remove();
	}
}
