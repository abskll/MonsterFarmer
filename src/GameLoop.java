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

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Collect the Money Bags!
public class GameLoop extends Application implements Serializable
{
	private static final long serialVersionUID = 1L;
	transient private Double experience = null;
	transient private Integer money = null;
	transient UISpriteMenu uiSpriteM = new UISpriteMenu();
	transient BGSpriteMenu bgSpriteM = new BGSpriteMenu();
	transient double width = 1024;
	transient double height = 768;
	transient Random rand = new Random();
	transient SpriteStore uiStore = new UISpriteStore();
	transient Sprite cashbag = null;
	transient boolean fieldhasmbag = false;
	transient Singleton log = Logger.getInstance();
	transient GameState GS;
	transient SpriteServer ss;
	//    public static void main(String[] args) 
//    {
//        launch(args);
//    }
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Integer getMoney() {
		return money;
	}
	public void setExperience(Double experience) {
		this.experience = experience;
	}
	public Double getExperience() {
		return experience;
	}
	public UISpriteMenu getuiSpriteM() {
		return this.uiSpriteM;
	}
	public void setUISpriteMenu(UISpriteMenu uiSpriteM) {
		this.uiSpriteM = uiSpriteM;
	}
	public BGSpriteMenu getBGSpriteMenu() {
		return this.bgSpriteM;
	}
	public void setBGSpriteMenu(BGSpriteMenu bgSpriteM) {
		this.bgSpriteM = bgSpriteM;
	}
	public void setuiStore(SpriteStore uiStore) {
		this.uiStore = uiStore;
	}
	public SpriteStore getuiStore() {
		return uiStore;
	}
	public void setcashbag(Sprite cashbag) {
		this.cashbag = cashbag;
	}
	public Sprite getcashbag() {
		return cashbag;
	}
	public void setfieldhadmbag(boolean fieldhasmbag) {
		this.fieldhasmbag = fieldhasmbag;
	}
    public GameLoop(GameState GS) {
    	//launch(args);
    	this.GS = GS;
    }
    @Override
    public void start(Stage theStage) 
    {
        theStage.setTitle( "Monster(Farmer)!" );

        
        //long cnanotime;
        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );
        //double width = 512;
        //double height = 512;

        Canvas canvas = new Canvas( width, height );
        root.getChildren().add( canvas );
        GraphicsContext gc = canvas.getGraphicsContext2D();
        if(experience==null) {
        	experience = 0.0;
        	log.addLine("experience set to 0");
        }
        if(money==null) {
        	money = 0;
        	log.addLine("money set to 0");
        }
        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setFill( Color.GREEN );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);     
        
        
        ArrayList<String> input = new ArrayList<String>();

        Sprite pointer = uiStore.orderSprite("pointer", 200, 0);
        Sprite pointer2 = uiStore.orderSprite("pointer", 300, 0);
        log.addLine("pointers made");
        uiSpriteM.addSprite(pointer);
        uiSpriteM.addSprite(pointer2);
        ss = new SpriteServer(gc, uiSpriteM, bgSpriteM);
        
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
		log.addLine("commands set");
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
	                    case DIGIT0:
	                    	//Singleton bar = HotterSingleton.getInstance();
	                    	//GameState GS = GameState.getInstance();
	                    	GameLoop gl = GS.getGameLoop();
	                    	GS.saveGame(gl);
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
                
                experience += 0.0001;
                int randint = rand.nextInt(10000);

                
                

                
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
                
                gc.clearRect(0, 0, width,height);
                
                //for(Sprite fg:fgreen) fg.render(gc);
                //pointer.render( gc );
                moneybags(pointer, randint, gc);
                ss.renderitems();
//                for (Sprite moneybag : moneybagList )
//                    moneybag.render( gc );
                
                
                DecimalFormat df = new DecimalFormat("###.###");
                String pointsText = "Controls: you=1, pets=2, save(not working)=0, xp:" 
                + df.format(experience) + 
                		", money:" + money;
                gc.fillText( pointsText, 300, 36 );
                gc.strokeText( pointsText, 300, 36 );
            }
        }.start();

        theStage.show();
    }
    
    public void moneybags(Sprite pointer, int randint, GraphicsContext gc) {
    	if(!fieldhasmbag) {
    		if(randint>9970) {
                int randwidth = rand.nextInt((int) width - 200);
                int randheight = rand.nextInt((int) height - 200);
                randwidth+=100;
                randheight+=100;
            	cashbag = uiStore.orderSprite("moneybag", randwidth, randheight);
            	uiSpriteM.addSprite(cashbag);
            	//uiSpriteM.addSprite(cashbag);
            	//uiSpriteM.addSprite(cashbag);
            	fieldhasmbag = true;
            	this.ss = new SpriteServer(gc, uiSpriteM, bgSpriteM);
            	//return ss;
            }
    	} else {
    		if ( pointer.intersects(cashbag) )
            {
    			System.out.println("Intersects");
          	while(uiSpriteM.hasNext()) {
          		if(uiSpriteM.next().name.contains("MbagSprite")) {
          			uiSpriteM.remove();
          			money+=100;
          			cashbag = null;
          			fieldhasmbag = false;
          			this.ss = new SpriteServer(gc, uiSpriteM, bgSpriteM);
          		}
          	}

            }
    	}
    	//return ss;

    }
}