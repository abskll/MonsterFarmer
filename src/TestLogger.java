import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestLogger {

	@Test
	void test() {
//		assertThat(getStringFromInputStream(
//	    	      new FileInputStream(fileName)))
//	    	      .isEqualTo("UK\r\n" + "US\r\n" + "Germany\r\n" + "Spain\r\n");
		
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
		
	}

}
