import java.util.*;

public class Game implements Comparable<Game>
{
	private String away;
	private String home;
	private int awayScore;
	private int homeScore;
	String time;
	String date;

	public Game(String a, String h, int as, int hs, String d) 
	 {
	  away = a;
	  home = h;
	  awayScore = as;
	  homeScore = hs;
	  date = d;
	 }

	public Game(Game temp) 
	 {
	  away = temp.away;
	  home = temp.home;
	  awayScore = temp.awayScore;
	  homeScore = temp.homeScore;
	 }

	public void setAway(String i) 
	 {
	  away = i;
	 }

	public void setHome(String i)
	 {
	  home = i;
	 }

	public void setawayScore(int i) 
	 {
	  awayScore = i;
	 }

	public void sethomeScore(int i) 
	 {
	  homeScore = i;
	 }

	public String getAway() 
	 {
	  return away;
	 }

	public String getHome() 
	 {
	  return home;
	 }

	public int getAwayScore() 
	 {
	  return awayScore;
	 }

	public int getHomeScore() 
	 {
	  return homeScore;
	 } 

	public String getDate() 
	 {
	  return date;
	 }

	public void print() 
	 {
	  System.out.print(away + " VS ");
	  System.out.print(home);
	  System.out.println(" " + date);
	 }
	 
	public int compareTo(Game o)
	 {
	  int rtnValue = 0;
	 
	  ArrayList<Integer> thisDate = new ArrayList<Integer>();
   ArrayList<Integer> otherDate = new ArrayList<Integer>();
   
   String tMonth = (this.date.substring(0,2));
   String tDay = (this.date.substring(3,5));
   String tYear = (this.date.substring(6,10));
   
   String oMonth = (o.date.substring(0,2));
   String oDay = (o.date.substring(3,5));
   String oYear = (o.date.substring(6,10));
   
   thisDate.add(Integer.parseInt(tYear));
   thisDate.add(Integer.parseInt(tMonth));
   thisDate.add(Integer.parseInt(tDay));
   
   otherDate.add(Integer.parseInt(oYear));
   otherDate.add(Integer.parseInt(oMonth));
   otherDate.add(Integer.parseInt(oDay));
   
   int temp = thisDate.get(0).compareTo(otherDate.get(0));
    
   if(temp == 0)//same year
    {
     temp = thisDate.get(1).compareTo(otherDate.get(1));
     
     if(temp == 0)//same month
      {
       temp = thisDate.get(2).compareTo(otherDate.get(2));
       
       if(temp == 0)//equal day value
        {
         rtnValue =  0;
        }
       else if(temp < 0)//less month value
        {
         rtnValue = -1;
        }
       else//greater month value
        {
         rtnValue = 1;
        }
      }
     else if(temp < 0)//less month value
      {
       rtnValue = -1;
      }
     else//greater month value
      {
       rtnValue = 1;
      }
    }
   else if(temp < 0)//less year value
    {
     rtnValue = -1;
    }
   else//greater year value
    {
     rtnValue = 1;
    }
   return rtnValue; 
	 }
}
