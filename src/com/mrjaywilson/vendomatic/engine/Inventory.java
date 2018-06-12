/**
* 	Program:	Vend-o-Matic (Vending Machine Project)
*	File:		Inventory.java
*	Summary:	Class that manages the inventory.
* 	Author:		Jay Wilson
* 				Bibata RABBA IDI
*	Date:		May 04, 2018
**/

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