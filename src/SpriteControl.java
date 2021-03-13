import java.io.Serializable;

public class SpriteControl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4435222224717222313L;
	Command[] activateCommands;
	Command[] disableCommands;
	Sprite sprite;
	public SpriteControl() {
		activateCommands = new Command[10];
		disableCommands = new Command[10];
		for(int i = 0; i< 10; i++) {
			activateCommands[i] = () -> {};
			disableCommands[i] = () -> {};
		}		
	}
	public void setCommand(int slot, Command activateCommand, Command disableCommand) {
		activateCommands[slot] = activateCommand;
		disableCommands[slot] = disableCommand;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void activateButtonWasPushed(int slot) {
		activateCommands[slot].execute();
	}
 
	public void disableButtonWasPushed(int slot) {
		disableCommands[slot].execute();
	}
}
