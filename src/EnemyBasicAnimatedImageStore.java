import java.io.Serializable;

public class EnemyBasicAnimatedImageStore extends BasicAnimatedImageStore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6013642019513774250L;

	@Override
	BasicAnimatedImage createBasicAnimatedImage(String item) {
		// TODO Auto-generated method stub
		if(item.equals("bat")) {
			return new BatAnimatedImage();
		} else {
			return null;			
		}

	}

}
