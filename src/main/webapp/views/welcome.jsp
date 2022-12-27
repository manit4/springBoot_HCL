<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="masterPage">Master</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="about_us.jsp">About Us</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="contact_us.jsp">Contact Us</a>
        </li>
         <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Logout</a>
        </li>
       
      </ul>
    </div>
  </div>
</nav>

<br>

<h2>Welcome ${userData.getName() }</h2>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Username</th>
      <th scope="col">Complete Name</th>
      <th scope="col">Email</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><${userData.getUsername()} </td>
      <td>${userData.getName() }</td>
      <td>${userData.getEmail() }</td>
    </tr>
   
  </tbody>
</table>
<br><br><br><br><br><br><br><br><br><br>
<footer class="footer mt-auto py-3 bg-light">
  <div class="container">
    <span style="margin-left: 800px" class="text-muted">Copyright & Powered by Winter Batch.</span>
  </div>
</footer>
</body>
</html>