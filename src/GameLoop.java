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
import javafx.scene.input.KeyCode;
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
        theStage.setTitle( "MonsterFarmer!" );
        //long cnanotime;
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        //double width = 512;
        //double height = 512;
        double width = 1024;
        double height = 768;
        Canvas canvas = new Canvas( width, height );
        root.getChildren().add( canvas );
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setFill( Color.GREEN );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);       

        ArrayList<String> input = new ArrayList<String>();
        SpriteStore uiStore = new UISpriteStore();
        Sprite pointer = uiStore.orderSprite("pointer", 200, 0);
        Sprite pointer2 = uiStore.orderSprite("pointer", 300, 0);
        UISpriteMenu uiSpriteM = new UISpriteMenu();
        BGSpriteMenu bgSpriteM = new BGSpriteMenu();
        uiSpriteM.addSprite(pointer);
        uiSpriteM.addSprite(pointer2);
        SpriteServer ss = new SpriteServer(gc, uiSpriteM, bgSpriteM);
        
        SpriteControl spritecontrol = new SpriteControl();
        Move move = new Move(pointer);
        
		Command goRight = () -> {
			move.goRight();
		};
		Command goLeft = () -> {
			move.goLeft();
		};
		Command goUp = () -> {
			move.goUp();
		};
		Command goDown = () -> {
			move.goDown();
		};
		
		Command stopgoRight = () -> {
			move.stopgoRight();
		};
		Command stopgoLeft = () -> {
			move.stopgoLeft();
		};
		Command stopgoUp = () -> {
			move.stopgoUp();
		};
		Command stopgoDown = () -> {
			move.stopgoDown();
		};		
		
//        Move move2 = new Move(pointer2);
//        
//		Command goRight2 = () -> {
//			move2.goRight();
//		};
//		Command goLeft2 = () -> {
//			move2.goLeft();
//		};
//		Command goUp2 = () -> {
//			move2.goUp();
//		};
//		Command goDown2 = () -> {
//			move2.goDown();
//		};
//		
//		Command stopgoRight2 = () -> {
//			move2.stopgoRight();
//		};
//		Command stopgoLeft2 = () -> {
//			move2.stopgoLeft();
//		};
//		Command stopgoUp2 = () -> {
//			move2.stopgoUp();
//		};
//		Command stopgoDown2 = () -> {
//			move2.stopgoDown();
//		};		
        //because could control the various sprites with this
		//spritecontrol.setSprite(pointer);
		int D = 0;
		int A = 1;
		int W = 2;
		int S = 3;
		spritecontrol.setCommand(D, goRight, stopgoRight);
		spritecontrol.setCommand(A, goLeft, stopgoLeft);
		spritecontrol.setCommand(W, goUp, stopgoUp);
		spritecontrol.setCommand(S, goDown, stopgoDown);
		
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    KeyCode code = e.getCode();//.toString();
                    if ( !input.contains(code.toString()) )
                        input.add( code.toString() );
                    switch(code) {
	                    case D:
	                    	spritecontrol.activateButtonWasPushed(D);
	                    	break;
	                    case A:
	                    	spritecontrol.activateButtonWasPushed(A);
	                    	// code block
	                    	break;
	                    case W:
	                    	spritecontrol.activateButtonWasPushed(W);
	                        // code block
	                        break;
	                    case S:
	                    	spritecontrol.activateButtonWasPushed(S);
	                        // code block
	                        break;
	                    case DIGIT1:
//	                    	spritecontrol.setCommand(D, goRight, stopgoRight);
//	                		spritecontrol.setCommand(A, goLeft, stopgoLeft);
//	                		spritecontrol.setCommand(W, goUp, stopgoUp);
//	                		spritecontrol.setCommand(S, goDown, stopgoDown);
	                    	spritecontrol.setSprite(pointer);
	                    	move.setSprite(pointer);
	                    	System.out.println("Pressed 1 - switching control");
	                        // code block
	                        break;
	                    case DIGIT2:
//	                    	spritecontrol.setCommand(D, goRight2, stopgoRight2);
//	                		spritecontrol.setCommand(A, goLeft2, stopgoLeft2);
//	                		spritecontrol.setCommand(W, goUp2, stopgoUp2);
//	                		spritecontrol.setCommand(S, goDown2, stopgoDown2);
	                    	spritecontrol.setSprite(pointer2);
	                    	move.setSprite(pointer2);
	                    	System.out.println("Pressed 2 - switching control");
	                        // code block
	                        break;
	                    default:
                    	// code block
                    }
                }
            });

        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                	KeyCode code = e.getCode();
                    input.remove( code.toString() );
                    switch(code) {
                    case D:
                    	spritecontrol.disableButtonWasPushed(D);
                    	break;
                    case A:
                    	spritecontrol.disableButtonWasPushed(A);
                    	// code block
                    	break;
                    case W:
                    	spritecontrol.disableButtonWasPushed(W);
                        // code block
                        break;
                    case S:
                    	spritecontrol.disableButtonWasPushed(S);
                        // code block
                        break;
                    default:
                	// code block
                }
                }
            });


        

        //ArrayList<Sprite> moneybagList = new ArrayList<Sprite>();
        
        boolean done = false;
    	double fgx = 0;
    	double fgy= 0;
    	//ArrayList<Sprite> fgreen = new ArrayList<Sprite>();
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
                //pointer.setVelocity(0,0);
//                if (input.contains("A"))
//                    pointer.addVelocity(-5,0);
//                if (input.contains("D"))
//                    pointer.addVelocity(5,0);
//                if (input.contains("W"))
//                    pointer.addVelocity(0,-5);
//                if (input.contains("S"))
//                    pointer.addVelocity(0,5);
                
                
                
                
                //GameObjects.updateposition();
                //GameObjects.render( gc );
                pointer.update(elapsedTime);
                pointer2.update(elapsedTime);
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
                
                
                
                String pointsText = "Controls: you=1, pets=2";
                gc.fillText( pointsText, 360, 36 );
                gc.strokeText( pointsText, 360, 36 );
            }
        }.start();

        theStage.show();
    }
}