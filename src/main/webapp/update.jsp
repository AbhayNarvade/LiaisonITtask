<%@page import="java.util.List"%>
<%@page import="org.hibernate.*"%>
<%@page import="POJO.*"%>
<%@page import="servlett.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Task Management System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<%
	tasks t = new tasks();
	t.setId(Integer.parseInt(request.getParameter("id")));
	SessionFactory sf = mainmethod.s();
	Session ss = sf.openSession();
	ss.getTransaction().begin();
	t = (tasks) ss.get(tasks.class, t.getId());
	%>
	<div class="container">
		<div class="row justify-content-center align-items-center" id="cc">
			<div class="col-md-6">

				<form action="Editdata" method="post">
					<p class="text-center" id="heading">Task Entry</p>
					<div>
						<table class="table ">

							<tbody>

								<tr>
									<td>Your task Id</td>
									<td><input type="number" name="Taskid"
										value=<%=t.getId()%>></td>
								</tr>
								<tr>
									<td>Enter Your task Title</td>
									<td><input type="text" name="Title"
										value=<%=t.getTask_Title()%>></td>
								</tr>

								<tr>
									<td>Enter Your task Description</td>

									<td><input type="text" name="Description"
										value=<%=t.getTask_Description()%>></td>

								</tr>

								<tr>
									<th colspan="2"><button type="submit"
											class="btn btn-primary ">Submit</button></th>
								</tr>

							</tbody>
						</table>
					</div>
				</form>
				<%
				ss.getTransaction().commit();
				ss.close();
				%>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>

</html>
