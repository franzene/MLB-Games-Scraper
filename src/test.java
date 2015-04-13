import java.awt.EventQueue;

public class test {

	public static void main(String[] args) throws Exception {
	
				
//			Schedule OddsShark = new Schedule("01/01/2015","01/05/2015");
//			System.out.println("---------Home--------");
//			OddsShark.orderHomeTeam();
//			OddsShark.print();
//			System.out.println("---------Away--------");
//			OddsShark.orderAwayTeam();
//			OddsShark.print();
//			System.out.println("---------Date--------");
//			OddsShark.orderDate();
//			OddsShark.print();
//			System.out.println("---------AwayScore--------");
//			OddsShark.orderAwayScore();
//			OddsShark.print();
//			System.out.println("---------HomeScore--------");
//			OddsShark.orderAwayScore();
//			OddsShark.print();

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
		
		//OddsShark.getAllTeam("New York");
		
		//storeSchedule.writeSchedule();
//		Calendar testCal = new Calendar();
//		String startDate = "01/20/2015";
//		String  eDate = "02/09/2015";
//		startDate = testCal.nextDay(startDate);
//		
//		while (!testCal.laterDate(startDate, eDate)) {
//			{
//				//System.out.println(startDate);
//				startDate = testCal.nextDay(startDate);
//			}
//		}
	}

}
