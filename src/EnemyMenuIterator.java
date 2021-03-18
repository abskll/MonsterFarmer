import java.io.Serializable;
import java.util.Iterator;

public class EnemyMenuIterator implements Iterator<BasicAnimatedImage>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -309496007599887782L;
	transient BasicAnimatedImage[] list;
	int position = 0;

	public EnemyMenuIterator(BasicAnimatedImage[] list) {
		this.list = list;
	}
	
	public BasicAnimatedImage next() {
		BasicAnimatedImage sprite = list[position];
		position++;
		return sprite;
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if (position >= list.length || list[position] == null) {
			return false;
		} else {
			return true;
		}
	}

	public void remove() {
		if (position <= 0) {
			throw new IllegalStateException
				("You can't remove an item until you've done at least one next()");
		}
		if (list[position-1] != null) {
			for (int i = position-1; i < (list.length-1); i++) {
				list[i] = list[i+1];
			}
			list[list.length-1] = null;
		}
	}

}
