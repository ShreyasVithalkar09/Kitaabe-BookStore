<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"/>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<title>Book Store</title>
</head>
<body>
<% if(request.getSession().getAttribute("username") == null) {
		response.sendRedirect("loginform.jsp");
	}%>
<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="admin.jsp">Admin Panel</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item mr-3">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="LogoutServlet"><button type="button" class="btn btn-dark btn-sm">Logout</button></a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>
<div class="container-sm w-50 m-auto">
<h3>Hello ${sessionScope.username}!</h3>
<h1>Welcome to Book Store</h1>
<br>
	
	<a href="bookform.jsp"><button class="btn btn-outline-primary mb-3">Add a new Book</button></a>
	
	<a href="GetAllBooksServlet"><button class="btn btn-outline-primary mb-3">Get all books</button></a>
	<a href="singlebookform.jsp"><button class="btn btn-outline-primary mb-3">Get a book</button></a>
	<a href="updatebookform.jsp"><button class="btn btn-outline-info mb-3">Update book</button></a>
	<a href="deletebookform.jsp"><button class="btn btn-outline-danger mb-3">Delete a book</button></a>
	
	<br>
	<% String msg = (String) request.getAttribute("msg"); %>
	<br>
	<% if(msg!=null){  %>
	<div class = "alert alert-primary">
   							<a href = "#" class = "close" data-dismiss = "alert"> &times; </a>  
  						 <strong><%= msg %></strong>
						</div>
		<%} %>
	
	</div>
	
	
	
</body>
</html>