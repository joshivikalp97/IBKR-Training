package example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<pizza> p=new Vector<pizza>();
		pizza piz;
		int flag=0;
		Customer c=null;
		 String cname = request.getParameter("custname");
		 String cadd = request.getParameter("custadd");
		 long cphone = Long.parseLong(request.getParameter("custphone"));
		 try {
			Customer prev=CustomerReport.RetrieveByCphone(cphone);
			if(prev!=null)
			 {
				c=prev;
				flag=1;
			 }
			 else
			 {
			 	c=new Customer(cname,cadd,cphone);
			 }
			request.setAttribute("isPrev", flag);
			 request.setAttribute("cust", c); 
			int index = Integer.parseInt(request.getParameter("count"));
			 int count=0, top=0, cop=0, tot=0;
			String ptype,pvariant,pname,ptopping,psize;
			int pquantity;
			String description="";
			for(int i=1;i<=index;i++)
			 {
				 ptype = request.getParameter("type"+i);
				 pvariant = request.getParameter("variant"+i);
				 pname = request.getParameter("name"+i);
				 psize = request.getParameter("size"+i);
				 ptopping = request.getParameter("topping"+i);
				 pquantity = Integer.parseInt(request.getParameter("quantity"+i));
				 count=count+pquantity;
				 if(pvariant.equalsIgnoreCase("Italian"))
					 piz=new ItalianPizza(ptype,ptopping,pname,psize,pquantity,pvariant);
				 else
					 piz=new MexicanPizza(ptype,ptopping,pname,psize,pquantity,pvariant);
				 	
				 p.add(piz);
					description=""+" "+psize+" "+" "+ptype+" "+" "+pvariant+" "+pname;
					tot=tot+piz.getCostOfPizza();
			 }
			String desc;
			if(count==1)
				desc=""+"1 "+description;
			else
				desc=""+count+" pizzas";
			Bill b=new Bill(c,p,cname,desc);
			request.setAttribute("bill", b);
			request.setAttribute("pizz", p);
			RequestDispatcher r=request.getRequestDispatcher("order.jsp");
			r.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		
	}
}
