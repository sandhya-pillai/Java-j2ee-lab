package practiceTshirt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
@WebServlet("/tshirt")
public class tshirt extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{	response.setContentType("text/html");
	String tag = request.getParameter("tag");
	String colour = request.getParameter("colour");
	String[] accessories = request.getParameterValues("acc");
	int pocket = Integer.parseInt(request.getParameter("pocket"));
	int on=0;
	String acc = "";
	for (String x : accessories )
		acc = acc + x + " ";


		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt", "root", "root");
			Statement stmt1= con.createStatement();
			ResultSet rs= stmt1.executeQuery("select * from tshirt;");
			if(!rs.isBeforeFirst())
			{
				on=100;
			}
			rs.afterLast();
			if( rs.previous())
			{
				on=rs.getInt("orderno");
				on++;
			}

			PreparedStatement stmt ;//= conn.prepareStatement("insert into tshirt values(?,?,?,?,?)");

			stmt = (PreparedStatement) con.prepareStatement("insert into tshirt values(?,?,?,?,?);");
			stmt.setInt(1,on);
			stmt.setString(2, colour);
			stmt.setInt(3, pocket);
			stmt.setString(4, tag);
			stmt.setString(5,acc );
			stmt.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		

		RequestDispatcher red=request.getRequestDispatcher("display.jsp");
        red.forward(request, response);
    /*
		PrintWriter out=response.getWriter();
		out.println("<html>"
				+ "<body>"
				+ "<table>"
				+ "<tr><td>Orderno</td><td>color</td><td>pocket</td><td>tag</td><td>acc</td></tr>"
				+ "<tr>"
				+ "<td>"+on+"</td>"
				+"<td>"+colour+"</td>"
				+"<td>"+pocket+"</td>"
				+"<td>"+tag+"</td>"
				+"<td>"+acc+"</td>"
				+"</tr>"
				+"</table>"
				+"</body>"
				+"</html>");
		*/
	}
}
