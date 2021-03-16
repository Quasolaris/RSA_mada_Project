import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.*;
import java.util.*;

public class KeyPair {
	//====================Attributes=================
	private SecureKey skey;
	private PublicKey pkey;
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
	
	//TODO GRAU: change readSk & readPk to static (?)
	public void readKeypair() throws IOException {
		String skStr = fileService.readSk();
		skStr = skStr.substring(1, skStr.length() - 1);
		String[] skArr = skStr.split(",");
		skey = new SecureKey(new BigInteger(skArr[0]), new BigInteger(skArr[1]));
		
		String pkStr = fileService.readPk();
		pkStr = pkStr.substring(1, skStr.length() - 1);
		String[] pkArr = skStr.split(",");
		pkey = new PublicKey(new BigInteger(pkArr[0]), new BigInteger(pkArr[1]));
	}	

	public String encrypt(String message) {
		return pkey.encrypt(message);
	}

	public String decrypt(String cipher) {
		return skey.decrypt(cipher);
	}
	//TODO ROTH: merge quickPOW from SecureKey/PrivateKey
	
}