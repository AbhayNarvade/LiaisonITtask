package POJO;

import javax.persistence.*;

@Entity
public class tasks {
	@Id
	@GeneratedValue
	int id;
	String Task_Title;
	String Task_Description;
	@ManyToOne
	ragister r;

	public tasks() {

		// TODO Auto-generated constructor stub
	}

	public tasks(int id, String task_Title, String task_Description, ragister r) {
		super();
		this.id = id;
		Task_Title = task_Title;
		Task_Description = task_Description;
		this.r = r;
	}

	@Override
	public String toString() {
		return "tasks [id=" + id + ", Task_Title=" + Task_Title + ", Task_Description=" + Task_Description + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask_Title() {
		return Task_Title;
	}

	public void setTask_Title(String task_Title) {
		Task_Title = task_Title;
	}

	public String getTask_Description() {
		return Task_Description;
	}

	public void setTask_Description(String task_Description) {
		Task_Description = task_Description;
	}

	public ragister getR() {
		return r;
	}

	public void setR(ragister r) {
		this.r = r;
	}
}
