/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package préprocessamento;

/**
 *
 * @author Ticiana
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PréProcessamento {
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         BufferedReader consumoin = null ;
         BufferedReader pessoain = null;
         String linhapessoa,linhaconsumo;
       
        FileReader consumo = null;
        try {
            consumo = new FileReader("D:/BasesStataFINAL/consumo.csv");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PréProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        FileReader pessoas = null;
        try {
            pessoas = new FileReader("D:/BasesStataFINAL/pessoas.csv");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PréProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        consumoin = new BufferedReader(consumo);
        pessoain = new BufferedReader(pessoas);
        
        try {
            while ((linhapessoa = pessoain.readLine())!= null)
            {
                String[] splitlinhapessoa = linhapessoa.split(",");
               
            
            }
        } catch (IOException ex) {
            Logger.getLogger(PréProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
