import javafx.scene.image.Image;

public class FGSprite extends Sprite {
	public FGSprite() {
		name = "FGSprite";
		String filename = "BFT_FIELDGREEN.png";
        Image i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
