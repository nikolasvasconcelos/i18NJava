/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CobrancaComponent;

/**
 *
 * @authors Rodrigo, Fabio
 */
public class CobrancaComponent {
      
    /**
     *
     * @param horaEntrada
     * @param minutoEntrada
     * @param horaSaida
     * @param minutoSaida
     * @param periodoInicial
     * @param periodoAdicional
     * @param valorInicial
     * @param valorAdicional
     * @param tolerancia
     * @return
     */
    public static double calculaCobranca(int horaEntrada, int minutoEntrada, int horaSaida, int minutoSaida, int periodoInicial, int periodoAdicional, double valorInicial, double valorAdicional, int tolerancia){
       
        int multiplicador = 1;
        int difHora = horaSaida - horaEntrada;
        int difMinuto = minutoSaida - minutoEntrada;
        double valor = 0;
        
        if(difHora <=0 && difMinuto <= tolerancia){// menor que 30 minuto
            multiplicador = 0;
        }
        else if(difHora <= periodoInicial && difMinuto <= 0){ //tempo <= 2 horas
            return valorInicial;
        }
        else{
            difHora = difHora - periodoInicial; 
            valor = valorInicial;
            multiplicador = Math.round((( Math.round(difHora + (difMinuto/60)) ) / periodoAdicional));
        }   
        return valor + (multiplicador*valorAdicional);
    }
}