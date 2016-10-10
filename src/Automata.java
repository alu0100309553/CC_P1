import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

public class Automata {
	private Hashtable <String, Estado> estados = new Hashtable<String, Estado>();
	private Estado actual;
	private Cinta cinta;
	private Pila pila;
	private Stack <Transcicion> trans = new Stack <Transcicion>();
	private int estFinales = 0;
	Automata(ArrayList <ArrayList<String>> programa){
		for (String est : programa.get(0)){
			estados.put(est, new Estado());
		}
		cinta = new Cinta (programa.get(1));
		pila = new Pila (programa.get(2));
		actual = estados.get(programa.get(3).get(0));
		System.out.println(programa.get(3).get(0));
		pila.insertar(programa.get(4)); 
		for (String estado : programa.get(5)){
			if (estado != "*"){
				estados.get(estado).setFinal();
				estFinales++;
			}
		}
		for (int i = 6; i < programa.size(); i++){
			estados.get(programa.get(i).get(0)).addFTran(programa.get(i));
		}
	}
	public void run (String cadena) {
		cinta.setCinta(cadena);
		boolean ejecutando = true;
		boolean aceptada = false;
		while (ejecutando){
			System.out.println(cinta.puntero);
			if ((actual.esFinal() && cinta.puntero < 0) || (cinta.puntero < 0 && pila.pila.size()==1 && estFinales == 0)){
				ejecutando = false;
				aceptada = true;
				break;
			}else {
				if (cinta.puntero >= 0){
					System.out.println(pila.consultar());
					for (FTrans t : actual.explorar(cinta.read(), pila.consultar())){

						System.out.println("//" + t.getNext());
						trans.push(new Transcicion(new Pila (pila), cinta.puntero, t));
					}
				} else {
					System.out.println(pila.consultar());
					for (FTrans t : actual.explorar(pila.consultar())){
						System.out.println("///" + t.getNext());
						trans.push(new Transcicion(new Pila (pila), cinta.puntero, t));
					}
				}			
			}
			if (!trans.isEmpty()){
				Transcicion transAct = trans.pop();
				pila = transAct.pila;
				FTrans act = transAct.ftran;
				System.out.println("----------------------");
				System.out.println(act.getNext());
				pila.extraer();//actualizar pila
				pila.insertar(act.escPila);
				cinta.puntero = new Integer(transAct.cinta);
				if (!act.getCinta().equals("*")){
					cinta.puntero--;//consumir cinta
				}
				actual = estados.get(act.getNext());
			} else {
				ejecutando = false	;
				aceptada = false;
				break;
			}
		}
		System.out.println(aceptada);
	}
}
