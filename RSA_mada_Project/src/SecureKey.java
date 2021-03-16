import java.math.*;

public class SecureKey implements Key{
	//====================Attributes=================
	BigInteger n;
	BigInteger d;
	
	//====================C'tors=====================
	public SecureKey(BigInteger n, BigInteger d) {
		this.n = n;
		this.d = d;
	}
	
	//====================Methods====================
	@Override
	public String toString() {
		return "(" + n.toString() + ", " + d.toString() + ")";
	}
	
	// decrypt cipher and returns message
	public String decrypt(String cipher) {
		
		//delimit String of Numbers by commas to get individual Letters
		String[] letters = cipher.split(",");
		
		String message = "";
		for(String letter : letters) {
			message += (char)quickPow(new BigInteger(letter)).intValue();
		}
		
		return message;
	}
	
	//implementation of optimized calculation of large Powers (from lecture notes)
	private BigInteger quickPow(BigInteger k) {
		BigInteger h = BigInteger.ONE;
		char[] chars = d.toString(2).toCharArray();
    	
    	for(int i = d.bitLength() - 1; i >= 0; i--){
    		if(chars[i] == '1') {
    			h = h.multiply(k).mod(n);
    		}
    		k = k.multiply(k).mod(n);
    	}
    	return h;
	}
}