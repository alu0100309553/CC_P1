
public class Transcicion {
	public FTrans ftran = null;
	public int cinta = 0;
	public Pila pila = null;
	Transcicion (Pila p, int c, FTrans n){
		ftran = n;
		cinta = new Integer(c);
		pila = p;
	}
}
