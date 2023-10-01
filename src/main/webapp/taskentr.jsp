<%@page import="java.util.List"%>
<%@page import="org.hibernate.*"%>
<%@page import="POJO.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Task Enter Succeful</title>
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
	<div class="container">
		<div class="row justify-content-center align-items-center" id="cc">
			<div class="col-md-6">


				<table class="table table-bordered  text-center ">
					<tr class="table-primary">
						<th>Task Title</th>

						<th>Task Description</th>


						<th colspan="2">Actions</th>
					</tr>



					<tbody>
						<%
						ragister r = new ragister();

						r.setId(Integer.parseInt(request.getParameter("rid")));

						SessionFactory sf = mainmethod.s();
						Session ss = sf.openSession();
						ss.getTransaction().begin();
						ScrollableResults in = ss.createQuery("from tasks where r = " + r.getId()).scroll();
						while (in.next()) {
							tasks d = (tasks) in.get(0);
							System.out.println(d);
						%>


						<tr>

							<td><%=d.getTask_Title()%></td>
							<td><%=d.getTask_Description()%></td>

							<td><a href="update.jsp?id=<%=d.getId()%>"
								class="btn btn-success">Edit</a></td>

							<td><a href="delet?id=<%=d.getId()%>"
								class="btn btn-danger">Delete</a></td>
						</tr>

						<%
						}
						ss.getTransaction().commit();
						ss.close();
						%>



					</tbody>
					<tr>
						<th colspan="4"><a class="btn btn-primary " href="home.jsp">Log
								OUT</a></th>
					</tr>

				</table>

			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>

</html>
