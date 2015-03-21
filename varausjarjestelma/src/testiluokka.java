import java.util.Scanner;


public class testiluokka {
	
	//nopeuttamaan kirjoittamista
	public static void print(String s){
		System.out.println(s);
	}
	
	public static void main(String[] args){
		
		print("Hello World, this is Testiluokka \n\n");
		
		//Elokuva-testi
		//konstruktori
		print("Luodaan Elokuva-olio 'elokuva'. Nimi= Hessu Hermanni. Kesto 123 min\n ");		
		Elokuva elokuva = new Elokuva("hessu",123);
		print("Elokuva luotu");
		//getterit
		print("Nimi : "+elokuva.annaNimi()+" ja kesto: "+elokuva.annaKesto());
		//setterit
		print("muokataan nimeksi Aku ankka ja kestoksi 30 min");
		elokuva.asetaNimi("Aku Ankka");
		elokuva.asetaKesto(30);
		//toString
		print("uusi nimi: "+elokuva.toString());
		
		
	
		
		
	}
	

}
