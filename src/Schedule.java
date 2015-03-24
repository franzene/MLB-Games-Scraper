import java.util.ArrayList;
import java.util.List;

public class Schedule {
	static ArrayList<Game> schedule = new ArrayList<Game>();

	Schedule(String sDate, String eDate) throws Exception {
		Web oddsShark = new Web();
		oddsShark.readSite(sDate,eDate);
	}

	Schedule(String getDate) throws Exception {
		Web oddsShark = new Web();
		//oddsShark.readSite(sDate,eDate);

	}

	public static void addGame(Game game) {
		schedule.add(game);
	}

	public static ArrayList<Game> getScedule() {
		return schedule;

	}

	public void saveSchedule() {

	}

	public void print() {
		for (Game game : schedule) {
			game.print();
		}

	}

}
