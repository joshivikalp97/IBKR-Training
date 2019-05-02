package example;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetrieveCustServlet
 */
@WebServlet("/RetrieveCustServlet")
public class RetrieveCustServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
		Customer c=null;
		String searchby=request.getParameter("searchby");
		int cno;
		long cphone;
		int flag=1;
		if(searchby.equalsIgnoreCase("Phone"))
		{
			cphone=Long.parseLong(request.getParameter("cphone"));
			
				c=CustomerReport.RetrieveByCphone(cphone);
			
		}
		else
		{
			cno=Integer.parseInt(request.getParameter("cno"));
			
				c=CustomerReport.RetrieveByCno(cno);
			
		}
		if(c!=null)
		{
			flag=0;
		}
		request.setAttribute("customer", c);
		request.setAttribute("isCustNull", flag);
		
		RequestDispatcher r=request.getRequestDispatcher("retrieve.jsp");
		r.forward(request, response);
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
