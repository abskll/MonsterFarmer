
public class Move {
	Sprite sprite;
	public Move(Sprite sprite) {
		this.sprite = sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	public String goRight() {
		// TODO Auto-generated method stub
		sprite.addVelocity(5,0);
		System.out.println("selected sprite going right");
		return "selected sprite going right";
	}
	public String stopgoRight() {
		// TODO Auto-generated method stub
		sprite.subtractVelocity(5,0);
		System.out.println("selected sprite stop going right");
		return "selected sprite stop going right";
	}
	public String goLeft() {
		// TODO Auto-generated method stub
		sprite.addVelocity(-5,0);
		System.out.println("selected sprite going left");
		return "selected sprite going left";
	}
	public String stopgoLeft() {
		// TODO Auto-generated method stub
		sprite.subtractVelocity(-5,0);
		System.out.println("selected sprite stop going left");
		return "selected sprite stop going left";
	}
	public String goUp() {
		// TODO Auto-generated method stub
		sprite.addVelocity(0,-5);
		System.out.println("selected sprite going up");
		return "selected sprite going up";
	}
	public String stopgoUp() {
		// TODO Auto-generated method stub
		sprite.subtractVelocity(0,-5);
		System.out.println("selected sprite stop going up");
		return "selected sprite stop going up";
	}
	public String goDown() {
		// TODO Auto-generated method stub
		sprite.addVelocity(0,5);
		System.out.println("selected sprite going down");
		return "selected sprite going down";
	}
	public String stopgoDown() {
		// TODO Auto-generated method stub
		sprite.subtractVelocity(0,5);
		System.out.println("selected sprite stop going down");
		return "selected sprite stop going down";
	}
}
