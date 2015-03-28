
public class Elokuva{

	private String nimi;
	//minuuteissa
	private int kesto;
	//testaukseen
	private boolean verbose = false;

	//konstruktori
	public Elokuva(String nimi, int kesto){
		if(verbose){System.out.println("Luokka: Elokuva : konstruktori -String:"+nimi+" - int:"+kesto);
		}
		this.nimi = nimi;
		this.kesto = kesto;
	}
	//----------------------------------
	//setterit & getterit
	public String annaNimi(){
		if(verbose){System.out.println("Luokka: Elokuva : annaNimi()");}
		return nimi;
	}

	public int annaKesto(){
		if(verbose){System.out.println("Luokka: Elokuva : annaKesto()");}	

		return kesto;
	}

	public void asetaNimi(String nimi){
		if(verbose){System.out.println("Luokka: Elokuva : asetaNimi() - String:"+nimi);}
		this.nimi = nimi;
	}

	public void asetaKesto(int kesto){
		if(verbose){System.out.println("Luokka: Elokuva : asetaKesto() - int:"+kesto);}
		this.kesto = kesto;
	}
	//-----------------------------------------

	public String toString(){
		if(verbose){System.out.println("Luokka: Elokuva : toString()");}
		return("Nimi: " + nimi + ", Kesto: " + kesto);		
	}

	public boolean equals(Elokuva verrattava){
		if(verbose){System.out.println("Luokka: Elokuva : equals()");}

		//jos kaikki attribuutit t‰sm‰‰v‰t, palauttaa true
		if(nimi.equals(verrattava.annaNimi()) &&
				kesto == verrattava.annaKesto()){
			if(verbose){System.out.println("Luokka: Elokuva : equals() - verrattava sama!");}
			return true;
		}

		if(verbose){System.out.println("Luokka: Elokuva : equals() - verrattava eri!");}
		return false;
	}
}
