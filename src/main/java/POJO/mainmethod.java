package POJO;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class mainmethod {

	public static ragister r() {
		ragister r = new ragister();
		return r;
	}

	public static tasks t() {
		tasks t = new tasks();
		return t;
	}

	public static List<tasks> list_task() {
		List<tasks> t = new ArrayList<tasks>();

		return t;
	}
	public static SessionFactory s ()
	{
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
	
		return sf;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
