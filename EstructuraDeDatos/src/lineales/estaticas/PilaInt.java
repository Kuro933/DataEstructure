/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.estaticas;

/**
 *
 * @author liam
 */
public class PilaInt {
    private int[] arr;
    private int tope;
    public static final int TAM=20;
    

public PilaInt(){
    this.arr=new int [TAM];
    this.tope=-1;
}
public boolean apilar(int nuevoElem){
    boolean exito;
    if(this.tope+1>=this.TAM)
        //Error : pila llena
        exito=false;
    else{
        //pone el elemento en el tope de la pila e incrementa tope
        this.tope++;
        this.arr[tope]=nuevoElem;
        exito=true;
    }
    return exito;
}
public boolean desapilar(){
    boolean exito;
    if(this.tope==-1)
        //pila vacia
        exito=false;
    else{
        this.arr[tope]=0;
        this.tope--;
        exito=true;
    }
    return exito;
}
public int obtenerTope(){
    int elemento;
    if(this.tope==-1)
        //pila vacia
        elemento=Integer.MIN_VALUE;
    else
        elemento=this.arr[tope];
    return elemento;
}
public boolean esVacia(){
    boolean vacia=false;
    if(this.tope==-1)
        vacia=true;
    return vacia;
}
public void vaciar(){
    this.tope=-1;
}
public PilaInt clone(){
    PilaInt pilaAux=new PilaInt();
    pilaAux.tope=this.tope;
    pilaAux.arr=this.arr.clone();
    return pilaAux;
}
public String toString(){
    String cadena="";
    for (int i = 0; i <=this.tope; i++) {
        cadena=cadena+this.arr[i]+";";
    }
    return cadena;
}
}