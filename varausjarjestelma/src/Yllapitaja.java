
//TODO testaa!
public class Yllapitaja extends Kayttaja {

	//testaukseen
	private boolean verbose = true;

	public Yllapitaja(String nimi, String salasana, String kayttajanimi){		
		super(nimi, salasana, kayttajanimi);		
		if(verbose){System.out.println("Luokka: Yllapitaja : Konstruktori");}
	}

	public boolean onkoAsiakas(){
		if(verbose){System.out.println("Luokka: Yllapitaja : onkoAsiakas()");}

		return false;
	}
	public boolean onkoYllapitaja(){
		if(verbose){System.out.println("Luokka: Yllapitaja : onkoYllapitaja()");}

		return true;
	}

}


