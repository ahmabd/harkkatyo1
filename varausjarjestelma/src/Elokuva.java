
public class Elokuva {

	private String nimi;
	private int kesto;
	//testaukseen
	private boolean verbose = true;

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
		return("Nimi: " + nimi + ",Kesto: " + kesto);		
	}
}
