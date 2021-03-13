import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

import javafx.stage.Stage;

public class GameState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3819389370187110130L;
	private Double experience = null;
	private Integer money = null;
	UISpriteMenu uiSpriteM = new UISpriteMenu();
	BGSpriteMenu bgSpriteM = new BGSpriteMenu();
	UISpriteMenu uiSpriteMExplorer = new UISpriteMenu();
	UISpriteMenu uiSpriteMFarmer = new UISpriteMenu();
	BGSpriteMenu bgSpriteMExplorer = new BGSpriteMenu();
	BGSpriteMenu bgSpriteMFarmer = new BGSpriteMenu();
	double width = 1024;
	double height = 768;
	Random rand = new Random();
	SpriteStore uiStore = new UISpriteStore();
	Sprite cashbag = null;
	boolean fieldhasmbag = false;
	Singleton log = Logger.getInstance();
	GameState GS;
	GameLoop gl;
	SpriteServer ss;
	boolean farm = false;
	double posX = 0;
	double posY = 0;
	SpriteControl spritecontrol;
	CropSpriteStore css = new CropSpriteStore();
	private Double food = 0.0;

	
	// other useful instance variables here
 
	
	public void setGameLoop(GameLoop gl) {
		this.gl = gl;
	}
	public GameLoop getGameLoop() {
		return gl;
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
