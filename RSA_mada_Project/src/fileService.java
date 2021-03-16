import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileService implements Key {
    
    //-----------------------Attributes-----------------------
    private File skFile = new File("src/sk.txt");
    private File pkFile = new File("src/pk.txt");
    
    
    //----------------------Constructors----------------------
    fileService() {
 
    }
    
    //-------------------------Methods------------------------
    
        public String readSk() throws FileNotFoundException {
            
            
            Scanner sc = new Scanner(skFile); 
          
            return sc.nextLine(); 
        }
        
        public String readPk() throws FileNotFoundException {
                
               
                Scanner sc = new Scanner(pkFile); 
              
                return sc.nextLine();  
            }
        
        public String readFile(String fileName) throws FileNotFoundException {
            
            
            Scanner sc = new Scanner(new File(fileName)); 
          
            return sc.nextLine(); 
        }

        public boolean writeSk(String key) throws IOException {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(skFile));
            bw.write(key);
            bw.close();
            
            return true;
        }
        
        public boolean writePk(String key) throws IOException {
                
                BufferedWriter bw = new BufferedWriter(new FileWriter(pkFile));
                bw.write(key);
                bw.close();
                

                return true;
            }
        
        public boolean writeFile(String fileName, String text) throws IOException {
            
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write(text);
            bw.close();
            

            return true;
        }
        
        public int[] getKeyValues(String fileName) {
            
            int[] values = new int[2];
            String key = readFile(fileName);
            
        }
   }
  

