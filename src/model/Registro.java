/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author FabioDelaRoca
 */
public class Registro implements Serializable {

    private int horaEntrada;
    private int minutoEntrada;
    
    public Registro(){
        
    }
	
    public Registro(int horaEntrada, int minutoEntrada){
        this.horaEntrada = horaEntrada;
        this.minutoEntrada = minutoEntrada;
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
