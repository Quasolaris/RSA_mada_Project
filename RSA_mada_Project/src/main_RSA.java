public class main_RSA {

    public static void main(String[] args) {
    	CLI.run();
    	
    	
    	// Test key-gen, encrypt and decrypt
        /*
    	int c = 0, a = 0;
		String message = "This is my message.";
		System.out.print("Testing encryption and decryption | Progress: ");
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
    	System.out.println("==================================================");
    	
    	if (c == 100) {
    	    a++;
    	}
    	c = 0;
    	
    	System.out.print("Testing encryption and decryption with text.txt | Progress: ");
        for(int i = 0; i < 100; i++) {
            KeyPair keys = new KeyPair();
            keys.generate();
            keys.writeKeyPair();
            String encryptText = keys.encrypt(fileService.readFile("text.txt"));
            fileService.writeFile("chiffre.txt", encryptText);
            encryptText = fileService.readFile("chiffre.txt");
            keys.readKeyPair();
            String decryptText = keys.decrypt(encryptText);
            fileService.writeFile("text-d.txt", decryptText);
            if(fileService.readFile("text-d.txt").equals("This is a clear text, lets encrypt it!"))
                c++;
            if((i+1)%10 == 0)
                System.out.print("#");
        }
        
        System.out.println();
        System.out.println(c + " of 100 tests worked." );
        System.out.println("==================================================");
        
        if (c == 100) {
            a++;
        }
        
        System.out.println("2 test finished! " + a + " of them were successful");
        */
    }
}
