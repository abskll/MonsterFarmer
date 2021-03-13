import java.io.Serializable;

public abstract class SpriteStore implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4698227590491102417L;

	abstract Sprite createSprite(String item);
	
	public Sprite orderSprite(String type, double x, double y) {
		Sprite sprite = createSprite(type);
		sprite.setPosition(x, y);
		System.out.println("--- Making a " + sprite.getName() + " ---");
		//sprite.grow();
		sprite.box();
		return sprite;
	}
	
	
}