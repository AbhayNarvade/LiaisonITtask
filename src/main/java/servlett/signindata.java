package servlett;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import POJO.ragister;



/**
 * Servlet implementation class signindata
 */
@WebServlet("/signindata")
public class signindata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signindata() {
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
		String email = request.getParameter("Email");
		String Password = request.getParameter("Password");
		 PrintWriter out = response.getWriter(); 

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		ScrollableResults signin = ss.createQuery("from ragister").scroll();
		while(signin.next())
		{
			ragister e = (ragister)signin.get(0);
			if(e.getEmail().equals(email)&& e.getPassword().equals(Password))
				
			{
					System.out.print(e);		
//				 out.print("<a href='taskentrypage.jsp?rid="+e.getId()+"'>Go to Task System</a>");  
				 response.sendRedirect("taskentrypage.jsp?rid="+e.getId());
			}
			else {
				out.print("<h1>Something Wrong Recheck your input</h1>");
				request.getRequestDispatcher("signinpage.jsp").include(request, response);
			}
			
		}
		
		ss.getTransaction().commit();
		ss.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
