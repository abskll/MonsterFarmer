
public class MoveSpriteRightCommand implements Command {
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
