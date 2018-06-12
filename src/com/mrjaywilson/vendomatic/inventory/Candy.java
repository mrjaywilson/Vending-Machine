/**
* 	Program:	Vend-o-Matic (Vending Machine Project)
*	File:		Candy.java
*	Summary:	Manages candy objects.
*				'Candy' sub-class, inheriting from Snack, and thus Product
* 	Author:		Jay Wilson
* 				Bibata RABBA IDI
*	Date:		May 04, 2018
**/

// package decalartion
package com.mrjaywilson.vendomatic.inventory;

// import package
import com.mrjaywilson.vendomatic.engine.SnackType;

// import api
import javafx.scene.image.Image;

// class declaration
public class Candy extends Snack implements Comparable<Product>{
	
	// Empty Constructor
	public Candy() {
		super();
	}
	
	// Constructor with args
	public Candy(String name, String description, Image image, int quantity,
			int dollarValue, int coinValue) {
		super (name, SnackType.CANDY, description, image, quantity, dollarValue, coinValue);
	}
	
	// Copy constructor
	public Candy(Candy candy) {
		super (candy.getName(), candy.getSnackType(), candy.getDescription(), candy.getImage(),
				candy.getQuantity(), candy.getDollarValue(), candy.getCentValue());
	}
	
	// ToString method
	public String toString() {
		return super.toString();
	}

	// Compare Method
	@Override
	public int compareTo(Product candy) {
		if (this.getName().compareTo(candy.getName()) > 0) {
			// If > 0 return 1
			return 1;
		} else if (this.getName().compareTo(candy.getName()) < 0) {
			// If < 0 return -1
			return -1;
		} else {
			// If == 0, check price
			if (this.getPrice() > candy.getPrice()) {
				// If price > 0 return 1
				return 1;
			} else if (this.getPrice() < candy.getPrice()) {
				//	If price > = return -1
				return -1;
			}
		}
		// If all checks fail, return 0 as equal
		return 0;
	}

}
