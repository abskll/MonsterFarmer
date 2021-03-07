import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public abstract class SpriteStore {
	
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