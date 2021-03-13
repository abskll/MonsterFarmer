import java.io.Serializable;

public class MoveSpriteDownCommand implements Command, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2999595731711936482L;
	Sprite sprite;
	
	public MoveSpriteDownCommand(Sprite sprite) {
		this.sprite = sprite;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		sprite.addVelocity(0,5);
	}

}
