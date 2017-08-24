/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Rodrigo
 */
public class ControlePagamento {
    // OBJETO CARRO 
    String placaA = "ABC1234";
    int horaEntrada = 13;
    int minutoEntrada = 30;
    
    int horaIni = 15;
    final double valorIni = 15;
    final int valorHora = 5;
    final int tolMinuto = 30; 
    final int periodoMinimo = 2;
    double fatura = 15;
    
    public double calculaSaida(String placa, int horaSaida, int minutoSaida){
        int multiplicador = 1;
        int difHora = horaSaida - horaEntrada;
        int difMinuto = minutoSaida - minutoEntrada;
        double valor = 0;
        
        if(difHora <=0 && difMinuto <= tolMinuto){// menor que 30 minuto
            multiplicador = 0;
        }
        else if(difHora <= periodoMinimo && difMinuto <= 0){ //tempo <= 2 horas
            return valorIni;
        }
        else{
            difHora = difHora - periodoMinimo; 
            valor = valorIni;
            multiplicador = Math.round(difHora + (difMinuto/60));
        }   
        return valor + (multiplicador*valorHora);
    }
}
