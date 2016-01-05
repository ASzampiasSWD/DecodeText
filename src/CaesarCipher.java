import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * CaesarCipher covers the shift of seven commonly used English
 * letters or every English letter. Deciphers user input.
 * @author Amanda
 */
public class CaesarCipher 
{
   public CaesarCipher()
   {
   }
   
   /**
    * Finds the most used letter.
    * @param cipher cipher input.
    * @return popular letter.
    */
   public String Most(String cipher)
   {
	   LinkedList<String> List = new LinkedList<String>();
	   int count = 0;
	  
	   for (int i = 0; i < cipher.length(); i++)
	   {
	     List.insertInOrder(cipher.substring(i, i + 1));
	     count++;
	   }
	   
	   String current = "";
	   int intCounter = 1;
	   int intMax = 0;
	   String strHighestLetter[] = new String[25];
	   int strTrackArray = 1;
	   for (int i = 0; i < count; i++)
	   {
		   String start = List.front.getNext().info;
		   List.remove(List.front.getNext().info);
		   String end = List.front.getNext().info;
	    
		   
	    if (start.equals(end) && !start.equals(" "))
	     {
		    intCounter++;
		    current = start;
		
	     }
	    else
	    {  
	       if (intCounter > intMax)
	       {
	    	strHighestLetter[0] = current;
	    	intMax = intCounter;
	    	intCounter = 1;
	       }
	    
	      if (intCounter >= intMax)
	      {
	    	  strHighestLetter[strTrackArray] = current;
	    	  strTrackArray++;
	      }
	    	intCounter = 1;
	    }
	  }
	   //System.out.println("The biggest letter is: " + strHighestLetter[0] + " with " + intMax + " hits");
	   return strHighestLetter[0];
   }
    public String findCipher(String cipher, String maxLetter, boolean bReturnAll)
    {
    	/** Ordered from most common to 
    	 * least common.
    	 */
    	/*** TOP 7 USED ***/
    	String maxToA = "";
    	String maxToE = "";
    	String maxToT = "";
    	String maxToO = "";
    	String maxToI = "";
    	String maxToN = "";
    	String maxToH = "";
    	/*** TOP 7 USED ***/
    	/*** Show all alphabet ***/
    	String maxToS = "";
    	String maxToR = "";
    	String maxToD = "";
    	String maxToL = "";
    	String maxToC = "";
    	String maxToU = "";
    	String maxToM = "";
    	String maxToW = "";
    	String maxToF = "";
    	String maxToG = "";
    	String maxToY = "";
    	String maxToP = "";
    	String maxToB = "";
    	String maxToV = "";
    	String maxToK = "";
    	String maxToJ = "";
    	String maxToX = "";
    	String maxToQ = "";
    	String maxToZ = "";
    	/*** Show all alphabet ***/
    	
    	int counter = 0;
    	int indexInitial = -1; // 0 is a pos
    	boolean bKeepGoing = true;
    	String[] arAlphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
    			               "i", "j", "k", "l", "m", "n", "o", "p",
    			               "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
       
    	for (int i = 0; i <= 25; i++)
    	{
    		indexInitial++;
    		if (arAlphabet[i].equalsIgnoreCase(maxLetter))
    		{
    			i = 30;
    		}
    	}
    	
    	for (int i = indexInitial; i != 0; i++)
    	{
    		counter++;
    		
    		if (i >= 25)
    		{
    			i = -1;
    		}
        }
    	    	
    	for (int i = 0; i < cipher.length(); i++)
    	{
    		//System.out.println("CIPHER LENGTH IS: " + cipher.length());
    		String current = cipher.substring(i, i + 1);
    		
    		if (current.equals(" ") || current.equals("\n"))
    		{
    			maxToA += current;
    			maxToE += current;
    			maxToT += current;
    			maxToO += current;
    			maxToI += current;
    			maxToN += current;
    			maxToH += current;
    			maxToS += current;
    			maxToR += current;
    			maxToD += current;
    			maxToL += current;
    			maxToC += current;
    			maxToU += current;
    			maxToM += current;
    			maxToW += current;
    			maxToF += current;
    			maxToG += current;
    			maxToY += current;
    			maxToP += current;
    			maxToB += current;
    			maxToV += current;
    			maxToK += current;
    			maxToJ += current;
    			maxToX += current;
    			maxToQ += current;
    			maxToZ += current;
    		}
    		
    		if (!current.equals(" "))
    		{
    		for (int d = 0; d <= 25; d++)
    		{
    			bKeepGoing = true;
    			
    			if (current.equals(arAlphabet[d]))
    			{
    			   maxToA += arAlphabet[(d + counter) % 26];
    			                                // E is 4 away from A.
    			                                // Save us from writing many loops.
    			   maxToE += arAlphabet[(d + (counter + 4)) % 26];
    			   maxToT += arAlphabet[(d + (counter + 19)) % 26];
    			   maxToO += arAlphabet[(d + (counter + 14)) % 26];
    			   maxToI += arAlphabet[(d + (counter + 8)) % 26];
    			   maxToN += arAlphabet[(d + (counter + 13)) % 26];
    			   maxToH += arAlphabet[(d + (counter + 7)) % 26];
    			   maxToS += arAlphabet[(d + (counter + 18)) % 26];
    			   maxToR += arAlphabet[(d + (counter + 17)) % 26];
    			   maxToD += arAlphabet[(d + (counter + 3)) % 26];
    			   maxToL += arAlphabet[(d + (counter + 11)) % 26];
    			   maxToC += arAlphabet[(d + (counter + 2)) % 26];
    			   maxToU += arAlphabet[(d + (counter + 20)) % 26];
    			   maxToM += arAlphabet[(d + (counter + 12)) % 26];
    			   maxToW += arAlphabet[(d + (counter + 22)) % 26];
    			   maxToF += arAlphabet[(d + (counter + 5)) % 26];
    			   maxToG += arAlphabet[(d + (counter + 6)) % 26];
    			   maxToY += arAlphabet[(d + (counter + 24)) % 26];
    			   maxToP += arAlphabet[(d + (counter + 15)) % 26];
    			   maxToB += arAlphabet[(d + (counter + 1)) % 26];
    			   maxToV += arAlphabet[(d + (counter + 21)) % 26];
    			   maxToK += arAlphabet[(d + (counter + 10)) % 26];
    			   maxToJ += arAlphabet[(d + (counter + 9)) % 26];
    			   maxToX += arAlphabet[(d + (counter + 23)) % 26];
    			   maxToQ += arAlphabet[(d + (counter + 16)) % 26];
    			   maxToZ += arAlphabet[(d + (counter + 25)) % 26];
    			   d = 25;
    			   bKeepGoing = false;
    			}	
    			
    			if (bKeepGoing == true && current.equalsIgnoreCase(arAlphabet[d]))
    			{
    				maxToA += arAlphabet[(d + counter) % 26].toUpperCase();
                    maxToE += arAlphabet[(d + (counter + 4)) % 26].toUpperCase();
                    maxToT += arAlphabet[(d + (counter + 19)) % 26].toUpperCase();
                    maxToO += arAlphabet[(d + (counter + 14)) % 26].toUpperCase();
                    maxToI += arAlphabet[(d + (counter + 8)) % 26].toUpperCase();
                    maxToN += arAlphabet[(d + (counter + 13)) % 26].toUpperCase();
                    maxToH += arAlphabet[(d + (counter + 7)) % 26].toUpperCase();
                    maxToS += arAlphabet[(d + (counter + 18)) % 26].toUpperCase();
                    maxToR += arAlphabet[(d + (counter + 17)) % 26].toUpperCase();
                    maxToD += arAlphabet[(d + (counter + 3)) % 26].toUpperCase();
                    maxToL += arAlphabet[(d + (counter + 11)) % 26].toUpperCase();
                    maxToC += arAlphabet[(d + (counter + 2)) % 26].toUpperCase();
                    maxToU += arAlphabet[(d + (counter + 20)) % 26].toUpperCase();
                    maxToM += arAlphabet[(d + (counter + 12)) % 26].toUpperCase();
                    maxToW += arAlphabet[(d + (counter + 22)) % 26].toUpperCase();
                    maxToF += arAlphabet[(d + (counter + 5)) % 26].toUpperCase();
                    maxToG += arAlphabet[(d + (counter + 6)) % 26].toUpperCase();
                    maxToY += arAlphabet[(d + (counter + 24)) % 26].toUpperCase();
                    maxToP += arAlphabet[(d + (counter + 15)) % 26].toUpperCase();
                    maxToB += arAlphabet[(d + (counter + 1)) % 26].toUpperCase();
                    maxToV += arAlphabet[(d + (counter + 21)) % 26].toUpperCase();
                    maxToK += arAlphabet[(d + (counter + 10)) % 26].toUpperCase();
                    maxToJ += arAlphabet[(d + (counter + 9)) % 26].toUpperCase();
                    maxToX += arAlphabet[(d + (counter + 23)) % 26].toUpperCase();
                    maxToQ += arAlphabet[(d + (counter + 16)) % 26].toUpperCase();
                    maxToZ += arAlphabet[(d + (counter + 25)) % 26].toUpperCase();
                    d = 25;
    			}
    		  }
    		}
       }
        // Return every option. This will be useful in case competitions
    	// try to throw us off with an uncommon option.
    	if (bReturnAll)
    	{
    		try {
    			PrintWriter pwOut = new PrintWriter(new File("CaesarCipherResults.txt"));
    			pwOut.println(maxToA + System.getProperty("line.separator") +
    			              maxToE + System.getProperty("line.separator") +
    			              maxToT + System.getProperty("line.separator") +
    			              maxToO + System.getProperty("line.separator") +
    			              maxToI + System.getProperty("line.separator") +
    			              maxToN + System.getProperty("line.separator") +
    			              maxToH + System.getProperty("line.separator") +
    			              maxToS + System.getProperty("line.separator") +
    			              maxToR + System.getProperty("line.separator") +
    			              maxToD + System.getProperty("line.separator") +
    			              maxToL + System.getProperty("line.separator") +
    			              maxToC + System.getProperty("line.separator") +
    			              maxToU + System.getProperty("line.separator") +
    			              maxToM + System.getProperty("line.separator") +
    			              maxToW + System.getProperty("line.separator") +
    			              maxToF + System.getProperty("line.separator") +
    			              maxToG + System.getProperty("line.separator") +
    			              maxToY + System.getProperty("line.separator") +
    			              maxToP + System.getProperty("line.separator") +
    			              maxToB + System.getProperty("line.separator") +
    			              maxToV + System.getProperty("line.separator") +
    			              maxToK + System.getProperty("line.separator") +
    			              maxToJ + System.getProperty("line.separator") +
    			              maxToX + System.getProperty("line.separator") +
    			              maxToQ + System.getProperty("line.separator") +
    			              maxToZ + System.getProperty("line.separator"));
    			pwOut.close();
    		} 
    		catch (FileNotFoundException e) 
    		{
    			e.printStackTrace();
    		}
    		
    	 return maxToA + "\n" + maxToE + "\n" + maxToT + "\n" +
    	    	maxToO + "\n" + maxToI + "\n" + maxToN + "\n" +
    	    	maxToH + "\n" + maxToS + "\n" + maxToR + "\n" +
    	    	maxToD + "\n" + maxToL + "\n" + maxToC + "\n" +
    	    	maxToU + "\n" + maxToM + "\n" + maxToW + "\n" +
    	    	maxToF + "\n" + maxToG + "\n" + maxToY + "\n" +
    	    	maxToP + "\n" + maxToB + "\n" + maxToV + "\n" +
    	    	maxToK + "\n" + maxToJ + "\n" + maxToX + "\n" +
    	    	maxToQ + "\n" + maxToZ;
    	}
    	
    	// Return top 7 matches. These are the most used in English
    	// language.
    	return maxToA + "\n" + maxToE + "\n" + maxToT + "\n" +
    	       maxToO + "\n" + maxToI + "\n" + maxToN + "\n" +
    	       maxToH;
    }
}