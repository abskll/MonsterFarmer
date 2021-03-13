import java.io.Serializable;

public class MoveSpriteUpCommand implements Command, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 739247173473472308L;
	Sprite sprite;
	
	public MoveSpriteUpCommand(Sprite sprite) {
		this.sprite = sprite;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		sprite.addVelocity(0,-5);
	}

}
