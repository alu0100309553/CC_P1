/*
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 4 - Computación
 * Subject: Complejidad Computacional
 * Practice: 1
 * Class/Program: Autómata de pila
 * File: Pila.java
 * Description: Programa que simula el funcionamiento de un autómata de pila.
 * @author Rubén Labrador Páez
 * @version 1.0.0 13/10/2016
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/*
 * Clase que representa a la pila del autómata, contiene un stack que almacena los caracteres
 * que se van introduciendo en la pila, y el alfabeto de la pila.
 */
public class Pila {
	private Stack<String> pila = new Stack<String>();
	private ArrayList<String> alpPila = new ArrayList<String>();

	// Construcotr
	Pila(ArrayList<String> element) {
		alpPila = element;
	}

	@SuppressWarnings("unchecked")
	// Constructor de copia
	Pila(Pila original) {
		pila = (Stack<String>) original.pila.clone();
		alpPila = (ArrayList<String>) original.alpPila.clone();
	}

	public String consultar() {
		return pila.peek();
	}

	public String extraer() {
		return pila.pop();
	}

	public void insertar(ArrayList<String> elementos) {
		if (!elementos.get(0).equals("*")) {
			for (int i = elementos.size() - 1; i >= 0; i--) {
				if (alpPila.contains(elementos.get(i))) {
					pila.push(elementos.get(i));
				} else {
					System.err.println("Se ha intentado intruducir un simbolo no perteneciente al alfabeto de la pila");
					System.exit(1);
				}
			}
		}
	}

	public int size() {
		return pila.size();
	}

	public boolean isEmpty() {
		return pila.isEmpty();
	}

	public String getPila() {
		String aux = "";
		for (String item : pila) {
			aux += " " + item;
		}
		return aux;
	}
}
