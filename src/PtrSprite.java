import java.io.Serializable;

import javafx.scene.image.Image;

public class PtrSprite extends Sprite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3674953460598443447L;
	transient Image i;
	public PtrSprite() {
		name = "PntrSprite";
		String filename = "pointer.png";
        i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
