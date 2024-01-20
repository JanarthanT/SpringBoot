<%@ include file="common/header.jspf" %>

<%@ include file="common/nav.jspf" %>
<div class="container">
<h1>Welcome ${name}</h1>
<hr>

<table class="table">
  <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Description</th>
      <th>Date</th>
      <th>Status</th>
      <th></th>
       <th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${todos}" var ="todo" >
       
      
    <tr>
    
      <td>${todo.id}</td>
      <td>${todo.name}</td>
      <td>${todo.description}</td>
      <td>${todo.date}</td>
      <td>${todo.status}</td>
      <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete ${todo.id}</a></td>
      <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">update ${todo.id}</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>

 <a href="add-todo" class="btn btn-success">ADD TODO</a>
<%@ include file="common/footer.jspf" %>