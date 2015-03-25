package varausjarjestelma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;

public class Kirjaudu {

	private JFrame Kirjaudu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kirjaudu window = new Kirjaudu();
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
	public Kirjaudu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Kirjaudu = new JFrame();
		Kirjaudu.setBounds(100, 100, 574, 307);
		Kirjaudu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Kirjaudu.getContentPane().setLayout(null);
		
		JButton button = new JButton("Elokuvat");
		button.setBounds(0, 51, 114, 29);
		Kirjaudu.getContentPane().add(button);
		
		JButton button_1 = new JButton("Varaa Liput");
		button_1.setBounds(114, 51, 114, 29);
		Kirjaudu.getContentPane().add(button_1);
		
		JButton btnOmatTiedot = new JButton("Omat Tiedot");
		btnOmatTiedot.setBounds(456, 51, 114, 29);
		Kirjaudu.getContentPane().add(btnOmatTiedot);
		
		JButton btnRekisteridy = new JButton("Rekister\u00F6idy");
		btnRekisteridy.setBounds(342, 51, 114, 29);
		Kirjaudu.getContentPane().add(btnRekisteridy);
		
		JButton btnKirjaudu = new JButton("Kirjaudu");
		btnKirjaudu.setBounds(228, 51, 114, 29);
		Kirjaudu.getContentPane().add(btnKirjaudu);
		
		JLabel label = new JLabel("Ict Elokuvateatteri");
		label.setBounds(188, 6, 185, 26);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		Kirjaudu.getContentPane().add(label);
	}

}
