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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
         BufferedWriter processado = null;
         
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
            processado = new BufferedWriter(new  FileWriter("D:/BasesStataFINAL/processado.csv"));
        } catch (IOException ex) {
            Logger.getLogger(PréProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String dummies = "cons_celular,cons_telfixo,cons_shows,cons_dvd,tem_internet";
       
        
        try {
            while ((linhapessoa = pessoain.readLine())!= null)
            {
                String[] splitlinhapessoa = linhapessoa.split(",");
                String pessoaId = splitlinhapessoa[1] + splitlinhapessoa[2] + splitlinhapessoa[3] + splitlinhapessoa[4]
                + splitlinhapessoa[23];
                String domclId = splitlinhapessoa[1] + splitlinhapessoa[2] + splitlinhapessoa[3] + splitlinhapessoa[4];
                
                while ((linhaconsumo = consumoin.readLine())!= null)
                {
                 String[] splitlinhaconsumo = linhaconsumo.split(",");
                 String con_pessoaId = splitlinhaconsumo[1] + splitlinhaconsumo[2] + splitlinhaconsumo[3] +
                 splitlinhaconsumo[4] + splitlinhaconsumo[21]  ;
                 String con_domclId = splitlinhaconsumo[1] + splitlinhaconsumo[2] + splitlinhaconsumo[3] + splitlinhaconsumo[4];
                
                 String cons_celular,cons_telfixo,cons_shows,cons_dvd,cons_internet = "0";
                 
                 
                 if (pessoaId == con_pessoaId)
                 {
                    if (((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "801"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1101"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1301"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "2401"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "2402")))
                       {cons_celular = "1";}
                    
                    if (((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "801"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "901"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1101"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1401"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "401"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "501")))
                       {cons_telfixo = "1";}
                         
                    if ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "1101"))
                    {
                    cons_shows = "1";
                    }
                    
                    if (((splitlinhaconsumo[9] == "13") &&  (splitlinhaconsumo[10] == "1701"))|
                       ((splitlinhaconsumo[9] == "15") &&  (splitlinhaconsumo[10] == "2701"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "5701"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "2601"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "901")))                      
                       {cons_dvd = "1";}
                    
                     if (((splitlinhaconsumo[9] == "6") && (splitlinhaconsumo[10] == "502"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "503"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "504"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "505"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "506"))|
                        ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "801"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "901"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1001"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1301"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1401")))                      
                       {cons_internet = "1";}
                    
                }
                 
                if (domclId == con_domclId)
                 {
                    if (((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "801"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1101"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1301"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "2401"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "2402")))
                       {cons_celular = "1";}
                    
                    if (((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "801"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "901"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1101"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1401"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "401"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "501")))
                       {cons_telfixo = "1";}
                         
                    if ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "1101"))
                    {
                    cons_shows = "1";
                    }
                    
                    if (((splitlinhaconsumo[9] == "13") &&  (splitlinhaconsumo[10] == "1701"))|
                       ((splitlinhaconsumo[9] == "15") &&  (splitlinhaconsumo[10] == "2701"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "5701"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "2601"))|
                       ((splitlinhaconsumo[9] == "28") &&  (splitlinhaconsumo[10] == "901")))                      
                       {cons_dvd = "1";}
                    
                     if (((splitlinhaconsumo[9] == "6") && (splitlinhaconsumo[10] == "502"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "503"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "504"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "505"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "506"))|
                        ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "801"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "901"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1001"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1301"))|
                       ((splitlinhaconsumo[9] == "6") &&  (splitlinhaconsumo[10] == "1401")))                      
                       {cons_internet = "1";}
                    
                }
                 
                 
                 
                 
                
                }
            
            }
        } catch (IOException ex) {
            Logger.getLogger(PréProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
