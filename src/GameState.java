import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

import javafx.stage.Stage;

public class GameState implements Serializable {
	private static final long serialVersionUID = 1L;
	protected static GameState uniqueInstance;
	private GameLoop gl;
	private Stage s;
	transient public Double experience = null;
	transient public Integer money = null;
	transient public UISpriteMenu uiSpriteM = new UISpriteMenu();
	transient public BGSpriteMenu bgSpriteM = new BGSpriteMenu();
	transient public double width = 1024;
	transient public double height = 768;
	transient public Random rand = new Random();
	transient public SpriteStore uiStore = new UISpriteStore();
	transient public Sprite cashbag = null;
	transient public boolean fieldhasmbag = false;
	
	
	// other useful instance variables here
 
	
	public void setGameLoop(GameLoop gl) {
		this.gl = gl;
	}
	public GameLoop getGameLoop() {
		return gl;
	}

	public void setStage(Stage s) {
		// TODO Auto-generated method stub
		this.s = s;
	}

	public Stage getStage() {
		// TODO Auto-generated method stub
		return this.s;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getMoney() {
		return money;
	}
	public void setExperience(Double experience) {
		this.experience = experience;
	}
	public Double getExperience() {
		return experience;
	}
	public void saveGame(GameLoop gl) {
		
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		
		try {
		    fos = new FileOutputStream("gamesave.ser");
		    out = new ObjectOutputStream(fos);
		    out.writeObject(gl);
		    out.close();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
}
