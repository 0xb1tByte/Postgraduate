package modularexponentiation;

import java.math.BigInteger;

/**
 *
 * @author Alaa
 */
public class ModularExponentiation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test 
        int baseSmall = 5;
        int exponentSmall = 2;
        int moduloSmall = 23;
        System.out.println("Modular Exponent for small numbers using Math.pow");
        ModularExponent(baseSmall,exponentSmall,moduloSmall);
        
        BigInteger baseLarge = new BigInteger("30");
        BigInteger exponentLarge = new BigInteger("13");
        BigInteger moduloLarge = new BigInteger("79");
        System.out.println("Modular Exponent for large numbers using modPow");
        ModularExponentForBigInteger(baseLarge,exponentLarge,moduloLarge);
    }

    // Works for large base,exponent, and modulo
    private static BigInteger ModularExponentForBigInteger(BigInteger base, BigInteger exponent, BigInteger modulo) {
        BigInteger result = base.modPow(exponent, modulo);
        System.out.print(base + " ^ " + exponent + " % " + modulo);
        System.out.println(" = " + result);
        return result;
    } // end ModularExponentForBigInteger()

    // Works only when the number of digits (results from Math.pw < 18)
    private static long ModularExponent(long base, long exponent, long modulo) {
        long result = 0;
        result = (long) Math.pow(base, exponent) % modulo;
        System.out.print(base + " ^ " + exponent + " % " + modulo);
        System.out.println(" = " +result);
        return result;
    } // end ModularExponent()

    // Works only when the number of digits (results from Math.pw < 18)
    private static void ModularExponentLoop(long base, long exponent, long modulo) {
        long result = 0;
        long power = 0;

        for (; exponent < modulo; exponent++) {
            power = (long) Math.pow(base, exponent);
            System.out.println(base + " ^ " + exponent + " = " + power);
            result = (long) Math.pow(base, exponent) % modulo;
            System.out.print(base + " ^ " + exponent + " % " + modulo);
            System.out.println(" = " + result);
        } // end for  
    } // end ModularExponentLoop()
}
