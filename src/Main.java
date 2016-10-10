
public class Main {

	public static void main(String[] args) {
		Reader rd = new Reader("automata.txt");
		Automata at = new Automata(rd.programa);
		at.run("11011");

	}

}
