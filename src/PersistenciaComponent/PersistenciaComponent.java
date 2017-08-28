/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaComponent;

/**
 *
 * @author Rodrigo
 */
import java.io.File;
  import java.io.IOException;
  import java.util.ArrayList;
  import java.io.FileInputStream;
  import java.io.FileOutputStream;
  import java.io.ObjectInputStream;
  import java.io.ObjectOutputStream;
   
  public class PersistenciaComponent {
   
    // serialização: gravando o objetos no arquivo binário "nomeArq"
    public void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
        File arq = new File(nomeArq);
        if(arq.exists()){
            try {
            arq.delete();
            arq.createNewFile();

            ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
            objOutput.writeObject(lista);
            
            objOutput.close();
            } 
            catch(IOException erro) {
                System.out.printf("Erro: %s", erro.getMessage());
            }
        }
    }
   
    // desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
    public ArrayList<Object> lerArquivoBinario(String nomeArq) {
      ArrayList<Object> lista = new ArrayList();
      try {
        File arq = new File(nomeArq);
        if (arq.exists()) {
           ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
           lista = (ArrayList<Object>)objInput.readObject();
           objInput.close();
        }
        else{
           lista = null;
           System.out.println("Não encontrado!");
        }
      } catch(IOException erro1) {
          System.out.printf("Erro: %s", erro1.getMessage());
      } catch(ClassNotFoundException erro2) {
          System.out.printf("Erro: %s", erro2.getMessage());
      }
   
      return(lista);
    }
    
    // exclusão: excluindo o arquivo binário "nomeArq"
    public void deleteArquivo(String nomeArq){
        File arq = new File (nomeArq);
        this.lerArquivoBinario(nomeArq);
        if (arq.exists()){
            arq.delete();
        }
    }
    
   
  }
