import java.io.Serializable;

import javafx.scene.image.Image;

public class FLCBSprite extends Sprite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6259791051569279373L;
	transient Image i;
	public FLCBSprite() {
		name = "FLCBSprite";
		String filename = "BFT_FARMLGCROPBROWN.png";
        i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();
	}
}
