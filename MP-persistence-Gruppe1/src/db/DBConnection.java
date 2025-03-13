package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;


public class DBConnection {   
	//Constants used to get access to the database
	
	//private static final String  driver = "jdbc:sqlserver://localhost:1433";
//	private static final String serverAddress = "jdbc:sqlserver:hildur.ucn.dk";
//	private static final String databaseName = ";databaseName=DMA-CSD-S243_10647447";
//	private static String userName = ";user=sa";
//	private static String password = ";password=Password1!";
//	private static String encryption = ";encrypt=false";
	
//	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "DMA-CSD-S243_10647447";
	//private static final String serverAddress = "localhost";
	private static final String serverAddress = "hildur.ucn.dk";
	private static final int serverPort = 1433;
	private static final String userName = "DMA-CSD-S243_10647447";
	private static final String password = "Password1!";

   
    private DatabaseMetaData dma;
    private static Connection con;
    
    // an instance of the class is generated
    private static DBConnection  instance = null;

    // the constructor is private to ensure that only one object of this class is created
    private DBConnection()
    {
    	//String url = driver + databaseName + userName + password + encryption;
    	String url = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=false",
				serverAddress, serverPort, dbName, userName, password);
    	System.out.println("URL: " + url);

        try{
            //load of driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver class loaded ok");
          
        }
        catch(Exception e){
            System.out.println("Cannot find the driver");
            System.out.println(e.getMessage());
        }
        try{
            //connection to the database
            con = DriverManager.getConnection(url);
            con.setAutoCommit(true);
            dma = con.getMetaData(); // get meta data
            System.out.println("Connection to " + dma.getURL());
            System.out.println("Driver " + dma.getDriverName());
            System.out.println("Database product name " + dma.getDatabaseProductName());
        }//end try
        catch(Exception e){
            System.out.println("Problems with the connection to the database:");
            System.out.println(e.getMessage());
            System.out.println(url);
        }//end catch
    }//end  constructor
	   
  //closeDb: closes the connection to the database
    public static void closeConnection()
    {
       	try{
            con.close();
            instance= null;
            System.out.println("The connection is closed");
        }
         catch (Exception e){
            System.out.println("Error trying to close the database " +  e.getMessage());
         }
    }//end closeDB
		
    //getDBcon: returns the singleton instance of the DB connection
    public Connection getDBcon()
    {
       return con;
    }
    //getDBcon: returns the singleton instance of the DB connection
    public static boolean instanceIsNull()
    {
       return (instance == null);
    }    
    //this method is used to get the instance of the connection
    public static DBConnection getInstance()
    {
        if (instance == null)
        {
          instance = new DBConnection();
        }
        return instance;
    }
    public static boolean getOpenStatus() {
    	boolean isOpen = false;
    	try {
    		isOpen = (!con.isClosed());
    	} catch (Exception sclExc) {
    		isOpen = false;
    	}
    	return isOpen;
    }

}//end DbConnection
