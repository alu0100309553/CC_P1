/*
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 4 - Computación
 * Subject: Complejidad Computacional
 * Practice: 1
 * Class/Program: Autómata de pila
 * File: FTrans.java
 * Description: Programa que simula el funcionamiento de un autómata de pila.
 * @author Rubén Labrador Páez
 * @version 1.0.0 13/10/2016
 **/
import java.util.ArrayList;

// Clase en la que se definen funciones de transición
public class FTrans {
	private String cinta;
	private String pila;
	private String next;
	public ArrayList<String> escPila = new ArrayList<String>();

	FTrans(ArrayList<String> func) {
		cinta = func.get(1);
		pila = func.get(2);
		next = func.get(3);
		for (int i = 4; i < func.size(); i++) {
			if (func.get(i) != "*") {
				escPila.add(func.get(i));
			}
		}
	}

	public String getCinta() {
		return cinta;
	}

	public String getPila() {
		return pila;
	}

	public String getNext() {
		return next;
	}

}
