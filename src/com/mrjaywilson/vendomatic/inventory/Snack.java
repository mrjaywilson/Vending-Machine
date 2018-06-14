/**
* Snack.java - Abstract Class for Snack Items inheriting Product.
* @author  Jay Wilson
* @version 1.0
* @see Product
*/

// package declaration
package com.mrjaywilson.vendomatic.inventory;

// import package
import com.mrjaywilson.vendomatic.engine.SnackType;

// import API
import javafx.scene.image.Image;

// class declaration
public abstract class Snack extends Product {
	
	// constructor
	public Snack() {
		super();
	}
	
	// constructor with args
	public Snack(String name, SnackType snackType, String description, Image image, int quantity,
			int dollarValue, int coinValue) {
		super (name, snackType, description, image, quantity, dollarValue, coinValue);
	}
	
	// Copy constructor
	public Snack(Snack snack) {
		super (snack.getName(), snack.getSnackType(), snack.getDescription(), snack.getImage(),
				snack.getQuantity(), snack.getDollarValue(), snack.getCentValue());
	}
	
	// toString method
	public String toString() {
		return super.toString();
	}
	
	// CompareTo method
	@Override
	public int compareTo(Product snack) {
		if (this.getName().compareTo(snack.getName()) > 0) {
			// If > 0 return 1
			return 1;
		} else if (this.getName().compareTo(snack.getName()) < 0) {
			// If < 0 return -1
			return -1;
		} else {
			// If == 0, check price
			if (this.getPrice() > snack.getPrice()) {
				// If price > 0 return 1
				return 1;
			} else if (this.getPrice() < snack.getPrice()) {
				//	If price > = return -1
				return -1;
			}
		}
		// If all checks fail, return 0 as equal
		return 0;
	}
}
