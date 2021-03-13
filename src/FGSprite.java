import java.io.Serializable;

import javafx.scene.image.Image;

public class FGSprite extends Sprite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4734471786652827330L;
	transient Image i;
	public FGSprite() {
		name = "FGSprite";
		String filename = "BFT_FIELDGREEN.png";
        i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
