import javafx.scene.canvas.GraphicsContext;

import java.io.Serializable;
import java.util.Iterator;

public class AnimatedImageServer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5613941496514081680L;
	/**
	 * 
	 */
	EnemyBasicAnimatedImageMenu enemyM;
	transient GraphicsContext gc;
	
	public AnimatedImageServer(GraphicsContext gc, EnemyBasicAnimatedImageMenu enemyM) {
		// TODO Auto-generated constructor stub
		this.gc = gc;
		this.enemyM =enemyM;
	}
	public void renderitems(double elapsedTime) {
		// TODO Auto-generated method stub
		//Iterator<BasicAnimatedImage> createIterator()
		Iterator<BasicAnimatedImage> enemyIterator = enemyM.createIterator();
		render(enemyIterator, elapsedTime);
	}
	private void render(Iterator<BasicAnimatedImage> iterator, double elapsedTime) {
		try {
			while(iterator.hasNext()) {
				BasicAnimatedImage sprite = iterator.next();
				sprite.update(elapsedTime);
				sprite.render(gc);
			}	
		}catch(Exception e) {
			System.out.println("Nothing to render this time");
		}

	}
	
	
}
