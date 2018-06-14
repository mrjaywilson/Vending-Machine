/**
* ProductUnit.java - Creates an object for each product to be used in the vending machien as a button using ImageButton clss
* @author  Jay Wilson
* @version 1.0
* @see ImageButton
*/


// package declaration
package com.mrjaywilson.vendomatic.inventory;

// import packages
//import com.mrjaywilson.vendomatic.engine.Animation;
import com.mrjaywilson.vendomatic.engine.UserInventory;
import com.mrjaywilson.vendomatic.main.ImageButton;

// import API
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.text.DecimalFormat;

// import com.sun.glass.ui.Robot; 

// class declaration
public class ProductUnit {
	
	private ImageButton btnProduct;

	// declare object members
	private Label _lblQty;
	private Label _lblPrice;
	private GridPane _mainGrid;
	private GridPane _miniGrid;
	private Product _product;
		
	// constructor
	public ProductUnit(Product product) {
		
		// initialize grids
		_mainGrid = new GridPane();
		_miniGrid = new GridPane();
		
		/********************************************
		 * Setup Main Grid
		*********************************************/
		ColumnConstraints colMGConstraint1 = new ColumnConstraints(25);
		ColumnConstraints colMGConstraint2 = new ColumnConstraints(25);
		RowConstraints rowMGConstraint1 = new RowConstraints(25);
		RowConstraints rowMGConstraint2 = new RowConstraints(25);
		RowConstraints rowMGConstraint3 = new RowConstraints(25);
		
		_mainGrid.getColumnConstraints().addAll(colMGConstraint1, colMGConstraint2);
		_mainGrid.getRowConstraints().addAll(rowMGConstraint1, rowMGConstraint2, rowMGConstraint3);
		
		
		/**********************************************
		 * Create Product "Button"
		 **********************************************/
		btnProduct = new ImageButton(product.getImage());
		btnProduct.setStyle("-fx-background-color: transparent");

		GridPane.setHalignment(btnProduct, HPos.CENTER);
		GridPane.setValignment(btnProduct, VPos.CENTER);
		
		_mainGrid.add(btnProduct, 0, 0, 2, 2);
		
		btnProduct.setOnAction(event -> {
			UserInventory userInventory = new UserInventory();
			if (product.getQuantity() > 0) {
				product.updateQuantity(-1);
				
				if (!userInventory.getUserInventory().contains(product)) {
					userInventory.getUserInventory().add(product);					
				} else {
					userInventory.getUserInventory().get(userInventory.getUserInventory().indexOf(product)).updateQuantity(1);
				}

				this._lblQty.setTextFill(Color.YELLOW);
				this._lblQty.setText("QTY: " + product.getQuantity());
				
				
			} else {
				this._lblQty.setTextFill(Color.RED);
			}
		});

		/**********************************************
		 * Create 'Mini'grid
		 **********************************************/
		ColumnConstraints colProductConstraint = new ColumnConstraints(25);
		ColumnConstraints colProductConstraint2 = new ColumnConstraints(25);
		RowConstraints rowProductConstraint = new RowConstraints(12.5);
		RowConstraints rowProductConstraint2 = new RowConstraints(12.5);

		_miniGrid.getColumnConstraints().addAll(colProductConstraint,colProductConstraint2);
		_miniGrid.getRowConstraints().addAll(rowProductConstraint,rowProductConstraint2);
		
		_mainGrid.add(_miniGrid, 0, 2);
		
		
		/**********************************************
		 * Create Labels for QTY and Price
		 **********************************************/
		DecimalFormat format = new DecimalFormat("#.00");
		_lblQty = new Label("QTY: " + product.getQuantity());
		_lblPrice = new Label("$" + format.format(product.getPrice()));
		
		_lblQty.setTextFill(Color.YELLOW);
		_lblQty.setFont(Font.font("Rockwell Nova", FontWeight.BOLD, 10));
		_lblPrice.setTextFill(Color.YELLOW);
		_lblPrice.setFont(Font.font("Rockwell Nova", FontWeight.BOLD, 10));
		

		GridPane.setHalignment(_lblQty, HPos.CENTER);
		GridPane.setValignment(_lblQty, VPos.CENTER);
		GridPane.setHalignment(_lblPrice, HPos.CENTER);
		GridPane.setValignment(_lblPrice, VPos.CENTER);
		
		_miniGrid.add(_lblQty, 0, 0, 2, 1);
		_miniGrid.add(_lblPrice, 0, 1, 2, 1);
	}
	
	public ImageButton getButtonProduct() {
		return this.btnProduct;
	}

	// return the main grid
	public GridPane getProductGrid() {
		return this._mainGrid;
	}
	
	// return the objects product
	public Product getProduct() {
		return this._product;
	}
}
