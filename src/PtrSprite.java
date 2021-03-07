import javafx.scene.image.Image;

public class PtrSprite extends Sprite {
	public PtrSprite() {
		name = "PntrSprite";
		String filename = "pointer.png";
        Image i = new Image(filename);
        setImage(i);
        image = i;
        width = i.getWidth();
        height = i.getHeight();		
	}
}
