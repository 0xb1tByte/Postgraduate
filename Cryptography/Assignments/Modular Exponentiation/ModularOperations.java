package modularexponentiation;

import java.math.BigInteger;

/**
 *
 * @author Alaa aka. b1tByte
 */
public class ModularOperations {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Test 
        int baseSmall = 6;
        int exponentSmall = 1;
        int moduloSmall = 11;
        System.out.println("1 - Modular Exponent for small numbers using Math.pow:");
        ModularExponent(baseSmall,exponentSmall,moduloSmall);
        System.out.println("=======================================");

        int baseSmallLoop = 6;
        int exponentSmallLoop = 1;
        int moduloSmallLoop = 11;
        System.out.println("2 - Modular Exponent for small numbers (Loop) using Math.pow:");
        ModularExponentLoop(baseSmall,exponentSmall,moduloSmall);
        System.out.println("=======================================");

        BigInteger baseLarge = new BigInteger("30");
        BigInteger exponentLarge = new BigInteger("13");
        BigInteger moduloLarge = new BigInteger("79");
        System.out.println("3 - Modular Exponent for large numbers using modPow:");
        ModularExponentForBigInteger(baseLarge,exponentLarge,moduloLarge);
        System.out.println("=======================================");

        BigInteger baseLargeLopp = new BigInteger("5");
        BigInteger exponentLargeLopp = new BigInteger("0");
        BigInteger moduloLargeLopp = new BigInteger("23");
        System.out.println("4 - Modular Exponent for large numbers (Loop) using modPow:");
        ModularExponentForBigIntegerLoop(baseLargeLopp, exponentLargeLopp, moduloLargeLopp);
        System.out.println("=======================================");
        
        System.out.println("5 - Modular Multiplicative Inverse for large numbers using modPow:");
        ModularMultiplicativeInverseForBigInteger(baseLargeLopp, moduloLargeLopp);
        System.out.println("=======================================");

        System.out.println("6 - Modular Multiplicative for two large numbers:");
        multiplyModP(baseLargeLopp,exponentLarge, moduloLargeLopp);
        System.out.println("=======================================");

    }

    // Works for large base,exponent, and modulo
    private static BigInteger ModularExponentForBigInteger(BigInteger base, BigInteger exponent, BigInteger modulo) {
        BigInteger result = base.modPow(exponent, modulo);
        System.out.print(base + " ^ " + exponent + " % " + modulo);
        System.out.println(" = " + result);
        return result;
    } // end ModularExponentForBigInteger()

    // Works for large base,exponent, and modulo
    private static BigInteger ModularExponentForBigIntegerLoop(BigInteger base, BigInteger exponent, BigInteger modulo) {
        BigInteger result = BigInteger.ZERO;
        int lessThan = -1;
        // Note : exponent.compareTo(modulo) ==> return -1 when exponent < modulo 
        for (; lessThan == exponent.compareTo(modulo); exponent = exponent.add(BigInteger.ONE)) {
            result = base.modPow(exponent, modulo);
            System.out.print(base + " ^ " + exponent + " % " + modulo);
            System.out.println(" = " + result);
        } // end for
        return result;
    } // end ModularExponentForBigIntegerLoop()

    // This function multyply two BigInteger in mod p 
    private static BigInteger multiplyModP(BigInteger val1, BigInteger val2, BigInteger modulo) {
        BigInteger result = val1.multiply(val2).mod(modulo);
        System.out.print(val1 + " * " + val2 + " % " + modulo);
        System.out.println(" = " + result);
        return result;
    } // end multiplyModP()

    private static BigInteger ModularMultiplicativeInverseForBigInteger(BigInteger base, BigInteger modulo) {
        BigInteger result = base.modInverse(modulo);
        System.out.print(base + " ^ -1 " + " % " + modulo);
        System.out.println(" = " + result);
        return result;
    } // end ModularMultiplicativeInverseForBigInteger()

    // Works only when the number of digits (results from Math.pw < 18)
    private static long ModularExponent(long base, long exponent, long modulo) {
        long result = 0;
        result = (long) Math.pow(base, exponent) % modulo;
        System.out.print(base + " ^ " + exponent + " % " + modulo);
        System.out.println(" = " + result);
        return result;
    } // end ModularExponent()

    // Works only when the number of digits (results from Math.pw < 18)
    private static void ModularExponentLoop(long base, long exponent, long modulo) {
        long result = 0;
        for (; exponent < modulo; exponent++) {
            result = (long) Math.pow(base, exponent) % modulo;
            System.out.print(base + " ^ " + exponent + " % " + modulo);
            System.out.println(" = " + result);
        } // end for  
    } // end ModularExponentLoop() 
}
