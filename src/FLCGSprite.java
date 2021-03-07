import javafx.scene.image.Image;

public class FLCGSprite extends Sprite {
	public FLCGSprite() {
		name = "FLCGSprite";
		String filename = "BFT_FARMLGCROPGREEN.png";
        Image i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
