package application;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import controller.RGBColorController;


public class App extends HBox {


	private static final long serialVersionUID = 1L;

	private RGBColorController controller; // Color controller
	private Rectangle sample; // Color preview box
	private TextField colorCode; // Text field containing the color in hex format

	/** Construct the application */
	public App() {
		controller = new RGBColorController(79, 178, 255);
		initUI();
	}

	public RGBColorController getController() {
		return controller;
	}
	
	private void initUI() {

		// Column 1: Sliders
		VBox sliderPane = new VBox();
		sliderPane.setPadding(new Insets(20, 10, 10, 20));
		sliderPane.setSpacing(30);
		// Red
		Slider slider = new Slider(0, 255, 127);
		sliderPane.getChildren().add(slider);
		controller.red.bind(slider);
		// Green
		slider = new Slider(0, 255, 127);
		sliderPane.getChildren().add(slider);		
		controller.green.bind(slider);
		// Blue
		slider = new Slider(0, 255, 127);
		sliderPane.getChildren().add(slider);		
		controller.blue.bind(slider);
		

		// Column 2: Text fields (next to the sliders)
		VBox textPane = new VBox();		// Red
		textPane.setPadding(new Insets(10, 10, 10, 10));
		textPane.setSpacing(20);
		TextField textField = new TextField();
		textPane.getChildren().add(textField);
		controller.red.bind(textField);
		// Green
		textField = new TextField();
		textPane.getChildren().add(textField);
		controller.green.bind(textField);
		// Blue
		textField = new TextField();
		textPane.getChildren().add(textField);
		controller.blue.bind(textField);

		// Column 3: Hex color field and color sample
		VBox hexPane = new VBox();
		hexPane.setAlignment(Pos.CENTER);
		hexPane.setPadding(new Insets(10, 10, 10, 10));
		hexPane.setSpacing(10); 
		// Color in hex format
		colorCode = new TextField();
		hexPane.getChildren().add(colorCode);
		controller.bind(colorCode);
		// Color preview
		sample = new Rectangle (100,100);
		hexPane.getChildren().add(sample);
		controller.bind(sample);

		// Resize window and make it visible
		this.getChildren().addAll(sliderPane, textPane, hexPane);	}



}
