/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import CobrancaComponent.CobrancaComponent;
import PersistenciaComponent.PersistenciaComponent;
import java.util.ArrayList;
import model.Registro;

/**
 *
 * @author Rodrigo
 */
public class ControleArmazenamento {
    ///Forma de armazenamento (PLACA,HORA,MINUTO)
    /*
    
    ABC1234,13,30;
    DEF2345,15,30;
    EFG3456,08,50;
    
    */
    /// ENTRADA REGISTRA
    /// SAIDA DELETA
    
    
    public static void RegistrarEntrada(String placa, int horaEntrada, int minutoEntrada){
        ArrayList<Object> lista = new ArrayList();
        Registro entrada = new Registro();
        entrada.setHoraEntrada(horaEntrada);
        entrada.setMinutoEntrada(minutoEntrada);
        lista.add(entrada);
        PersistenciaComponent.gravarArquivoBinario(lista, placa);
    }
    
    public static void RegistrarSaida(String placa, int horaSaida, int minutoSaida, int periodoInicial, int periodoAdicional, double valorInicial, double valorAdicional, int tolerancia){
        ArrayList<Object> lista = new ArrayList();
        Registro registro = new Registro();
        lista = PersistenciaComponent.lerArquivoBinario(placa);
        registro = (Registro) lista.get(0);
        double cobranca = CobrancaComponent.calculaCobranca(registro.getHoraEntrada(), registro.getMinutoEntrada(), horaSaida, minutoSaida, periodoInicial, periodoAdicional, valorInicial, valorAdicional, tolerancia);
    }

    public static void RegistrarCobranca(String placa){
        PersistenciaComponent.deleteArquivo(placa);
    }
    
    
}
