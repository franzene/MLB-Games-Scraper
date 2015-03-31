import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class League {
	static Map<String, String> team = new HashMap<String, String>();

	public static Map<String, String> getTeams() 
	 {
		return team;
	 }

	public static String teamsContains(String line) 
	 {
	  Set<String> keys = team.keySet();
		
	  for (String key : keys) 
	   {
		if (line.contains(key)) 
		 {
		  return key;
		 }
		}
		return null;
	 }

	public static void print() 
	 {
	  System.out.println(team);
     }

	public static void teams() throws Exception 
	 {
	  @SuppressWarnings("resource")
		
	  Scanner in = new Scanner(new FileReader("teams.txt"));
	  String line;
	  String state;
	  String name;

	  while (in.hasNextLine()) 
	   {
		int split = 1;
		line = in.nextLine();
		String[] temp = line.split("\\s");
			// System.out.println(temp.length);
		for (int u = 0; u < temp.length; u++) 
		 {
		 }
		if (temp.length > 2) 
		 {
		  if (temp[0].contains("New") || temp[0].contains("Golden")|| temp[0].contains("San")|| temp[0].contains("Oklahoma")|| temp[0].contains("Los")) 
		   {
			state = temp[0] + " " + temp[1];
			split = 2;
		   } 
		  else 
		   {
			state = temp[0];
		   }
		  if (temp[0 + split] == "Trail") 
		   {
			name = temp[0 + split] + " " + temp[1 + split];
		   } 
		  else 
		   {
			name = temp[0 + split];
		   }
		  }
		 else 
		  {
		   state = temp[0];
		   name = temp[1];
		  }
		 team.put(state, name);
		 split = 1;	
		}
	}
}
