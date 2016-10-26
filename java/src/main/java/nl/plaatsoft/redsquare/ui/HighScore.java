package nl.plaatsoft.redsquare.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

import nl.plaatsoft.redsquare.tools.Score;

public class HighScore extends Pane {
	
	private final ObservableList<Score> data =
	        FXCollections.observableArrayList(
	            new Score( new Date(), 4423, 6),
	            new Score( new Date(), 3823, 5),
	            new Score( new Date(), 3723, 4),
	            new Score( new Date(), 3543, 3),
	            new Score( new Date(), 2423, 2),
	            new Score( new Date(), 4423, 6),
	            new Score( new Date(), 3823, 5),
	            new Score( new Date(), 3723, 4),
	            new Score( new Date(), 3543, 3),
	            new Score( new Date(), 2423, 2),
	            new Score( new Date(), 4423, 6),
	            new Score( new Date(), 3823, 5),
	            new Score( new Date(), 3723, 4),
	            new Score( new Date(), 3543, 3),
	            new Score( new Date(), 2423, 2),
	            new Score( new Date(), 1423, 1)
	        );
	
	@SuppressWarnings("unchecked")
	private TableView <Score> table() {
			
		TableView <Score> table = new TableView<Score>();
				
		table.setLayoutX(30);
		table.setLayoutY(30);
		table.setMaxHeight(370);
		table.setMinWidth(570);
		 		
		table.setEditable(false);
		
		TableColumn<Score,Date>  timestamp = new TableColumn<Score, Date>("Timestamp");
		timestamp.setCellValueFactory(new PropertyValueFactory<Score, Date>("timestamp"));
		timestamp.setMinWidth(200);
		
		TableColumn<Score, Integer> score = new TableColumn<Score, Integer>("Score");
		score.setCellValueFactory(new PropertyValueFactory<Score, Integer>("score"));
		score.setMinWidth(200);
		
		TableColumn<Score, Integer> level = new TableColumn<Score, Integer>("Level");
		level.setCellValueFactory(new PropertyValueFactory<Score, Integer>("level"));
		level.setMinWidth(150);
		
		table.setItems(data);
		table.setStyle("-fx-background-color: transparent;");
		table.getColumns().addAll(timestamp, score, level);
				
		return table;
	}

      
	HighScore(final Navigator page) {
		
		Image image1 = new Image("images/background1.png");
    	BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    	BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    	Background background = new Background(backgroundImage);
    	    	
		Label label1 = new Label("HighScore");
		label1.setLayoutX(30);
		label1.setLayoutY(30);
		label1.setStyle("-fx-font-size:30px; -fx-text-fill: white;");
		
		Button btn1 = new Button();
        btn1.setText("Close");
        btn1.setLayoutX(250);
        btn1.setLayoutY(420);
        btn1.setPrefWidth(150);
        btn1.setStyle("-fx-font-size:18px;");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
 
            public void handle(ActionEvent event) {
            	page.setHome();
            }
        });
                
		setBackground(background);
		getChildren().add(label1);
		getChildren().add(table());
		getChildren().add(btn1);				 
	}
}
