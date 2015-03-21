
import java.util.ArrayList;




public class Sali {
	//testaukseen
	private boolean verbose = false;

	private int salinumero;
	private boolean[][] istumapaikat;
	private Teatteri teatteri;
	private Naytos[] naytokset;

	//konstruktori
	public Sali(int salinumero){
		if(verbose){System.out.println("Luokka: Sali : konstruktori");}
		this.salinumero=salinumero;

	}

	//getterit ja setterit
	//------------------------------------------------------------

	public int annaSalinumero(){
		if(verbose){System.out.println("Luokka: Sali : annaSalinumero()");}

		return salinumero;
	}
}
