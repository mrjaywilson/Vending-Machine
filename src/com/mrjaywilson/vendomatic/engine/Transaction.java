/**
* Transaction.java - Class to handle customer transactions with the vending machine.
* @author  Jay Wilson
* @version 1.0
*/

// Declare Package
package com.mrjaywilson.vendomatic.engine;

// import package
import com.mrjaywilson.vendomatic.inventory.Product;

import javafx.scene.control.Label;

import java.util.concurrent.ThreadLocalRandom;

import com.mrjaywilson.vendomatic.customerqueue.CustomerDisplay;
import com.mrjaywilson.vendomatic.inventory.Dispenser;

// Class decalartion
public class Transaction {
	Dispenser dispenser = new Dispenser();
	CustomerDisplay queue = new CustomerDisplay();
	
	// Declare members
	private double _totalCost;
	private Product _purchaseItems;
	private double _userAccountBalance;
	
	// handle buying item from vending machine
	public void buyItem(Product product, Label label) {
		int index = (dispenser.getInventoryList().indexOf(product));
		if (index >= 0) {
			if (product.getQuantity() > 0) {
				dispenser.updateItemQuantity(product, -1);
				
				CustomerDisplay.output += product.getName() + " purchased! Enjoy!\r\n";
				label.setText(CustomerDisplay.output);
				
				CustomerDisplay.output += "Number of " + product.getName() + " left: " + product.getQuantity();
				label.setText(CustomerDisplay.output);
				
			} else {
				
				CustomerDisplay.output += "Item not available!\r\n";
				label.setText(CustomerDisplay.output);

				while (true) {
					index = ThreadLocalRandom.current().nextInt(0, dispenser.getInventoryList().size() - 1);
					
					CustomerDisplay.output += "Checking: " + dispenser.getInventoryList().get(index).getName() + " has a qty of " 
							+ dispenser.getInventoryList().get(index).getQuantity() + " with a price of " 
							+ dispenser.getInventoryList().get(index).getPrice()
							+ "\r\n";

					label.setText(CustomerDisplay.output);
					
					if (dispenser.getInventoryList().get(index).getQuantity() > 0) {
						dispenser.updateItemQuantity(dispenser.getInventoryList().get(index), -1);
						CustomerDisplay.output += dispenser.getInventoryList().get(index).getName() + " purchased! Enjoy!" + "\r\n";
						label.setText(CustomerDisplay.output);

						CustomerDisplay.output += "Number of " + dispenser.getInventoryList().get(index).getName() + " left: " + dispenser.getInventoryList().get(index).getQuantity() + "\r\n";
						label.setText(CustomerDisplay.output);
						break;
					}
				}
			}
		} else {
			CustomerDisplay.output += "Sorry, can't buy anything\r\n";
		}
	}
	
	// Get Total Cost
	public double getTotalCost() {
		return _totalCost;
	}

	// Set Total Cost
	public void setTotalCost(double _totalCost) {
		this._totalCost = _totalCost;
	}
	
	// Get Purchased Items
	public Product getPurchaseItems() {
		return _purchaseItems;
	}
	
	// Set List of Purchase Items
	public void setPurchaseItems(Product _purchaseItems) {
		this._purchaseItems = _purchaseItems;
	}
	
	// Get user Account Balance
	public double getUserAccountBalance() {
		return _userAccountBalance;
	}
	
	// Sert user Account Balance
	public void setUserAccountBalance(double _userAccountBalance) {
		this._userAccountBalance = _userAccountBalance;
	}
	
	// Pay for the items
	public double DoCalculation() {
		return this._userAccountBalance - _totalCost;
	}
}
