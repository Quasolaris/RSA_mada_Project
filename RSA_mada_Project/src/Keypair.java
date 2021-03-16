import java.math.*;
import java.util.*;

public class Keypair {
	//====================Attributes=================
	
	
	//====================C'tors=====================
	public Keypair() {
		
	}
	
	//====================Methods====================
	private static BigInteger randNum() {
		
		BigInteger min = new BigInteger("5_000_000_000_000");
		BigInteger max = new BigInteger("25_000_000_000");
		BigInteger bigInteger = max.subtract(min);
		
		Random rand = new Random();
		int len = max.bitLength();
		BigInteger res = new BigInteger(len, rand);
		
		if (res.compareTo(min) < 0) {
			res = res.add(min);
		}
		
		if (res.compareTo(bigInteger) >= 0) {
			res = res.mod(bigInteger).add(min);
		}
		
		return res;
	}
	
	
}