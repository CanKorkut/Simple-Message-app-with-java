import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.UIManager;




import java.awt.SystemColor;
import javax.swing.JLabel;

public class Main {

	msg_recv msg_windows;
	public JFrame frame;
	public JTextField textField;
	public JTextPane textPane;
	public static Msg_recv_Thread thr;

	/**
	 * Launch the application.
	 */
	
	Super s = new Super();
	private JTextField txtSearch;
	private JLabel lblJhoWilliams;
	
	
	public static void gui() {

		Msg_recv_Thread thr_msg = new Msg_recv_Thread();
		thr_msg.start();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void set_text(String s){
		textPane.setText(s);
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Msg_sender send_msg = new Msg_sender();
		Msg_recv_Thread recv_msg = new Msg_recv_Thread();
		String init_message = "Write a message...";
		
		
		recv_msg.start();
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 933, 612);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textPane = new JTextPane();
		textPane.setBackground(Color.WHITE);
		textPane.setFont(new Font("Times New Roman", textPane.getFont().getStyle() & ~Font.ITALIC | Font.BOLD, 17));
		textPane.setBounds(34, 105, 146, 189);
		
		JScrollPane jsp = new JScrollPane(textPane);
		jsp.setBounds(281, 47, 608, 445);
		frame.getContentPane().add( jsp );
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 17));
		textField.setBounds(281, 503, 608, 43);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search...");
		txtSearch.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtSearch.setBackground(Color.WHITE);
		txtSearch.setBounds(281, 11, 608, 20);
		frame.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Jasmine Mehra");
		listModel.addElement("Ankit Mishra");
		listModel.addElement("Madhuri Sanghvi");
		listModel.addElement("Alok Kumar");
		listModel.addElement("Rohit Bothra");
		listModel.addElement("Rahul Aggarwal");
		
		JList list = new JList(listModel);
		
		
		
		list.setBackground(Color.WHITE);
		list.setBounds(39, 47, 244, 445);
		frame.getContentPane().add(list);
		textField.setText(init_message);
		
		String msg_history = s.db.get_message();
		textPane.setText(msg_history);
		
		lblJhoWilliams = new JLabel("Jho Williams");
		lblJhoWilliams.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblJhoWilliams.setBounds(50, 7, 183, 32);
		frame.getContentPane().add(lblJhoWilliams);
		
		textField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				 if (arg0.getKeyChar() == KeyEvent.VK_ENTER){
					String msg = textField.getText();
					textField.setText("");
					send_msg.Send_message(msg);
					String text_pane_msg = textPane.getText();
					textPane.setText(text_pane_msg + "\n Jho: "+ msg);
						
				 }
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		txtSearch.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				 if (arg0.getKeyChar() == KeyEvent.VK_ENTER){
					String key_word = txtSearch.getText();
					String lines[] = msg_history.split("\\r?\\n");
					String results = "";
					int index;
					int counter = 0;
					while (lines.length> counter){
						index = lines[counter].indexOf(key_word);
						if (index != -1) {
							results = results+ "\n" +lines[counter];
							
							}
						counter++;
					}
				if (results != "")
					JOptionPane.showMessageDialog(null, results, "InfoBox: " + "Bulunan Mesajlar", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "Mesaj Bulunamadý", "InfoBox: " + "Bulunan Mesajlar", JOptionPane.INFORMATION_MESSAGE);
				 }
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		textField.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int i = 1;
				if(i == 1){
					textField.setText("");
					i = 0 ;
				}
					
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
	}
	
}
