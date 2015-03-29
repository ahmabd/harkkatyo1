

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import javax.swing.JScrollPane;

import javax.swing.JList;



public class GUI {

	//testaukseem
	private static boolean verbose = true;

	private JFrame tausta;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JPasswordField passwordField_1;

	//kayttajien tunnistamiseen
	private boolean asiakas = true;
	private boolean yllapitaja = true;
	private boolean kirjautunut = false;

	//elokuvat, teatterit ja varaukset
	private static ArrayList<Elokuva> elokuvat;
	private JList<Elokuva> elokuvaLista;
	private static ArrayList<Teatteri> teatterit;
	private JList <Teatteri> teatteriLista;
	//varaukset & kayttajat
	private static ArrayList<Kayttaja> kayttajat;
	private static ArrayList<Varaus> varaukset;
	
	//aina kayttajaa luodessa tulee lisata ID:n arvoa yhdella!!!
	private static int kayttaja_ID;

	private JPanel etusivu;
	private JPanel varaussivu;
	private JPanel kirjautumissivu;
	private JPanel hallintapaneeli;
	private JPanel kayttajanTiedot;
	
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		if(verbose){System.out.println("Luokka: GUI : main()");}
		
		// TODO - lukee tiedostoista 
		
		/*TODO tarkistus -> jos ei ole aikaisempia kirjoitettuja Teatteri-olioita ajetaan alusta - metodi
		 * Kaytannossa varmaan try(*lue filut*)catch(*ei aikaisemmin tallennettuja filuja joten alustus*)
		 * Ohjelman lopettamisen yhteydessä
		*/alusta();
		
		//TODO - seivaus
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.tausta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		if(verbose){System.out.println("Luokka: GUI : konstruktori()");}
		initialize();
		
		


	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		if(verbose){System.out.println("Luokka: GUI : initialize()");}

		//paivittaa valilehdet
		paivitaValilehdet();

		//paivittaa etusivun
		paivitaEtusivu(elokuvat, teatterit);

		//varaussivu nakyviin vain jos asiaks on kirjautunut
		if(asiakas){
			paivitaVarausSivu();
		}

