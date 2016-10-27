package nl.plaatsoft.redsquare.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import nl.plaatsoft.redsquare.tools.MyButton;
import nl.plaatsoft.redsquare.tools.MyLabel;

public class ReleaseNotes extends Pane {

	String notes="27-10-2016 (Version 0.1)\n"
			+ "- Added new version check thread to home page.\n"
			+ "- Added page nagivator so pages are loaded just in time.\n"
			+ "- Added basic game page.\n"
			+ "- Added Intro1 and Intro2 pages with simple animation.\n"
			+ "- Added Donate, Credit, Help, Release Notes page.\n"
			+ "- My first JavaFX game!.\n";
	
	ReleaseNotes(final Navigator page) {
		
		Image image1 = new Image("images/background1.png");
    	BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    	BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    	Background background = new Background(backgroundImage);
    	    	   	
    	MyLabel label1 = new MyLabel(130, 30, "Release Notes", 60);
    	MyLabel label2 = new MyLabel(30, 120, notes, 18);    	
    	MyButton button1 = new MyButton(230, 420, "Close", 18, page, page.getHome());
                      
		setBackground(background);
		getChildren().add(label1);
		getChildren().add(label2);
		getChildren().add(button1);
	}
}
