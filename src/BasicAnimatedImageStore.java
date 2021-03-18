import java.io.Serializable;

public abstract class BasicAnimatedImageStore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1331502895097866514L;


	abstract BasicAnimatedImage createBasicAnimatedImage(String item);
	
	public BasicAnimatedImage orderBasicAnimatedImage(String type, double x, double y) {
		BasicAnimatedImage BAI = createBasicAnimatedImage(type);
		BAI.setPosition(x, y);
		System.out.println("--- Making a " + BAI.getName() + " ---");
		return BAI;
	}
}
