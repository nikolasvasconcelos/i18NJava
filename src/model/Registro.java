/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Rodrigo
 */
public class Registro {
    private String placa;
    private int horaEntrada;
    private int minutoEntrada;
    
    public Registro(){
        
    }
    public Registro(String placa, int horaEntrada, int minutoEntrada){
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @return the horaEntrada
     */
    public int getHoraEntrada() {
        return horaEntrada;
    }

    /**
     * @return the minutoEntrada
     */
    public int getMinutoEntrada() {
        return minutoEntrada;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @param horaEntrada the horaEntrada to set
     */
    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    /**
     * @param minutoEntrada the minutoEntrada to set
     */
    public void setMinutoEntrada(int minutoEntrada) {
        this.minutoEntrada = minutoEntrada;
    }
}
