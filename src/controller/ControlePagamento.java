/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Registro;

/**
 *
 * @author Rodrigo
 */
public class ControlePagamento {
        
    final int periodoMinimo = 2; //Periodo mínimo de permanência, dado em horas
    final double tarifaMinima = 15; //Tafira mínima a ser cobrada
    final int tarifaHora = 5; //Tarifa a ser cobrada por hora
    final int tolerancia = 30; //Tempo tolerado sem cobrança, dado em minutos
    
    // OBJETO TESTE DE REGISTRO DE ENTRADA
    // Registro teste = new Registro(placa, horaEntrada, minutoEntrada)
    Registro teste = new Registro("ABC1234", 13, 30);
    
    public double calculaSaida(String placa, int horaSaida, int minutoSaida){
        /*
        TODO: Buscar registro de carro por placa
        Registo resgisto = buscarRegistro(placa);
        */
        
        int multiplicador = 1;
        int difHora = horaSaida - teste.getHoraEntrada();
        int difMinuto = minutoSaida - teste.getMinutoEntrada();
        double valor = 0;
        
        if(difHora <=0 && difMinuto <= tolerancia){// menor que 30 minuto
            multiplicador = 0;
        }
        else if(difHora <= periodoMinimo && difMinuto <= 0){ //tempo <= 2 horas
            return tarifaMinima;
        }
        else{
            difHora = difHora - periodoMinimo; 
            valor = tarifaMinima;
            multiplicador = Math.round(difHora + (difMinuto/60));
        }   
        return valor + (multiplicador*tarifaHora);
    }
}
