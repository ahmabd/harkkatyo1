package varausjarjestelma;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class Etusivu {

	private JFrame Etusivu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Etusivu window = new Etusivu();
					window.Etusivu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Etusivu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Etusivu = new JFrame();
		Etusivu.setTitle("Varausj\u00E4rjestelm\u00E4");
		Etusivu.setForeground(Color.WHITE);
		Etusivu.setBackground(new Color(204, 204, 204));
		Etusivu.setBounds(100, 100, 589, 298);
		Etusivu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		Etusivu.getContentPane().setLayout(springLayout);
		
		JButton btnElokuvat = new JButton("Elokuvat");
		springLayout.putConstraint(SpringLayout.NORTH, btnElokuvat, 66, SpringLayout.NORTH, Etusivu.getContentPane());
		Etusivu.getContentPane().add(btnElokuvat);
		
		JButton btnVaraa = new JButton("Varaa Liput");
		springLayout.putConstraint(SpringLayout.EAST, btnElokuvat, -5, SpringLayout.WEST, btnVaraa);
		springLayout.putConstraint(SpringLayout.NORTH, btnVaraa, 66, SpringLayout.NORTH, Etusivu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnVaraa, -362, SpringLayout.EAST, Etusivu.getContentPane());
		Etusivu.getContentPane().add(btnVaraa);
		
		JButton btnKirjaudu = new JButton("Kirjaudu");
		springLayout.putConstraint(SpringLayout.NORTH, btnKirjaudu, 66, SpringLayout.NORTH, Etusivu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnKirjaudu, -261, SpringLayout.EAST, Etusivu.getContentPane());
		Etusivu.getContentPane().add(btnKirjaudu);
		
		JButton btnRekisteridy = new JButton("Rekister\u00F6idy");
		springLayout.putConstraint(SpringLayout.NORTH, btnRekisteridy, 66, SpringLayout.NORTH, Etusivu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnRekisteridy, -134, SpringLayout.EAST, Etusivu.getContentPane());
		Etusivu.getContentPane().add(btnRekisteridy);
		
		JButton btnOmatTiedot = new JButton("Omat Tiedot");
		springLayout.putConstraint(SpringLayout.NORTH, btnOmatTiedot, 66, SpringLayout.NORTH, Etusivu.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnOmatTiedot, -7, SpringLayout.EAST, Etusivu.getContentPane());
		Etusivu.getContentPane().add(btnOmatTiedot);
		
		JLabel lblIctElokuvateatteri = new JLabel("Ict Elokuvateatteri");
		springLayout.putConstraint(SpringLayout.NORTH, lblIctElokuvateatteri, 10, SpringLayout.NORTH, Etusivu.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblIctElokuvateatteri, 201, SpringLayout.WEST, Etusivu.getContentPane());
		lblIctElokuvateatteri.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		Etusivu.getContentPane().add(lblIctElokuvateatteri);
		Etusivu.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Etusivu.getContentPane(), btnElokuvat, btnVaraa, btnKirjaudu, btnRekisteridy, btnOmatTiedot}));
	}
}
