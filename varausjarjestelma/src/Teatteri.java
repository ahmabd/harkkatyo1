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
	 * Palauttaa kaikki elokuvat
	 * @return ArrayList<Elokuva>
	 */
	public ArrayList<Elokuva> annaElokuvat(){
		if(verbose){System.out.println("Luokka: Teatteri : annaElokuvat()");}
		
		ArrayList<Elokuva> elokuvat = new ArrayList<Elokuva>();
		ArrayList<Naytos> naytokset = annaNaytokset();
		Elokuva elokuva;
		//iteroidaan naytokset-lista l‰pi ja lis‰t‰‰n elokuvat listaan Elokuva-oliot, kuitenkin poistaen dublikaatit
		for(int i=0; i<naytokset.size(); i++){
			elokuva = naytokset.get(i).annaElokuva();
		
			//tarkistaa onko elokuva jo lis‰tty
			if(loytyykoElokuva(elokuva, elokuvat) == false){
				elokuvat.add(elokuva);
			}
		}
		return elokuvat;
	}
	
	/**
	 * tarkistaa onko elokuva jo lis‰tty listaan
	 * @param elokuva : Elokuva
	 * @param elokuvat : ArrayList<Elokuva>
	 * @return boolean
	 */
	private boolean loytyykoElokuva(Elokuva elokuva, ArrayList<Elokuva> elokuvat){
		if(verbose){System.out.println("Luokka: Teatteri : loytyykoElokuva()");}
		
		//jos elokuva jo listassa, palauttaa true
		for(int i=0; i<elokuvat.size(); i++){
			
			if(elokuva.equals(elokuvat.get(i))){
				if(verbose){System.out.println("Luokka: Teatteri : loytyykoElokuva() - elokuva jo listassa!");}
				return true;
			}
		}
		if(verbose){System.out.println("Luokka: Teatteri : loytyykoElokuva() - elokuvaa ei listassa");}
		return false;
	}
	/**
	 * palauttaa kaikki teatterin n‰ytˆkset
	 * @return ArrayList<Naytos>
	 */
	public ArrayList<Naytos> annaNaytokset(){
		if(verbose){System.out.println("Luokka: Teatteri : annaNaytokset()");}
		//iteroi kaikkien salien kaikki elokuvat l‰pi ja lis‰‰ palautettavaan listaan
		
		ArrayList<Naytos> naytokset = new ArrayList<Naytos>();
		for(int i=0; i<salit.size(); i++){
			naytokset.addAll(salit.get(i).annaNaytokset());
		}
		
		return naytokset;
		
	}
	/**
	 * Poistaa salin tietyst‰ paikasta. Ei muokkaa muiden salien ID-numeroita.
	 * @param salinumero
	 */
	public void poistaSali(int salinumero){
		if(verbose){System.out.println("Luokka: Teatteri : poistaSali() - int: "+salinumero);}

		salit.remove(salinumero-1);

	}
	/**
	 * Lis‰‰ uuden salin muiden per‰‰n
	 * @param rivit
	 * @param sarakkeet
	 */
	public void lisaaSali(int rivit, int sarakkeet){
		if(verbose){System.out.println("Luokka: Teatteri : lisaaSali()");}

		salit.add(new Sali(salit.size()+1, rivit, sarakkeet, nimi, paikkakunta));

	}

	/**
	 * Lis‰‰ salin tiettyyn kohtaan listaa. Tarkistaa dublikaatit, jos lˆytyy palauttaa false
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
		//laittaa pilkut salien v‰liin niin ettei viimeisen j‰lkeen en‰‰ tule :D 
		for(int i=0; i<salit.size(); i++){
			a = a+salit.get(i).annaSalinumero();
			if(i<salit.size()-1){
				a = a+",";
			}
		}

		return a;
	}
}
