import java.math.*;

public class PublicKey implements Key{
	//====================Attributes=================
	BigInteger n;
	BigInteger e;
	
	//====================C'tors=====================
	public PublicKey(BigInteger n, BigInteger e) {
		this.n = n;
		this.e = e;
	}
	
	//====================Methods====================
	@Override
	public String toString() {
		return "(" + n.toString() + ", " + e.toString() + ")";
	}
	
	public String encrypt(String message) {
		char[] chars = message.toCharArray();
		String cipher = "";
		
		for(char c : chars) {
			BigInteger cint = BigInteger.valueOf((int)c);
			cipher += quickPow(cint).toString() + ",";
		}
		
		return cipher;
	}
	
	private BigInteger quickPow(BigInteger k) {
		BigInteger h = BigInteger.ONE;
		char[] chars = e.toString(2).toCharArray();
    	
    	for(int i = e.bitLength() - 1; i >= 0; i--){
    		if(chars[i] == '1') {
    			h = h.multiply(k).mod(n);
    		}
    		k = k.multiply(k).mod(n);
    	}
    	return h;
	}
}