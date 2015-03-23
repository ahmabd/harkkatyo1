import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * Lis‰‰ informaatiota ohjelman toiminnasta saa kun vaihtaa luokkien verbose-muuttujat arvoksi true!
 * lis‰ksi salipaikat tulostetaan aina jos Sali-luokan tulostapaikat-muuttujan arvo on true.
 */
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
		Elokuva elokuva = new Elokuva("Hessu Hermanni",123);
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
		print("muokataan teatterin nimeksi: Ikituuri, paikkakunnaksi Nummi sek‰ salim‰‰r‰ksi 3");
		teatteri1.asetaNimi("Ikituuri");
		teatteri1.asetaPaikkakunta("Nummi");
		teatteri1.asetaSalimaara(3);
		print("uudet tiedot: " +teatteri1.toString());
		//lis‰t‰‰n sali
		print("lis‰t‰‰n uusi sali muiden lis‰ksi. Katsomo 10 x 10");
		teatteri1.lisaaSali(10,10);		
		print("teatterin tiedot: "+teatteri1.toString());
		//poistetaan sali
		print("poistetaan sali numero 2");
		teatteri1.poistaSali(2);
		salit = teatteri1.annaSalit();		
		print("teatterin tiedot: "+teatteri1.toString());
		print("lis‰t‰‰n sali id:ll‰ 3, Katsomo 10x10");
		if(teatteri1.lisaaSali(3, 10, 10) == false){
			print("Ei voitu lis‰t‰, sali jo olemassa!");
		}
		print("teatterin tiedot: "+teatteri1.toString());
		print("lis‰t‰‰n sali id:ll‰ 2, Katsomo 10 x 20");
		if(teatteri1.lisaaSali(2, 10, 20) == false){
			print("Ei voitu lis‰t‰, sali jo olemassa!");
		}else{print("Sali lis‰tty!");}
		salit = teatteri1.annaSalit();		
		print("teatterin tiedot: "+teatteri1.toString());
		
		//--------------------------------------------------------------------------------------------
		
		//Sali-testi
		//Konstruktori
		print("\nLuodaan uusi sali teatteri1:lle. katsomo 7 x 10");
		teatteri1.lisaaSali(7, 10);
		System.out.println("Uuden salin numero: "+teatteri1.annaSali(teatteri1.annaSalit().size()).annaSalinumero());
		//getterit
		print("Sali on teatterissa: "+ teatteri1.annaSali(5).annaTeatterinNimi()+", paikkakunnalla: "+teatteri1.annaSali(5).annaTeatterinPaikkakunta());
		print("Salin istumapaikat: ");
		//paikkatulostus
		teatteri1.annaSali(5).tulostaPaikat();
		print("teatteri1:n kaikkien salien paikat:");
		for(int i=0; i<teatteri1.annaSalit().size(); i++){
			System.out.println(teatteri1.annaSali(i+1).annaSalinumero()+": ");
			teatteri1.annaSali(i+1).tulostaPaikat();
		}
		//onkoKesken()
		print("valmiita saleja: ");
		for(int i=0; i<teatteri1.annaSalit().size();i++){
			if(teatteri1.annaSali(i+1).onkoKesken()){
			}else{
				System.out.println(teatteri1.annaSali(i+1).annaSalinumero());
			}
		}
		print("keskener‰isi‰ saleja: ");
		ArrayList<Sali> kesken = new ArrayList<Sali>();
		for(int i=0; i<teatteri1.annaSalit().size();i++){
			if(teatteri1.annaSali(i+1).onkoKesken()){
				System.out.println(teatteri1.annaSali(i+1).annaSalinumero());
				kesken.add(teatteri1.annaSali(i+1));
			}
		}
		//asetaSalinKoko
		print("asetetaan keskener‰isiin saleihin koot. ensimm‰inen 5x5, seuraavat aina yhden isompia");
		for(int i=0; i<kesken.size();i++){
			System.out.println("Sali numero: "+kesken.get(i).annaSalinumero());
			kesken.get(i).asetaSalinKoko(5+i, 5+i);
			kesken.get(i).tulostaPaikat();			
		}		
		print("teatteri1:n kaikkien salien paikat:");
		for(int i=0; i<teatteri1.annaSalit().size(); i++){
			System.out.println(teatteri1.annaSali(i+1).annaSalinumero()+": ");
			teatteri1.annaSali(i+1).tulostaPaikat();
		}
		//toString
		print("Teatteri1:n ja sen salien tiedot:");
		print(teatteri1.toString());
		for(int i=0; i<teatteri1.annaSalit().size();i++){
			print(teatteri1.annaSali(i+1).toString());
		}
	
		
		
		//N‰ytˆs-testi
		//konstruktori
		//print("Luodaan Naytos-olio 'naytos'")
		
	
		
		
	}
	

}
