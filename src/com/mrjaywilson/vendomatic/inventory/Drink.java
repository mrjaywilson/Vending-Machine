/**
* 	Program:	Vend-o-Matic (Vending Machine Project)
*	File:		Drink.java 
*	Summary:	Manages drink objects.
* 	Author:		Jay Wilson
* 				Bibata RABBA IDI
*	Date:		May 04, 2018
**/

// package declaration 
package com.mrjaywilson.vendomatic.inventory;

// import package
import com.mrjaywilson.vendomatic.engine.SnackType;

// import API
import javafx.scene.image.Image;

// class declaration
public class Drink extends Product implements Comparable<Product>{
	
	// Constructor
	public Drink() {
		super();
	}
	
	// constructor with args
	public Drink(String name, String description, Image image, int quantity,
			int dollarValue, int coinValue) {
		super (name, SnackType.DRINK, description, image, quantity, dollarValue, coinValue);
	}

	// Copy constructor
	public Drink(Drink drink) {
		super (drink.getName(), drink.getSnackType(), drink.getDescription(), drink.getImage(),
				drink.getQuantity(), drink.getDollarValue(), drink.getCentValue());
	}

	// CompareTO method
	@Override
	public int compareTo(Product drink) {
		if (this.getName().compareTo(drink.getName()) > 0) {
			// If > 0 return 1
			return 1;
		} else if (this.getName().compareTo(drink.getName()) < 0) {
			// If < 0 return -1
			return -1;
		} else {
			// If == 0, check price
			if (this.getPrice() > drink.getPrice()) {
				// If price > 0 return 1
				return 1;
			} else if (this.getPrice() < drink.getPrice()) {
				//	If price > = return -1
				return -1;
			}
		}
		// If all checks fail, return 0 as equal
		return 0;
	}
}
