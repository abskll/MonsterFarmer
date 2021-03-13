import java.io.Serializable;
import java.util.Iterator;

public class UISpriteMenuIterator implements Iterator<Sprite>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1233613081644934695L;
	transient Sprite[] list;
	int position = 0;
	
	public UISpriteMenuIterator(Sprite[] list) {
		this.list = list;
	}
	
	public Sprite next() {
		Sprite sprite = list[position];
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
