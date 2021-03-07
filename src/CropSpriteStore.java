
public class CropSpriteStore extends SpriteStore {

	Sprite createSprite(String item) {
		//name = "Farm Plant Mature";
		if (item.equals("FARMLGCROPBROWN")) {
			return new FLCBSprite();
		} else if (item.equals("FARMLGCROPGREEN")) {
			return new FLCGSprite();
		} else if (item.equals("FARMSMCROPBROWN")) {
			return new FSCBSprite();
		} else if (item.equals("FARMSMCROPGREEN")) {
			return new FSCGSprite();
		} else return null;
	}
}
