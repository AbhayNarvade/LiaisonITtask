<!DOCTYPE html>
<%@ page import="POJO.ragister"%>
<%@ page import=" javax.servlet.http.HttpSession"%>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Task Entry</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous" />
<link rel="stylesheet" href="style.css" />
</head>
<body>


	<%
	ragister rr = new ragister();
	rr.setId(Integer.parseInt(request.getParameter("rid")));

	System.out.print("task" + rr.getId());
	%>

	<div class="container">
		<div class="row justify-content-center align-items-center" id="cc">
			<div class="col-md-6">
				<form action="inserttask" method="post">
					<p class="text-center" id="heading">Task Entry</p>
					<div>
						<table class="table ">
							<tbody>
								<tr>
									<td>Enter Your task Title</td>
									<td><input type="text" name="tasktitle" id=""></td>
									<td><input type="hidden" name="ragisterid"
										value=<%=rr.getId()%>></td>

								</tr>
								<tr>
									<td>Enter Your task Description</td>
									<td><textarea name="Description" cols="30" rows="2"></textarea></td>
									<td colspan="1"></td>
								</tr>
								<tr>


				<td><a class="btn btn-danger "	href="taskentr.jsp?rid=<%=rr.getId()%>">View</a></td>
				<td ><input type="submit" class="btn btn-primary  "></td>
				<td><a class="btn btn-primary " href="home.jsp">Log OUT</a></td>



								</tr>
							</tbody>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>

</html>
