import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public class SimpleSpriteFactory {

	public Sprite createSprite(Image i) {
		// TODO Auto-generated method stub
		Sprite sprite = null;
		
		if(i.equals("BFT_TREEGREEN")) {
			sprite = new BFT_TREEGREENSprite();
		}
		return sprite;
	}

}
