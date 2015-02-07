/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnanqa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admn
 */
public class Palindrome {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Palindrome pd = new Palindrome();
        pd.begin();
    }
    
    void begin()
    {
        String sent="0";
        int sl=-1;
        try {
            sent = br.readLine();
            
        } catch (IOException ex) {
            Logger.getLogger(Palindrome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        char[] sentc = sent.toCharArray();
        char[] sen = new char[sentc.length];
        
        for (int i = 0; i < sentc.length; i++) {
            sentc[i]=Character.toLowerCase(sentc[i]);
            if(sentc[i]>=97&&sentc[i]<=122)
            {
                sl++;
                sen[sl] = sentc[i];
                
            }
        }
        //System.out.println(sen);
        for (int i = 0; i < sl/2; i++) {
            
            if(sen[i]!=sen[sl-i])
            {
                System.out.println("no");
                return;
            }
            
        }
        System.out.println("yes");
    }
    
}
