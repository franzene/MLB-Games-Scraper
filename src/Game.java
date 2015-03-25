public class Game {
	private String away;
	private String home;
	private int awayScore;
	private int homeScore;
	String time;
	String date;

	public Game(String a, String h, int as, int hs, String d) {
		away = a;
		home = h;
		awayScore = as;
		homeScore = hs;
		date = d;
	}

	public Game(Game temp) {
		away = temp.away;
		home = temp.home;
		awayScore = temp.awayScore;
		homeScore = temp.homeScore;
	}

	public void setAway(String i) {
		away = i;
	}

	public void setHome(String i) {
		home = i;
	}

	public void setawayScore(int i) {
		awayScore = i;
	}

	public void sethomeScore(int i) {
		homeScore = i;
	}

	public String getAway() {
		return away;
	}

	public String getHome() {
		return home;
	}

	public int getAwayScore() {
		return awayScore;
	}

	public int getHomeScore() {
		return homeScore;
	}

	public String getDate() {
		return date;
	}

	public void print() {

		System.out.print(away + " VS ");
		System.out.print(home);
		System.out.println(" " + date);
	}
}
