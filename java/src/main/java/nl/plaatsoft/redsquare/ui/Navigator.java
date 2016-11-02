package nl.plaatsoft.redsquare.ui;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import nl.plaatsoft.redsquare.tools.Constants;
import nl.plaatsoft.redsquare.tools.ScoreGlobal;

public class Navigator {
		
	private static Intro1 intro1;
	private static Intro2 intro2;
	private static Home home;
	private static Game game;	
	private static Donate donate;
	private static HighScore1 highScore1;
	private static HighScore2 highScore2;
	private static Credits credits;	
	private static ReleaseNotes releaseNotes;
	private static Help help;
	private static Settings settings;	
	
	private static Scene scene;	
			
	public static final int INTRO1 = 1;
	public static final int INTRO2 = 2;
	public static final int HOME = 3;
	public static final int GAME = 4;
	public static final int DONATE = 5;
	public static final int LOCAL_HIGHSCORE = 6;
	public static final int GLOBAL_HIGHSCORE = 7;
	public static final int CREDITS = 8;
	public static final int RELEASE_NOTES = 9;
	public static final int HELP = 10;
	public static final int SETTINGS = 11;
	public static final int EXIT = 12;
			
	public static Scene getScene() {
		return scene;
	}
	
	public static void go(int page) {
				
		switch (page ) {
		
			case INTRO1:
				intro1 = new Intro1();
				intro1.draw();
				scene = new Scene(intro1, Constants.WIDTH, Constants.HEIGHT);	
				scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				    public void handle(KeyEvent key) {
				    	Navigator.go(Navigator.INTRO2);			
				    }
				});						
				break;
			
			case INTRO2:
				intro2 = new Intro2();				
				intro2.draw();
				scene.setRoot(intro2);
				scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				    public void handle(KeyEvent key) {
				    	Navigator.go(Navigator.HOME);			
				    }
				});		
				break;		
				
			case HOME:
				if (home==null) {
					home = new Home();
				}
				home.draw();
				scene.setRoot(home);	
				scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				    public void handle(KeyEvent key) {
				       // switch it off
				    }
				});		
				break;		
		
			case GAME:
				game = new Game();
				game.draw();		
				scene.setRoot(game);					
				break;		
				
			case LOCAL_HIGHSCORE:
				ScoreGlobal.clear();
				
				highScore1 = new HighScore1();
				highScore1.draw();
				
				scene.setRoot(highScore1);
				break;
				
			case GLOBAL_HIGHSCORE:
				highScore2 = new HighScore2();
				scene.setRoot(highScore2);
				highScore2.draw();
				break;		
				
			case DONATE:
				donate = new Donate();
				scene.setRoot(donate);
				donate.draw();
				break;
								
			case CREDITS:
				credits = new Credits();
				credits.draw();
				scene.setRoot(credits);
				break;	
				
			case RELEASE_NOTES:
				releaseNotes = new ReleaseNotes();
				releaseNotes.draw();
				scene.setRoot(releaseNotes);				
				break;		
				
			case SETTINGS:
				settings = new Settings();
				settings.draw();
				scene.setRoot(settings);			
				break;	
				
			case HELP:
				help = new Help();
				help.draw();
				scene.setRoot(help);			
				break;	
				
			case EXIT:
				System.exit(0);
				break;
		}
	}
}
