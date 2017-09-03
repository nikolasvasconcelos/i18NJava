/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CobrancaComponent;

import model.Registro;
import model.Variaveis;

/**
 *
 * @authors Rodrigo, Fabio
 */
public class CobrancaComponent {
        
    final int periodoInicial = getPeriodoInicial() ;   //Periodo mínimo de permanência, dado em horas
    final int periodoAdicional = getPeriodoAdicional(); //Periodo adicional de permanência, dado em horas
    final double valorInicial = getValorInicial(); //Tafira mínima a ser cobrada
    final double valorAdicional = getValorAdicional();   //Tarifa a ser cobrada pelo período adicional
    final int tolerancia = getTolerancia();      //Tempo tolerado, sem cobrança, dado em minutos
      
    public double calculaCobranca(int horaEntrada, int minutoEntrada, int horaSaida, int minutoSaida){
       
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