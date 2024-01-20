<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
<div class="container">
<h1>AddTodo ${name}</h1>

<div>

<form:form method="POST" modelAttribute="todo">
<fieldset class="mb-3">				
	<form:label path="description">Description</form:label>
	<form:input type="text" path="description" required="required"/>
	<form:errors path="description" cssClass="text-warning"/>
	
</fieldset>
<fieldset class="mb-3">				
	<form:label path="date">Target Date</form:label>
	<form:input type="text" path="date" required="required"/>
	<form:errors path="date" cssClass="text-warning"/>
</fieldset>
<form:input type="hidden" path="status" />
<form:input type="hidden" path="name" />


<input type="submit" class="btn btn-success" name="Add Todo">
 </form:form>

</div>
</div>
<script type="text/javascript">
	$('.date').datepicker({
	    format: 'yyyy-mm-dd'
        startDate:'-3d'
	});
</script>

<%@ include file="common/footer.jspf" %>