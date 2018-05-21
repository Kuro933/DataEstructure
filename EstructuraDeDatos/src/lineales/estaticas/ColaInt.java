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
public class ColaInt {
    private int[] arr;
    private int frenteCola;
    private int finalCola;
    private static final int TAM=5;
    public  ColaInt(){
        this.arr=new int[TAM];
        this.frenteCola=0;
        this.finalCola=0;
            
        }
    public boolean sacar(){
        boolean exito=true;
        if(this.esVacia())
            exito=false;
        else{
            this.frenteCola=(this.frenteCola+1)%this.TAM;
        }
        return exito;
    }
    public boolean poner(int elem){
        boolean exito=true;
        if(this.frenteCola==(this.finalCola+1)%TAM){
            exito=false;
        }else{
            this.arr[finalCola]=elem;
            this.finalCola=(finalCola+1)%this.TAM;
        }
    return exito;
    }
    public boolean esVacia(){
        boolean vacia;
        if(this.finalCola==this.frenteCola){
            vacia=true;
        }else
            vacia=false;
        return vacia;
    }
    public int obtenerFrente(){
        if(this.frenteCola!=this.finalCola){
            return arr[this.frenteCola];
            
        }else{
            return Integer.MIN_VALUE;
        }
    }
    public String toString(){
        String cadena="";
        int i=this.frenteCola;
        cadena="[";
        System.out.println("frente: "+this.frenteCola);
        System.out.println("final"+this.finalCola);
        while(i!=this.finalCola){
            cadena=cadena+this.arr[i]+";";
            i=((i+1)%this.TAM);
        }
        
        cadena=cadena+"]";
        return cadena;
    }
}
