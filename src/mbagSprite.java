import java.io.Serializable;

import javafx.scene.image.Image;

public class mbagSprite extends Sprite  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3618520383978016100L;
	transient Image i;
	public mbagSprite() {
		name = "MbagSprite";
		String filename = "moneybag.png";
        i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
