import java.io.Serializable;

public class IntValue implements Serializable 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3822351166528743028L;
	public int value;
    
    public IntValue(int i)
    {
        value = i;
    }
}