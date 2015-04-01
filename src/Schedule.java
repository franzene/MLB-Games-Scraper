import java.util.ArrayList;
import java.util.List;

public class Schedule 
 {
  static BinaryHeap<Game> schedule = new BinaryHeap<Game>();

  Schedule(String sDate, String eDate) throws Exception 
   {
	   Web oddsShark = new Web();
	   oddsShark.readSite(sDate,eDate);
   }

  Schedule(String getDate) throws Exception 
   {
	Web oddsShark = new Web();
	//oddsShark.readSite(sDate,eDate);
   }

  public static void addGame(Game game) 
   {
	   schedule.insert(game);
   }

  public static ArrayList<Game> getScedule() 
   {
	   return schedule.getOutput();
   }

  public void saveSchedule() 
   {

   }

  public void print() 
   {
	   ArrayList<Game> temp = schedule.getOutput();
	   
	   for(int i = 0; i < temp.size(); i++)
	    {
	     temp.get(i).print();
	    }
   }

 }
