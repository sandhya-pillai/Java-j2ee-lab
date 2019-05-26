package q6;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class server
 */
@WebServlet("/server")
public class server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public server() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String name;
	        int age;
	        float basic,taxp,net,taxamt;
	        name=request.getParameter("pname");
	        age=Integer.parseInt(request.getParameter("age"));
	        basic=Float.parseFloat(request.getParameter("salary"));
	        taxp=Float.parseFloat(request.getParameter("tax"));
	        taxamt=(taxp/100)*basic;
	        net=basic-taxamt;
	        System.out.println("hi");
	        File f=new File("C:/Users/X240/eclipse-workspace/q6/TaxFile.txt");
	        PrintWriter pw=new PrintWriter(f);
	        pw.println("Name:"+name+"\nAge:"+age+"\nBasic Salary: Rs."+basic+"\nTax Deducted: Rs."+taxamt+"\nNet Salary: Rs."+net);
	        pw.close();
	        
	        
	        response.setContentType("text/html");
	        PrintWriter out=response.getWriter();
	        out.println("<html>"
	                + "<head><title>Tax Calculated</title></head>"
	                + "<body>"
	                + "<h1>Tax Information</h1>"
	                + "<p>Name:"+name+"</p><br>"
	                + "<p>Age:"+age+"</p><br>"
	                + "<p>Basic Salary: Rs."+basic+"</p><br>"
	                + "<p>Tax Deducted: Rs."+taxamt+"</p><br>"
	                + "<p>Net Salary: Rs."+net+"</p><br>"
	                + "</body></html>");
	        out.close();
	        
	        java.util.Scanner in=new java.util.Scanner(f);
	        while(in.hasNextLine()) {
	            System.out.println(in.nextLine());
	        }
	        in.close();
	}

}