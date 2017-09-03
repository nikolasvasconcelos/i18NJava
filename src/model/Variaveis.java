/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @authors Rodrigo, Fabio
 */
public class Variaveis {
    private int periodoInicial;
    private int periodoAdicional;
    private double valorInicial;
    private double valorAdicional;
    private int tolerancia;
    
    public Variaveis(){
        
    }
    public Variaveis(int periodoInicial, int periodoAdicional,
                    double valorInicial, double valorAdicional, int tolerancia){
        this.periodoInicial = periodoInicial;
        this.periodoAdicional = periodoAdicional;
        this.valorInicial = valorInicial;
        this.valorAdicional = valorAdicional;
        this.tolerancia = tolerancia;
    }


    public int getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(int periodoInicial) {
        this.periodoInicial = periodoInicial;
    }

    public int getPeriodoAdicional() {
        return periodoAdicional;
    }

    public void setPeriodoAdicional(int periodoAdicional) {
        this.periodoAdicional = periodoAdicional;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public int getTolerancia() {
        return tolerancia;
    }

    public void setTolerancia(int tolerancia) {
        this.tolerancia = tolerancia;
    }
}
