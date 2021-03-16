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
	public String toString() {
		return "(" + n.toString() + ", " + e.toString() + ")";
	}
	
}