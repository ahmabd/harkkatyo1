
import java.util.ArrayList;
import java.util.Calendar;




public class Sali {
	//testaukseen
	private boolean verbose = false;
	private boolean tulostapaikat = false;

	private int salinumero;
	//null -> vapaa, varausnumero -> varattu
	private String[][] istumapaikat;
	private String  teatterinNimi;
	private String teatterinPaikkakunta;
	private ArrayList<ArrayList<Naytos>> naytokset;
	//onko katsomon koko m��ritt�m�tt�
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

		//tarkistaa onko salin muokkaus viel� kesken
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
	 * palauttaa kaikki salin n�yt�kset
	 * @return ArrayList<Naytos>[]
	 */
	public ArrayList<ArrayList<Naytos>> annaKaikkiNaytokset(){
		if(verbose){System.out.println("Luokka: Sali : annaIstumapaikat()");}
		return naytokset;
	}

	/** TODO testaa! 
	 * palauttaa tietyn kellonajan n�y�kset, 1= klo 10, 2= klo 13, 3= klo 16, 4= klo 19, 5= klo 22
	 * @param kellonaika
	 * @return ArrayList<Naytos> tai null mik�li kellonaika ei ole 1-5
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

	/**TODO miksei toimi? - ei k�y n�yt�ksi� l�pi? 
	 * palauttaa kaikki salin n�yt�kset
	 * @return ArrayList<Naytos>
	 */
	public ArrayList<Naytos> annaNaytokset(){
		if(verbose){System.out.println("Luokka: Sali : annaNaytokset()");}

		ArrayList<Naytos> elokuvat = new ArrayList<Naytos>();
		//k�y l�pi kaikkien n�yt�ksien elokuvat
		for(int i=0; i<naytokset.size(); i++){
			elokuvat.addAll(naytokset.get(i));

		}

		return elokuvat;
	}
	/**
	 * TODO miksei toimi?
	 * @param naytokset
	 */
	private void printtaaElokuvat(ArrayList<Naytos> naytokset){

		for(int i=0; i<naytokset.size(); i++){
			System.out.println(naytokset.get(i).toString());
		}
	}
	/**
	 * Lis�� n�yt�ksen saliin. Palauttaa booleanin true = onnistunut lis�ys, false = ep�onnistunut
	 * @param naytos : Naytos 
	 * @return boolean voidaanLisata
	 */
	public boolean  lisaaNaytos(Naytos naytos){
		if(verbose){System.out.println("Luokka: Sali : lisaaNaytos()");}

		//saman n�yt�sajan muut n�yt�kset
		int naytosPaikka = naytos.annaNaytosPaikka();		
		System.out.println("n�yt�ksen n�yt�spaikka on: "+naytosPaikka);

		//samanpaikann�yt�kset
		ArrayList<Naytos> samanPaikanNaytokset = naytokset.get(naytosPaikka-1);

		//voidaanko lis�t�
		boolean lisays = false;

		//jos n�yt�spaikassa ei ole muita n�yt�ksi�, lis�t��n n�yt�s
		if(samanPaikanNaytokset.size() == 0){
			if(verbose){System.out.println("Luokka: Sali : lisaaNaytos() - n�yt�spaikassa ei muita n�yt�ksi�!");}
			naytokset.get(naytosPaikka-1).add(naytos);
			lisays = true;
		}else{
			//on muita n�yt�ksi� -> tarkistetaan onko samana p�iv�n�
			if(verbose){System.out.println("Luokka: Sali : lisaaNaytos() - Samaan aikaan on "+samanPaikanNaytokset.size()+" muuta n�yt�st�.");}
			lisays = voidaankoLisata(naytos, samanPaikanNaytokset);

			if(lisays){

				naytokset.get(naytosPaikka-1).add(naytos);
				lisays = true;
			}
		}

		if(verbose){System.out.println("Luokka: Sali : lisaaNaytos() - boolean lisays: "+lisays);}
		return lisays;
	}

	/**
	 * tarkistaa voidaanko n�yt�s lis�t�
	 * @param naytos : Naytos
	 * @param samanPaikanNaytokset : ArrayList<Naytos>
	 * @return boolean 
	 */
	public boolean voidaankoLisata(Naytos naytos, ArrayList<Naytos> samanPaikanNaytokset){
		if(verbose){System.out.println("Luokka: Sali : voidaankoLisata()");}
		int vertailu;

		//iteroidaan ArrayList l�pi ja kutsutaan jokaisella Naytos-oliolla Naytokset compareTo - metodia. Jos palauttaa 0, p�iv�m��r� on sama ja n�yt�st� ei voida lis�t�
		for(int i=0; i<samanPaikanNaytokset.size(); i++){
			if(verbose){System.out.println("Luokka: Sali : voidaankoLisata() - vertailu saman paikan n�yt�kseen no "+ (i+1));}
			vertailu = naytos.vertaaPvm(samanPaikanNaytokset.get(i));
			//jos vertailu palauttaa arvon 0, samana p�iv�n� on jo n�yt�s
			if(vertailu == 0){
				if(verbose){System.out.println("Luokka: Sali : voidaankoLisata() - naytos on samana p�iv�n� -> ei voida lis�t�");}
				return false;
			}
		}
		return true;
	}

	/**
	 * Alustaa n�yt�spaikat ArrayList<Naytos> olioilla
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
