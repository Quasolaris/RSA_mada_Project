import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;
import java.util.*;

public class KeyPair {
	//====================Attributes=================
	private SecureKey skey;
	private PublicKey pkey;
	private int maxLen = 8; 
	private static BigInteger one = BigInteger.ONE;
	private static BigInteger zero = BigInteger.ZERO; 
	private static BigInteger x0 = one;
	private static BigInteger y0 = zero;
	
	//====================C'tors=====================
	public KeyPair() {
		
	}
	
	//====================Methods====================
	
	public void generate() {
	    /*
         * This function is based on a code snippet from the following website:
         * https://www.thejavaprogrammer.com/rsa-algorithm-in-java/
         */
		Random rand = new Random();
		
        
		// initialise p & q as random Primes
		BigInteger p = BigInteger.probablePrime(maxLen, rand);
		BigInteger q = BigInteger.probablePrime(maxLen, rand);
		
		// p != q
		while(p.equals(q)) {
			q = BigInteger.probablePrime(maxLen, rand);
		}
		System.err.println("p: " + p + "| q: " + q);
		// calculate n
		BigInteger n = p.multiply(q);

		BigInteger PHI = (p.subtract(one)).multiply((q.subtract(one)));
		BigInteger e = one;
        
		while(PHI.multiply(x0).add(y0.multiply(e)).intValue() != 1) {
			e = BigInteger.probablePrime(maxLen / 2, rand);
	        while (PHI.gcd(e).compareTo(one) > 0 && e.compareTo(PHI) < 0)
	        {
	            e.add(one);
	        }
	        euklid(e, PHI);
		}
		BigInteger d = y0;
        
        //Populate KeyPair
        skey = new SecureKey(n, d);
        pkey = new PublicKey(n, e);
	}
	
	//reads Keypair from existing file if they are not empty
	public void readKeyPair() {
		String skStr = fileService.readSk();
		if(skStr !="") {
			skStr = skStr.substring(1, skStr.length() - 1);
			String[] skArr = skStr.split(",");
			skey = new SecureKey(new BigInteger(skArr[0].trim()), new BigInteger(skArr[1].trim()));
		}
		
		String pkStr = fileService.readPk();
		if(pkStr != "") {
			pkStr = pkStr.substring(1, pkStr.length() - 1);
			String[] pkArr = skStr.split(",");
			pkey = new PublicKey(new BigInteger(pkArr[0].trim()), new BigInteger(pkArr[1].trim()));
		}
	}
	
	//save keys to file
	public void writeKeyPair() {
		fileService.writeSk(skey.toString());
		fileService.writePk(pkey.toString());
	}

	public String encrypt(String message) {
		return pkey.encrypt(message);
	}

	public String decrypt(String cipher) {
		return skey.decrypt(cipher);
	}
	
	//Euklid algorithm
	private void euklid(BigInteger e, BigInteger PHI) {
	    BigInteger a = PHI, b = e, x1 = zero, y1 = one, q2 = zero, r = zero, 
                        tempX0, tempY0, tempX1, tempY1;
	    
	    System.err.println("a: " + a + "| b: " + b);
	    if(a.compareTo(b) <= 0) {
	    	a = e;
	    	b = PHI;
	    }
        
        while(b.intValue() != 0) {
            tempX1 = x1;
            tempY1 = y1;
            tempX0 = x0;
            tempY0 = y0;

            q2 = a.divide(b);
            r = a.mod(b);
            
            a = b;
            b = r;
            
            x0 = x1;
            y0 = y1;
            x1 = tempX0.subtract(q2.multiply(tempX1));
            y1 = tempY0.subtract(q2.multiply(tempY1));
        }
        System.err.println("y0: " + y0 + "| x0: " + x0);
	}
}