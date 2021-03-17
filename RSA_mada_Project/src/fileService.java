import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileService implements Key {
    
    //-----------------------Attributes-----------------------
    private static String skFile = "sk.txt";
    private static String pkFile = "pk.txt";
    
    
    //----------------------Constructors----------------------
    //TODO GRAU: (?) Why Object and not Class || Explain pls, i wanna know why
    fileService() {
 
    }
    
    //-------------------------Methods------------------------
    //TODO GRAU: Exception Handler for empty files -> should return empty String
    	
	// read secure key from file
    public static String readSk(String skFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/" + skFile));
        String content = sc.nextLine();
        sc.close();
        return content;
    }
    // default file path for readSk()
    public static String readSk() throws FileNotFoundException {
    	return readSk(skFile);
    }
    
    // read public key from file
    public static String readPk(File pkFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/" + pkFile));
        String content = sc.nextLine();
        sc.close();
        return content;
    }
    // default file path for readPk()
    public static String readPk() throws FileNotFoundException {
    	return readSk(pkFile);
    }
    
    // read from specified file
    //TODO GRAU: do we want to read multiple lines? 
    public static String readFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/" + fileName));
        String content = sc.nextLine();
        sc.close();
        return content; 
    }
    
    // write secure key to standard file
    public static boolean writeSk(String key) throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/" + skFile)));
        bw.write(key);
        bw.close();
        
        return true;
    }
    
    // write public key to standard file
    public static boolean writePk(String key) throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/" + pkFile)));
        bw.write(key);
        bw.close();
        
        return true;
    }
    
    // write custom text to a specified file within the source folder
    public static boolean writeFile(String fileName, String text) throws IOException {
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/" + fileName));
        bw.write(text);
        bw.close();
        
        return true;
    }
}
  

