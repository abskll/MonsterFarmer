import java.io.Serializable;

import javafx.scene.image.Image;

public class FLCGSprite extends Sprite implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3348805315332010840L;
	transient Image i;
	public FLCGSprite() {
		name = "FLCGSprite";
		String filename = "BFT_FARMLGCROPGREEN.png";
        i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
