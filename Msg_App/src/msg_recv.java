import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class msg_recv {

	Super s = new Super();
	public void recv_msg(){
		System.out.println("server_run");
		String clientSentence; 
		String capitalizedSentence; 
		
		try {
			ServerSocket welcomeSocket = new ServerSocket(6804);
			System.out.println("Connect:");
			System.out.println(welcomeSocket);
			while(true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream())); 
			DataOutputStream  outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine(); 
			capitalizedSentence = clientSentence + '\n'; 
			outToClient.writeBytes(capitalizedSentence); 
			System.out.println("Jho: " + capitalizedSentence);
			String text_pane_msg = s.m.textPane.getText();
			s.m.set_text( text_pane_msg.trim() + "\n"+"Mike: " + capitalizedSentence);
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        
			s.db.insert_message("Mike", "Jho",sdf.format(cal.getTime()) , capitalizedSentence);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

