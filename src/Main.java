
public class Main {

	public static void main(String[] args) {
		Reader rd = new Reader("AP1.txt");
		Automata at = new Automata(rd.programa);
		System.out.println(at.run("aaabbb", true));

	}

}
