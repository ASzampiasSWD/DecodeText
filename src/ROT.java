/*
 * Class deals with ROT caesar rotation.
 * @author Amanda
 */
public class ROT 
{
	public ROT()
	{
	}
	
	/**
	 * ROT13Move takes a char and moves it to the right 13 times.
	 * @param strUserText user text
	 * @return rotation 13 of every char.
	 */
	public String ROT13Move(String strUserText)
	{
	   String strAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   String strShift13Alphabet = "NOPQRSTUVWXYZABCDEFGHIJKLM";
	   String strDecipher = "";
	   boolean bCapitalLetter = false;
	   
	   for (int i = 0; i < strUserText.length(); i++)
	   {
		   Character chTemp = strUserText.charAt(i);
		   String strTemp = chTemp.toString();
		   int dn = 0;
	
		   for (int d = 0; d < strAlphabet.length(); d++)
		   {
			   if (strTemp.equals("!") || strTemp.equals("?") || strTemp.equals(".") ||
				   strTemp.equals(" ") || strTemp.equals("\n"))
				{
				   strDecipher += strTemp;
				   break;
				}
			   
		      if (strTemp.equals(strAlphabet.charAt(d)))
		      {
		    	strDecipher += strShift13Alphabet.charAt(d); 
		    	bCapitalLetter = true;
		    	break;
		      }
			  dn++;
			  
			  if (!bCapitalLetter && strTemp.equalsIgnoreCase(strAlphabet.substring(dn - 1, dn)))
		      {
		    	strDecipher += strShift13Alphabet.substring(dn - 1, dn).toLowerCase(); 
		    	break;
		      }
			  
			  if (d > strAlphabet.length() - 2)
			  {
				strDecipher += strTemp;  
			  }
		   }
	   }
	   return strDecipher;
	}
	
	/**
	 * ROT47Move takes a char and moves it to the right 47 times.
	 * @param strUserText user text
	 * @return rotation 47 of every char.
	 */
	public String ROT47Move(String strUserText)
	{
		String ROTOrignalCharacters = "!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
		String ROTShiftedCharacters = "PQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNO";
		int count = 0;
		String strNew = "";
		
		for (int i = 0; i < strUserText.length(); i++)
		{
			Character chTemp = strUserText.charAt(i);
			
			do
			{
			  count++;
			}
			
			while (!chTemp.equals(' ') && !Character.isWhitespace(chTemp) && !chTemp.equals(ROTOrignalCharacters.charAt(count)));
			
			if (!Character.isWhitespace(chTemp))
			{
			  strNew += ROTShiftedCharacters.charAt(count);
			}
			if (chTemp.equals(' '))
			{
				strNew += " ";
			}
			
			if (chTemp.equals('\n'))
			{
				strNew += "\n";
			}
			
	    	count = 0;
		}
		return strNew; 
	}
}