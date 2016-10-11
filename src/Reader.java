import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {
	private FileReader fin = null;
	private BufferedReader bin = null;
	public ArrayList<ArrayList<String>> programa = new ArrayList<ArrayList<String>>();
	Reader (String file){
		try {
			fin = new FileReader (file);
			bin = new BufferedReader (fin);
			String line = bin.readLine();
			while (line != null){
				String [] token = line.split("\\s");
				ArrayList<String> sentencia = new ArrayList<String>();
				for (String st : token){
					if (st.matches("#.*")|token.length == 0){
						break;
					}
					else {
						sentencia.add(st);
					}
				}
				if (sentencia.size()>=1){
					programa.add(sentencia);
				}
				line = bin.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
