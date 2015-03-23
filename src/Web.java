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

	public static void readSite() throws Exception {
		URL link = new URL("http://www.oddsshark.com/nba/scores");
		String tempteam;
		boolean addAwayScore = true;
		boolean addHomeScore = false;
		boolean addTeams = false;
		String awayTeam = "";
		String homeTeam = "";
		int homeScore = -1;
		int awayScore = -1;
		String time = "";
		String date = "";
		boolean full = false;
		// System.out.println(i);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				link.openStream()));
		while ((inputLine = in.readLine()) != null) {
			if(inputLine.contains("Final"))
			{			
				inputLine = inputLine.replace(" ","-");
				date = inputLine.substring(inputLine.indexOf("/>")+2, inputLine.indexOf("</")-14);
			}
			if (inputLine.contains("scores-data last")) {
				inputLine = inputLine.substring(inputLine.indexOf("\">") + 2,
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
				String tempHome = inputLine.substring(inputLine.indexOf("at"), inputLine.length());
				String tempAway = inputLine.substring(0, inputLine.indexOf("at"));
				if ((tempteam = League.teamsContains(tempAway)) != null) {
					awayTeam = tempteam;
				}
				//inputLine = inputLine.replace(tempteam.toString(), " ");
				if ((tempteam = League.teamsContains(tempHome)) != null) {
					homeTeam = tempteam;
				}

				addTeams = false;
			}
			if (inputLine.contains("teams last")) {
				addTeams = true;

			}
			if (full) {
				Schedule.addGame(new Game(awayTeam, homeTeam, awayScore,homeScore, date));
				full = false;
			}

		}

	}

}