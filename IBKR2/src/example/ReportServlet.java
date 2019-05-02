package example;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int flag=0;
		Sales s;
		
			s = SalesReport.readFromFile();
		
		if(s==null || !s.getDt().toString().equalsIgnoreCase(LocalDate.now().toString()))
		{
			flag=1;
		}
		
		request.setAttribute("sales", s);
		request.setAttribute("isSaleNull", flag);
		
		RequestDispatcher r=request.getRequestDispatcher("report.jsp");
		r.forward(request, response);
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}
