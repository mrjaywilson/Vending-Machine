// Package Declaration
package com.mrjaywilson.vendomatic.engine;

// Import package
import com.mrjaywilson.vendomatic.inventory.Product;

// Import API
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

// Class Declaration
public class Animation {
	
	// Declare objects
	private PathTransition transition;
	private Product product;
	
	// Constructor, takes product
	public Animation(Product product) {
		// sets product
		this.product = product;
	}
	
	// Anmiate call
	public void animate() {
		
		// Declare and initialize objects
		final Pane root = new Pane();
		Stage stage = new Stage();
		
		// setup up root		
		root.setPrefSize(280, 190);
		root.setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
		root.setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

		// setup image
		Image img = new Image("\\");
		ImageView drop = new ImageView(img);
		
		// add drop to root
		root.getChildren().add(drop);
		
		// setup path for dropping animation
		Path path = new Path(new MoveTo(20,20), new CubicCurveTo(380, 0, 220, 120, 120, 80), new CubicCurveTo(0, 40, 0, 240, 220, 120));

		// add path to root
		root.getChildren().add(path);
		
		// setup animation
		transition  = new PathTransition(Duration.seconds(4), path, drop);
		transition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		transition.setCycleCount(1);
		
		// add root to scene
		Scene scene = new Scene(root);
		
		// add scene to stage
		stage.setScene(scene);
		
		// setbackground to transparent
		scene.setFill(Color.TRANSPARENT);
		
		// show invisible stage
		stage.show();
		
		// Play the animation drop
		transition.play();
	}
	
	// method to play the animation
	public void play() {
		transition.play();
	}
	
	// method to stop loop anmiations (none used)
	public void stop() {
		transition.stop();
	}
}
