import java.util.ArrayList;
import java.util.Stack;

public class Cinta {
	private ArrayList <String> alphabeto = new ArrayList <String>();
	private ArrayList <String> valores = new ArrayList <String>();
	private int puntero = 0;
	Cinta(ArrayList<String> alp){
		alphabeto = alp;
	}
	Cinta (Cinta original){
		valores = (ArrayList<String>) original.valores.clone();
		alphabeto = (ArrayList<String>) original.alphabeto.clone();
		puntero = original.puntero;
	}
	public String read(){
		return valores.get(puntero);
	}
	public int getPuntero(){
		return puntero;
	}
	public void setCinta (String cadena){
		for (int i = cadena.length()-1 ; i >= 0; i--){

			if (alphabeto.contains("" + cadena.charAt(i))){
				valores.add("" + cadena.charAt(i));
			}
			else {
				System.err.println("Se ha intentado intruducir un simbolo no perteneciente al alfabeto de la cinta");
			}

		}
		puntero = cadena.length()-1;
	}
	public int puntero(){
		return puntero;
	}
	public void setPuntero(int value){
		puntero = value;
	}
	public void punteroDec(){
		puntero--;
	}
	public String getCinta(){
		String aux = "";
		if (puntero >= 0){
			for ( int i = puntero; i >= 0; i--){
				aux += " " + valores.get(i);
			}
		}
		return aux;
	}
}
