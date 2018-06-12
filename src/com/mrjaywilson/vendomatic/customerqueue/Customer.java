package com.mrjaywilson.vendomatic.customerqueue;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import com.mrjaywilson.vendomatic.inventory.Product;

public class Customer {
	/**
	 * Private Members
	 */
	private String customerName;
	private Product product;
	private Image normal;
	private Image happy;
	private ProcessCustomerQueue customerQueue = new ProcessCustomerQueue(); 
	
	/**
	 * Getter / Setters
	 */
	public String getCustomerName() {
		return this.customerName;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public Image getNormalFace() {
		return this.normal;
	}
	
	public Image getHappyFace() {
		return this.happy;
	}
	
	/**
	 * Constructors
	 */
	public Customer(String name, Product product, Image normal, Image happy, ImageView imageview, int x, int y) {
		this.customerName = name;
		this.product = product;
		this.normal = normal;
		this.happy = happy;
	}

	public Customer() {
		// Empty
	}
	
	/**
	 * Use vending machine
	 */
	private void useVendingMachine() {
		
	}
	
	/**
	 * Setup Customer Path
	 */
	private PathTransition westPath = new PathTransition(
			Duration.millis(3000), 
			new Line(400, 275, 150, 275));
	private PathTransition southPath = new PathTransition(
			Duration.millis(3000), 
			new Line(150, 275, 150, 360));
	private PathTransition eastPath = new PathTransition(
			Duration.millis(2750), 
			new Line(150, 360, 550, 360));
	
	/**
	 * Return Path
	 */
	public PathTransition getWestPath() {
		return this.westPath;
	}

	public PathTransition getSouthPath() {
		return this.southPath;
	}
	
	public PathTransition getEastPath() {
		return this.eastPath;
	}
	
	public Customer(ImageView imageView) {
		
	}
	
	public void moveWest(ImageView imageView) {
		westPath.setNode(imageView);
		westPath.setCycleCount(1);
		westPath.play();
	}
	
	public void moveSouth(ImageView imageView) {
		southPath.setNode(imageView);
		southPath.setCycleCount(1);
		southPath.play();
	}

	public void moveEast(ImageView imageView) {
		eastPath.setNode(imageView);
		eastPath.setCycleCount(1);
		eastPath.play();
	}
}
