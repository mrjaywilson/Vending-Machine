/**
* ImageButton.java - Class extending Button to created custom
* buttons for inventory items to be selected from the
* vending machine.
* @author  Jay Wilson
* @version 1.0
* @see Button
*/

// package declaration
package com.mrjaywilson.vendomatic.main;

// import API
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// class declaration
public class ImageButton extends Button {
	
	// constructor
	public ImageButton(String stateUp, String stateDown) {
		setGraphic(new ImageView(new Image(stateUp)));

		// setup pressed event
		setOnMousePressed(evt -> {
			setGraphic(new ImageView(new Image(stateDown)));
		});

		// setup released event
		setOnMouseReleased(evt -> {
			setGraphic(new ImageView(new Image(stateUp)));
		});
	}

	// Setup additional constructor for additional calls
	public ImageButton(Image image) {
		setGraphic(new ImageView(image));

		// setup pressed event
		setOnMousePressed(evt -> {
			setGraphic(new ImageView(image));
		});

		// setup released event
		setOnMouseReleased(evt -> {
			setGraphic(new ImageView(image));
		});
	}
}
