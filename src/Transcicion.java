
public class Transcicion {
	private FTrans ftran = null;
	private int cinta = 0;
	private Pila pila = null;
	Transcicion (Pila p, int c, FTrans n){
		ftran = n;
		cinta = new Integer(c);
		pila = p;
	}
	public FTrans getFtran(){
		return ftran;
	}
	public int getCinta(){
		return cinta;
	}
	public Pila getPila(){
		return pila;
	}
}
