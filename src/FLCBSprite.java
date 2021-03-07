import javafx.scene.image.Image;

public class FLCBSprite extends Sprite {

	public FLCBSprite() {
		name = "FLCBSprite";
		String filename = "BFT_FARMLGCROPBROWN.png";
        Image i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();
	}
}
