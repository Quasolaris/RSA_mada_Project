import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileService implements Key {
    
    //-----------------------Attributes-----------------------
    //Define files for secure and public key
    private static File skFile = new File("src/sk.txt");
    private static File pkFile = new File("src/pk.txt");

    //-------------------------Methods------------------------
    //TODO GRAU: Exception Handler for empty files -> should return empty String
    //TODO GRAU: Make change path method 
    
    //Read secure key from file from sk.txt
    public static String readSk() throws FileNotFoundException {
        Scanner sc = new Scanner(skFile); 
        return sc.nextLine(); 
    }
    
    //Read public key from file pk.txt
    public static String readPk() throws FileNotFoundException {
            Scanner sc = new Scanner(pkFile); 
            return sc.nextLine();  
        }
    
    //Read file with given name
    public static String readFile(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/" + fileName)); 
        return sc.nextLine(); 
    }
    
    //Write secure key into sk.txt
    public static boolean writeSk(String key) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(skFile));
        bw.write(key);
        bw.close();

        return true;
    }
    
    //Write public key into pk.txt
    public static boolean writePk(String key) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(pkFile));
        bw.write(key);
        bw.close();             

        return true;
        }
    
    //Write string into given file
    public static boolean writeFile(String fileName, String text) throws IOException {            
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/" + fileName));
        bw.write(text);
        bw.close();          

        return true;
    }
        
       
   }
  

