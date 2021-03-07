import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

// Collect the Money Bags!
public class GameLoop extends Application 
{
    public static void main(String[] args) 
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle( "Farm!" );
        //long cnanotime;
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        double width = 512;
        double height = 512;
        Canvas canvas = new Canvas( width, height );
        root.getChildren().add( canvas );
        

        ArrayList<String> input = new ArrayList<String>();

        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !input.contains(code) )
                        input.add( code );
                }
            });

        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    input.remove( code );
                }
            });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setFill( Color.GREEN );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);
        
        SpriteStore uiStore = new UISpriteStore();
        Sprite pointer = uiStore.orderSprite("pointer", 200, 0);
        UISpriteMenu uiSpriteM = new UISpriteMenu();
        BGSpriteMenu bgSpriteM = new BGSpriteMenu();
        uiSpriteM.addSprite(pointer);
        SpriteServer ss = new SpriteServer(gc, uiSpriteM, bgSpriteM);
        
        //ArrayList<Sprite> moneybagList = new ArrayList<Sprite>();
        
        boolean done = false;
    	double fgx = 0;
    	double fgy= 0;
    	ArrayList<Sprite> fgreen = new ArrayList<Sprite>();
    	//Iterator
    	SpriteStore bgStore = new BackgroundSpriteStore();
        while(!done) {
        	Sprite sprite = bgStore.orderSprite("FIELDGREEN", fgx, fgy);
        	//fieldgreen.setPosition(fgx, fgy);
        	//fgreen.add(sprite);
        	bgSpriteM.addSprite(sprite);
        	fgx = fgx + sprite.getWidth()-1;
        	
        	if(fgx > width) {
        		if(fgy > height) {
        			done=true; 
        			break;
        		} else {
        			fgy = fgy + sprite.getHeight() - 1;
        			fgx = 0;
        		}
        		
        	}
        }
        
        
//        for (int i = 0; i < 15; i++)
//        {
//
//            double px = 350 * Math.random() + 50;
//            double py = 350 * Math.random() + 50;  
//            Sprite moneybag = new Sprite();
//            moneybag.setImage("moneybag.png");
//            moneybag.setPosition(px,py);
//            
//            moneybagList.add( moneybag );
//        }
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );

        IntValue score = new IntValue(0);

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // calculate time since last update.
            	//cnanotime = currentNanoTime;
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 100000000.0;
                lastNanoTime.value = currentNanoTime;
                
                // game logic
//        		PizzaStore nyStore = new NYPizzaStore();
//        		PizzaStore chicagoStore = new ChicagoPizzaStore();
//         
//        		Pizza pizza = nyStore.orderPizza("cheese");
                
        		
                pointer.setVelocity(0,0);
                if (input.contains("A"))
                    pointer.addVelocity(-5,0);
                if (input.contains("D"))
                    pointer.addVelocity(5,0);
                if (input.contains("W"))
                    pointer.addVelocity(0,-5);
                if (input.contains("S"))
                    pointer.addVelocity(0,5);
                    
                //GameObjects.updateposition();
                //GameObjects.render( gc );
                pointer.update(elapsedTime);
                
                // collision detection
                
//                Iterator<Sprite> moneybagIter = moneybagList.iterator();
//                while ( moneybagIter.hasNext() )
//                {
//                    Sprite moneybag = moneybagIter.next();
//                    if ( pointer.intersects(moneybag) )
//                    {
//                        moneybagIter.remove();
//                        score.value++;
//                    }
//                }
                
                // render
                
                gc.clearRect(0, 0, 512,512);
                
                //for(Sprite fg:fgreen) fg.render(gc);
                //pointer.render( gc );
                ss.renderitems();
//                for (Sprite moneybag : moneybagList )
//                    moneybag.render( gc );
                
                
                
                String pointsText = "Cash: $" + (100 * score.value);
                gc.fillText( pointsText, 360, 36 );
                gc.strokeText( pointsText, 360, 36 );
            }
        }.start();

        theStage.show();
    }
}