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
			estados.put(est, new Estado(est));
		}
		cinta = new Cinta (programa.get(1));
		pila = new Pila (programa.get(2));
		actual = estados.get(programa.get(3).get(0));
		pila.insertar(programa.get(4)); 
		for (String estado : programa.get(5)){
			if (!estado.equals("*")){
				estados.get(estado).setFinal();
				estFinales++;
			}
		}
		for (int i = 6; i < programa.size(); i++){
			estados.get(programa.get(i).get(0)).addFTran(programa.get(i));
		}
	}
	public boolean run (String cadena, boolean traza) {
		cinta.setCinta(cadena);
		boolean ejecutando = true;
		boolean aceptada = false;
		while (ejecutando){
			ArrayList <String> transPos = new ArrayList <String>();
			if ((actual.esFinal() && cinta.puntero() < 0) || (cinta.puntero() < 0 && pila.isEmpty() && estFinales == 0)){
				ejecutando = false;
				aceptada = true;
				if (traza){
					traza(transPos);
				}
				break;
			}else {
				if (cinta.puntero() >= 0 && !pila.isEmpty()){
					for (FTrans t : actual.explorar(cinta.read(), pila.consultar())){
						transPos.add(t.getNext());
						trans.push(new Transcicion(new Pila (pila), cinta.puntero(), t));
					}
				} else {
					if (!pila.isEmpty()){
						for (FTrans t : actual.explorar(pila.consultar())){
							transPos.add(t.getNext());
							trans.push(new Transcicion(new Pila (pila), cinta.puntero(), t));
						}
					}
				}			
			}
			if (traza){
				traza(transPos);
			}
			if (!trans.isEmpty()){
				Transcicion transAct = trans.pop();
				pila = transAct.getPila();
				FTrans act = transAct.getFtran();
				pila.extraer();
				pila.insertar(act.escPila);
				cinta.setPuntero(transAct.getCinta());
				if (!act.getCinta().equals("*")){
					cinta.punteroDec();
				}
				actual = estados.get(act.getNext());
			} else {
				ejecutando = false	;
				aceptada = false;
				break;
			}
		}
		return aceptada;

	}
	private void traza(ArrayList <String> transPos){
		String aux = "";
		for (String item : transPos){
			aux += " "+item;
		}
		System.out.println(actual.getId() + " ||" + cinta.getCinta() + " ||" + pila.getPila() + " ||" + aux);
		System.out.println("----------------------");
	}
}
