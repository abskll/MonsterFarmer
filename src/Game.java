import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Game extends Application {
	String filename = "gamesave.ser";
	//GameLoop gl;
	Scene scene;
	Singleton log = Logger.getInstance();
	GameState GS;
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
	       
	       in.close();
	   } catch (Exception ex) {
	       ex.printStackTrace();
	   }
	   
	   //GS.setGameLoop(gl);
		Stage s = new Stage();
		//gl.start(s);
	   //GS.getGameLoop().start(GS.getStage());
		GS.getGameLoop().start(s);

   }
  });
  newg.setOnAction(new EventHandler<ActionEvent>(){
	   public void handle(ActionEvent ae){
		   //Game game = Game.getInstance();
		   log.addLine("new game button clicked");
			//GameState GS = GameState.getInstance();
			GameLoop gl = new GameLoop(GS);
			GS.setGameLoop(gl);
		    Stage s = new Stage();
		    GS.setStage(s);
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
