package Test;
import Jerarquicas.ArbolGen;
import java.util.Scanner;
public class testArbolGen {
public static void main(String[] args) {
	ArbolGen arbol=new ArbolGen();
	arbol.insertarPrimera(1, 1);
	arbol.insertarUltima(2, 1);
	arbol.insertarUltima(3, 1);
	arbol.insertarUltima(4, 2);
	System.out.println("ARbol "+arbol.toString());
	Scanner sc= new Scanner(System.in);
	int elem=sc.nextInt();
	if(arbol.pertenece(elem)) {
		System.out.println("El elemento pertenece");
		
	}else {
		System.out.println("El elemento no pertenece");
	}
}
}
