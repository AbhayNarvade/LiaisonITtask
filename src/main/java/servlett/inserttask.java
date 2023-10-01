package servlett;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import POJO.mainmethod;
import POJO.ragister;
import POJO.tasks;

/**
 * Servlet implementation class inserttask
 */
@WebServlet("/inserttask")
public class inserttask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserttask() {
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
		String title = request.getParameter("tasktitle");
		String Description = request.getParameter("Description");
		ragister r = new ragister();
		r.setId( Integer.parseInt(request.getParameter("ragisterid"))) ;
		
//		System.out.print(title+" "+Description+" "+r.getId());
		
		SessionFactory sf = mainmethod.s();
		Session ss = sf.openSession();
		ss.getTransaction().begin();
		r = (ragister) ss.get(ragister.class,r.getId());
		
		
		System.out.println(r);
		
		tasks data = new tasks ();
		data.setTask_Description(Description);
		data.setTask_Title(title);
		
		
		
		List<tasks> t =new ArrayList<tasks>();
		data.setR(r);
		t.add(data);
		
//		System.out.println(t);
		
		r.setT(t);
		
		System.out.println(r);
		
		SessionFactory sf1 =mainmethod.s();
		Session ss1 = sf1.openSession();
		ss1.getTransaction().begin();
		ss1.update(r);
		ss1.save(data);
		
//	We used this method to fetch data
		
//		ScrollableResults in = ss1.createQuery("from tasks where r = " + r.getId()).scroll();
//		while(in.next()) {
//			tasks d = (tasks)in.get(0);
//			System.out.println(d);
//			
//		}
		
		ss1.getTransaction().commit();
		sf.close();
		
		
		
//		List<tasks> in =new ArrayList<tasks>();
//		t.add(data);
		
		 response.sendRedirect("taskentr.jsp?rid="+r.getId());
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
