/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author liam
 */
public class PilaInt {
    private NodoInt tope;
    //apilar
    public boolean apilar(int nuevoElem){
        NodoInt nodoNuevo= new NodoInt(nuevoElem,this.tope);
        this.tope=nodoNuevo;
        return true;
    }
    //desapilar
    public boolean desapilar(){
        boolean exito;
        if(this.tope!=null){
            
        
            this.tope=this.tope.getEnlace();
            exito=true;
        }else
            exito=false;
    return exito;
}
    public int obtenerTope(){
        return this.tope.getElem();
    }
    public boolean esVacia(){
        boolean vacia;
        if(this.tope==null)
            vacia=true;
        else
            vacia=false;
        return vacia;
    }
    //vaciar
    public void vaciar(){
        this.tope=null;
    }
    //clonar
    public PilaInt clone(){
        PilaInt pilaAux=new PilaInt();
        pilaAux.tope=this.tope;
        return pilaAux;
    }
    public String toString(){
        String cadena="";
        if(this.tope==null)
            cadena="pila vacia";
        else{
            cadena="[";
            //se ubica al principio de la estructura
            NodoInt aux=this.tope;
            //recorre los nodos hacia el final
            while(aux!=null){
                //agrega el elem al string
                cadena+=aux.getElem();
                //avanza al siguiente nodo
                aux=aux.getEnlace();
                if(aux!=null)
                    cadena+=";";
            }
            cadena+="]";
        }
        return cadena;
    }
}
    
