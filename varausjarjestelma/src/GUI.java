

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

import javax.swing.JList;

public class GUI {

	//testaukseem
	private static boolean verbose = true;

	private JFrame Kirjaudu;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;
	private JPasswordField passwordField_1;

	//elokuvat, teatterit ja varaukset
	private static ArrayList<Elokuva> elokuvat;
	private static ArrayList<Teatteri> teatterit;
	//varaukset TODO

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		alusta();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.Kirjaudu.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		Kirjaudu = new JFrame();
		Kirjaudu.setBounds(100, 100, 580, 500);
		Kirjaudu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Kirjaudu.getContentPane().setLayout(null);

		JLabel label = new JLabel("Ict Elokuvateatteri");
		label.setBounds(188, 6, 185, 26);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		Kirjaudu.getContentPane().add(label);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 35, 568, 405);
		Kirjaudu.getContentPane().add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Etusivu", null, panel, null);
		panel.setLayout(null);

		JLabel lblElokuvat = new JLabel("Elokuvat:");
		lblElokuvat.setBounds(20, 12, 81, 16);
		panel.add(lblElokuvat);

		JLabel lblElokuvateatteri = new JLabel("Elokuvateatteri:");
		lblElokuvateatteri.setBounds(232, 12, 101, 16);
		panel.add(lblElokuvateatteri);

		paivitaElokuvat(elokuvat, panel);



		JList list_1 = new JList();
		list_1.setBounds(232, 40, 184, 251);
		panel.add(list_1);

		JButton btnPivitElokuvat = new JButton("P\u00E4ivit\u00E4 Elokuvat");
		btnPivitElokuvat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPivitElokuvat.setBounds(20, 324, 184, 29);
		panel.add(btnPivitElokuvat);

		JButton btnPivitElokuvateatterit = new JButton("P\u00E4ivit\u00E4 Elokuvateatterit");
		btnPivitElokuvateatterit.setBounds(232, 324, 184, 29);
		panel.add(btnPivitElokuvateatterit);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Varaa Lippu", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblValitseTeatteri = new JLabel("Teatteri:");
		lblValitseTeatteri.setBounds(16, 52, 116, 16);
		panel_1.add(lblValitseTeatteri);

		JLabel lblValitseElokuva = new JLabel("Elokuva:");
		lblValitseElokuva.setBounds(171, 52, 116, 16);
		panel_1.add(lblValitseElokuva);

		JLabel lblVytsaika = new JLabel("N\u00E4yt\u00F6saika:");
		lblVytsaika.setBounds(332, 52, 116, 16);
		panel_1.add(lblVytsaika);

		JLabel lblValitse = new JLabel("Valitse:");
		lblValitse.setBounds(16, 23, 61, 16);
		panel_1.add(lblValitse);

		JButton btnVaraa = new JButton("Varaa");
		btnVaraa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Lippu varattu!!");
			}
		});
		btnVaraa.setBounds(16, 290, 117, 29);
		panel_1.add(btnVaraa);

		JList list_2 = new JList();
		list_2.setBounds(16, 94, 134, 173);
		panel_1.add(list_2);

		JList list_3 = new JList();
		list_3.setBounds(171, 94, 134, 173);
		panel_1.add(list_3);

		JList list_4 = new JList();
		list_4.setBounds(332, 94, 134, 173);
		panel_1.add(list_4);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Kirjaudu", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblKirjaudu = new JLabel("Kirjaudu:");
		lblKirjaudu.setBounds(6, 10, 75, 16);
		panel_2.add(lblKirjaudu);

		JLabel lblSalasana = new JLabel("Salasana:");
		lblSalasana.setBounds(6, 79, 61, 16);
		panel_2.add(lblSalasana);

		textField_2 = new JTextField();
		textField_2.setBounds(106, 45, 134, 28);
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(106, 73, 134, 28);
		panel_2.add(passwordField);

		JLabel lblRekisteridy = new JLabel("Rekister\u00F6idy:");
		lblRekisteridy.setBounds(6, 164, 100, 16);
		panel_2.add(lblRekisteridy);

		JLabel lblValitseKyttjnimi = new JLabel("S\u00E4hk\u00F6posti:");
		lblValitseKyttjnimi.setBounds(6, 200, 100, 16);
		panel_2.add(lblValitseKyttjnimi);

		JLabel lblUusiSalasana = new JLabel("Uusi Salasana:");
		lblUusiSalasana.setBounds(6, 228, 132, 16);
		panel_2.add(lblUusiSalasana);

		textField_3 = new JTextField();
		textField_3.setBounds(106, 194, 134, 28);
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(106, 222, 134, 28);
		panel_2.add(passwordField_1);

		JLabel label_1 = new JLabel("S\u00E4hk\u00F6posti:");
		label_1.setBounds(6, 51, 100, 16);
		panel_2.add(label_1);

		JButton btnKirjaudu = new JButton("Kirjaudu");
		btnKirjaudu.setBounds(106, 113, 117, 29);
		panel_2.add(btnKirjaudu);

		JButton btnNewButton = new JButton("Rekister\u00F6idy");
		btnNewButton.setBounds(106, 261, 117, 29);
		panel_2.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 154, 289, 12);
		panel_2.add(separator);
	}

	public void paivitaElokuvat(ArrayList<Elokuva> elokuvat, JPanel panel){
		if(verbose){System.out.println("Luokka: GUI : paivitaElokuvat()");}
		//elokuvalistaa tähän
		JList<Elokuva> list = new JList<Elokuva>();
		list =  new JList(elokuvat.toArray());
		list.setBounds(20, 40, 184, 251);
		panel.add(list);
	}

	/**
	 * Jos ei ole luettavissa tallennettuja elokuvia, eli tietokanta ei ole käytössä tai ohjelma käynnistetään ensimmäistä kertaa, suoritetaan alustus
	 * Luo teatteri- ja elokuva-listaan esimerkkioliot ja elokuvat
	 */
	private static void alusta(){
		if(verbose){System.out.println("Luokka: GUI : alusta()");}
		elokuvat = new ArrayList<Elokuva>();
		//elokuvat
		Elokuva elokuva;
		for(int i=0; i<10; i++){
			elokuva = new Elokuva("Iso Arska "+(i+1) , 120);
			if(verbose){System.out.println(elokuva.toString());}
			elokuvat.add(elokuva);
		}
		//teatterit
		Teatteri teatteri;
		for(int i=0; i<3;i++){
			//	teatteri = new Teatteri()
		}

	}
}
