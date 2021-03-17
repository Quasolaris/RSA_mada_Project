
public class CLI {
    
    public static void run() {
        
        //init
        KeyPair keys = new KeyPair();
        String encryptText, decryptText;
        
        //Test with chiffre and sk from AD files
        printLine();
        System.out.println("Chiffre encrypt test");
        System.out.println("Opening test_chiffre.txt file");
        
        //Reading file
        encryptText = fileService.readFile("test_chiffre.txt");
        System.out.println("Content of test_chiffre.txt saved in temp string");
        printNewLine();
        
        System.out.println("Decrypting test_chiffre.txt...");
        fileService.writeSk(fileService.readFile("test_sk.txt"));
        //Read keys and decrypt
        keys.readKeyPair();
        decryptText = keys.decrypt(encryptText);
        System.out.println("test_chiffre.txt decrypted!");
        printNewLine();
        System.out.println("Text of file: " + decryptText);
        printNewLine();
        System.out.println("Test done, starting tasks...");
        printLine();
        
        
        //Task 1
        printLine();
        System.out.println("Task 1:");
        System.out.println("Generate secure and public key");
        printLine();
        printNewLine();
        
        //generating keys
        System.out.println("Generates keys...");
        keys.generate();
        System.out.println("Keys generated!");
        
        //Saving keys to sk.txt and pk.txt
        printNewLine();
        System.out.println("Saving keys into file: src/sk.txt and src/pk.txt");
        keys.writeKeyPair();
        System.out.println("Keys saved!");
        printNewLine();
        
        System.out.println("Task 1 finished!");
        printLine();
        printNewLine();
        
        //Task 2
        System.out.println("Task 2:");
        System.out.println("Encrypting text.txt with public key from task 1");
        printLine();
        printNewLine();
        
        //Encrypting text.txt
        System.out.println("Encrypting content of text.txt...");
        encryptText = keys.encrypt(fileService.readFile("text.txt"));
        System.out.println("Text encrypted!");
        printNewLine();
        
        //Saving encrypted text into file chiffre.txt
        System.out.println("Saving encrypted content into file text-d.txt");
        fileService.writeFile("text-d.txt", encryptText);
        System.out.println("Content saved!");
        printNewLine();
        
        System.out.println("Task 2 finished!");
        printLine();
        
        //Task 3
        printLine();
        System.out.println("Task 3");
        System.out.println("Decrypting text-d.txt");
        
        //Readig file
        encryptText = fileService.readFile("text-d.txt");
        System.out.println("Content of text-d.txt saved in temp string!");
        printNewLine();
        
        System.out.println("Decrypting text-d.txt...");
        fileService.writeSk(fileService.readFile("sk.txt"));
        
        //Reading keys and decrypting file
        keys.readKeyPair();
        decryptText = keys.decrypt(encryptText);
        System.out.println("text-d.txt decrypted!");
        printNewLine();
        System.out.println("Text of file: " + decryptText);
        printNewLine();
        System.out.println("Tasks completed.");
        printLine();
        
        
    }
    
    
    //Prints line in console
    private static void printLine() {
        System.out.println("--------------------------------------");
    }
    
    //Prints a new line in console
    private static void printNewLine() {
        System.out.println();
    }
}
