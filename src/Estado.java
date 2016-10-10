import java.util.ArrayList;

public class Estado {
	private ArrayList <FTrans> ftrans = new ArrayList <FTrans>();
	private boolean esFinal = false;
	private String id;

	Estado(String identificador){
		id = identificador;
	}
	public void setFinal(){
		esFinal= true;
	}
	public void addFTran (ArrayList <String> func){
		ftrans.add(new FTrans(func));
	}
	public ArrayList <FTrans> getFTrans(){
		return ftrans;
	}
	public boolean esFinal (){
		return esFinal;
	}
	public ArrayList <FTrans> explorar (String cinta, String pila){
		ArrayList <FTrans> aux = new ArrayList <FTrans>();
		for (FTrans func : ftrans){
			if ((func.getCinta().equals(cinta) && func.getPila().equals(pila)) || (func.getCinta().equals("*") && func.getPila().equals(pila))){
				aux.add(func);
			}
		}

		return aux;
	}
	public ArrayList <FTrans> explorar (String pila){
		ArrayList <FTrans> aux = new ArrayList <FTrans>();
		for (FTrans func : ftrans){
			if (func.getCinta().equals("*") && func.getPila().equals(pila)){
				aux.add(func);
			}
		}
		return aux;
	}
	public String getId(){
		return id;
	}
}
