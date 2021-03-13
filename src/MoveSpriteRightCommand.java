import java.io.Serializable;

public class MoveSpriteRightCommand implements Command, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5205077126936142767L;
	Sprite sprite;
	
	public MoveSpriteRightCommand(Sprite sprite) {
		this.sprite = sprite;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		sprite.addVelocity(5,0);
	}

}
