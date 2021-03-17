import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class fileService implements Key {
    
    //-----------------------Attributes-----------------------
    private static String skFile = "sk.txt";
    private static String pkFile = "pk.txt";

    //-------------------------Methods------------------------
    	
	// read secure key from file
    public static String readSk(String skFile) {
        return readFile(skFile);
        
    }
    // default file path for readSk()
    public static String readSk() {
    	return readSk(skFile);
    }
    
    // read public key from file
    public static String readPk(String pkFile) {
        return readFile(pkFile);
    }
    // default file path for readPk()
    public static String readPk() {
    	return readSk(pkFile);
    }
    
    // read from specified file
    public static String readFile(String fileName) {
        String content;
        try {
            Scanner sc;
            sc = new Scanner(new File("src/" + fileName));
            content = sc.nextLine();
            sc.close();
        } catch (FileNotFoundException e) {
            content = "";
            System.out.println("File not found, saving error");
            e.printStackTrace();
        }
        if (content.isEmpty()) {
            return "";
        }
        else {
            return content;
        } 
    }
    
    // write secure key to standard file
    public static boolean writeSk(String key) {
        writeFile(skFile, key);
        return true;
    }
    
    // write public key to standard file
    public static boolean writePk(String key) {
        writeFile(pkFile, key);
        return true;
    }
    
    // write custom text to a specified file within the source folder
    public static boolean writeFile(String fileName, String text) {
        try {
            //Bodge vom fiinste... bw überschribt zeiche, 
            //sprich wenn neue key chürzer isch stimmt z format nümme
            PrintWriter writer = new PrintWriter("src/" + fileName);
            writer.print(text);
            writer.close();

        } catch (IOException e) {
            System.out.println("File not found, writing error");
            e.printStackTrace();
        }
        return true;
    }
}
  

