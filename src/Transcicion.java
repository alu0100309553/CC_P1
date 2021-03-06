/*
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 4 - Computación
 * Subject: Complejidad Computacional
 * Practice: 1
 * Class/Program: Autómata de pila
 * File: Transcicion.java
 * Description: Programa que simula el funcionamiento de un autómata de pila.
 * @author Rubén Labrador Páez
 * @version 1.0.0 13/10/2016
 **/

// Clase empleada para almacenar posibles transiciones del autómata
// Contiene un función de transición, y el estado de la pila y la cinta en el instante en que se generó la transición.
public class Transcicion {
	private FTrans ftran = null;
	private int cinta = 0;
	private Pila pila = null;

	Transcicion(Pila p, int c, FTrans n) {
		ftran = n;
		cinta = new Integer(c);
		pila = p;
	}

	public FTrans getFtran() {
		return ftran;
	}

	public int getCinta() {
		return cinta;
	}

	public Pila getPila() {
		return pila;
	}
}
