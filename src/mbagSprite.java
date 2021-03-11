import javafx.scene.image.Image;

public class mbagSprite extends Sprite {
	public mbagSprite() {
		name = "MbagSprite";
		String filename = "moneybag.png";
        Image i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
