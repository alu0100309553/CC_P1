/*
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 4 - Computación
 * Subject: Complejidad Computacional
 * Practice: 1
 * Class/Program: Autómata de pila
 * File: Cinta.java
 * Description: Programa que simula el funcionamiento de un autómata de pila.
 * @author Rubén Labrador Páez
 * @version 1.0.0 13/10/2016
 **/
import java.util.ArrayList;
import java.util.Stack;

/*
 * Clase que representa a la cinta del autómata, contiene un ArrayList de String
 * que guarda los caracteres de la cinta, un puntero que apunta a la posición de
 * y el alfabeto de la cinta *
 */
public class Cinta {
	private ArrayList<String> alphabeto = new ArrayList<String>();
	private ArrayList<String> valores = new ArrayList<String>();
	private int puntero = 0;

	// Constructor normal
	Cinta(ArrayList<String> alp) {
		alphabeto = alp;
	}

	// Constructor de copia
	Cinta(Cinta original) {
		valores = (ArrayList<String>) original.valores.clone();
		alphabeto = (ArrayList<String>) original.alphabeto.clone();
		puntero = original.puntero;
	}

	public String read() {
		return valores.get(puntero);
	}

	public int getPuntero() {
		return puntero;
	}

	public void setCinta(String cadena) {
		for (int i = cadena.length() - 1; i >= 0; i--) {

			if (alphabeto.contains("" + cadena.charAt(i))) {
				valores.add("" + cadena.charAt(i));
			} else {
				System.err.println("Se ha intentado intruducir un simbolo no perteneciente al alfabeto de la cinta");
				System.exit(1);
			}

		}
		puntero = cadena.length() - 1;
	}

	public int puntero() {
		return puntero;
	}

	public void setPuntero(int value) {
		puntero = value;
	}

	public void punteroDec() {
		puntero--;
	}

	public String getCinta() {
		String aux = "";
		if (puntero >= 0) {
			for (int i = puntero; i >= 0; i--) {
				aux += " " + valores.get(i);
			}
		}
		return aux;
	}
}
