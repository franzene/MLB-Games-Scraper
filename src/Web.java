import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Web {

	static String inputLine;

	Web() throws Exception {
		League.teams();
	}

	public static void setHome(String line) {

	}

	public static void setAway(String line) {

	}

	public void readSite(String sDate, String eDate) throws Exception {
		String tempteam;
		String awayTeam = "";
		String homeTeam = "";
		String date = "";
		String startDate = sDate;

		boolean addAwayScore = true;
		boolean addHomeScore = false;
		boolean addTeams = false;
		boolean full = false;
		boolean lastDay = false;

		int homeScore = -1;
		int awayScore = -1;
		int count = 0;
		Calendar testCal = new Calendar();

		startDate = testCal.nextDay(startDate);
		
		calendarLoop:
		while (!testCal.laterDate(startDate, eDate)) {
			// System.out.println(startDate);
			URL link = new URL("http://www.oddsshark.com/nba/scores?date="
					+ startDate);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					link.openStream()));
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains("Final")) {
					inputLine = inputLine.replace(" ", "-");
					date = inputLine.substring(inputLine.indexOf("/>") + 2,
							inputLine.indexOf("</") - 14);
					date = testCal.convertDate(date);
				}

				count++;
				if(lastDay == true)
				{
					if(!eDate.equals(date))
					{
						break calendarLoop;
					}
				}
				if(eDate.equals(date))
				{
					lastDay = true;
				}
			
				if (inputLine.contains("scores-data last")) {
					inputLine = inputLine.substring(
							inputLine.indexOf("\">") + 2,
							inputLine.indexOf("</"));
					int tempscore = Integer.parseInt(inputLine);
					if (addAwayScore == true) {
						awayScore = tempscore;
						addAwayScore = false;
						addHomeScore = true;
					} else if (addHomeScore == true) {
						homeScore = tempscore;
						full = true;
						addHomeScore = false;
						addAwayScore = true;
					}

				}
				if (addTeams == true) {
					String tempHome = inputLine.substring(
							inputLine.indexOf("at"), inputLine.length());
					String tempAway = inputLine.substring(0,
							inputLine.indexOf("at"));
					if ((tempteam = League.teamsContains(tempAway)) != null) {
						awayTeam = tempteam;
					}
					// inputLine = inputLine.replace(tempteam.toString(), " ");
					if ((tempteam = League.teamsContains(tempHome)) != null) {
						homeTeam = tempteam;
					}

					addTeams = false;
				}
				if (inputLine.contains("teams last")) {
					addTeams = true;

				}
				if (full) {
					Schedule.addGame(new Game(awayTeam, homeTeam, awayScore,
							homeScore, date));
					full = false;
				}
			}
			startDate = testCal.nextDay(startDate);

		}
	}

}
