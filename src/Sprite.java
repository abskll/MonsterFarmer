import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
import java.util.Random;

public abstract class Sprite
{
    Image image;
    private double positionX;
    private double positionY;    
    private double velocityX;
    private double velocityY;
    private double minvelocityX = -5;
    private double minvelocityY = -5;
    private double maxvelocityX = 5;
    private double maxvelocityY = 5;
    double width;
    double height;
    String name;
    Random rand = new Random();
    
 

    public Sprite()
    {
        positionX = 0;
        positionY = 0;    
        velocityX = 0;
        velocityY = 0;
    }
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
    public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename)
    {
        Image i = new Image(filename);
        setImage(i);
    }
	public void box() {
		System.out.println("Placing Sprite in official SpriteStore box");
	}
	public String getName() {
		return name;
	}
    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
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

    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, positionX, positionY );
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
    
    public String toString()
    {
        return " Position: [" + positionX + "," + positionY + "]" 
        + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
	public void grow() {
		// TODO Auto-generated method stub
		

//		new Thread(() -> {
//			
//		    while(!donegrowing) {
//				int randnum = rand.nextInt(1000);
//				if(randnum > 900) {
//					
//				}
//		    }
//		}).start();
		
	}
}