/**  
* CustomerDisplay.java - Class for displaying the "Security Camera" effect of the customer objects' animated interaction with the Vending Machine.
* @author  Jay Wilson
* @version 1.0
*/

package com.mrjaywilson.vendomatic.customerqueue;

import com.mrjaywilson.vendomatic.engine.Transaction;
import com.mrjaywilson.vendomatic.inventory.Dispenser;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CustomerDisplay {
	public static String output = "";
	static ImageView imageView;

	public void getCustomerDisplay() {
		Stage stage = new Stage();
		GridPane grid = new GridPane();
		final String appStyleSheet = 
				getClass().getResource("camera.css").toExternalForm();

		/**
		 * Setup Grid
		 */
		int columns = 21;
		int rows = 16;

		grid.setPrefSize(375, 500);
		grid.setId("cameraGrid");
		grid.getStylesheets().add(appStyleSheet);

		for (int i = 0; i < columns; i++) {
			ColumnConstraints colConstraint = new ColumnConstraints();
			colConstraint.setPrefWidth(25);
			grid.getColumnConstraints().add(colConstraint);
		}

		for (int i = 0; i < rows; i++) {
			RowConstraints rowConstraint = new RowConstraints();
			rowConstraint.setPrefHeight(25);
			grid.getRowConstraints().add(rowConstraint);
		}


		/**
		 * Make the Text Box for translation of customer interaction
		 */
		Label txtInformation = new Label("Customer Name: John");
		txtInformation.setStyle("-fx-background-color: transparent");

		txtInformation.setId("lblCredits");
		txtInformation.setTextFill(Color.BLACK);
		txtInformation.setFont(Font.font("Rockwell Nova", FontWeight.BOLD, 10));
		txtInformation.setAlignment(Pos.CENTER);
		txtInformation.setMinHeight(125);
		txtInformation.setMinWidth(150);
		
		txtInformation.setTextAlignment(TextAlignment.LEFT);
		txtInformation.setAlignment(Pos.CENTER_LEFT);
		txtInformation.setWrapText(true);

		GridPane.setHalignment(txtInformation, HPos.LEFT);
		GridPane.setValignment(txtInformation, VPos.BASELINE);

		grid.add(txtInformation, 0, 0, 8, 4);

		
		/**
		 * Put the vending machine in the view
		 */
		ImagePattern pattern = new ImagePattern(new Image("\\images\\security_camera.png"));

		/**
		 * Additional Stuff
		 */
		Pane pane = new Pane();
		grid.add(pane, 0, 0, 20, 15);

		/**
		 * Begin Customers
		 */
		ProcessCustomerQueue queue = new ProcessCustomerQueue();
		Dispenser dispenser = new Dispenser();

		queue.loadCustomerList("C:\\Users\\mrjay\\Desktop\\Week 7\\Java Programming II\\VendoMatic\\csv\\customers.csv", dispenser);

		CustomerOrder(grid, txtInformation);

		Scene scene = new Scene(grid, 500, 375);
		scene.setFill(pattern);
		stage.setTitle("Flying Cat");
		stage.setScene(scene);

		stage.show();
	}
	
	private static void CustomerOrder(GridPane grid, Label label) {
		Dispenser dispenser = new Dispenser();
		ProcessCustomerQueue queue = new ProcessCustomerQueue();
		Transaction transaction = new Transaction();
		
		// Set text info for tracking
		output = "NAME: " + queue.First().getCustomerName() + "\r\n";
		label.setText(output);
		
		// Set customer
		imageView = new ImageView(queue.First().getNormalFace());
		grid.add(imageView, 0, 0);

		// Create new path for customer
		Customer path = new Customer(imageView);

		// move customer to the vending machine
		path.moveWest(imageView);

		// Wait unti moving west complete
		path.getWestPath().setOnFinished(e -> {
			// print the actions at the vending machine
			output += "attempting to purchase: " + queue.First().getProduct().getName() + "\r\n"
					+ "For a total cost of: $" + (double)(queue.First().getProduct().getPrice()) + "\r\n";
			
			// attempt to buy the item
			transaction.buyItem(queue.First().getProduct(), label);
			
			// get teh happy face upon purchase
			imageView.setImage(queue.First().getHappyFace());
			
			// call move south
			path.moveSouth(imageView);
		});

		// wait until south move finished
		path.getSouthPath().setOnFinished(e -> {
			
			// change direction of image
			imageView.setScaleX(-1);
			
			// move east
			path.moveEast(imageView);
			
			// remove from customer from queue
			ProcessCustomerQueue.customerList.remove();
			
			// if is not empty, keep moving through queue
			if (!ProcessCustomerQueue.customerList.isEmpty()) {
				CustomerOrder(grid, label);
			} else {
				// Show remaining inventory
				dispenser.showRemainingInventory("Vendor Inventory: ");
			}
		});
	}
	
	// access output
	public String getOutput() {
		return CustomerDisplay.output;
	}
}
