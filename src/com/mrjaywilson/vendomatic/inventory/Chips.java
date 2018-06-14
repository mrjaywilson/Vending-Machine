/**
* Chips.java - Class to handle inventory of chips.
* @author  Jay Wilson
* @version 1.0
* @see Snack
*/

// package declaration
package com.mrjaywilson.vendomatic.inventory;

// Import package
import com.mrjaywilson.vendomatic.engine.SnackType;

// import API
import javafx.scene.image.Image;

// Class declaration
public class Chips extends Snack implements Comparable<Product>{

	// Empty Constructor
	public Chips() {
		super();
	}

	// Constructor with args
	public Chips(String name, String description, Image image, int quantity,
			int dollarValue, int coinValue) {
		super (name, SnackType.CHIPS, description, image, quantity, dollarValue, coinValue);
	}

	// Copy constructor
	public Chips(Chips chips) {
		super (chips.getName(), chips.getSnackType(), chips.getDescription(), chips.getImage(),
				chips.getQuantity(), chips.getDollarValue(), chips.getCentValue());
	}

	// CompareTo method
	@Override
	public int compareTo(Product chips) {
		if (this.getName().compareTo(chips.getName()) > 0) {
			// If > 0 return 1
			return 1;
		} else if (this.getName().compareTo(chips.getName()) < 0) {
			// If < 0 return -1
			return -1;
		} else {
			// If == 0, check price
			if (this.getPrice() > chips.getPrice()) {
				// If price > 0 return 1
				return 1;
			} else if (this.getPrice() < chips.getPrice()) {
				//	If price > = return -1
				return -1;
			}
		}
		// If all checks fail, return 0 as equal
		return 0;
	}
}
