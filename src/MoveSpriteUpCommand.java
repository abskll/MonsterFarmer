
public class MoveSpriteUpCommand implements Command {
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
