import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.Iterator;

public class SpriteServer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6655974844163012847L;
	SpriteMenu uiSpriteMenu;
	SpriteMenu bgSpriteMenu;
	transient GraphicsContext gc;
	
	public SpriteServer(GraphicsContext gc, SpriteMenu uiSpriteM, SpriteMenu bgSpriteM) {
		// TODO Auto-generated constructor stub
		this.gc = gc;
		this.uiSpriteMenu =uiSpriteM;
		this.bgSpriteMenu =bgSpriteM;
	}
	public void renderitems(double elapsedTime) {
		// TODO Auto-generated method stub
		Iterator<Sprite> uiIterator = uiSpriteMenu.createIterator();
		Iterator<Sprite> bgIterator = bgSpriteMenu.createIterator();
		render(bgIterator, elapsedTime);
		render(uiIterator, elapsedTime);
	}
	private void render(Iterator<Sprite> iterator, double elapsedTime) {
		try {
			while(iterator.hasNext()) {
				Sprite sprite = iterator.next();
				sprite.update(elapsedTime);
				sprite.grow(elapsedTime);
				sprite.render(gc);
			}	
		}catch(Exception e) {
			System.out.println("Nothing to render this time");
		}

	}
	
	
}
