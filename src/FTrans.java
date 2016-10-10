import java.util.ArrayList;

public class FTrans {
	private String cinta;
	private String pila;
	private String next;
	public ArrayList <String> escPila = new ArrayList <String>(); 

	FTrans(ArrayList <String> func){
		cinta = func.get(1);
		pila = func.get(2);
		next = func.get(3);
		for (int i = 4; i < func.size(); i++){
			if (func.get(i) != "*"){
				escPila.add(func.get(i));
			}
		}
	}
	public String getCinta (){
		return cinta;
	}
	public String getPila (){
		return pila;
	}
	public String getNext (){
		return next;
	}


}
