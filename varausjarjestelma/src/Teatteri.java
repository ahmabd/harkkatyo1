import java.util.ArrayList;


public class Teatteri {
	//testaukseen
	private boolean verbose = false;

	private String nimi;
	private String paikkakunta;
	private ArrayList<Sali> salit;

	//konstruktori
	public Teatteri(String nimi, String paikkakunta, int salimaara){
		if(verbose){System.out.println("Luokka: Teatteri : konstruktori - String: "+nimi+" - String: "
				+paikkakunta+" - int: "+salimaara);}

		this.nimi = nimi;
		this.paikkakunta = paikkakunta;
		
		

		//luodaan salit teatterille		
		alustaSalit(salimaara);

	}

	//setterit ja getterit
	//--------------------------------------------------------------

	public String annaNimi(){
		if(verbose){System.out.println("Luokka: Teatteri : annaNimi()");}

		return nimi;
	}

	public String annaPaikkakunta(){
		if(verbose){System.out.println("Luokka: Teatteri : annaPaikkakunta()");}

		return paikkakunta;
	}

	public ArrayList<Sali> annaSalit(){
		if(verbose){System.out.println("Luokka: Teatteri : annaSalit()");}

		return salit;
	}

	/**
	 *palauttaa tietyn salin
	 * @param salinumero
	 * @return Sali 
	 */
	public Sali annaSali(int salinumero){
		return salit.get(salinumero-1);
	}

	public void asetaNimi(String nimi){
		if(verbose){System.out.println("Luokka: Teatteri : asetaNimi() - String: "+nimi);}

		this.nimi = nimi;
	}

	public void asetaPaikkakunta(String paikkakunta){
		if(verbose){System.out.println("Luokka: Teatteri : asetaPaikkakunta() - String: "+paikkakunta);}

		this.paikkakunta = paikkakunta;
	}

	/**
	 * asettaa teatteriin salit kokonaan uusilla Sali-olioilla
	 * @param salimaara
	 */
	public void asetaSalimaara(int salimaara){
		if(verbose){System.out.println("Luokka: Teatteri : asetaSalimaara() - int: "+salimaara);}

		//salit = new ArrayList<Sali>(salimaara);
		alustaSalit(salimaara);
	}
	//----------------------------------------------------------------

	/**
	 * Poistaa salin tietystä paikasta. Ei muokkaa muiden salien ID-numeroita.
	 * @param salinumero
	 */
	public void poistaSali(int salinumero){
		if(verbose){System.out.println("Luokka: Teatteri : poistaSali() - int: "+salinumero);}

		salit.remove(salinumero-1);

	}
	/**
	 * Lisää uuden salin muiden perään
	 * @param rivit
	 * @param sarakkeet
	 */
	public void lisaaSali(int rivit, int sarakkeet){
		if(verbose){System.out.println("Luokka: Teatteri : lisaaSali()");}

		salit.add(new Sali(salit.size()+1, rivit, sarakkeet, nimi, paikkakunta));

	}

	/**
	 * Lisää salin tiettyyn kohtaan listaa. Tarkistaa dublikaatit, jos löytyy palauttaa false
	 * @param salinumero : int
	 * @param rivit : int
	 * @param sarakkeet : int
	 * @return boolean
	 */
	public boolean lisaaSali(int salinumero, int rivit, int sarakkeet){
		if(verbose){System.out.println("Luokka: Teatteri : lisaaSali() - int: "+salinumero);}

		//tarkistaa ettei tule dublikaatteja
		for(int i=0; i<salit.size(); i++){
			if(salit.get(i).annaSalinumero() == salinumero){
				return false;
			}
		}		
		salit.add(salinumero-1, new Sali(salinumero, rivit, sarakkeet, nimi, paikkakunta));
		return true;
	}

	/**
	 * poistaa vanhat salit ja alustaa uusilla saleilla. Asettaa katsomoksi 1x1
	 * @param salimaara
	 */
	private void alustaSalit(int salimaara){
		if(verbose){System.out.println("Luokka: Teatteri : alustaSalit() - int: "+salimaara);}
		salit = new ArrayList<Sali>();
		for(int i = 0 ; i< salimaara; i++){
			salit.add(new Sali(i+1,1,1,nimi, paikkakunta));
		}
	}

	public String toString(){
		if(verbose){System.out.println("Luokka: Teatteri : toString()");}

		String a = ("Nimi: "+ nimi
				+", Paikkakunta: "+paikkakunta
				+", Salit: ");
		//laittaa pilkut salien väliin niin ettei viimeisen jälkeen enää tule :D 
		for(int i=0; i<salit.size(); i++){
			a = a+salit.get(i).annaSalinumero();
			if(i<salit.size()-1){
				a = a+",";
			}
		}

		return a;
	}
}
