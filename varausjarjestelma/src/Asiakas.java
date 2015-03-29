import java.util.ArrayList;


//TODO testaa!
public class Asiakas extends Kayttaja {

	//testaukseen
	private boolean verbose = true;	
	
	
	private ArrayList<Varaus> varaukset;
	


	public Asiakas(String nimi, String salasana, String kayttajanimi, int ID){
		super(nimi, salasana, kayttajanimi, ID);	
		if(verbose){System.out.println("Luokka: Asiakas : Konstruktori");}
	}
	
	public boolean onkoAsiakas(){
		if(verbose){System.out.println("Luokka: Asiakas : onkoAsiakas()");}

		return true;
	}
	public boolean onkoYllapitaja(){
		if(verbose){System.out.println("Luokka: Asiakas : onkoYllapitaja()");}

		return false;
	}

	/**
	 * Lisaa varauksen asiakkaan tietoihin
	 * @param varaus
	 */
	public void lisaaVaraus(Varaus varaus){
		if(verbose){System.out.println("Luokka: Asiakas : lisaaVaraus()");}
		varaukset.add(varaus);
	}
}
