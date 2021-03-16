import java.math.*;

public class SecureKey implements Key{
	//====================Attributes=================
	BigInteger n;
	BigInteger d;
	
	//====================C'tors=====================
	public SecureKey(BigInteger n, BigInteger d) {
		
	}
	
	//====================Methods====================
	public String toString() {
		return "(" + n.toString() + ", " + d.toString() + ")";
	}
	
}