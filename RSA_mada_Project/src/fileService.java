import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileService implements Key {
    
    //-----------------------Attributes-----------------------
    private static File skFile = new File("src/sk.txt");
    private static File pkFile = new File("src/pk.txt");
    
    
    //----------------------Constructors----------------------
    fileService() {
 
    }
    
    //-------------------------Methods------------------------
    
        public static String readSk() throws FileNotFoundException {
            
            
            Scanner sc = new Scanner(skFile); 
          
            return sc.nextLine(); 
        }
        
        public static String readPk() throws FileNotFoundException {
                
               
                Scanner sc = new Scanner(pkFile); 
              
                return sc.nextLine();  
            }
        
        public static String readFile(String fileName) throws FileNotFoundException {
            
            
            Scanner sc = new Scanner(new File("src/" + fileName)); 
          
            return sc.nextLine(); 
        }

        public static boolean writeSk(String key) throws IOException {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(skFile));
            bw.write(key);
            bw.close();
            
            return true;
        }
        
        public static boolean writePk(String key) throws IOException {
                
                BufferedWriter bw = new BufferedWriter(new FileWriter(pkFile));
                bw.write(key);
                bw.close();
                

                return true;
            }
        
        public static boolean writeFile(String fileName, String text) throws IOException {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/" + fileName));
            bw.write(text);
            bw.close();
            

            return true;
        }
        
       
   }
  

