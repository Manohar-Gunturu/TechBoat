import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  
	Connection con=null;
	
	
	public Connection getConnection(){
		
	 try {
	  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost/dbname","username","password");
	 }
	 catch (ClassNotFoundException e) {
	   e.printStackTrace();
	 } catch (SQLException e) {
	   e.printStackTrace();
	  }
     
	 return con;
        
	}	    
	
	public void close(){
		try {
		  if(this.con != null)
		    this.con.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
	}
	
}
