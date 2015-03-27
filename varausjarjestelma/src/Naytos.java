

import java.util.Calendar;
import java.util.GregorianCalendar;




public class Naytos{
	private boolean verbose = false;

	private String[][] istumapaikat;
	private Calendar pvm;

	private int salinumero;
	private Teatteri teatteri;
	private Elokuva elokuva;
	private int aika;





	/**
	 * Konstruktori
	 * @param vuosi : int
	 * @param kuukausi : int
	 * @param paiva : int
	 * @param istumapaikat : String[][]
	 * @param sali : int
	 * @param teatteri : Teatteri
	 * @param elokuva : Elokuva
	 * @param aika : int
	 */
	public Naytos(int vuosi, int kuukausi, int paiva, int sali, Teatteri teatteri, Elokuva elokuva, int aika){		
		if(verbose){System.out.println("Luokka: Naytos : konstruktori");}

		pvm = new GregorianCalendar();
		pvm.set(vuosi, kuukausi, paiva);


		this.istumapaikat = teatteri.annaSali(sali).annaIstumapaikat();
		this.salinumero = sali;
		this.teatteri = teatteri;
		this.elokuva = elokuva;
		this.aika = aika;
	}





	//getterit & setterit
	//----------------------------------------------------------------------------------------


	/**
	 * Palauttaa esityksen p�iv�m��r�n.
	 * k�sittely muodossa: olio.annaPvm().get(Calendar.*haluttum��re*) - m��re= DATE/MONTH/YEAR
	 * @return Calendar pvm
	 */
	public Calendar annaPvm(){
		if(verbose){System.out.println("Luokka: Naytos : annaPvm()");}

		return pvm;
	}

	/**
	 * Palauttaa teatterin jossa n�yt�s on
	 * @return Teatteri teatteri
	 */
	public Teatteri annaTeatteri(){
		if(verbose){System.out.println("Luokka: Naytos : annaTeatteri()");}

		return teatteri;
	}

	/**
	 * Palauttaa salinumeron jossa esitys on
	 * @return int salinumero
	 */
	public int annaSali(){
		if(verbose){System.out.println("Luokka: Naytos : annaSali()");}

		return salinumero;
	}

	/**
	 * Palauttaa n�yt�ksien kellonajat
	 * N�yt�ksien ajankohdat ovat: 1-10:00 - 2-13:00 - 3-16:00 - 4-19:00 - 5-22:00
	 * @return int kellonaika (tunti). Mik�li aika virheellinen palauttaa arvon -1
	 */
	public int annaAika(){
		if(verbose){System.out.println("Luokka: Naytos : annaAika()");}


		switch(aika){
		case 1: aika = 1;
		return 10;
		case 2: aika = 2;
		return 13;
		case 3: aika = 3;
		return 16;
		case 4: aika = 4;
		return 19;
		case 5: aika = 5;
		return 22;
		}

		return -1;


	}

	/**
	 * Palauttaa n�yt�ksien n�yt�spaikat, 1-5
	 * @return int aika
	 */
	public int annaNaytosPaikka(){
		if(verbose){System.out.println("Luokka: Naytos : annaNaytosPaikka()");}

		return aika;
	}

	/**
	 * palauttaa n�yt�ksess� py�riv�n elokuvan
	 * @return Elokuva elokuva
	 */
	public Elokuva annaElokuva(){
		if(verbose){System.out.println("Luokka: Naytos : annaElokuva()");}

		return elokuva;
	}

	public void vaihdaPvm(int vuosi, int kuukausi, int paiva){
		if(verbose){System.out.println("Luokka: Naytos : vaihdaPvm");}

		pvm.set(vuosi, kuukausi, paiva);
	}

	//-----------------------------------------------------------------------------------------

	/**TODO - Tarviiko aikaisempaa/my�hemp�� vertailua?
	 * Vertailee kahden n�yt�ksen p�iv�m��ri�. Sama = 0, verrattava aikaisemmin = -1, verrattava my�hemmin = 1
	 * @param lisattava : Naytos
	 * @return int
	 */
	public int vertaaPvm(Naytos lisattava){
		if(verbose){System.out.println("Luokka: Naytos : vertaaPvm()");}

		Calendar verrattavaPvm = lisattava.annaPvm();

		//jos on sama p�iv�, palauta 0
		if(verrattavaPvm.get(Calendar.DATE) == pvm.get(Calendar.DATE) &&
				verrattavaPvm.get(Calendar.MONTH) == pvm.get(Calendar.MONTH) &&
				verrattavaPvm.get(Calendar.YEAR) == pvm.get(Calendar.YEAR)){
			
			if(verbose){System.out.println("Luokka: Naytos : vertaaPvm() - verrattavalla naytoksella on sama pvm");}
			return 0;
		}
		if(verbose){System.out.println("Luokka: Naytos : vertaaPvm() - samana p�iv�n� ei muita esityksi�.");}
		//jos on verrattava on aikaisemmin, palauttaa -1
		
		//jos verrattava on my�hemmin, palauttaa 1
		return 1;

	}

	/**TESTAUKSEEN
	 * tulostaa paikat
	 */
	public void tulostaPaikat(){
		if(verbose){System.out.println("Luokka: Naytos : tulostaPaikat()");}

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

		return "P�iv�m��r�: " +pvm.get(Calendar.DATE)
				+"."+pvm.get(Calendar.MONTH)
				+"."+pvm.get(Calendar.YEAR)
				+"\nPaikka: "+teatteri.annaSali(salinumero).toString()
				+"\nElokuva: "+elokuva.toString()
				+"\nKlo: "+annaAika();
	}






}



