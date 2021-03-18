public class main_RSA {

    public static void main(String[] args) {
    	CLI.run();
    	
    	/*
    	// Test key-gen, encrypt and decrypt
    	int c = 0;
		String message = "This is my message.";
		System.out.print("Progress: ");
    	for(int i = 0; i < 100; i++) {
    		KeyPair keys = new KeyPair();
    		keys.generate();
    		String cipher = keys.encrypt(message);
    		if(keys.decrypt(cipher).equals(message))
    			c++;
    		if((i+1)%10 == 0)
    			System.out.print("#");
    	}
    	System.out.println();
    	System.out.println(c + " of 100 generated keys worked." );
    	*/
    }
}
