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

    /**
     *
     * @param lista
     * @param nomeArq
     */
    public static void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
        File arq = new File(nomeArq);
        if(arq.exists()){
            try {
                arq.delete();
                arq.createNewFile();
                try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq))) {
                    objOutput.writeObject(lista);
                }
            } 
            catch(IOException erro) {
                System.out.printf("Erro: %s", erro.getMessage());
            }
        }
    }
   
    // desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"

    /**
     *
     * @param nomeArq
     * @return
     */
    public static ArrayList<Object> lerArquivoBinario(String nomeArq) {
      ArrayList<Object> lista = new ArrayList();
      try {
        File arq = new File(nomeArq);
        if (arq.exists()) {
            try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq))) {
                lista = (ArrayList<Object>)objInput.readObject();
            }
        }
        else{
           lista = null;
           System.out.println("Não encontrado!");
        }
      } catch(IOException | ClassNotFoundException erro) {
          System.out.printf("Erro: %s", erro.getMessage());
      }
   
      return(lista);
    }
    
    // exclusão: excluindo o arquivo binário "nomeArq"

    /**
     *
     * @param nomeArq
     */
    public static void deleteArquivo(String nomeArq){
        File arq = new File(nomeArq);
        if(arq.exists()){
            arq.delete();
        }
    }
    
   
  }
