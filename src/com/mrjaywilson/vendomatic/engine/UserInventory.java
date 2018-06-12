/**
* 	Program:	Vend-o-Matic (Vending Machine Project)
*	File:		UserInvetory.java
*	Summary:	Manages user inventory.
* 	Author:		Jay Wilson
* 				Bibata RABBA IDI
*	Date:		May 06, 2018
**/

// Package Declaration
package com.mrjaywilson.vendomatic.engine;

// Import Packages
import com.mrjaywilson.vendomatic.inventory.Dispenser;
import com.mrjaywilson.vendomatic.inventory.Product;

// Import API
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


// Class delcaration
public class UserInventory {
	// Declare and initialize objects
	static public ArrayList<Product> _userInventory = new ArrayList<Product>();
	
	// Return the arraylist for user inventory
	public ArrayList<Product> getUserInventory() {
		return this._userInventory;
	}
	
	// Empty constructor
	public UserInventory() {
	}
	
	// Shows the inventory list for the user in a new stage
	public void showInventory() {
		// Declare and initialize objects
		Stage stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 200, 200);
		
		// setup scene
		scene.setFill(Color.BLACK);
		
		// setup label
		Label removeItem = new Label("Each click removes (1) Item: ");
		removeItem.setTextAlignment(TextAlignment.CENTER);
		removeItem.setTextFill(Color.WHITE);
		
		// Create new Gridpane
		GridPane gridPane = new GridPane();
		
		// setup label with grid
		GridPane.setHalignment(removeItem, HPos.LEFT);
		GridPane.setValignment(removeItem, VPos.CENTER);
		
		// add label to grid
		gridPane.add(removeItem, 0, 0, 12, 2);
		
		// Create the inventory List
		ListView<Product> inventoryList = new ListView<Product>();
		
		// Define the columns and rows
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
		
		// Add the columns and rows to the grid
		gridPane.getColumnConstraints().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11, col12);
		gridPane.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12);
		
		// add the inventory list to the grid
		gridPane.add(inventoryList, 0, 2, 12, 10);
		
		// Create observable list for hte product items
		ObservableList<Product> inventory = FXCollections.observableArrayList(this._userInventory);
		
		// Add the observable list to the list view
		inventoryList.setItems(inventory);
		
		// Define the event for clicking the listview
		inventoryList.setOnMouseClicked(event -> {
			
			// Declare and initialize object
			Dispenser dispenser = new Dispenser();
			
			// Update the quantity 
			dispenser.updateItemQuantity(inventoryList.getSelectionModel().getSelectedItem(), 1);
		});
		
		// Add grid to the root
		root.getChildren().add(gridPane);
		
		// Update stage with the scene
		stage.setScene(scene);
		
		// Show the stage
		stage.show();
	}
}
