import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

public class UnitTesting extends Application {

	
	@Test
	void test() throws InterruptedException {

		//Testing Singleton Functionality
		Singleton log = Logger.getInstance();
		log.addLine("testinput");
		log.setfname("LOG.txt");
		log.createNewLog();
		log.writeToLogandFlush();
		String estimatedcontents = log.getfcontents();
		String actualcontents = log.readEntireLog();
		char[] econtentsarr = estimatedcontents.toCharArray();
		char[] acontentsarr = actualcontents.toCharArray();
		Assert.assertArrayEquals(econtentsarr, acontentsarr);
		Singleton log2 = Logger.getInstance();

		Assert.assertEquals(log, log2);


		System.out.println("Please wait 8 seconds for the tests to finish");
		System.out.println("The rest of the unit tests run on another thread, so pay attention to failures in the log instead!");
		
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                new JFXPanel(); // Initializes the JavaFx Platform
                Platform.runLater(new Runnable() {
                	UnitTesting ut = new UnitTesting();
                    @Override
                    public void run() {
                        try {
							ut.start(new Stage());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} // Create and
                                                        // initialize
                                                        // your app.

                    }
                });
            }
        });
        thread.start();// Initialize the thread
        

        Thread.sleep(8000);
         // with out this, the thread
         // will be killed before you can tell.

        
        
        
		
		
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		BGSpriteMenu bgSpriteMExplorer = new BGSpriteMenu();
    	double fgx = 0;
    	double fgy= 0;
    	SpriteStore bgStore = new BackgroundSpriteStore();
        for(int i = 0; i < 5; i++) {
        	Sprite sprite = bgStore.orderSprite("FIELDGREEN", fgx, fgy);
        	bgSpriteMExplorer.addSprite(sprite);
        }
        System.out.println(bgSpriteMExplorer.numberOfItems);
        Assert.assertTrue(bgSpriteMExplorer.numberOfItems==5);
        Sprite[] sprites = bgSpriteMExplorer.getSprites();
        Assert.assertTrue(sprites.length==10000);
        for(int i = 0; i < 5; i++) {
        	Sprite s = sprites[i];
        	Assert.assertTrue(s.getName().contains("FGSprite"));
        	Assert.assertTrue(s.getposX()==0);
        	Assert.assertTrue(s.getposY()==0);
        }
		UISpriteMenu uiSpriteMExplorer = new UISpriteMenu();
    	SpriteStore uiStore = new UISpriteStore();
        for(int i = 0; i < 5; i++) {
        	Sprite sprite = uiStore.orderSprite("pointer", fgx, fgy);
        	uiSpriteMExplorer.addSprite(sprite);
        }
        System.out.println(uiSpriteMExplorer.numberOfItems);
        Assert.assertTrue(uiSpriteMExplorer.numberOfItems==5);
        sprites = uiSpriteMExplorer.getSprites();
        Assert.assertTrue(sprites.length==10000);
        for(int i = 0; i < 5; i++) {
        	Sprite s = sprites[i];
        	Assert.assertTrue(s.getName().contains("PntrSprite"));
        	Assert.assertTrue(s.getposX()==0);
        	Assert.assertTrue(s.getposY()==0);
        }
        
		uiSpriteMExplorer = new UISpriteMenu();
    	uiStore = new UISpriteStore();
        for(int i = 0; i < 5; i++) {
        	Sprite sprite = uiStore.orderSprite("moneybag", fgx, fgy);
        	uiSpriteMExplorer.addSprite(sprite);
        }
        System.out.println(uiSpriteMExplorer.numberOfItems);
        Assert.assertTrue(uiSpriteMExplorer.numberOfItems==5);
        sprites = uiSpriteMExplorer.getSprites();
        Assert.assertTrue(sprites.length==10000);
        for(int i = 0; i < 5; i++) {
        	Sprite s = sprites[i];
        	Assert.assertTrue(s.getName().contains("MbagSprite"));
        	Assert.assertTrue(s.getposX()==0);
        	Assert.assertTrue(s.getposY()==0);
        }
        
        System.out.println("Done testing!");
        
	}

}
