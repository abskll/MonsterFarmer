
public class BackgroundSpriteStore extends SpriteStore {

	Sprite createSprite(String item) {
		//name = "Farm Plant Mature";
		if (item.equals("FIELDGREEN")) {
			return new FGSprite();
		} else return null;
	}
}
