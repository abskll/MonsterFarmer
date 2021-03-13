import java.io.Serializable;

import javafx.scene.image.Image;

public class FSCGSprite extends Sprite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4797636005072938614L;
	transient Image i;
	public FSCGSprite() {
		name = "FSCGSprite";
		String filename = "BFT_FARMSMCROPGREEN.png";
        i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
