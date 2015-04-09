import java.util.ArrayList;
import java.util.List;

public class Schedule {
	static ArrayList<Game> schedule = new ArrayList<Game>();

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

//	public static ArrayList<Game> getScedule() {
//		return schedule.getOutput();
//	}

	public void saveSchedule() {

	}
	
	public void getAllTeam(String t)
	{
		for (int i = 0; i < schedule.size()  ; i++) {
			if(schedule.get(i).getHome().equals(t) || schedule.get(i).getAway().equals(t)  )
				schedule.get(i).print();
			}
	}

	public void print() {

		for (int i = 0; i < schedule.size()  ; i++) {
			schedule.get(i).print();
		}
	}
	
	public void orderHomeTeam()
	{
		sort:
		while(true)
		{		
			boolean sorted = false;
			int i = 0;
			while(i + 1 < schedule.size()){
				
				if(schedule.get(i).getHome().compareToIgnoreCase(schedule.get(i+1).getHome()) > 0 )
				{
					//System.out.println(schedule.get(i).getHome() + schedule.get(i+1).getHome() + schedule.get(i).getHome().compareTo(schedule.get(i+1).getHome()));
					Game temp_1 = schedule.get(i);
					Game temp_2 = schedule.get(i + 1);
					
					schedule.set(i + 1, temp_1);
					schedule.set(i  , temp_2);
					sorted = true;
				}
				i++;
			}
			if(sorted == false)
			{
				break sort;
			}
			else
			{
				i = 0;
				sorted = false;
			}
			
		}
	}
	public void orderAwayTeam()
	{
		sort:
		while(true)
		{		
			boolean sorted = false;
			int i = 0;
			while(i + 1 < schedule.size()){
				
				if(schedule.get(i).getAway().compareToIgnoreCase(schedule.get(i+1).getAway()) > 0 )
				{
					//System.out.println(schedule.get(i).getHome() + schedule.get(i+1).getHome() + schedule.get(i).getHome().compareTo(schedule.get(i+1).getHome()));
					Game temp_1 = schedule.get(i);
					Game temp_2 = schedule.get(i + 1);
					
					schedule.set(i + 1, temp_1);
					schedule.set(i  , temp_2);
					sorted = true;
				}
				i++;
			}
			if(sorted == false)
			{
				break sort;
			}
			else
			{
				i = 0;
				sorted = false;
			}
			
		}
	}
	public void orderDate()
	{
		sort:
		while(true)
		{		
			boolean sorted = false;
			int i = 0;
			while(i + 1 < schedule.size()){
				
				if(schedule.get(i).getDate().compareToIgnoreCase(schedule.get(i+1).getDate()) > 0 )
				{
					//System.out.println(schedule.get(i).getHome() + schedule.get(i+1).getHome() + schedule.get(i).getHome().compareTo(schedule.get(i+1).getHome()));
					Game temp_1 = schedule.get(i);
					Game temp_2 = schedule.get(i + 1);
					
					schedule.set(i + 1, temp_1);
					schedule.set(i  , temp_2);
					sorted = true;
				}
				i++;
			}
			if(sorted == false)
			{
				break sort;
			}
			else
			{
				i = 0;
				sorted = false;
			}
			
		}
	}
	public void orderAwayScore()
	{
		sort:
		while(true)
		{		
			boolean sorted = false;
			int i = 0;
			while(i + 1 < schedule.size()){
				
				if(schedule.get(i).getAwayScore() > schedule.get(i+1).getAwayScore() )
				{
					Game temp_1 = schedule.get(i);
					Game temp_2 = schedule.get(i + 1);
					
					schedule.set(i + 1, temp_1);
					schedule.set(i  , temp_2);
					sorted = true;
				}
				i++;
			}
			if(sorted == false)
			{
				break sort;
			}
			else
			{
				i = 0;
				sorted = false;
			}
			
		}
	}
	public void orderHomeScore()
	{
		sort:
		while(true)
		{		
			boolean sorted = false;
			int i = 0;
			while(i + 1 < schedule.size()){
				
				if(schedule.get(i).getHomeScore() > schedule.get(i+1).getHomeScore() )
				{
					Game temp_1 = schedule.get(i);
					Game temp_2 = schedule.get(i + 1);
					
					schedule.set(i + 1, temp_1);
					schedule.set(i  , temp_2);
					sorted = true;
				}
				i++;
			}
			if(sorted == false)
			{
				break sort;
			}
			else
			{
				i = 0;
				sorted = false;
			}
			
		}
	}

}
