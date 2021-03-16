import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class fileService {
    
    private File skFile = new File("src/sk.txt");
    private File pkFile = new File("src/pk.txt");
    
    fileService() {
 
    }
    
        public String readSk() throws FileNotFoundException {
            
            
            Scanner sc = new Scanner(skFile); 
          
            return sc.nextLine(); 
        }
        
        public String readPk() throws FileNotFoundException {
                
               
                Scanner sc = new Scanner(pkFile); 
              
                return sc.nextLine();  
            }
        
        public boolean writeSk(String key) throws IOException {
            
            FileWriter fr = new FileWriter(skFile);
            BufferedWriter bw = new BufferedWriter(fr);
            bw.write(key);
            bw.close();
            
            return true;
        }
        
         public boolean writePk(String key) throws IOException {
                
                FileWriter fr = new FileWriter(pkFile);
                BufferedWriter bw = new BufferedWriter(fr);
                bw.write(key);
                bw.close();
                

                return true;
            }
   }
  

