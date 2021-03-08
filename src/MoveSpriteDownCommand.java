
public class MoveSpriteDownCommand implements Command {
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
