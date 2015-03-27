import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * Lisää informaatiota ohjelman toiminnasta saa kun vaihtaa luokkien verbose-muuttujat arvoksi true!
 * lisäksi salipaikat tulostetaan aina jos Sali-luokan tulostapaikat-muuttujan arvo on true.
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
		print("\nLuodaan Teatteri-olio 'teatteri1'. Nimi = Jouvillage, paikkakunta = Turku, salien lukumäärä = 4\n");
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
		print("muokataan teatterin nimeksi: Ikituuri, paikkakunnaksi Nummi sekä salimääräksi 3");
		teatteri1.asetaNimi("Ikituuri");
		teatteri1.asetaPaikkakunta("Nummi");
		teatteri1.asetaSalimaara(3);
		print("uudet tiedot: " +teatteri1.toString());
		//lisätään sali
		print("lisätään uusi sali muiden lisäksi. Katsomo 10 x 10");
		teatteri1.lisaaSali(10,10);		
		print("teatterin tiedot: "+teatteri1.toString());
		//poistetaan sali
		print("poistetaan sali numero 2");
		teatteri1.poistaSali(2);
		salit = teatteri1.annaSalit();		
		print("teatterin tiedot: "+teatteri1.toString());
		print("lisätään sali id:llä 3, Katsomo 10x10");
		if(teatteri1.lisaaSali(3, 10, 10) == false){
			print("Ei voitu lisätä, sali jo olemassa!");
		}
		print("teatterin tiedot: "+teatteri1.toString());
		print("lisätään sali id:llä 2, Katsomo 10 x 20");
		if(teatteri1.lisaaSali(2, 10, 20) == false){
			print("Ei voitu lisätä, sali jo olemassa!");
		}else{print("Sali lisätty!");}
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
		print("keskeneräisiä saleja: ");
		ArrayList<Sali> kesken = new ArrayList<Sali>();
		for(int i=0; i<teatteri1.annaSalit().size();i++){
			if(teatteri1.annaSali(i+1).onkoKesken()){
				System.out.println(teatteri1.annaSali(i+1).annaSalinumero());
				kesken.add(teatteri1.annaSali(i+1));
			}
		}
		//asetaSalinKoko
		print("asetetaan keskeneräisiin saleihin koot. ensimmäinen 5x5, seuraavat aina yhden isompia");
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
		
		//-----------------------------------------------------------------------------------------		
		
		//Näytös-testi
		
		boolean lisays;
		
		//konstruktori
		//näytöksien ajankohdat ovat: 1-10:00 - 2-13:00 - 3-16:00 - 4-19:00 - 5-22:00
		print("\nLuodaan Naytos-olio 'naytos', teatteri1:n saliin no 3 kello 10. Pvm = 24.3.2015. Elokuvana on 'Hessu Hermanni'");
		Naytos naytos = new Naytos(2015, 3, 24, 3, teatteri1, elokuva, 1 );
		//getterit
		print("näytöksen tiedot ovat: ");
		print("Päivämäärä: " +naytos.annaPvm().get(Calendar.DATE)
				+"."+naytos.annaPvm().get(Calendar.MONTH)
				+"."+naytos.annaPvm().get(Calendar.YEAR));
		print("näytös on teatterissa: \n"+naytos.annaTeatteri().toString());
		print("näytös on salissa: "+naytos.annaSali());
		print("näytös alkaa klo: "+naytos.annaAika());
		print("elokuvana on: "+elokuva.toString());
		//tulostapaikat
		print("varaustilanne on: " );
		naytos.tulostaPaikat();
		print("naytoksen tiedot kootusti: ");
		print(naytos.toString());
		
		//SALI-luokan lisääNäytös - metodi
		print("lisätään näytös teatteri1:n sali 3:n tietoihin");
		lisays = teatteri1.annaSali(3).lisaaNaytos(naytos);
		lisays = teatteri1.annaSali(3).lisaaNaytos(naytos);
		
		print("\nLuodaan toinne elokuva. Nimi: Hessu Hopo ja kesto 120 min");
		Elokuva elokuva2 = new Elokuva("Hessu Hopo", 120);
		print("Elokuvan tiedot: "+ elokuva2.toString());
		print("Koitetaan luoda uusi näytös uudesta elokuvasta saliin no 3 klo 10 pvm 24.3. ja 27.3.2015");
		//naytos2
		Naytos naytos2 = new Naytos(2015, 3, 25, 3, teatteri1, elokuva2, 1);
		lisays = teatteri1.annaSali(3).lisaaNaytos(naytos2);
		
		//----------------------------------------------------------------------------------
		print("luodaan joukko uusia elokuvia ja lisataan teatteri1:n saleihin");
		print("\nelokuva3");
		Elokuva elokuva3 = new Elokuva("Iso Arska", 125);
		print(elokuva3.toString());
		teatteri1.annaSali(1).lisaaNaytos(new Naytos(2015, 3, 20, 1, teatteri1, elokuva3, 1));
		teatteri1.annaSali(2).lisaaNaytos(new Naytos(2015, 3, 20, 2, teatteri1, elokuva3, 1));
		teatteri1.annaSali(3).lisaaNaytos(new Naytos(2015, 3, 20, 3, teatteri1, elokuva3, 1));
		teatteri1.annaSali(4).lisaaNaytos(new Naytos(2015, 3, 20, 4, teatteri1, elokuva3, 1));
		teatteri1.annaSali(5).lisaaNaytos(new Naytos(2015, 3, 20, 5, teatteri1, elokuva3, 1));
		
		print("\nelokuva4");
		Elokuva elokuva4 = new Elokuva("Iso Arska2", 125);
		print(elokuva4.toString());
		teatteri1.annaSali(1).lisaaNaytos(new Naytos(2015, 3, 21, 1, teatteri1, elokuva4, 1));
		
		print("\nelokuva5");
		Elokuva elokuva5 = new Elokuva("Iso Arska3", 125);
		print(elokuva5.toString());
		naytos = new Naytos(2015, 3, 22, 1, teatteri1, elokuva5, 1);
		teatteri1.annaSali(1).lisaaNaytos(naytos);
		
		print("\nelokuva6");
		Elokuva elokuva6 = new Elokuva("Iso Arska4", 125);
		print(elokuva6.toString());
		teatteri1.annaSali(1).lisaaNaytos(new Naytos(2015, 3, 23, 1, teatteri1, elokuva6, 1));
		
		print("\nelokuva7");
		Elokuva elokuva7 = new Elokuva("Iso Arska5", 125);
		print(elokuva7.toString());
		teatteri1.annaSali(1).lisaaNaytos(new Naytos(2015, 3, 24, 1, teatteri1, elokuva7, 1));
		
		print("\nelokuva8");
		Elokuva elokuva8 = new Elokuva("Iso Arska6", 125);
		print(elokuva8.toString());
		teatteri1.annaSali(1).lisaaNaytos(new Naytos(2015, 3, 25, 1, teatteri1, elokuva8, 1));
		
		//Teatteri- anna näytökset
		print("\nKaikki pyörivät elokuvat:");
		ArrayList<Elokuva> elokuvat1 = teatteri1.annaElokuvat();
		printtaaElokuvat(elokuvat1);
	
		//Teatteri - annaNaytokset
		print("Kaikki pyörivät näytökset");
		ArrayList<Naytos> naytokset1 = teatteri1.annaNaytokset();
		printtaaNaytokset(naytokset1);
	
	
	}
	/**
	 * printtaa kaikki näytökset
	 * @param naytokset
	 */
	public static void printtaaNaytokset(ArrayList<Naytos> naytokset){
		for(int i=0; i<naytokset.size(); i++){
			print(naytokset.get(i).toString());
		}
	}
	/**
	 * printtaa kaikki elokuvat
	 * @param elokuvat
	 */
	public static void printtaaElokuvat(ArrayList<Elokuva> elokuvat){
		for(int i=0; i<elokuvat.size(); i++){
			print(elokuvat.get(i).toString());
		}
	}
	
	/**
	 * Ilmoittaa onnistuiko esityksen lisääminen tiettyyn saliin tietylle paikalle
	 * @param lisays
	 */
	public static void onnistuiko(boolean lisays){
		if(lisays){
			print("Lisäys onnistui!");
		}else{
			print("lisäys ei onnistunut, salissa jo näytös samaan aikaan!");
		}
	}
	
	public static void tulostaNaytokset(ArrayList<Naytos> naytokset){
		for(int i=0; i<naytokset.size(); i++){
			print(naytokset.get(i).toString());
		}
	}

}
