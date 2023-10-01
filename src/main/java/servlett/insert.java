package servlett;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import POJO.mainmethod;
import POJO.ragister;
import POJO.tasks;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		String email=request.getParameter("Email");
		String Password=request.getParameter("Password");
		String Firstname=request.getParameter("Firstname");
		String Lastname=request.getParameter("Lastname");
		
	
//		System.out.println(email+" "+Password+" "+Firstname+" "+Lastname);
		
	      PrintWriter out = response.getWriter();  
		
		ragister r = new ragister();
		r.setEmail(email);
		r.setPassword(Password);
		r.setFirst_name(Firstname);
		r.setLast_name(Lastname);

		
		SessionFactory sf =mainmethod.s();
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		ss.save(r);
		ss.getTransaction().commit();
		sf.close();
		
		System.out.println(r.getId());
		response.sendRedirect("taskentrypage.jsp?rid="+r.getId());
//		 out.print("<a href='taskentrypage.jsp?rid="+r.getId()+"'>visit</a>");  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
