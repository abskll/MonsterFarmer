import java.util.Iterator;

public class UISpriteMenu implements SpriteMenu {
	static final int MAX_ITEMS = 10000;
	int numberOfItems = 0;
	Sprite[] sprites;
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
			sprites[numberOfItems] = sprite;
			numberOfItems++;
		}
	}
	public Sprite[] getSprites() {
		return sprites;
	}

}
