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
        
        try {
            processado.write("tipo_reg,cod_uf,num_seq,num_dv,cod_domc,num_ext_renda,fator_expansao1,fator_expansao2,perd_cod_p_visit_realm_em,qtd_morador_domc,qtd_uc,qtd_familia,cod_tipo_domc,qtd_comd_serv_dormit,cod_abast_agua,qtd_banheiros,cod_cond_ocup,imput_qtd_comodos,imput_qtd_banheiros,renda_bruta_monetaria,renda_total,estrada_grande_1,num_uc,num_inf,cod_rel_pess_refe_uc,num_familia,cod_cond_familia,cod_cond_presenca,dat_ano_nasc,idade_anos,cod_sexo,cod_sabe_ler,cod_freq_escola,cod_serie_freq,cod_nivel_instr,cod_concluiu_curso,anos_de_estudo,cod_cor_raca,cod_tem_cartao,cod_ehtitular_conta,num_comprimento,num_altura,num_peso,num_peso_crianca,comprimento_imputado,altura_imputado,peso_imputado,renda_percapita,religiao,plano_saude,cod_cond_vida,val_rec_min_ali,cons_celular,cons_telfixo,cons_shows,cons_dvd,tem_internet");
        } catch (IOException ex) {
            Logger.getLogger(PréProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
                
                 String cons_celular,cons_telfixo,cons_shows,cons_dvd,tem_internet = "0";
                 
                 
                 if (pessoaId == con_pessoaId)
                 {
                 
                 
                 }
                 
                 
                 
                 
                
                }
            
            }
        } catch (IOException ex) {
            Logger.getLogger(PréProcessamento.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
