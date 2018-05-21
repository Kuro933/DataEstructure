package Conjuntistas;

public class ArbolHeap {
	private final int TAM=20;
	private int [] heap;
	private int ultimo=0;
	public ArbolHeap() {
		heap= new int[TAM];
		
	}
	public boolean insertar(int elem) {
		boolean exito=false;
		return exito;
		
	}
	public boolean eliminarCim() {
		boolean exito;
		if(this.ultimo==0) {
			//estructura vacia
			exito=false;
			
		}else {
			//saca la raiz y pone la ultim ahoja en su lugar
			this.heap[1]=this.heap[ultimo];
			this.ultimo--;
			//reestablece la propiedad de heap minimo
			hacerBajar(1);
			exito=true;
		}
		return exito;
	}
	private void hacerBajar(int posicion) {
		int hijoMenor;
		int temp= this.heap[posicion];
		boolean salir=false;
		while(!salir) {
			hijoMenor=posicion*2;
			if(hijoMenor<=this.ultimo) {
				//temp tiene hijos , al menos uno
				if(hijoMenor<this.ultimo) {
					//hijoMenor tiene hermano derecho
					if(this.heap[hijoMenor+1]<this.heap[hijoMenor]) {
						hijoMenor++;
					}
				}
				if(this.heap[hijoMenor]<temp) {
					this.heap[posicion]=this.heap[hijoMenor];
					posicion=hijoMenor;
				}else {
					//el padre es menor que sus hijos
					salir=true;
				}
			}else {
				//hijo menor es una hoja
				salir=true;
			}
		}
		this.heap[posicion]=temp;
	}
}
