import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class UnitTesting {

	@Test
	void test() {

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
		//testing whether object is equal in singleton
		Assert.assertEquals(log, log2);
		
		
		UISpriteMenu testuispritemenu = new UISpriteMenu();
		
		
		
	}

}
