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
 * Servlet implementation class Editdata
 */
@WebServlet("/Editdata")
public class Editdata extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Editdata() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		tasks t = new tasks();
		t.setId(Integer.parseInt(request.getParameter("Taskid")));
		t.setTask_Title(request.getParameter("Title"));
		t.setTask_Description(request.getParameter("Description"));

		SessionFactory sf = mainmethod.s();
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		tasks tt = (tasks) ss.get(tasks.class, t.getId());
		tt.setTask_Description(t.getTask_Description());
		tt.setTask_Title(t.getTask_Title());
		ss.update(tt);
		ragister rr = tt.getR();
		System.out.println("before");
		System.out.println(rr.getId());
		System.out.println("after");
		ss.getTransaction().commit();
		ss.close();
		
		response.sendRedirect("taskentrypage.jsp?rid="+rr.getId());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
