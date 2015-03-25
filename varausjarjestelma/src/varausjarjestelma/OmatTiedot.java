package varausjarjestelma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OmatTiedot {

	private JFrame Omattiedot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OmatTiedot window = new OmatTiedot();
					window.Omattiedot.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OmatTiedot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Omattiedot = new JFrame();
		Omattiedot.setBounds(100, 100, 572, 338);
		Omattiedot.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Omattiedot.getContentPane().setLayout(null);
		
		JLabel lblIctElokuvateatteri = new JLabel("Ict Elokuvateatteri");
		lblIctElokuvateatteri.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		lblIctElokuvateatteri.setBounds(193, 6, 225, 27);
		Omattiedot.getContentPane().add(lblIctElokuvateatteri);
		
		JButton btnNewButton = new JButton("Elokuvat");
		btnNewButton.setBounds(15, 47, 96, 29);
		Omattiedot.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Varaa Lippu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_1.setBounds(126, 47, 96, 29);
		Omattiedot.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Kirjaudu");
		btnNewButton_2.setBounds(237, 47, 96, 29);
		Omattiedot.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Rekister\u00F6idy");
		btnNewButton_3.setBounds(348, 47, 96, 29);
		Omattiedot.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Omat Tiedot");
		btnNewButton_4.setBounds(459, 47, 96, 29);
		Omattiedot.getContentPane().add(btnNewButton_4);
	}
}
