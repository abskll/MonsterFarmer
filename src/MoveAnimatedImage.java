import java.io.Serializable;

import javafx.scene.image.Image;

public class MoveAnimatedImage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3905101181327350434L;
	transient AnimatedImage sprite;
	public MoveAnimatedImage(AnimatedImage sprite) {
		this.sprite = sprite;
		sprite.setRight();
	}
	public void setSprite(AnimatedImage sprite) {
		this.sprite = sprite;
		sprite.setRight();
	}
	public String goRight() {
		// TODO Auto-generated method stub
		sprite.setRight();
		sprite.addVelocity(5,0);
		System.out.println("selected sprite going right");
		return "selected sprite going right";
	}
	public String stopgoRight() {
		// TODO Auto-generated method stub
		sprite.setLastImage(new Image("rightL.png"));
		sprite.subtractVelocity(5,0);
		System.out.println("selected sprite stop going right");
		return "selected sprite stop going right";
	}
	public String goLeft() {
		// TODO Auto-generated method stub
		sprite.setLeft();
		sprite.addVelocity(-5,0);
		System.out.println("selected sprite going left");
		return "selected sprite going left";
	}
	public String stopgoLeft() {
		// TODO Auto-generated method stub
		sprite.setLastImage(new Image("leftL.png"));
		sprite.subtractVelocity(-5,0);
		System.out.println("selected sprite stop going left");
		return "selected sprite stop going left";
	}
	public String goUp() {
		// TODO Auto-generated method stub
		sprite.setUp();
		sprite.addVelocity(0,-5);
		System.out.println("selected sprite going up");
		return "selected sprite going up";
	}
	public String stopgoUp() {
		// TODO Auto-generated method stub
		sprite.setLastImage(new Image("upL.png"));
		sprite.subtractVelocity(0,-5);
		System.out.println("selected sprite stop going up");
		return "selected sprite stop going up";
	}
	public String goDown() {
		// TODO Auto-generated method stub
		sprite.setDown();
		sprite.addVelocity(0,5);
		System.out.println("selected sprite going down");
		return "selected sprite going down";
	}
	public String stopgoDown() {
		// TODO Auto-generated method stub
		sprite.setLastImage(new Image("downL.png"));
		sprite.subtractVelocity(0,5);
		System.out.println("selected sprite stop going down");
		return "selected sprite stop going down";
	}
}