		if(kirjautunut == false){
			paivitaKirjautumisSivu();
		}





	}

	public void paivitaKirjautumisSivu(){
		if(verbose){System.out.println("Luokka: GUI : paivitaKirjautumisSivu()");}

		JLabel lblKirjaudu = new JLabel("Kirjaudu:");
		lblKirjaudu.setBounds(6, 10, 75, 16);
		kirjautumissivu.add(lblKirjaudu);

		JLabel lblSalasana = new JLabel("Salasana:");
		lblSalasana.setBounds(6, 79, 61, 16);
		kirjautumissivu.add(lblSalasana);

		textField_2 = new JTextField();
		textField_2.setBounds(106, 45, 134, 28);
		kirjautumissivu.add(textField_2);
		textField_2.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(106, 73, 134, 28);
		kirjautumissivu.add(passwordField);

		JLabel lblRekisteridy = new JLabel("Rekister\u00F6idy:");
		lblRekisteridy.setBounds(6, 164, 100, 16);
		kirjautumissivu.add(lblRekisteridy);

		JLabel lblValitseKyttjnimi = new JLabel("S\u00E4hk\u00F6posti:");
		lblValitseKyttjnimi.setBounds(6, 200, 100, 16);
		kirjautumissivu.add(lblValitseKyttjnimi);

		JLabel lblUusiSalasana = new JLabel("Uusi Salasana:");
		lblUusiSalasana.setBounds(6, 228, 132, 16);
		kirjautumissivu.add(lblUusiSalasana);

		textField_3 = new JTextField();
		textField_3.setBounds(106, 194, 134, 28);
		kirjautumissivu.add(textField_3);
		textField_3.setColumns(10);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(106, 222, 134, 28);
		kirjautumissivu.add(passwordField_1);

		JLabel label_1 = new JLabel("S\u00E4hk\u00F6posti:");
		label_1.setBounds(6, 51, 100, 16);
		kirjautumissivu.add(label_1);

		JButton btnKirjaudu = new JButton("Kirjaudu");
		btnKirjaudu.setBounds(106, 113, 117, 29);
		kirjautumissivu.add(btnKirjaudu);

		JButton btnNewButton = new JButton("Rekister\u00F6idy");
		btnNewButton.setBounds(106, 261, 117, 29);
		kirjautumissivu.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 154, 289, 12);
		kirjautumissivu.add(separator);
	}
	/**
	 * Paivittaa valilehdet riippuen siitä kuka kayttaja on kyseessa
	 */
	public void paivitaValilehdet(){
		if(verbose){System.out.println("Luokka: GUI : paivitaValilehdet()");}
		
		tausta = new JFrame();
		tausta.setBounds(100, 100, 580, 500);
		tausta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tausta.getContentPane().setLayout(null);

		JLabel label = new JLabel("ICT-Elokuvateatteri");
		label.setBounds(188, 6, 185, 26);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		tausta.getContentPane().add(label);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 35, 568, 405);
		tausta.getContentPane().add(tabbedPane);

		etusivu = new JPanel();
		tabbedPane.addTab("Etusivu", null, etusivu, null);
		etusivu.setLayout(null);

		//vain jos kyseessä on asiakas
		if(asiakas == true){
			varaussivu = new JPanel();
			tabbedPane.addTab("Varaa lippuja", null, varaussivu, null);
			varaussivu.setLayout(null);
			
			kayttajanTiedot = new JPanel();
			tabbedPane.addTab("Omat tiedot", null, kayttajanTiedot, null);
			kayttajanTiedot.setLayout(null);
		}

		//vain jos kyseessä on yllapitaja
		if(yllapitaja == true){
			hallintapaneeli = new JPanel();
			tabbedPane.addTab("Hallintapaneeli", null, hallintapaneeli, null);
			hallintapaneeli.setLayout(null);
		}
		
		//vain jos kukaan ei ole vielä kirjautunut
		if(kirjautunut == false){
			kirjautumissivu = new JPanel();
			tabbedPane.addTab("Kirjaudu", null, kirjautumissivu, null);
			kirjautumissivu.setLayout(null);
		}
	}

	public void paivitaVarausSivu(){
		if(verbose){System.out.println("Luokka: GUI : paivitaVarausSivu()");}

		JLabel lblValitseTeatteri = new JLabel("Teatteri:");
		lblValitseTeatteri.setBounds(16, 52, 116, 16);
		varaussivu.add(lblValitseTeatteri);

		JLabel lblValitseElokuva = new JLabel("Elokuva:");
		lblValitseElokuva.setBounds(171, 52, 116, 16);
		varaussivu.add(lblValitseElokuva);

		JLabel lblVytsaika = new JLabel("N\u00E4yt\u00F6saika:");
		lblVytsaika.setBounds(332, 52, 116, 16);
		varaussivu.add(lblVytsaika);

		JLabel lblValitse = new JLabel("Valitse:");
		lblValitse.setBounds(16, 23, 61, 16);
		varaussivu.add(lblValitse);

		JButton btnVaraa = new JButton("Varaa");
		btnVaraa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Lippu varattu!!");
			}
		});
		btnVaraa.setBounds(16, 290, 117, 29);
		varaussivu.add(btnVaraa);

		JList list_2 = new JList();
		list_2.setBounds(16, 94, 134, 173);
		varaussivu.add(list_2);

		JList list_3 = new JList();
		list_3.setBounds(171, 94, 134, 173);
		varaussivu.add(list_3);

		JList list_4 = new JList();
		list_4.setBounds(332, 94, 134, 173);
		varaussivu.add(list_4);
	}
	/**
	 * Paivittaa etusivu-valilehden annetuilla elokuva ja teatteri ArrayListoilla
	 * @param uudetElokuvat : ArrayList<Elokuva>
	 * @param uudetTeatterit : ArrayList<Teatteri>
	 */
	public void paivitaEtusivu(ArrayList<Elokuva> uudetElokuvat, ArrayList<Teatteri> uudetTeatterit){
		if(verbose){System.out.println("Luokka: GUI : paivitaEtusivu()");}

		etusivu.removeAll();						
		etusivu.repaint();

		JLabel lblValitse = new JLabel("<html>Tervetuloa ICT-Elokuvateatteriin! Alla voit selata elokuvia ja niiden esityspaikkoja!<br>Meillä on tarjolla jokaiselle jotakin!</html>");
		lblValitse.setBounds(20, 0, 500, 50);
		etusivu.add(lblValitse);

		JLabel lblElokuvat = new JLabel("Elokuvat:");
		lblElokuvat.setBounds(20, 50, 81, 16);
		etusivu.add(lblElokuvat);

		JLabel lblElokuvateatteri = new JLabel("Elokuvateatterit:");
		lblElokuvateatteri.setBounds(232, 50, 101, 16);
		etusivu.add(lblElokuvateatteri);

		//paivittaa elokuvat
		paivitaElokuvat(uudetElokuvat);
		//paivittaa teatterit
		paivitaTeatterit(uudetTeatterit);

		elokuvaHiiri();
		teatteriHiiri();

		JButton btnPivitElokuvat = new JButton("Kaikki Elokuvat ja teatterit");
		btnPivitElokuvat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verbose){System.out.println("Luokka: GUI : paivitaEtusivu() - Kaikki elokuvat ja teatterit: ");}
				paivitaEtusivu(elokuvat, teatterit);
			}
		});
		btnPivitElokuvat.setBounds(20, 324, 184, 29);
		etusivu.add(btnPivitElokuvat);
	}

	/**
	 * Lisää MouseListenerin teatteri-listaan etusivulle
	 */
	public void teatteriHiiri(){
		if(verbose){System.out.println("Luokka: GUI : teatteriHiiri()");}

		MouseListener listener = new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				teatteriLista = (JList) e.getSource();

				int index = teatteriLista.locationToIndex(e.getPoint());
				if(e.getClickCount() ==1){
					if(index >= 0){
						Teatteri te = teatteriLista.getModel().getElementAt(index);
						if(verbose){System.out.println("Luokka: GUI : teatteriHiiri() - Klikattu: \n"+ te.toString());}

						//elokuvien päivitys kyseisen teatterin elokuviksi
						ArrayList<Elokuva> teatterinElokuvat = new ArrayList<Elokuva>();
						teatterinElokuvat.addAll(te.annaElokuvat());

						paivitaEtusivu(teatterinElokuvat, teatterit);

					}
				}
			}
		};
		teatteriLista.addMouseListener(listener);
	}
	/**
	 * Lisaa MouseListenerin elokuva-listaan etusivulle
	 */
	public void elokuvaHiiri(){
		if(verbose){System.out.println("Luokka: GUI : elokuvaHiiri()");}

		MouseListener listener = new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				elokuvaLista = (JList) e.getSource();

				int index = elokuvaLista.locationToIndex(e.getPoint());
				if(e.getClickCount() ==1){
					if(index >= 0){
						Elokuva el = elokuvaLista.getModel().getElementAt(index);
						if(verbose){System.out.println("Luokka: GUI : elokuvaHiiri() - Klikattu: \n"+ el.toString());}

						//TODO - teatterien päivitys niihin joissa kyseinen elokuva pyörii
						ArrayList<Teatteri> elokuvanTeatterit = new ArrayList<Teatteri>();
						elokuvanTeatterit.addAll(loytyykoElokuva(el));

						paivitaEtusivu(elokuvat, elokuvanTeatterit);

					}
				}
			}
		};
		elokuvaLista.addMouseListener(listener);
	}

	public ArrayList<Teatteri> loytyykoElokuva(Elokuva el){
		if(verbose){System.out.println("Luokka: GUI : loytyykoElokuva()");}
		ArrayList<Teatteri> elokuvanTeatterit = new ArrayList<Teatteri>();
		ArrayList<Elokuva> leffat = new ArrayList<Elokuva>();

		//haetaan kyseistä elokuvaa teatterin tarjonnasta
		for(int i=0; i<teatterit.size(); i++){
			Teatteri teatteri = teatterit.get(i);
			leffat = teatteri.annaElokuvat();
			if(teatteri.loytyykoElokuva(el, leffat)){
				if(verbose){System.out.println("Luokka: GUI : loytyykoElokuva() - Elokuva löytyi teatterista: "+teatteri.annaNimi());}
				elokuvanTeatterit.add(teatteri);
			}
		}
		return elokuvanTeatterit;
	}
	/**
	 * Paivittaa teatterit etusivu-välilehden listaan
	 * @param teatterit
	 * @param etusivu
	 */
	public void paivitaTeatterit(ArrayList<Teatteri> teatterit){
		if(verbose){System.out.println("Luokka: GUI : paivitaTeatterit()");}

		//teatterilistaa 

		teatteriLista = new JList(teatterit.toArray());	
		teatteriLista.setBounds(232, 70, 184, 251);
		etusivu.add(teatteriLista);

	}
	/**
	 * Paivittaa elokuvat - etusivu-välilehden listaan
	 * @param elokuvat
	 * @param etusivu
	 */
	public void paivitaElokuvat(ArrayList<Elokuva> elokuvat){
		if(verbose){System.out.println("Luokka: GUI : paivitaElokuvat()");}
		//elokuvalistaa tähän

		elokuvaLista =  new JList(elokuvat.toArray());
		elokuvaLista.setBounds(20, 70, 184, 251);

		etusivu.add(elokuvaLista);

		etusivu.revalidate();

		etusivu.repaint();



	}

	/**
	 * Jos ei ole luettavissa tallennettuja elokuvia, eli tietokanta ei ole käytössä tai ohjelma käynnistetään ensimmäistä kertaa, suoritetaan alustus
	 * Luo teatteri- ja elokuva-listaan esimerkkioliot ja elokuvat
	 */
	private static void alusta(){
		if(verbose){System.out.println("Luokka: GUI : alusta()");}
		
		//Alustetaan listat
		elokuvat = new ArrayList<Elokuva>();
		teatterit = new ArrayList<Teatteri>();
		kayttajat = new ArrayList<Kayttaja>();
		varaukset = new ArrayList<Varaus>();
		
		//elokuvat
		Elokuva elokuva;
		for(int i=0; i<10; i++){
			elokuva = new Elokuva("Iso Arska "+(i+1) , 120);			
			elokuvat.add(elokuva);
		}
		if(verbose){
			System.out.println("Luokka: GUI : alusta() - elokuvat:");
			tulostaElokuvat(elokuvat);}
		
		//teatterit		
		Teatteri teatteri;
		for(int i=0; i<3;i++){
			teatteri = new Teatteri("Teatteri"+(i+1),"Turku",2);
			//alustaa salit
			for(int j=0; j<teatteri.annaSalit().size(); j++){
				teatteri.annaSali(j).asetaSalinKoko(((j+1)*5),((i+1)*5));

				//tulostaa salipaikat
				if(verbose){
					System.out.println("Luokka: GUI : alusta() - salipaikat: "+teatteri.annaNimi() +" : "+teatteri.annaSali(j));
					teatteri.annaSali(j).tulostaPaikat();
				}
			}
			teatterit.add(teatteri);
		}
		if(verbose){tulostaTeatterit(teatterit);}
		lisaaNaytokset();
		
		kayttaja_ID = 1;
		if(verbose){System.out.println("kayttaja_ID: "+kayttaja_ID);}
		
		//luodaan yksi yllapitaja nimi Admin, salasana admin, kayttajanimi Admin1
		kayttajat.add(new Yllapitaja("Admin", "admin", "Admin1", kayttaja_ID));
		if(verbose){System.out.println(kayttajat.get(0).toString());}
		kayttaja_ID++;
		if(verbose){System.out.println("kayttaja_ID: "+kayttaja_ID);}
		
		//luodaan yksi asiakas nimi Asiakas, salasana Asiakas, kayttajanimi esimerkkiAsiakas
		kayttajat.add(new Asiakas("Asiakas", "asiakas","esimerkkiAsiakas",kayttaja_ID));
		if(verbose){System.out.println(kayttajat.get(1).toString());}
		kayttaja_ID++;
		if(verbose){System.out.println("kayttaja_ID: "+kayttaja_ID);}

	}

	/**
	 * lisää näytökset alustuksen yhteydessä. Naytokset hieman paallekkain, ts samoja leffoja eri teattereissa
	 */
	public static void lisaaNaytokset(){
		if(verbose){System.out.println("Luokka: GUI : lisaaNaytokset()");}

		int salit;
		Teatteri teatteri;
		//arska 1- 4 teatteri1:n
		teatteri = teatterit.get(0);
		salit = teatteri.annaSalit().size();
		for(int i=0; i<salit; i++){
			for(int j =0; j<5; j++){
				//näytösaikaan lisätään +1, koska sali-luokka lukee sitä luvuilla 1-5
				teatteri.annaSali(i).lisaaNaytos(new Naytos(2015,3,28,i, teatteri, elokuvat.get(j), j+1));
			}
		}
		//arska 4-8 teatteri2:n
		teatteri = teatterit.get(1);
		salit = teatteri.annaSalit().size();
		int aika;
		for(int i=0; i<salit; i++){
			aika = 1;
			for(int j =4; j<8; j++){
				//näytösaikaan lisätään +1, koska sali-luokka lukee sitä luvuilla 1-5
				teatteri.annaSali(i).lisaaNaytos(new Naytos(2015,3,28,i, teatteri, elokuvat.get(j), aika));
				aika ++;
			}
		}
		//arska 5-10 teatteri 3:n
		teatteri = teatterit.get(2);
		salit = teatteri.annaSalit().size();	
		for(int i=0; i<salit; i++){
			aika = 1;
			for(int j =7; j<10; j++){
				//näytösaikaan lisätään +1, koska sali-luokka lukee sitä luvuilla 1-5
				teatteri.annaSali(i).lisaaNaytos(new Naytos(2015,3,28,i, teatteri, elokuvat.get(j), aika));
				aika++;
			}
		}

		if(verbose){
			if(verbose){System.out.println("Luokka: GUI : lisaaNaytokset() - kaikki näytökset:");}

			ArrayList<Naytos> naytokset = new ArrayList<Naytos>();
			for(int i=0; i<teatterit.size(); i++){
				naytokset.addAll(teatterit.get(i).annaNaytokset());
			}
			for(int i=0; i<naytokset.size(); i++){
				System.out.println(naytokset.get(i).toString());
			}
		}
	}

	/**TESTAUKSEEN
	 * Tulostaa elokuvat
	 * @param elokuvat
	 */
	private static void tulostaElokuvat(ArrayList<Elokuva> elokuvat){
		if(verbose){System.out.println("Luokka: GUI : tulostaElokuvat()");}
		for(int i=0; i<elokuvat.size(); i++){
			System.out.println(elokuvat.get(i).toString());
		}
	}
	/**TESTAUKSEEN
	 * Tulostaa teatterit
	 * @param teatteri
	 */
	private static void tulostaTeatterit(ArrayList<Teatteri> teatteri){
		if(verbose){System.out.println("Luokka: GUI : tulostaTeatterit()");}
		for(int i=0; i<teatterit.size(); i++){
			System.out.println(teatterit.get(i).toString());			
		}
	}
}
