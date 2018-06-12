/**
* 	Program:	Vend-o-Matic (Vending Machine Project)
*	File:		Gum.java 
*	Summary:	Manages gum objects.
* 	Author:		Jay Wilson
* 				Bibata RABBA IDI
*	Date:		May 04, 2018
**/

// package declaration
package com.mrjaywilson.vendomatic.inventory;

// import Package
import com.mrjaywilson.vendomatic.engine.SnackType;

// import API
import javafx.scene.image.Image;

// Class declaration
public class Gum extends Snack implements Comparable<Product>{
	
	// Constructor
	public Gum() {
		super();
	}

	// Constructor with args
	public Gum(String name, String description, Image image, int quantity,
			int dollarValue, int coinValue) {
		super (name, SnackType.GUM, description, image, quantity, dollarValue, coinValue);
	}

	// Copy constructor
	public Gum(Gum gum) {
		super (gum.getName(), gum.getSnackType(), gum.getDescription(), gum.getImage(),
				gum.getQuantity(), gum.getDollarValue(), gum.getCentValue());
	}

	// CompareTo method
	@Override
	public int compareTo(Product gum) {
		if (this.getName().compareTo(gum.getName()) > 0) {
			// If > 0 return 1
			return 1;
		} else if (this.getName().compareTo(gum.getName()) < 0) {
			// If < 0 return -1
			return -1;
		} else {
			// If == 0, check price
			if (this.getPrice() > gum.getPrice()) {
				// If price > 0 return 1
				return 1;
			} else if (this.getPrice() < gum.getPrice()) {
				//	If price > = return -1
				return -1;
			}
		}
		// If all checks fail, return 0 as equal
		return 0;
	}
}
