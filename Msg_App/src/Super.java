
public class Super {
	public static Main m ;
	public static Database_Class db;
	public static void main(String[] args) {
		db = new Database_Class();
		db.OpenConnection();
		m = new Main();
		Giris g = new Giris();
		g.frame.setVisible(true);
		m.frame.setVisible(false);
		msg_recv msg_r = new msg_recv();

	}

}
