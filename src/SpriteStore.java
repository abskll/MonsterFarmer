import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public class SpriteStore {
	SimpleSpriteFactory factory;
	
	public SpriteStore(SimpleSpriteFactory factory) {
		this.factory = factory;
	}
	
	public Sprite orderSprite(Image i) {
		Sprite sprite;
		sprite = factory.createSprite(i);
		//do work like render
		
		sprite.grow();
		return sprite;
	}
	
}
