package POJO;

import java.util.List;

import javax.persistence.*;

@Entity
public class ragister {
	@Id
	@GeneratedValue
	int id;
	String Email;
	String Password;
	String first_name;
	String Last_name;
	@OneToMany(mappedBy = "r")
	List<tasks> t;

	public ragister() {

		// TODO Auto-generated constructor stub
	}

	public ragister( String email, String password, String first_name, String last_name, List<tasks> t) {
		super();
		
		Email = email;
		Password = password;
		this.first_name = first_name;
		Last_name = last_name;
		this.t = t;
	}

	@Override
	public String toString() {
		return "ragister [id=" + id + ", Email=" + Email + ", Password=" + Password + ", first_name=" + first_name
				+ ", Last_name=" + Last_name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public List<tasks> getT() {
		return t;
	}

	public void setT(List<tasks> t) {
		this.t = t;
	}
}
