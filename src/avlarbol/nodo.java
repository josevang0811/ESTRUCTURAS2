/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avlarbol;

/**
 *
 * @author sncardenas
 */
public class nodo {
    private int valor;
    private nodo izquierdo;
    private nodo derecho;
    private int altafulla;

    public nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.altafulla = 1;
    }

    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }

    public nodo getIzquierdo() { return izquierdo; }
    public void setIzquierdo(nodo izquierdo) { this.izquierdo = izquierdo; }

    public nodo getDerecho() { return derecho; }
    public void setDerecho(nodo derecho) { this.derecho = derecho; }

    public int getAltafulla() { return altafulla; }
    public void setAltafulla(int altafulla) { this.altafulla = altafulla; }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}