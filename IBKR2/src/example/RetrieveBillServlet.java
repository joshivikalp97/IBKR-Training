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
 * Servlet implementation class RetrieveBillServlet
 */
@WebServlet("/RetrieveBillServlet")
public class RetrieveBillServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int bno=Integer.parseInt(request.getParameter("bno"));
		Bill b;
		b = BillReport.RetrieveBill(bno);
		int flag=1;
		if(b!=null)
		{
			
			flag=0;
		}
		request.setAttribute("bill", b);
		request.setAttribute("isBillNull", flag);
		
		RequestDispatcher r=request.getRequestDispatcher("retrieveBill.jsp");
		r.forward(request, response);
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
