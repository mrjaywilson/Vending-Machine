/**
* Vendomatic.java - Main Entry-point for program
* @author  Jay Wilson
* @version 1.0
*/

// Declare package
package com.mrjaywilson.vendomatic.main;

import java.util.concurrent.ThreadLocalRandom;

import com.mrjaywilson.vendomatic.customerqueue.CustomerDisplay;
// import packages
import com.mrjaywilson.vendomatic.engine.SnackType;
import com.mrjaywilson.vendomatic.engine.UserInventory;
import com.mrjaywilson.vendomatic.inventory.Dispenser;
import com.mrjaywilson.vendomatic.inventory.Product;
import com.mrjaywilson.vendomatic.inventory.ProductUnit;

// import API
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

// Class Declaration
public class VendoMatic extends Application {
	
	static ProductUnit productUnit;
	static Stage mainStage;

	// main entrypoint for JAVAFX
	@Override
	public void start(Stage primaryStage) throws Exception {
		// Object declaration
		Dispenser dispenser = new Dispenser();
		primaryStage = new Stage();
		
		// Style sheet
		final String appStyleSheet = getClass().getResource("app.css").toExternalForm();
		
		// Columns and rows for the main grid
		final int columns = 19;
		final int rows = 34;
		
		// cost update variable
		double cost = 0d;

		
		/**********************************************
		 * Create Main Grid
		 **********************************************/
		GridPane mainGrid = new GridPane();
		mainGrid.setPrefSize(475, 800);
		mainGrid.setId("mainGrid");
		mainGrid.getStylesheets().add(appStyleSheet);
		
		for (int i = 0; i < columns; i++) {
			ColumnConstraints colConstraint = new ColumnConstraints();
			colConstraint.setPrefWidth(25);
			mainGrid.getColumnConstraints().add(colConstraint);
		}
		
		for (int i = 0; i < rows; i++) {
			RowConstraints rowConstraint = new RowConstraints();
			rowConstraint.setPrefHeight(25);
			mainGrid.getRowConstraints().add(rowConstraint);
		}

		
		/**********************************************
		 * Create Title
		 **********************************************/
		ImageView titleImage = new ImageView();
		
		titleImage.setImage(new Image("\\images\\title.png"));
		titleImage.setFitHeight(100);
		titleImage.setFitWidth(425);
		
		GridPane.setHalignment(titleImage, HPos.LEFT);
		GridPane.setValignment(titleImage, VPos.BASELINE);

		mainGrid.add(titleImage, 1, 1);

		
		/**********************************************
		 * Create Drink "Button"
		 **********************************************/
		ImageButton btnDrinks = new ImageButton("\\images\\drink_button_up.png", "\\images\\drink_button_down.png");
		btnDrinks.setId("btnCategory");
		
		GridPane.setHalignment(btnDrinks, HPos.CENTER);
		GridPane.setValignment(btnDrinks, VPos.CENTER);
		mainGrid.add(btnDrinks, 2, 6, 2, 2);

		
		/**********************************************
		 * Create Drink Title
		 **********************************************/
		ImageView drinkTitleImage = new ImageView();
		
		drinkTitleImage.setImage(new Image("\\images\\snack_label_drinks.png"));
		drinkTitleImage.setFitHeight(25);
		drinkTitleImage.setFitWidth(50);
		
		GridPane.setHalignment(drinkTitleImage, HPos.LEFT);
		GridPane.setValignment(drinkTitleImage, VPos.BASELINE);

		mainGrid.add(drinkTitleImage, 2, 8);
		
		
		/**********************************************
		 * Create Chips "Button"
		 **********************************************/
		ImageButton btnChips = new ImageButton("\\images\\chips_button_up.png", "\\images\\chips_button_down.png");
		btnChips.setId("btnCategory");

		GridPane.setHalignment(btnChips, HPos.CENTER);
		GridPane.setValignment(btnChips, VPos.CENTER);
		mainGrid.add(btnChips, 5, 6, 2, 2);
		
		
		/**********************************************
		 * Create Chips Title
		 **********************************************/
		ImageView chipsTitleImage = new ImageView();
		
		chipsTitleImage.setImage(new Image("\\images\\snack_label_chips.png"));
		chipsTitleImage.setFitHeight(25);
		chipsTitleImage.setFitWidth(50);
		
		GridPane.setHalignment(chipsTitleImage, HPos.LEFT);
		GridPane.setValignment(chipsTitleImage, VPos.BASELINE);

		mainGrid.add(chipsTitleImage, 5, 8);
		
		
		/**********************************************
		 * Create Candy "Button"
		 **********************************************/
		ImageButton btnCandy = new ImageButton("\\images\\candy_button_up.png", "\\images\\candy_button_down.png");
		btnCandy.setId("btnCategory");
		
		GridPane.setHalignment(btnCandy, HPos.CENTER);
		GridPane.setValignment(btnCandy, VPos.CENTER);
		
		mainGrid.add(btnCandy, 8, 6, 2, 2);

		
		/**********************************************
		 * Create Candy Title
		 **********************************************/
		ImageView candyTitleImage = new ImageView();
		
		candyTitleImage.setImage(new Image("\\images\\snack_label_candy.png"));
		candyTitleImage.setFitHeight(25);
		candyTitleImage.setFitWidth(50);
		
		GridPane.setHalignment(candyTitleImage, HPos.LEFT);
		GridPane.setValignment(candyTitleImage, VPos.BASELINE);

		mainGrid.add(candyTitleImage, 8, 8);
		
		
		/**********************************************
		 * Create Gum "Button"
		 **********************************************/
		ImageButton btnGum = new ImageButton("\\images\\gum_button_up.png", "\\images\\gum_button_down.png");
		btnGum.setId("btnCategory");

		GridPane.setHalignment(btnGum, HPos.CENTER);
		GridPane.setValignment(btnGum, VPos.CENTER);
		mainGrid.add(btnGum, 11, 6, 2, 2);

		
		/**********************************************
		 * Create Gum Title
		 **********************************************/
		ImageView gumTitleImage = new ImageView();
		
		gumTitleImage.setImage(new Image("\\images\\snack_label_gum.png"));
		gumTitleImage.setFitHeight(25);
		gumTitleImage.setFitWidth(50);
		
		GridPane.setHalignment(gumTitleImage, HPos.LEFT);
		GridPane.setValignment(gumTitleImage, VPos.BASELINE);

		mainGrid.add(gumTitleImage, 11, 8);
		
		
		
		/**********************************************
		 * Create Product View, Section I
		 **********************************************/
		FlowPane productView = new FlowPane();
		productView.setId("productView");
		productView.getStylesheets().add(appStyleSheet);
		productView.setVgap(5);
		productView.setHgap(5);
		
		productView.setPrefSize(325, 225);
		
		GridPane productGrid = new GridPane();
		
		productView.getChildren().add(productGrid);
		
		for (int i = 0; i < 13; i++) {
			ColumnConstraints colProductConstraint = new ColumnConstraints();
			colProductConstraint.setPrefWidth(25);
			productGrid.getColumnConstraints().add(colProductConstraint);
		}
		
		for (int i = 0; i < 9; i++) {
			RowConstraints colProductConstraint = new RowConstraints();
			colProductConstraint.setPrefHeight(25);
			productGrid.getRowConstraints().add(colProductConstraint);
		}
		
		mainGrid.add(productView, 1, 9, 13, 9);
		
		
		/**********************************************
		 * Category Button Events
		 **********************************************/
		// Create Grid layout ArrayList
		int[] gridLayout = {1, 4, 7, 10};
		
		// Do action for drink button by adding all items to the grid
		// but clear the grid first to prevent stacking and errors
		btnDrinks.setOnAction(event -> {
			productGrid.getChildren().clear();
			
			int count = gridLayout[0];
			int row = 1;
			int index = 0;
			
			// iterate and add all products to the grid
			for (Product product : dispenser.getInventoryList()) {
				if (product.getSnackType() == SnackType.DRINK) {
					if (count <= gridLayout[3]) {
						productUnit = new ProductUnit(product);
						productGrid.add(productUnit.getProductGrid(), count, row);
						if (index + 1 < gridLayout.length) {
							index++;
							count = gridLayout[index];
						} else {
							count = 11;
						}
					} else if (count > gridLayout[3] && row == 1) {
						index = 0;
						count = gridLayout[index];
						row = 5;
					} else {
						return;
					}
				}
			}
		});
		
		btnChips.setOnAction(event -> {
			productGrid.getChildren().clear();

			int count = gridLayout[0];
			int row = 1;
			int index = 0;

			// iterate and add all products to the grid
			for (Product product : dispenser.getInventoryList()) {
				if (product.getSnackType() == SnackType.CHIPS) {
					if (count <= gridLayout[3]) {
						productUnit = new ProductUnit(product);
						productGrid.add(productUnit.getProductGrid(), count, row);
						if (index + 1 < gridLayout.length) {
							index++;
							count = gridLayout[index];
						} else {
							count = 11;
						}
					} else if (count > gridLayout[3] && row == 1) {
						index = 0;
						count = gridLayout[index];
						row = 5;
					} else {
						return;
					}
				}
			}
		});

		btnCandy.setOnAction(event -> {
			productGrid.getChildren().clear();

			int count = gridLayout[0];
			int row = 1;
			int index = 0;
			
			
			// iterate and add all products to the grid
			for (Product product : dispenser.getInventoryList()) {
				if (product.getSnackType() == SnackType.CANDY) {
					if (count <= gridLayout[3]) {
						productUnit = new ProductUnit(product);
						productGrid.add(productUnit.getProductGrid(), count, row);
						if (index + 1 < gridLayout.length) {
							index++;
							count = gridLayout[index];
						} else {
							count = 11;
						}
					} else if (count > gridLayout[3] && row == 1) {
						index = 0;
						count = gridLayout[index];
						row = 5;
					} else {
						return;
					}
				}
			}
		});
		

		btnGum.setOnAction(event -> {
			productGrid.getChildren().clear();

			int count = gridLayout[0];
			int row = 1;
			int index = 0;
			
			// iterate and add all products to the grid
			for (Product product : dispenser.getInventoryList()) {
				if (product.getSnackType() == SnackType.GUM) {
					if (count <= gridLayout[3]) {
						productUnit = new ProductUnit(product);
						productGrid.add(productUnit.getProductGrid(), count, row);
						if (index + 1 < gridLayout.length) {
							index++;
							count = gridLayout[index];
						} else {
							count = 11;
						}
					} else if (count > gridLayout[3] && row == 1) {
						index = 0;
						count = gridLayout[index];
						row = 5;
					} else {
						return;
					}
				}
			}
		});
		
		/**********************************************
		 * Create Product View, Section II
		 * Scroll object
		 **********************************************/
		
		// Create Scroll for flow pane
		ScrollPane productScroller = new ScrollPane();
		productScroller.setId("productScroller");
		
		productScroller.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		productScroller.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		
		productScroller.setContent(productView);
		
		
		/**********************************************
		 * Add Confirm Order Button
		 **********************************************/
		Button btnConfirmOrder = new Button("Confirm\nOrder");
		btnConfirmOrder.setTextAlignment(TextAlignment.CENTER);
		btnConfirmOrder.setId("btnUtility");
		
		btnConfirmOrder.getStylesheets().add(appStyleSheet);
		GridPane.setHalignment(btnConfirmOrder, HPos.LEFT);
		GridPane.setValignment(btnConfirmOrder, VPos.BASELINE);
		
		mainGrid.add(btnConfirmOrder, 15, 10, 3, 2);
		
		btnConfirmOrder.setOnAction(event -> {
			GridPane confirm = new GridPane();
			confirm.setStyle("-fx-background-color: black");
			Label confirmed = new Label("ORDER\nCONFIRMED!");
			confirmed.setFont(Font.font("Times New Roman", FontWeight.EXTRA_BOLD, 20));
			confirmed.setTextFill(Color.WHITE);
			confirmed.setAlignment(Pos.CENTER);
			
			confirm.add(confirmed, 0, 0, 6, 2);
			
			mainGrid.add(confirm, 6, 12, 6, 2);
		});


		/**********************************************
		 * Add Modify Order Button
		 **********************************************/
		Button btnModifyOrder = new Button("Modify\nOrder");
		btnModifyOrder.setTextAlignment(TextAlignment.CENTER);
		btnModifyOrder.setId("btnUtility");
		
		btnModifyOrder.getStylesheets().add(appStyleSheet);
		GridPane.setHalignment(btnModifyOrder, HPos.LEFT);
		GridPane.setValignment(btnModifyOrder, VPos.BASELINE);
		
		mainGrid.add(btnModifyOrder, 15, 13, 3, 2);
		
		
		/**********************************************
		 * Add Modify Order Button
		 **********************************************/
		btnModifyOrder.setOnAction(event -> {
			UserInventory userInventory = new UserInventory();
			
			userInventory.showInventory();
		});
		
		
		/**********************************************
		 * Add Exit Button
		 **********************************************/
		Button btnExit = new Button("EXIT");
		btnExit.setTextAlignment(TextAlignment.CENTER);
		btnExit.setId("btnUtility");
		
		btnExit.getStylesheets().add(appStyleSheet);
		GridPane.setHalignment(btnExit, HPos.LEFT);
		GridPane.setValignment(btnExit, VPos.BASELINE);
		
		mainGrid.add(btnExit, 15, 16, 3, 2);
		
		btnExit.setOnAction(evt -> {
			System.exit(0);
		});
		
		/**********************************************
		 * Add Cart Basket
		 **********************************************/
		ImageView basket = new ImageView(new Image("\\images\\basket.png"));
		mainGrid.add(basket, 1, 19, 13, 6);
		

		/**********************************************
		 * Add Vendor Access Point
		 **********************************************/
		ImageView vendorAccess = new ImageView(new Image("\\images\\vendor_access.png"));
		mainGrid.add(vendorAccess, 1, 27, 13, 6);
		
		vendorAccess.setOnMouseClicked(event -> {
			dispenser.showRemainingInventory("Vendor Inventory: ");
		});
		
		
		/**********************************************
		 * Add "security camera" button
		 **********************************************/
		Button btnSecurityCamera = new Button("Security\nCamera");
		btnSecurityCamera.setTextAlignment(TextAlignment.CENTER);
		btnSecurityCamera.setId("btnUtility");
		
		btnSecurityCamera.getStylesheets().add(appStyleSheet);
		GridPane.setHalignment(btnSecurityCamera, HPos.LEFT);
		GridPane.setValignment(btnSecurityCamera, VPos.BASELINE);
		
		mainGrid.add(btnSecurityCamera, 15, 7, 3, 2);
		//mainGrid.add(btnSecurityCamera, 15, 29, 3, 2);
		
		btnSecurityCamera.setOnAction(event -> {
			CustomerDisplay queue = new CustomerDisplay();
			queue.getCustomerDisplay();
		});
		
		
		/**********************************************
		 * Add "Kick Machine" button
		 **********************************************/
		Button btnKick = new Button("Kick\nHere!");
		btnKick.setTextAlignment(TextAlignment.CENTER);
		btnKick.setId("btnKick");
		
		btnKick.getStylesheets().add(appStyleSheet);
		GridPane.setHalignment(btnKick, HPos.LEFT);
		GridPane.setValignment(btnKick, VPos.BASELINE);
		
		mainGrid.add(btnKick, 15, 29, 3, 2);
		
		mainStage = primaryStage;
		
		btnKick.setOnAction(event -> {
			mainStage.setX(mainStage.getX() + 25);
			int index = ThreadLocalRandom.current().nextInt(0, dispenser.getInventoryList().size() - 1);
			UserInventory._userInventory.add(dispenser.getInventoryList().get(index));
			UserInventory._userInventory.get(UserInventory._userInventory.size() - 1).setQuantity(1);
			mainStage.setX(mainStage.getX() - 15);
			
			Alert alert = new Alert(AlertType.INFORMATION, "Item Granted!\n\n You got a "
					+ dispenser.getInventoryList().get(index).getName()
					+ "!", ButtonType.OK);
			alert.showAndWait();
		});
		
		
		/**********************************************
		 * Create Scene
		 * Set to Stage
		 * Show Stage
		 **********************************************/
		Scene scene = new Scene(mainGrid, 475,  800);
		
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
