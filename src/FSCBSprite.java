import javafx.scene.image.Image;

public class FSCBSprite extends Sprite {
	public FSCBSprite() {
		name = "FSCBSprite";
		String filename = "BFT_FARMSMCROPBROWN.png";
        Image i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
