/**
* 	Program:	Vend-o-Matic (Vending Machine Project)
*	File:		Product.java
*	Summary:	Manages all product objects at a super-class level.
* 	Author:		Jay Wilson
* 				Bibata RABBA IDI
*	Date:		May 04, 2018
**/

// Package declaration
package com.mrjaywilson.vendomatic.inventory;

// import package
import com.mrjaywilson.vendomatic.engine.SnackType;

// import API
import javafx.scene.image.Image;

// class declaration
public abstract class Product {
	
	/*****************************
	 * Declare the private members
	 *****************************/
	private String _name;
	private String _description;
	private Image _image;
	private int _quantity;
	private int _dollarValue;
	private int _centValue;
	private SnackType _snackType;
	
	/**********************************
	 * Getter and Setter definitions
	 **********************************/
	// Return Product name
	public String getName() {
		return this._name;
	}
	
	// Set the Product name
	public void setName(String name) {
		this._name = name;
	}

	// Return product description
	public String getDescription() {
		return this._description;
	}

	// Set the description of the product
	public void setDescription(String description) {
		this._description = description;
	}
	
	// Return product quantity
	public int getQuantity() {
		return this._quantity;
	}
	
	// Set the quantity of the product
	public void setQuantity(int quantity) {
		this._quantity = quantity;
	}
	
	// Return only the dollar value
	public int getDollarValue() {
		return this._dollarValue;
	}
	
	// Return only the cent value
	public int getCentValue() {
		return this._centValue;
	}
	
	public void setSnackType(SnackType snackType) {
		this._snackType = snackType;
	}
	
	public SnackType getSnackType() {
		return this._snackType;
	}
	
	// Return full price as double
	public double getPrice() {
		
		// Brings both price values together with a point as a string
		// and parses into a double to return a single value
		return Double.parseDouble(this._dollarValue + "." + this._centValue);
	}

	// Set the dollar value of the product
	public void setdollarValue(int dollars) {
		this._dollarValue = dollars;
	}

	// Set the cent value of the product
	public void setCentValue(int cents) {
		
		// Check to make sure cents does not go over 99 cents
		// If over 99 cents, add value to dollars
		if (cents > 99) {
			this._dollarValue += (int)(cents / 100);
			this._centValue = (int)(cents % 100);
		} else {
			this._centValue = cents;
		}
	}
	
	// Set the dollars value of the product
	public void setFullValue(int dollars, int cents) {
		this._dollarValue = dollars;
		this.setCentValue(cents);
	}

	// Return the product image
	public Image getImage() {
		return this._image;
	}
	
	// Set an image for the product
	public void setImage(Image image) {
		this._image = image;
	}
	
	// Initialization Constructor
	public Product() {
		// Just an empty constructor
	}
	
	// constructor with args
	public Product(String name, SnackType snackType, String description, Image image, int quantity, int dollarValue, int centValue) {
		this._name = name;
		this._snackType = snackType;
		this._description = description;
		this._image = image;
		this._quantity = quantity;
		this.setFullValue(dollarValue, centValue);
	}
	
	// copy constructor
	public Product(Product product) {
		this._name = product.getName();
		this._snackType = product.getSnackType();
		this._description = product.getDescription();
		this._image = product.getImage();
		this._quantity = product.getQuantity();
		this.setFullValue(product._dollarValue, product._centValue);
	}
	
	// toString method
	public String toString() {
		return this._name + ", QTY: " + this.getQuantity();
	}
	
	// method to update qty
	public void updateQuantity(int quantity) {
		this.setQuantity(this._quantity + quantity);
	}
	
	// CompareTo method
	public int compareTo(Product product) {
		if (this.getName().compareTo(product.getName()) > 0) {
			// If > 0 return 1
			return 1;
		} else if (this.getName().compareTo(product.getName()) < 0) {
			// If < 0 return -1
			return -1;
		} else {
			// If == 0, check price
			if (this.getPrice() > product.getPrice()) {
				// If price > 0 return 1
				return 1;
			} else if (this.getPrice() < product.getPrice()) {
				//	If price > = return -1
				return -1;
			}
		}
		// If all checks fail, return 0 as equal
		return 0;
	}
}