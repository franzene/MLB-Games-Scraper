import java.awt.EventQueue;

public class test {

	public static void main(String[] args) throws Exception {
		//call GUI
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SportsGUI window = new SportsGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

}
