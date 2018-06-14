/**
* Inventory.java - Interface for inventory items in the vending machine.
* @author  Jay Wilson
* @version 1.0
*/

// package declaration
package com.mrjaywilson.vendomatic.engine;

// import package
import com.mrjaywilson.vendomatic.inventory.Product;

// Import API
import javafx.scene.image.Image;
import java.util.ArrayList;

// Interface declaration
public interface Inventory {
	
	// define the method for getting the inventory
	public <T> ArrayList<T> getInventoryList();
	
	// Adding item to the inventory
	public void addItem(SnackType snackType, String name, String description, Image productImage, int quantity, int dollarValue, int centValue);
	
	// This is our inventory management for adding and removing quantity
	// Implemented in Dispenser
	public void updateItemQuantity(Product product, int quantity);
	
	// Request an item from the inventory for various purposes
	public Object requestItem(SnackType snackType, Object object);
}
