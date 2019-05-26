<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    

 	<%	Connection con = null;
 	try{
 		Class.forName("com.mysql.cj.jdbc.Driver");
         con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt","root","root");
    }
	catch (Exception e) {
		e.printStackTrace();
	}
 	Statement stmt = con.createStatement();
	String query = "SELECT * FROM tshirt;";
	ResultSet rs = stmt.executeQuery(query);
 	%>
<html>
<head><title>Display</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Order No.</th>
			<th>Colour</th>
			<th>Chest pocket</th>
			<th>Tagline</th>
			<th>Accessories</th>
		</tr>
		<tbody>
			<% while(rs.next()) { %>
				<tr>
					<td><%= rs.getInt("orderno") %></td>
					<td><%= rs.getString("colour") %></td>
					<td>
						<%if (rs.getInt("pocket")== 1){%> Yes
						<%}else {%> No <%} %>
					</td>
					<td><%=rs.getString("tag") %></td>
					<td><%= rs.getString("acc") %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>