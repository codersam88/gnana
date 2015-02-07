
package gnanqa;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Maze {
    
    BufferedReader br;
    public static void main(String[] args) {
        
    }
    
    void begin()
    {
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Maze.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
