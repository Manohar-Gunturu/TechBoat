If you are using Mysql you have to import mysql-connecter-java jar into project WEB-INF/lib folder. Below is the Mypage.java Servlet which connects to database using getConnection() method in DBConnection class and prints an HTML select from SQL table.


		import java.io.IOException;
		import java.io.PrintWriter;
		import java.sql.Connection;
		import java.sql.ResultSet;
		import java.sql.SQLException;
		import java.sql.Statement;
		import javax.servlet.ServletException;
		import javax.servlet.annotation.WebServlet;
		import javax.servlet.http.Cookie;
		import javax.servlet.http.HttpServlet;
		import javax.servlet.http.HttpServletRequest;
		import javax.servlet.http.HttpServletResponse;

		import com.dao.DBConnection;
		@WebServlet("/Mypage")
		public class Mypage extends HttpServlet {
			
			protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				ResultSet rs = null;
				DBConnection db = new DBConnection();
				Statement stmt=null;
				try {			
				stmt = db.getConnection().createStatement();
				rs = stmt.executeQuery("select name from categories");
				out.println("<select>");
				while(rs.next()){
				out.println("<option value='"+rs.getString("name")+"'>"+rs.getString("name")+"</option>");
				}
				out.println("</select>");
				}catch (SQLException e) {
				 e.printStackTrace();
				}
				finally{
					try{
						db.close();
						if(rs != null)
						rs.close();
						if(stmt != null)
						stmt.close();
						} catch (SQLException e) {
						e.printStackTrace();
						}
					}
			}
		}