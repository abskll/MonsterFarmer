import java.io.Serializable;

public class UISpriteStore extends SpriteStore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8372485339522310836L;

	Sprite createSprite(String item) {
		//name = "Farm Plant Mature";
		if (item.equals("pointer")) {
			return new PtrSprite();
		} else if(item.equals("moneybag")) {
			return new mbagSprite();
		} else return null;
	}
}
