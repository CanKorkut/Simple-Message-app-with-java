import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Giris {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public static Super s ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giris window = new Giris();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Giris() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 934, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Giri\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				s.m.frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(341, 301, 188, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(341, 213, 188, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(341, 260, 188, 30);
		frame.getContentPane().add(passwordField);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblKullancAd.setBounds(258, 217, 73, 22);
		frame.getContentPane().add(lblKullancAd);
		
		JLabel lblifre = new JLabel("\u015Eifre");
		lblifre.setFont(new Font("Times New Roman", Font.BOLD, 11));
		lblifre.setBounds(266, 264, 50, 22);
		frame.getContentPane().add(lblifre);
	}
}
