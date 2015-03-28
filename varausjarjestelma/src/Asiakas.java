
//TODO testaa!
public class Asiakas extends Kayttaja {

	//testaukseen
	private boolean verbose = true;
	
	


	public Asiakas(String nimi, String salasana, String kayttajanimi){
		super(nimi, salasana, kayttajanimi);	
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

}
