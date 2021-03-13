import java.io.Serializable;
import java.util.Iterator;

public class UISpriteMenu implements SpriteMenu, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8979092259322538037L;
	static final int MAX_ITEMS = 10000;
	int numberOfItems = 0;
	int position = 0;
	transient Sprite[] sprites;
	public UISpriteMenu() {
		sprites = new Sprite[MAX_ITEMS];
	}
	@Override
	public Iterator<Sprite> createIterator() {
		// TODO Auto-generated method stub
		return new UISpriteMenuIterator(sprites);
	}
	public void addSprite(Sprite sprite) {
		// TODO Auto-generated method stub
		if(numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, SpriteMenu is full!");
		} else {
			System.out.println("numberofitems:" + numberOfItems);
			System.out.println(sprites==null);
			sprites[numberOfItems] = sprite;
			numberOfItems++;
		}
		System.out.println("numberOfItems:" + numberOfItems);
		System.out.println(sprite.name);
	}
	public Sprite[] getSprites() {
		return sprites;
	}
	public Sprite next() {
		Sprite sprite = sprites[position];
		position = position + 1;
		return sprite;
	}
 
	public boolean hasNext() {
		if (position >= sprites.length || sprites[position] == null) {
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
		if (sprites[position-1] != null) {
			for (int i = position-1; i < (sprites.length-1); i++) {
				sprites[i] = sprites[i+1];
			}
			sprites[sprites.length-1] = null;
			numberOfItems--;
		}
		position = 0;
		System.out.println("number of items:" + numberOfItems);
		System.out.println("spritelength:" + sprites.length);
		
//		for(Sprite s: sprites) {
//			//System.out.println(s.name);
//			
//		}
	}
}
