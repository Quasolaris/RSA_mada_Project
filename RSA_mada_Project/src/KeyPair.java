import java.math.*;
import java.util.*;

public class KeyPair {
	//====================Attributes=================
	SecureKey skey;
	PublicKey pkey;
	private int maxLen = 1024; 
	
	//====================C'tors=====================
	public KeyPair() {
		
	}
	
	//====================Methods====================
	
	public void generate() {
		Random rand = new Random();
		
		// initialise p & q as random Primes
		BigInteger p = BigInteger.probablePrime(maxLen, rand);
		BigInteger q = BigInteger.probablePrime(maxLen, rand);
		
		// p != q
		while(p.equals(q)) {
			q = BigInteger.probablePrime(maxLen, rand);
		}
		
		// calculate n
		BigInteger n = p.multiply(q);
		
		// determine e & d
		BigInteger PHI = p.subtract(BigInteger.ONE).multiply(  q.subtract(BigInteger.ONE));
		BigInteger e = BigInteger.probablePrime(maxLen / 2, rand);
        while (PHI.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(PHI) < 0)
        {
            e.add(BigInteger.ONE);
        }
        BigInteger d = e.modInverse(PHI);
        
        // populate KeyPair
        skey = new SecureKey(n, d);
        pkey = new PublicKey(n, e);
	}
	
	//TODO GRAU: Read Key-Values from sk.txt and pk.txt
	public void readKeypair() {
		
	}	

	public String encrypt(String message) {
		return pkey.encrypt(message);
	}

	public String decrypt(String cipher) {
		return skey.decrypt(cipher);
	}
	//TODO ROTH: merge quickPOW from SecureKey/PrivateKey
	
}