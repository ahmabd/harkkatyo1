
public class Kayttaja {
	//testaukseen
	private boolean verbose = true;
	
	private String nimi;
	private String salasana;
	private String kayttajanimi;
	
	public Kayttaja(String nimi, String salasana, String kayttajanimi){
		if(verbose){System.out.println("Luokka: Kayttaja : Konstruktori");}
		
		this.nimi = nimi;
		this.salasana = salasana;
		this.kayttajanimi = kayttajanimi;
	}
	
	//----------------------------------------------------------------------------------------
	//getterit ja setterit
	
	public String annaNimi(){
		if(verbose){System.out.println("Luokka: Kayttaja : annaNimi()");}

		return nimi;
	}
	public String annaSalasana(){
		if(verbose){System.out.println("Luokka: Kayttaja : annaSalasana()");}

		return salasana;
	}
	public String annaKayttajanimi(){
		if(verbose){System.out.println("Luokka: Kayttaja : annaKayttajanimi()");}

		return kayttajanimi;
	}
	
	public void asetaNimi(String nimi){
		if(verbose){System.out.println("Luokka: Kayttaja : asetaNimi()");}

		this.nimi = nimi;
	}
	public void asetaSalasana(String salasana){
		if(verbose){System.out.println("Luokka: Kayttaja : asetaSalasana()");}

		this.salasana = salasana;
	}
	public void asetaKayttajanimi(String kayttajanimi){
		if(verbose){System.out.println("Luokka: Kayttaja : asetaKayttajanimi()");}

		this.kayttajanimi = kayttajanimi;
	}

}
