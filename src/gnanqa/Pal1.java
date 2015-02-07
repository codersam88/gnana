/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gnanqa;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author admn
 */
public class Pal1 {
    
    String sent="0";
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) {
        Pal1 pd = new Pal1();
        pd.begin(args);
        //System.out.println(args[0]);
    }
    
    void begin(String[] arg)
    {
        
        int sl=-1;
        for (int i = 0; i < arg.length; i++) {
            sent+=arg[i];
        }
        //System.out.println(sent);
        
        
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
