import java.util.Iterator;
import java.io.Serializable;

public interface BasicAnimatedImageMenu extends Serializable {
	public Iterator<BasicAnimatedImage> createIterator();
}
