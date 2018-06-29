/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import CobrancaComponent.CobrancaComponent;
import PersistenciaComponent.PersistenciaComponent;
import model.Registro;

/**
 *
 * @author Fabio
 */
public  class ControllerParkingControl {

    /**
     *
     * @param placa
     * @param horaEntrada
     * @param minutoEntrada
     * @return 
     */
    public static boolean RegistrarEntrada(String placa, Integer horaEntrada, Integer minutoEntrada){
        Registro entrada = new Registro();
        entrada.setHoraEntrada(horaEntrada);
        entrada.setMinutoEntrada(minutoEntrada);
        return PersistenciaComponent.gravarArquivoBinario(placa, entrada);
    }
    
    /**
     *
     * @param placa
     * @param horaSaida
     * @param minutoSaida
     * @param periodoInicial
     * @param periodoAdicional
     * @param valorInicial
     * @param valorAdicional
     * @param tolerancia
     * @return
     */
    public static String RegistrarSaida(String placa, int horaSaida, int minutoSaida, int periodoInicial, int periodoAdicional, double valorInicial, double valorAdicional, int tolerancia){
        Registro registro = new Registro();
        registro = (Registro) PersistenciaComponent.lerArquivoBinario(placa);
        if(registro == null){
            return "false1";
        }
        double cobranca = CobrancaComponent.calculaCobranca(registro.getHoraEntrada(), registro.getMinutoEntrada(), horaSaida, minutoSaida, periodoInicial, periodoAdicional, valorInicial, valorAdicional, tolerancia);
        
        if(cobranca == -1){
            return "false2";
        }
        
        String strHoraEntrada = String.valueOf(registro.getHoraEntrada());
        if(strHoraEntrada.length() == 1){
            strHoraEntrada = "0"+strHoraEntrada;
        }
        String strMinutoEntrada = String.valueOf(registro.getMinutoEntrada());
        if(strMinutoEntrada.length() == 1){
            strMinutoEntrada = "0"+strMinutoEntrada;
        }
        String strHoraSaida = Integer.toString(horaSaida);
        if(strHoraSaida.length() == 1){
            strHoraSaida = "0"+strHoraSaida;
        }
        String strMinutoSaida = Integer.toString(minutoSaida);
        if(strMinutoSaida.length() == 1){
            strMinutoSaida = "0"+strMinutoSaida;
        }
        return strHoraEntrada+":"+strMinutoEntrada+";"+strHoraSaida+":"+strMinutoSaida+";"+String.valueOf(cobranca).replace(".", ",");
    }

    /**
     *
     * @param placa
     */
    public static void RegistrarCobranca(String placa){
        PersistenciaComponent.deleteArquivo(placa);
    }
    
    
}
