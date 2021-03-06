package Jerarquicas;

public class ArbolGen {
	private NodoGen raiz;
    public ArbolGen(){
        this.raiz=null;
    }
    private NodoGen obtenerNodo(NodoGen n, Object buscado){
        NodoGen resultado=null;
        NodoGen h;
        if(n!=null){
            if(n.getElem().equals(buscado)){
                resultado=n;
            }else{
                h=(NodoGen)n.getHijoIzq();
                while(h!=null&&resultado==null){
                    resultado=obtenerNodo(h,buscado);
                    h=(NodoGen) h.getHermanoDer();
                }
            }
        }
        return resultado;
    }
    public boolean insertarPrimera(Object elem,Object padre){
        boolean exito=false;
        NodoGen nuevo;
        if(this.raiz==null) {
        	nuevo=new NodoGen(elem);
        	this.raiz=nuevo;
        }else {
        	NodoGen aux=obtenerNodo(this.raiz,padre);
        	if(aux!=null) {
        		nuevo=new NodoGen(elem);
        		if(aux.getHijoIzq()==null) {
        			aux.setHijoIzq(nuevo);
        			
        		}else {
        			nuevo.setHermanoDer((NodoGen) aux.getHijoIzq());
        			aux.setHijoIzq(nuevo);
        		}
        		exito=true;
        	}
        
        	
        }
    
        
        return exito;
    }
    public boolean insertarUltima(Object elem, Object padre) {
		boolean exito = false;
		NodoGen nuevo;
		if (this.raiz == null) {
			nuevo = new NodoGen(elem);
			this.raiz = nuevo;
			exito = true;
		} else {
			NodoGen father = obtenerNodo(this.raiz, padre);
			if (father != null) {
				nuevo = new NodoGen(elem);
				if (father.getHijoIzq() == null) {
					father.setHijoIzq(nuevo);
				} else {
					NodoGen h = (NodoGen) father.getHijoIzq();
					while (h.getHermanoDer() != null) {
						h = (NodoGen) h.getHermanoDer();
					}
					h.setHermanoDer(nuevo);
				}
				exito = true;
			}
		}
		return exito;
	}
    public boolean pertenece(Object elem){
        boolean encontrado=false;
        if(obtenerNodo(this.raiz,elem)!=null){
            encontrado=true;
        }
        return encontrado;
    }
    public String toString(){
        return toStringAux(this.raiz);
    }
    private String toStringAux(NodoGen n){
        String s=";";
        if(n!=null){
            //visita el nodo n
            s+=n.getElem().toString()+" ->";
            NodoGen hijo=(NodoGen)n.getHijoIzq();
            while(hijo!=null){
                s+=hijo.getElem().toString()+", ";
                hijo=(NodoGen)hijo.getHermanoDer();
            }
            //comiienza recorrido de los hijos de n llamado recursivamente
            //para que cada hijo agregue su subcadena a la general
            hijo=(NodoGen)n.getHijoIzq();
            while(hijo!=null){
                s+="\n"+toStringAux(hijo);
                hijo=(NodoGen)hijo.getHermanoDer();
            }
        }
        return s;
    }
}
