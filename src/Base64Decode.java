import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Base64Decode is a class which takes a user's text
 * and decodes the Base64 to UTF-8.
 * @author Amanda
 */
public class Base64Decode 
{
	private String strUserInput;
	
	/**
	 * The constructor asks for text first
	 * in order to decode it. 
	 * @param strUserInput text to decode.
	 */
	public Base64Decode(String strUserInput)
	{
		this.strUserInput = strUserInput;
	}
	
	/**
	 * Decode Base64 to UTF-8. 
	 * @return strDecoded decoded text.
	 */
	public String DecodeText()
	{
		byte[] byDecode = Base64.getDecoder().decode(strUserInput);
		String strDecoded = "";
		
		try 
		{
		  strDecoded = new String(byDecode, "UTF-8");
		}
		catch (UnsupportedEncodingException e) 
		{
		  e.printStackTrace();
		}
		return strDecoded;
	}
}