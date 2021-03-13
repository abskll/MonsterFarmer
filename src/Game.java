import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Game extends Application implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9079102260098944415L;
	String filename = "gamesave.ser";
	//GameLoop gl;
	Scene scene;
	Singleton log = Logger.getInstance();
	GameState GS;
	GameLoop gl;
	public void start(Stage s)throws Exception{
		  //event();
		GS = new GameState();
		//////////////////////////
		Button load = new Button("Load Save");
        Button newg = new Button("New Game");
        load.setStyle("-fx-border-color: #ff0000; -fx-border-width: 5px;");
        newg.setStyle("-fx-background-color: #00ff00");

        HBox hbox = new HBox(load, newg);
        scene = new Scene(hbox, 400, 100);
  load.setOnAction(new EventHandler<ActionEvent>(){
   public void handle(ActionEvent ae){
	   log.addLine("load button clicked");
	   FileInputStream fis = null;
	   ObjectInputStream in = null;
	   //GameState GS = GameState.getInstance();
	   try {
	       fis = new FileInputStream(filename);
	       in = new ObjectInputStream(fis);
	       //p = (Person) in.readObject();
	       //GS.setGameLoop((GameLoop) in.readObject());
	       GS.setGameLoop((GameLoop) in.readObject());
	       in.close();
	   } catch (Exception ex) {
	       ex.printStackTrace();
	   }
	   gl = GS.getGameLoop();
	   gl.setGameState(GS);
	   //GS.setGameLoop(gl);
		Stage s = new Stage();
		//gl.start(s);
	   //GS.getGameLoop().start(GS.getStage());
		gl.start(s);

   }
  });
  newg.setOnAction(new EventHandler<ActionEvent>(){
	   public void handle(ActionEvent ae){
		   //Game game = Game.getInstance();
		   log.addLine("new game button clicked");
			//GameState GS = GameState.getInstance();
			GameLoop gl = new GameLoop();
			GS.setGameLoop(gl);
			gl.setGameState(GS);
		    Stage s = new Stage();
		    gl.start(s);
	   }
	  });
		
		/////////////////
		  s.setScene(scene);
		  s.show();
		 }
		 public void event(){
		        

		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Launching game...");
		Singleton log = Logger.getInstance();
		log.addLine("Launching game...");
		launch(args);
		//Application.launch(OKButton.class, args);
		//Application.launch(GameLoop.class, args);
		//Stage s = new Stage();
		//gl.start(s);
	}


}
