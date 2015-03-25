

import java.util.Calendar;
import java.util.GregorianCalendar;




public class Naytos{
	private boolean verbose = true;

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
	public Naytos(int vuosi, int kuukausi, int paiva, String[][] istumapaikat, int sali, Teatteri teatteri, Elokuva elokuva, int aika){		
		if(verbose){System.out.println("Luokka: Naytos : konstruktori");}

		pvm = new GregorianCalendar();
		pvm.set(vuosi, kuukausi, paiva);
		
	
		this.istumapaikat = istumapaikat;
		this.salinumero = sali;
		this.teatteri = teatteri;
		this.elokuva = elokuva;
		this.aika = aika;
	}

	public Naytos(){
		
	}


	

	//getterit & setterit
	//----------------------------------------------------------------------------------------

	
	/**
	 * Palauttaa esityksen päivämäärän.
	 * käsittely muodossa: olio.annaPvm().get(Calendar.*haluttumääre*) - määre= DATE/MONTH/YEAR
	 * @return Calendar pvm
	 */
	public Calendar annaPvm(){
		if(verbose){System.out.println("Luokka: Naytos : annaPvm()");}

		return pvm;
	}
	
	/**
	 * Palauttaa teatterin jossa näytös on
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
	 * Palauttaa näytöksien kellonajat
	 * Näytöksien ajankohdat ovat: 1-10:00 - 2-13:00 - 3-16:00 - 4-19:00 - 5-22:00
	 * @return int kellonaika (tunti). Mikäli aika virheellinen palauttaa arvon -1
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
	 * Palauttaa näytöksien näytöspaikat, 1-5
	 * @return int aika
	 */
	public int annaNaytosPaikka(){
		if(verbose){System.out.println("Luokka: Naytos : annaNaytosPaikka()");}
		
		return aika;
	}
	
	/**
	 * palauttaa näytöksessä pyörivän elokuvan
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
		
		return "Päivämäärä: " +pvm.get(Calendar.DATE)
			+"."+pvm.get(Calendar.MONTH)
			+"."+pvm.get(Calendar.YEAR)
			+"\nPaikka: "+teatteri.annaSali(salinumero).toString()
			+"\nElokuva: "+elokuva.toString()
			+"\nKlo: "+annaAika();
	}
	
	




}



