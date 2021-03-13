import java.io.Serializable;

public class MoveSpriteLeftCommand implements Command, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3358199824075596418L;
	Sprite sprite;
	
	public MoveSpriteLeftCommand(Sprite sprite) {
		this.sprite = sprite;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		sprite.addVelocity(-5,0);
	}

}
