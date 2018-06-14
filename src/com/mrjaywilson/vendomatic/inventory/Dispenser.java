// package declaration
package com.mrjaywilson.vendomatic.inventory;

// import packages
import com.mrjaywilson.vendomatic.engine.Inventory;
import com.mrjaywilson.vendomatic.engine.SnackType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
// import API
import javafx.scene.image.Image;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

// Class Declaration
public class Dispenser implements Inventory {

	// Declare and initialize inventory list
	public static ArrayList<Product> _inventoryList = new ArrayList<Product>();

	// constructor, adds items to list
	public Dispenser() {
		addProducts();
	}

	private void addProducts() {
	
		// make sure no duplicates, and if so, do not add them
		if (this._inventoryList.size() <= 0 || this._inventoryList.isEmpty() == true) {
			// DRINKS
			this.addItem(SnackType.DRINK, "Coke", "Cool and crisp!", new Image("\\images\\snacks\\coke.png"), 1, 0, 75);
			this.addItem(SnackType.DRINK, "Sprite", "Lemony!", new Image("\\images\\snacks\\sprite.png"), 7, 0, 75);
			this.addItem(SnackType.DRINK, "Mountain Dew", "Quite right, slick!", new Image("\\images\\snacks\\dew.png"), 10, 0, 75);
			this.addItem(SnackType.DRINK, "Pepsi", "Dark and tasty!", new Image("\\images\\snacks\\pepsi.png"), 2, 0, 75);
			this.addItem(SnackType.DRINK, "Orange Soda", "The best orange in town!", new Image("\\images\\snacks\\pepsi.png"), 3, 0, 75);
			this.addItem(SnackType.DRINK, "Rootbeer", "made in a barrel!", new Image("\\images\\snacks\\rootbeer.png"), 8, 0, 75);
			this.addItem(SnackType.DRINK, "Ginger Ale", "Great for tummy aches!", new Image("\\images\\snacks\\gingerale.png"), 3, 0, 75);
			this.addItem(SnackType.DRINK, "Diet Coke", "All the taste, none of the calories!", new Image("\\images\\snacks\\diet.png"), 12, 0, 75);
			
			// CHIPS
			this.addItem(SnackType.CHIPS, "Classic Potato", "Crunchy!", new Image("\\images\\snacks\\classic.png"), 10, 1, 25);
			this.addItem(SnackType.CHIPS, "Salt and Vinager", "With ridges!", new Image("\\images\\snacks\\salt.png"), 7, 1, 50);
			this.addItem(SnackType.CHIPS, "Sour Cream and Onions", "So Good!", new Image("\\images\\snacks\\sourcream.png"), 4, 1, 75);
			this.addItem(SnackType.CHIPS, "BBQ Crisps", "Great with hotdogs!", new Image("\\images\\snacks\\bbq.png"), 12, 1, 25);
			this.addItem(SnackType.CHIPS, "Soylent Green", "Yum!", new Image("\\images\\snacks\\soylentgreen.png"), 11, 1, 25);
			
			// CANDY
			this.addItem(SnackType.CANDY, "Snickers", "Need a break?", new Image("\\images\\snacks\\snickers.png"), 4, 2, 25);
			this.addItem(SnackType.CANDY, "Three Muskateers", "All for one!", new Image("\\images\\snacks\\three.png"), 5, 1, 50);
			this.addItem(SnackType.CANDY, "Reeses Pieces", "Top!", new Image("\\images\\snacks\\reeses.png"), 8, 1, 75);
			this.addItem(SnackType.CANDY, "Kit Kats", "Give me a break!", new Image("\\images\\snacks\\kitkat.png"), 4, 0, 75);
			this.addItem(SnackType.CANDY, "Skittles", "So much rainbow", new Image("\\images\\snacks\\skittles.png"), 10, 2, 50);
			this.addItem(SnackType.CANDY, "Sour Patch", "So much sour!", new Image("\\images\\snacks\\sourpatch.png"), 3, 0, 50);
			
			// GUM
			this.addItem(SnackType.GUM, "Juicy Fruit", "Is it real fruit?", new Image("\\images\\snacks\\juicyfruit.png"), 3, 1, 25);
			this.addItem(SnackType.GUM, "Double Mint", "Twinsies", new Image("\\images\\snacks\\doublemint.png"), 6, 1, 25);
			this.addItem(SnackType.GUM, "Orbit Spearmint", "Takes you to space!", new Image("\\images\\snacks\\orbits.png"), 1, 2, 50);
		}
	}
	
