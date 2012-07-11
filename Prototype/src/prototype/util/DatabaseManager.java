package prototype.util;

//TODO: discuss all that needs to be included in this class
public class DatabaseManager {
	private static DatabaseManager instance = null;
	
	private DatabaseManager()
	{
		
	}
	
	public static DatabaseManager getInstance()
	{
		if(instance == null)
		{
			instance = new DatabaseManager();
		}
		
		return instance;
	}
	
	//TODO: create a table for users settings, users events (birthday, wedding etc) and users customizations.  

}
