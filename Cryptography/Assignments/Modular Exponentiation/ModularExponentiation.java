
package testfortest;

/**
 *
 * @author Alaa
 */
public class ModularExponentiation {
    public static void main(String[] args) {
        int base = 5;
        int exponent = 0;
        int modulo = 23;
        long result;
        for (;exponent < modulo ; exponent++)
        {
         result = (long) Math.pow(base, exponent) % modulo; 
         System.out.print(base + " ^ " + exponent + " % " + modulo);
         System.out.println(" = " + result);
        } // end for  
    } // end main
} // end class
