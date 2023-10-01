package servlett;

import java.io.IOException;
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
 * Servlet implementation class delet
 */
@WebServlet("/delet")
public class delet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delet() {
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
		tasks t = new tasks();
		t.setId(Integer.parseInt( request.getParameter("id")));
		
		SessionFactory sf = mainmethod.s();
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		tasks tt = (tasks) ss.get(tasks.class, t.getId());
		ss.delete(tt);
		ragister r = tt.getR();
		ss.getTransaction().commit();
		ss.close();
		response.sendRedirect("taskentrypage.jsp?rid="+r.getId());

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
