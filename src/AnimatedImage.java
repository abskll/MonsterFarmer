import java.io.Serializable;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class AnimatedImage implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 6132498863611141632L;
	// assumes animation loops,
    //  each image displays for equal time
    transient public Image[] frames;
    public double duration = 5;
    private double positionX;
    private double positionY;    
    double width;
    double height;
    double timeelapsed = 0;
    private double velocityX;
    private double velocityY;
    private double minvelocityX = -5;
    private double minvelocityY = -5;
    private double maxvelocityX = 5;
    private double maxvelocityY = 5;
    transient private Image lastImage = new Image("downL.png");
    
    public double getposX() {
    	return positionX;
    }
    public double getposY() {
    	return positionY;
    }
    public double getWidth() {
    	return width;
    }
    public double getHeight() {
    	return height;
    }
    public void render(GraphicsContext gc)
    {
    	if((velocityX==0)&&(velocityY==0)) {
    		gc.drawImage( lastImage, positionX, positionY );
    	} else {
    		gc.drawImage( getFrame(timeelapsed), positionX, positionY );
    	}
        
    }
    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
    }
    public Image getLastImage() {
    	return lastImage;
    }
    public void setLastImage(Image lastImage) {
    	this.lastImage = lastImage;
    }
    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }
    public Image getFrame(double time)
    {
        int index = (int)((time % (frames.length * duration)) / duration);
        return frames[index];
    }
    public void setDown() {
    	Image[] imgs = new Image[2];
    	imgs[0] = new Image("downL.png");
    	imgs[1] = new Image("downR.png");
    	this.frames=imgs;
    }
    public void setUp() {
    	Image[] imgs = new Image[2];
    	imgs[0] = new Image("upL.png");
    	imgs[1] = new Image("upR.png");
    	this.frames=imgs;
    }
    public void setRight() {
    	Image[] imgs = new Image[2];
    	imgs[0] = new Image("rightL.png");
    	imgs[1] = new Image("rightR.png");
    	this.frames=imgs;
    }
    public void setLeft() {
    	Image[] imgs = new Image[2];
    	imgs[0] = new Image("leftL.png");
    	imgs[1] = new Image("leftR.png");
    	this.frames=imgs;
    }


    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y)
    {
    	
        velocityX += x;
        velocityY += y;
        if(!(velocityX==0)) {
        	if(velocityX>0) {
        		if(velocityX > maxvelocityX) {
        			velocityX = maxvelocityX;
        		}
        	} else if(velocityX < minvelocityX) {
        		velocityX = minvelocityX;
        	}
        }	
        if(!(velocityY==0)) {
        	if(velocityY>0) {
        		if(velocityY > maxvelocityY) {
        			velocityY = maxvelocityY;
        		}
        	} else if(velocityY < minvelocityY) {
        		velocityY = minvelocityY;
        	}        	
        }
    }
    public void subtractVelocity(double x, double y)
    {
        velocityX -= x;
        velocityY -= y;
    }
    public void update(double time)
    {
    	
        positionX += velocityX * time;
        positionY += velocityY * time;
        this.timeelapsed += time;
    }
}