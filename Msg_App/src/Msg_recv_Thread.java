
public class Msg_recv_Thread extends Thread {

	public void run(){
	
		msg_recv m = new msg_recv();
		m.recv_msg();
	}

}
