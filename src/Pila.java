import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Pila {
	public Stack <String> pila = new Stack <String>();
	private ArrayList <String> alpPila = new ArrayList <String>();
	Pila (ArrayList <String> element){
		alpPila = element;
	}
	@SuppressWarnings("unchecked")
	Pila (Pila original){
		pila = (Stack<String>)original.pila.clone();
		alpPila = (ArrayList<String>) original.alpPila.clone();
	}
	public String consultar(){
		return pila.peek();
	}
	public String extraer(){
		return pila.pop();
	}
	public void insertar(ArrayList <String> elementos){
		if (!elementos.get(0).equals("*")){
			//for (String elemento : elementos){
			for (int i = elementos.size()-1; i >= 0; i--){
				pila.push(elementos.get(i));
			}
		}
		System.out.println(pila);
	}
}
