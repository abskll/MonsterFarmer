import java.io.Serializable;
import java.util.Iterator;
public interface SpriteMenu extends Serializable {
	public Iterator<Sprite> createIterator();
}
