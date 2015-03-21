import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Testausluokka {
	
	//nopeuttamaan kirjoittamista
	public static void print(String s){
		System.out.println(s);
	}
	
	public static void main(String[] args){
		
		print("Hello World, this is Testiluokka \n\n");
		
		//Elokuva-testi
		//konstruktori
		print("Luodaan Elokuva-olio 'elokuva'. Nimi = Hessu Hermanni. Kesto = 123 min\n ");		
		Elokuva elokuva = new Elokuva("hessu",123);
		print("Elokuva luotu");
		//getterit
		print("Nimi : "+elokuva.annaNimi()+" ja kesto: "+elokuva.annaKesto());
		//setterit
		print("muokataan nimeksi Aku ankka ja kestoksi 30 min");
		elokuva.asetaNimi("Aku Ankka");
		elokuva.asetaKesto(30);
		//toString
		print("uudet tiedot: "+elokuva.toString());
		
		//----------------------------------------------------------------------------
		
		//Teatteri-testi
		//konstruktori
		print("\nLuodaan Teatteri-olio 'teatteri1'. Nimi = Jouvillage, paikkakunta = Turku, salien lukum‰‰r‰ = 4\n");
		Teatteri teatteri1 = new Teatteri("Jouvillage", "Turku", 4);
		print("Teatteri luotu");
		//getterit
		print("nimi : "+teatteri1.annaNimi()+", paikakunta : "+teatteri1.annaPaikkakunta());		
		print("Salit:");
		ArrayList<Sali> salit = teatteri1.annaSalit();		
		for(int i=0; i<salit.size(); i++){
			System.out.println(salit.get(i).annaSalinumero());
		}
		//setterit
		print("muokataan salin nimeksi: Ikituuri, paikkakunnaksi Nummi sek‰ salim‰‰r‰ksi 3");
		teatteri1.asetaNimi("Ikituuri");
		teatteri1.asetaPaikkakunta("Nummi");
		teatteri1.asetaSalimaara(3);
		print("uudet tiedot: " +teatteri1.toString());
		//lis‰t‰‰n sali
		print("lis‰t‰‰n uusi sali muiden lis‰ksi");
		teatteri1.lisaaSali();		
		print("teatterin tiedot: "+teatteri1.toString());
		//poistetaan sali
		print("poistetaan sali numero 2");
		teatteri1.poistaSali(2);
		salit = teatteri1.annaSalit();		
		print("teatterin tiedot: "+teatteri1.toString());
		print("lis‰t‰‰n sali id:ll‰ 3");
		if(teatteri1.lisaaSali(3) == false){
			print("Ei voitu lis‰t‰, sali jo olemassa!");
		}
		print("teatterin tiedot: "+teatteri1.toString());
		print("lis‰t‰‰n sali id:ll‰ 2");
		if(teatteri1.lisaaSali(2) == false){
			print("Ei voitu lis‰t‰, sali jo olemassa!");
		}else{print("Sali lis‰tty!");}
		salit = teatteri1.annaSalit();		
		print("teatterin tiedot: "+teatteri1.toString());
		
		//N‰ytˆs-testi
		//konstruktori
		//print("Luodaan Naytos-olio 'naytos'")
		
	
		
		
	}
	

}
