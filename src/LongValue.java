import java.io.Serializable;

public class LongValue implements Serializable 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3338595284214487987L;
	public long value;
    
    public LongValue(long i)
    {
        value = i;
    }
}