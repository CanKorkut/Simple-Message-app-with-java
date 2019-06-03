import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Msg_sender {
	public void Send_message(String message){
		String Message = null;
		String modifiedSentence;
		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		Super s = new Super();
		
		
		try {
			clientSocket = new Socket("localhost", 6803);
			
			outToServer =new DataOutputStream(clientSocket.getOutputStream());
			
			inFromServer =new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
			
			outToServer.writeBytes(message+'\n');
			modifiedSentence = inFromServer.readLine();
			
			System.out.println("Jho: " + modifiedSentence);
			Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        
			s.db.insert_message("Jho", "Mike", sdf.format(cal.getTime()), modifiedSentence);
			
			clientSocket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
