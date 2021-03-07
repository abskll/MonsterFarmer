
public class UISpriteStore extends SpriteStore {

	Sprite createSprite(String item) {
		//name = "Farm Plant Mature";
		if (item.equals("pointer")) {
			return new PtrSprite();
		} else return null;
	}
}
