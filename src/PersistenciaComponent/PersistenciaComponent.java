/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PersistenciaComponent;

/**
 *
 * @author Fabio
 */
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
   
public class PersistenciaComponent {
   
    /**
     *
     * @param entrada
     * @param nomeArq
     * @return 
     */
    public static boolean gravarArquivoBinario(String nomeArq, Object entrada) {
        File arq = new File(nomeArq);
        if(arq.exists()){
            return false;
        } else {
            try {
                arq.createNewFile();
                try (ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq))) {
                    objOutput.writeObject(entrada);
                }
            } 
            catch(IOException erro) {
                System.out.printf("Erro: %s", erro.getMessage());
            }
        }
        return true;
    }
 
    /**
     *
     * @param nomeArq
     * @return
     */
    public static Object lerArquivoBinario(String nomeArq) {
        try {
            File arq = new File(nomeArq);
            if (arq.exists()) {
                try (ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq))) {
                    return (Object) objInput.readObject();
                }
            }
            else{
                System.out.println("PersistenciaComponent: Registro Não Encontrado!");
            }
        } catch(IOException | ClassNotFoundException erro) {
            System.out.printf("PersistenciaComponent Erro: %s", erro.getMessage());
        }
        return null;
    }
    
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
