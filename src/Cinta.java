import java.util.ArrayList;
import java.util.Stack;

public class Cinta {
	private ArrayList <String> alphabeto = new ArrayList <String>();
	private ArrayList <String> valores = new ArrayList <String>();
	public int puntero = 0;
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
			valores.add("" + cadena.charAt(i));
		}
		puntero = cadena.length()-1;
	}
}