	// Show Inventory
	public void showRemainingInventory(String title) {
		Stage stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 350, 300);
		scene.setFill(Color.BLACK);
		
		Label remainingItem = new Label(title);
		remainingItem.setFont(Font.font("Rockwell Nova", FontWeight.BOLD, 24));
		remainingItem.setAlignment(Pos.CENTER);
		remainingItem.setTextFill(Color.WHITE);
		GridPane gridPane = new GridPane();
		
		GridPane.setHalignment(remainingItem, HPos.LEFT);
		GridPane.setValignment(remainingItem, VPos.CENTER);
		
		gridPane.add(remainingItem, 0, 0, 16, 2);
		
		ListView<Product> inventoryList = new ListView<Product>();
		
		ColumnConstraints col1 = new ColumnConstraints(25);
		ColumnConstraints col2 = new ColumnConstraints(25);
		ColumnConstraints col3 = new ColumnConstraints(25);
		ColumnConstraints col4 = new ColumnConstraints(25);
		ColumnConstraints col5 = new ColumnConstraints(25);
		ColumnConstraints col6 = new ColumnConstraints(25);
		ColumnConstraints col7 = new ColumnConstraints(25);
		ColumnConstraints col8 = new ColumnConstraints(25);
		ColumnConstraints col9 = new ColumnConstraints(25);
		ColumnConstraints col10 = new ColumnConstraints(25);
		ColumnConstraints col11 = new ColumnConstraints(25);
		ColumnConstraints col12 = new ColumnConstraints(25);
		ColumnConstraints col13 = new ColumnConstraints(25);
		ColumnConstraints col14 = new ColumnConstraints(25);
		RowConstraints row1 = new RowConstraints(25);
		RowConstraints row2 = new RowConstraints(25);
		RowConstraints row3 = new RowConstraints(25);
		RowConstraints row4 = new RowConstraints(25);
		RowConstraints row5 = new RowConstraints(25);
		RowConstraints row6 = new RowConstraints(25);
		RowConstraints row7 = new RowConstraints(25);
		RowConstraints row8 = new RowConstraints(25);
		RowConstraints row9 = new RowConstraints(25);
		RowConstraints row10 = new RowConstraints(25);
		RowConstraints row11 = new RowConstraints(25);
		RowConstraints row12 = new RowConstraints(25);

		gridPane.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12, col13, col14);
		gridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12);
		
		gridPane.add(inventoryList, 0, 2, 14, 10);
		
		ObservableList<Product> inventory = FXCollections.observableArrayList(getInventoryList());
		
		inventoryList.setItems(inventory);
		root.getChildren().add(gridPane);
		
		stage.setScene(scene);
		stage.show();
	}

	// return the inventory list
	public ArrayList<Product> getInventoryList() {
		return this._inventoryList;
	}

	// method to add items
	@Override
	public void addItem(SnackType snackType, String name, String description, Image productImage, int quantity,
			int dollarValue, int coinValue) {
		switch (snackType) {
		case DRINK:
			this._inventoryList.add(new Drink(name, description, productImage, quantity, dollarValue, coinValue));
			break;
		case CHIPS:
			this._inventoryList.add(new Chips(name, description, productImage, quantity, dollarValue, coinValue));
			break;
		case CANDY:
			this._inventoryList.add(new Candy(name, description, productImage, quantity, dollarValue, coinValue));
			break;
		case GUM:
			this._inventoryList.add(new Gum(name, description, productImage, quantity, dollarValue, coinValue));
			break;
		}
	}

	// method to update quantity
	@Override
	public void updateItemQuantity(Product product, int quantity) {

		// Want to make sure we add the amount to the total, not replace it
		quantity += product.getQuantity();
		this._inventoryList.get(this._inventoryList.indexOf(product)).setQuantity(quantity);
	}

	// method to request item
	@Override
	public Object requestItem(SnackType snackType, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
