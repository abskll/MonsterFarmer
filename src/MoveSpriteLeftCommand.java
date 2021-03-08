
public class MoveSpriteLeftCommand implements Command {
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
