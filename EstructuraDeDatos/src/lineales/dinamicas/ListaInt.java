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
public class ListaInt {
    private NodoInt cabecera;
    private int longitud=0;
    public ListaInt(){
        this.cabecera=null;
    }
    public boolean insertar(int elem, int pos){
        boolean exito=true;
        if(pos<1|| pos>this.longitud+1)
            exito=false;
        else{
            if(pos==1)
                this.cabecera=new NodoInt(elem,this.cabecera);
            else{
                NodoInt aux=this.cabecera;
                int i=1;
                while(i<pos-1){
                    aux=aux.getEnlace();
                    i++;
                }
                NodoInt nuevo=new NodoInt(elem,aux.getEnlace());
                aux.setEnlace(nuevo);
            }
                longitud++;
            
        }
            
            return exito;
    }
    public boolean eliminar(int pos){
        NodoInt ant=this.cabecera;
        boolean exito=true;
        if(pos<1||pos>this.longitud+1)
            exito=false;
        else{
            if(pos==1){
                this.cabecera=ant.getEnlace();   
            }else{
                int i=1;
                while(i<pos-1){
                    ant=ant.getEnlace();
                    i++;
                }
                ant.setEnlace(ant.getEnlace().getEnlace());
                    
                
            }
            
        }
            return exito;
    }
    public int recuperar(int pos){
        boolean exito;
        int elem;
        NodoInt aux=this.cabecera;
        int i=1;
        if(pos<1|| pos>this.longitud)
            elem=Integer.MAX_VALUE;
        else{
            if(pos==1)
                elem=aux.getElem();
            else{
                while(i<pos){
                    aux=aux.getEnlace();
                    i++;
            }
                elem=aux.getElem();
           
        }
        
        }
            
        return elem;
    }
    public int localizar(int elem){
        int pos=0;
        int i=2;
        boolean encontrado=false;
        NodoInt aux=this.cabecera;
        if(aux.getElem()==elem)
            pos=1;
        else{
            while(i<this.longitud+1&&encontrado==false){
                aux=aux.getEnlace();
                if(aux.getElem()==elem){
                    pos=i;
                    encontrado=true;
                }else{
                    i++;
                }
            }
            
        }
        return pos;
    }
    public boolean esVacia(){
        boolean vacia=false;
        if(this.cabecera==null)
            vacia=true;
        return vacia;
            
    }
    public void vaciar(){
        this.cabecera=null;
        
    }
    public int longitud(){
        return this.longitud;
    }
    public ListaInt clone(){
        ListaInt listaAux=new ListaInt();
        listaAux.cabecera=this.cabecera;
        listaAux.longitud=this.longitud;
        return listaAux;
    }
    public String toString(){
        String cadena="";
        if(this.cabecera==null)
            cadena="cola vacia";
        else{
            cadena="[";
            //se ubica al principio de la estructura
            NodoInt aux=this.cabecera;
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
