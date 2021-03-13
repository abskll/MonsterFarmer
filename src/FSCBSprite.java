import java.io.Serializable;

import javafx.scene.image.Image;

public class FSCBSprite extends Sprite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5768292627085277023L;
	transient Image i;
	public FSCBSprite() {
		name = "FSCBSprite";
		String filename = "BFT_FARMSMCROPBROWN.png";
        i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
