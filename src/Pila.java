import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Pila {
	private Stack <String> pila = new Stack <String>();
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
			for (int i = elementos.size()-1; i >= 0; i--){
				if (alpPila.contains(elementos.get(i))){
					pila.push(elementos.get(i));
				}
				else {
					System.err.println("Se ha intentado intruducir un simbolo no perteneciente al alfabeto de la pila");
				}
			}
		}
	}
	public int size () {
		return pila.size();
	}
	public boolean isEmpty () {
		return pila.isEmpty();
	}
	public String getPila(){
		String aux = "";
		for (String item : pila){
			aux += " "+item;
		}
		return aux;
	}
}
