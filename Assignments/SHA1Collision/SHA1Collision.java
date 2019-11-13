/*
The Qs is : 
  Let MY60SHA be a hash function which outputs the first 60 bits (15 nibbles) of SHA-1. 
  For example, SHA-1 of “mark” is
  f1b5a91d4d6ad523f2610114591c007e75d15084
  so MY60SHA of “mark” is f1b5a91d4d6ad52. 
  Find any collision for MY60SHA.
*/

package hashcollision;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Alaa 
 */
public class SHA1Collision 
{
    // main() Variables :
    static long plainText = 1;
    static List<String> hashes = new LinkedList<String>();
    static long iterationNum;
    static boolean condition = false;
    static int counter1;
    static int counter2;
    static String hash1;
    static String hash2;

    // calcSHA1() Variables :
    static MessageDigest digest;
    static byte[] digestBytes;
    static String SHAHex;


    // MY60SHA() Variables :
    static String result;
    static int nibblesNumber;

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        
        iterationNum = 1000;
        hashes = new LinkedList<String>();
        hash1 = "";
        hash2 = "";
        
        // Initial Hashing 
        hash1 = MY60SHA(calcSHA1(Long.toString(plainText)), 15);
        hashes.add(0, hash1);
       
       
        // This FOR will create a list with the size of iterationNum (and search for the collision within this list), 
        // if no collision found in this list, then the program will stop storing hashes in the list, and go to WHILE
        for (counter1 = 1; counter1 < iterationNum; counter1++) 
        {
            hash2 = MY60SHA(calcSHA1(Long.toString(++plainText)), 15);        
            if (hashes.get(counter1 - 1).equals(hash2)) 
            {
                System.out.println("There is a collision between Message1: " + (plainText - 1) + " and Message2: " + (plainText));
                System.out.println("H( " + (plainText - 1) + " ) = " + hashes.get(counter1 - 1) + " and H( " + (plainText) + " ) = " + hash2);
                condition = true;
                break;
            } // end if 
            else 
            { // Adding the hashes until the collision is found, or the size of the list is exceeded 
                hashes.add(counter1, hash2);
            } // end else 
        } // end for 
        
        
        // This WHILE generates hashes and comparing them with the elements (hashes) in the previous list.  
        while(!condition) 
        { 
                hash2 = MY60SHA(calcSHA1(Long.toString(++plainText)), 15);
                // Searching in the list
                for (counter2 = 0; counter2 < hashes.size(); counter2++) 
                {
                    if (hashes.get(counter2).equals(hash2)) 
                    {        
                        System.out.println("There is a collision between Message1: " + (counter2 + 1) + " and Message2: " + (plainText));
                        System.out.println("H( " + (counter2 + 1) + " ) = " + hashes.get(counter2) + " and H( " + (plainText) + " ) = " + hash2);
                        condition = true;
                        break;
                    } // end if 
                } // end for
        } // end while
    } // end main()

    // This method calculate the SHA1
    public static String calcSHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        digest = MessageDigest.getInstance("SHA-1");
        digest.update(text.getBytes("UTF-8"));
        digestBytes = digest.digest();
        SHAHex = javax.xml.bind.DatatypeConverter.printHexBinary(digestBytes);
        return SHAHex;
    } // end calcSHA1()

    // This method return the first 60 bits of SHA1 result
    public static String MY60SHA(String SHAHex, int nibbles) {
        nibblesNumber = nibbles;
        result = SHAHex.substring(0, nibblesNumber);
        return result;
    } // end MY60SHA()

} // end Class
