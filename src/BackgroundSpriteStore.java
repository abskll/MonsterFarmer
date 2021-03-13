import java.io.Serializable;

public class BackgroundSpriteStore extends SpriteStore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4859975622417182701L;

	Sprite createSprite(String item) {
		//name = "Farm Plant Mature";
		if (item.equals("FIELDGREEN")) {
			return new FGSprite();
		} else return null;
	}
}
