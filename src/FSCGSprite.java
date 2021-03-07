import javafx.scene.image.Image;

public class FSCGSprite extends Sprite {
	public FSCGSprite() {
		name = "FSCGSprite";
		String filename = "BFT_FARMSMCROPGREEN.png";
        Image i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
