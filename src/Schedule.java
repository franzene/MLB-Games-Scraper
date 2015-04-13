import java.util.ArrayList;
import java.util.List;

public class Schedule {
	static ArrayList<Game> schedule = new ArrayList<Game>();
	static ArrayList<Game> tempschedule = new ArrayList<Game>();

	Schedule(String sDate, String eDate) throws Exception {
		Web oddsShark = new Web();
		oddsShark.readSite(sDate, eDate);
	}

	Schedule(String getDate) throws Exception {
		Web oddsShark = new Web();
		// oddsShark.readSite(sDate,eDate);
	}

	public static void addGame(Game game) {
		schedule.add(game);
	}

	// public static ArrayList<Game> getScedule() {
	// return schedule.getOutput();
	// }
	public void setTemp(String sDate, String eDate, String team0, String team1,
			String sort) {
		boolean get = false;
		boolean last = false;
		String teamA = "";
		String teamB = "";
		tempschedule = new ArrayList<Game>();

		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getDate().equals(sDate)) {
				get = true;
			}
			if (schedule.get(i).getDate().equals(eDate)) {
				last = true;
			}
			if (last && !schedule.get(i).getDate().equals(eDate)) {
				return;
			}

			if (get) {
				teamA = League.teamsContains(team0);
				teamB = League.teamsContains(team1);

				if (team0.equals("All")) {
					tempschedule.add(schedule.get(i));
				} else if (teamA.equals(schedule.get(i).getHome())|| teamA.equals(schedule.get(i).getAway())) {
					if (team1.equals("All")) {
						tempschedule.add(schedule.get(i));
					} else if (teamB.equals(schedule.get(i).getHome())|| teamB.equals(schedule.get(i).getAway())) {
						tempschedule.add(schedule.get(i));
					}

				}
			}			

		}
		if(sort.equals("Home Team"))
		{
			orderHomeTeam();
		}
		else if(sort.equals("Away Team"))
		{
			orderAwayTeam();

		}
		else if(sort.equals("Away Score"))
		{
			orderAwayScore();

		}
		else if(sort.equals("Home Score"))
		{
			orderHomeScore();

		}

	}

	public Object[][] getSchedule() {
		Object[][] sched = new Object[tempschedule.size()][5];
		for (int x = 0; x < tempschedule.size(); x++) {
			sched[x][0] = tempschedule.get(x).getDate();
			sched[x][1] = tempschedule.get(x).getHome();
			sched[x][2] = tempschedule.get(x).getAway();
			sched[x][3] = tempschedule.get(x).getHomeScore();
			sched[x][4] = tempschedule.get(x).getAwayScore();
		}
		return sched;

	}

	public void saveSchedule() {

	}

	public void getAllTeam(String t) {
		for (int i = 0; i < schedule.size(); i++) {
			if (schedule.get(i).getHome().equals(t)|| schedule.get(i).getAway().equals(t))
				schedule.get(i).print();
		}
	}

	public void print() {

		for (int i = 0; i < schedule.size(); i++) {
			schedule.get(i).print();
		}
	}

	public void orderHomeTeam() {
		sort: while (true) {
			boolean sorted = false;
			int i = 0;
			while (i + 1 < tempschedule.size()) {

				if (tempschedule.get(i).getHome()
						.compareToIgnoreCase(tempschedule.get(i + 1).getHome()) > 0) {
					// System.out.println(schedule.get(i).getHome() +
					// schedule.get(i+1).getHome() +
					// schedule.get(i).getHome().compareTo(schedule.get(i+1).getHome()));
					Game temp_1 = tempschedule.get(i);
					Game temp_2 = tempschedule.get(i + 1);

					tempschedule.set(i + 1, temp_1);
					tempschedule.set(i, temp_2);
					sorted = true;
				}
				i++;
			}
			if (sorted == false) {
				break sort;
			} else {
				i = 0;
				sorted = false;
			}

		}
	}

	public void orderAwayTeam() {
		sort: while (true) {
			boolean sorted = false;
			int i = 0;
			while (i + 1 < tempschedule.size()) {

				if (tempschedule.get(i).getAway()
						.compareToIgnoreCase(tempschedule.get(i + 1).getAway()) > 0) {
					// System.out.println(tempschedule.get(i).getHome() +
					// tempschedule.get(i+1).getHome() +
					// tempschedule.get(i).getHome().compareTo(tempschedule.get(i+1).getHome()));
					Game temp_1 = tempschedule.get(i);
					Game temp_2 = tempschedule.get(i + 1);

					tempschedule.set(i + 1, temp_1);
					tempschedule.set(i, temp_2);
					sorted = true;
				}
				i++;
			}
			if (sorted == false) {
				break sort;
			} else {
				i = 0;
				sorted = false;
			}

		}
	}

	public void orderDate() {
		sort: while (true) {
			boolean sorted = false;
			int i = 0;
			while (i + 1 < tempschedule.size()) {

				if (tempschedule.get(i).getDate()
						.compareToIgnoreCase(tempschedule.get(i + 1).getDate()) > 0) {
					// System.out.println(tempschedule.get(i).getHome() +
					// tempschedule.get(i+1).getHome() +
					// tempschedule.get(i).getHome().compareTo(tempschedule.get(i+1).getHome()));
					Game temp_1 = tempschedule.get(i);
					Game temp_2 = tempschedule.get(i + 1);

					tempschedule.set(i + 1, temp_1);
					tempschedule.set(i, temp_2);
					sorted = true;
				}
				i++;
			}
			if (sorted == false) {
				break sort;
			} else {
				i = 0;
				sorted = false;
			}

		}
	}

	public void orderAwayScore() {
		sort: while (true) {
			boolean sorted = false;
			int i = 0;
			while (i + 1 < tempschedule.size()) {

				if (tempschedule.get(i).getAwayScore() > tempschedule.get(i + 1)
						.getAwayScore()) {
					Game temp_1 = tempschedule.get(i);
					Game temp_2 = tempschedule.get(i + 1);

					tempschedule.set(i + 1, temp_1);
					tempschedule.set(i, temp_2);
					sorted = true;
				}
				i++;
			}
			if (sorted == false) {
				break sort;
			} else {
				i = 0;
				sorted = false;
			}

		}
	}

	public void orderHomeScore() {
		sort: while (true) {
			boolean sorted = false;
			int i = 0;
			while (i + 1 < tempschedule.size()) {

				if (tempschedule.get(i).getHomeScore() > tempschedule.get(i + 1).getHomeScore()) {
					Game temp_1 = tempschedule.get(i);
					Game temp_2 = tempschedule.get(i + 1);

					tempschedule.set(i + 1, temp_1);
					tempschedule.set(i, temp_2);
					sorted = true;
				}
				i++;
			}
			if (sorted == false) {
				break sort;
			} else {
				i = 0;
				sorted = false;
			}

		}
	}

}
