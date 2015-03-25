
import java.util.ArrayList;




public class Sali {
	//testaukseen
	private boolean verbose = true;
	private boolean tulostapaikat = false;

	private int salinumero;
	//null -> vapaa, varausnumero -> varattu
	private String[][] istumapaikat;
	private String  teatterinNimi;
	private String teatterinPaikkakunta;
	private ArrayList<ArrayList<Naytos>> naytokset;
	//onko katsomon koko määrittämättä
	boolean kesken;

	//konstruktori
	/**
	 * Konstruktori
	 * @param salinumero : int
	 * @param rivit : int
	 * @param sarakkeet : int
	 * @param teatterinNimi : String
	 * @param teatterinPaikkakunta : String
	 */
	public Sali(int salinumero, int rivit, int sarakkeet, String teatterinNimi, String teatterinPaikkakunta){
		if(verbose){System.out.println("Luokka: Sali : konstruktori");}

		this.salinumero=salinumero;
		this.teatterinNimi = teatterinNimi;
		this.teatterinPaikkakunta = teatterinPaikkakunta;
		istumapaikat = new String[rivit][sarakkeet];

		//tarkistaa onko salin muokkaus vielä kesken
		if(rivit == 1 && sarakkeet == 1){
			kesken = true;
		}else{
			kesken = false;
		}
		alustaPaikat();
		alustaNaytokset();

	}


	//getterit ja setterit
	//------------------------------------------------------------

	/**
	 * palauttaa salinumeron
	 * @return : Int
	 */
	public int annaSalinumero(){
		if(verbose){System.out.println("Luokka: Sali : annaSalinumero()");}
		return salinumero;
	}
	/**
	 * palauttaa teatterin nimen
	 * @return : String
	 */
	public String annaTeatterinNimi(){
		if(verbose){System.out.println("Luokka: Sali : annaTeatterinNimi()");}
		return teatterinNimi;
	}

	/**
	 * palauttaa teatterin paikkakunnan
	 * @return : String
	 */
	public String annaTeatterinPaikkakunta(){
		if(verbose){System.out.println("Luokka: Sali : annaTeatterinPaikkakunta()");}
		return teatterinPaikkakunta;
	}

	/**
	 * palauttaa salin istumapaikat
	 * @return : String[][]
	 */
	public String[][] annaIstumapaikat(){
		if(verbose){System.out.println("Luokka: Sali : annaIstumapaikat()");}
		return istumapaikat;
	}

	/** TODO testaa!
	 * palauttaa kaikki salin näytökset
	 * @return ArrayList<Naytos>[]
	 */
	public ArrayList<ArrayList<Naytos>> annaKaikkiNaytokset(){
		if(verbose){System.out.println("Luokka: Sali : annaIstumapaikat()");}
		return naytokset;
	}

	/** TODO testaa! 
	 * palauttaa tietyn kellonajan näyökset, 1= klo 10, 2= klo 13, 3= klo 16, 4= klo 19, 5= klo 22
	 * @param kellonaika
	 * @return ArrayList<Naytos> tai null mikäli kellonaika ei ole 1-5
	 */
	public ArrayList<Naytos> annaNaytokset(int kellonaika){
		if(verbose){System.out.println("Luokka: Sali : annaNaytokset()");}

		if(kellonaika > 0 && kellonaika <6){
			return naytokset.get(kellonaika-1);
		}else{
			return null;
		}
	}

	/**
	 * Asettaa salin koon halutun kokoiseksi istumapaikkojen suhteen
	 * @param rivit
	 * @param sarakkeet
	 */
	public void asetaSalinKoko(int rivit, int sarakkeet){
		if(verbose){System.out.println("Luokka: Sali : asetaSalinKoko()");}
		istumapaikat = new String[rivit][sarakkeet];
		alustaPaikat();
	}



	//------------------------------------------------------------

	/**
	 * TODO tee! 
	 */
	public boolean  lisaaNaytos(Naytos naytos){
		if(verbose){System.out.println("Luokka: Sali : lisaaNaytos()");}

		//kertoo voidaanko esitys lisätä
		boolean voidaanLisata = true;
		//tarkastetaan onko samana päivänä samaan aikaan jo näytös. naytokset : ArrayList<ArrayList<Naytos>> : *näytöspaikat*<*samanaikaisetnäytökset*>
		int naytosPaikka = naytos.annaNaytosPaikka();
		
		for(int i=0; i<naytokset.get(naytosPaikka-1).size(); i++){
			//jos näytöspaikka ei ole tyhjä ja näytöspaikan näytöksistä jollain on sama päivämäärä
			if(naytokset.get(naytosPaikka-1).get(i) != null && naytokset.get(naytosPaikka-1).get(i).annaPvm() == naytos.annaPvm()){
				if(verbose){System.out.println("Luokka: Sali : lisaaNaytos() - salissa on jo näytös samaan aikaan-> ei voida lisätä!");}
				//ei voida lisätä
				voidaanLisata = false;
				break;
			}
		}
		if(voidaanLisata){		
			naytokset.get(naytosPaikka-1).add(naytos);
			return true;
		}
		return false;		
	}
	/**
	 * Alustaa näytöspaikat ArrayList<Naytos> olioilla
	 */
	private void alustaNaytokset(){
		if(verbose){System.out.println("Luokka: Sali : alustaNaytokset()");}

		naytokset = new ArrayList<ArrayList<Naytos>>();
		for(int i=0; i<5; i++){
			naytokset.add(new ArrayList<Naytos>());

		}
	}

	public boolean onkoKesken(){
		if(verbose){System.out.println("Luokka: Sali : onkoKesken()");}
		return kesken;
	}
	/**
	 * Alustaa istumapaikat arvoilla null (=vapaa)
	 * @param istumapaikat
	 */
	private void alustaPaikat(){
		if(verbose){System.out.println("Luokka: Sali : alustaPaikat()");}

		int rivi = istumapaikat.length;
		int sarake = istumapaikat[0].length;		

		for(int i=0; i<rivi; i++){
			for(int j=0; j<sarake; j++){
				istumapaikat[i][j] = null;				
			}		
		}

		if(tulostapaikat){tulostaPaikat();}
	}

	/** TESTAUKSEEN
	 * Tulostaa istumapaikat ja arvot
	 * @param istumapaikat
	 */
	public void tulostaPaikat(){
		if(verbose){System.out.println("Luokka: Sali : tulostaPaikat()");}

		int rivi = istumapaikat.length;
		int sarake = istumapaikat[0].length;
		for(int j=0; j<sarake; j++){
			System.out.print("-------");
		}
		System.out.println("");
		for(int i=0; i<rivi; i++){

			System.out.print("|");
			for(int j=0; j<sarake; j++){
				System.out.print(" " +istumapaikat[i][j]+" |");
			}
			System.out.println("");
			for(int j=0; j<sarake; j++){
				System.out.print("-------");
			}
			System.out.println("");
		}

	}

	public String toString(){
		if(verbose){System.out.println("Luokka: Sali : toString()");}
		return("Salinumero: "+salinumero+
				", Teatterin nimi: "+teatterinNimi+
				", Teatterin paikkakunta: "+teatterinPaikkakunta+
				", salin koko: "+istumapaikat.length+ " x "+istumapaikat[0].length);
	}
}
