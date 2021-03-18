import java.io.Serializable;

import javafx.scene.image.Image;

public class BatAnimatedImage extends BasicAnimatedImage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3102417205463021994L;
	transient Image[] imgs = new Image[10000];
	int numberOfItems = 0;
	public BatAnimatedImage() {
		name = "Bat";
		Image im = new Image("bat-1.png");
        for(int i=1; i<7; i++) {
    		String filename = "bat-" + Integer.toString(i) + ".png";
            im = new Image(filename);
            imgs[i-1] = im;
            numberOfItems++;
        }
        System.out.println("#items" + numberOfItems);
        setNumberOfItems(numberOfItems);
        setImgArray(imgs);
        width = im.getWidth();
        height = im.getHeight();
        setTimeSinceLastAttack(System.nanoTime());
	}
	
	
}
