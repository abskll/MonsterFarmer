import javafx.scene.canvas.GraphicsContext;
import java.util.Iterator;

public class SpriteServer {
	SpriteMenu uiSpriteMenu;
	SpriteMenu bgSpriteMenu;
	GraphicsContext gc;
	
	public SpriteServer(GraphicsContext gc, SpriteMenu uiSpriteM, SpriteMenu bgSpriteM) {
		// TODO Auto-generated constructor stub
		this.gc = gc;
		this.uiSpriteMenu =uiSpriteM;
		this.bgSpriteMenu =bgSpriteM;
	}
	public void renderitems() {
		// TODO Auto-generated method stub
		Iterator<Sprite> uiIterator = uiSpriteMenu.createIterator();
		Iterator<Sprite> bgIterator = bgSpriteMenu.createIterator();
		render(bgIterator);
		render(uiIterator);
	}
	private void render(Iterator<Sprite> iterator) {
		while(iterator.hasNext()) {
			Sprite sprite = iterator.next();
			sprite.render(gc);
		}
	}
	
	
}
