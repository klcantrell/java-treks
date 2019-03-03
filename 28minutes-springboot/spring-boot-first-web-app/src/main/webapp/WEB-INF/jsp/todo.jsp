<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<fmt:formatDate pattern="MM/dd/yyyy" value="${todo.targetDate}" />

<html>
    <head>
        <title>First Web Application</title>
        <link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <form:form method="POST" modelAttribute="todo">
                <form:hidden path="id" />
                <fieldset class="form-group">
                    <form:label path="desc">Enter your todo</form:label>
                    <form:input path="desc" type="text" cssClass="form-control" required="required" />
                    <form:errors path="desc" cssClass="text-warning" />
                </fieldset>
                <fieldset class="form-group">
                    <form:label path="desc">Target Date</form:label>
                    <form:input path="targetDate" type="text" cssClass="form-control" required="required" />
                    <form:errors path="targetDate" cssClass="text-warning" />
                </fieldset>
                <button class="btn btn-success">Add</button>
            </form:form>
        <div/>
        <script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="/webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
        <script>
            $('#targetDate').datepicker({
                format : 'mm/dd/yyyy'
            });
        </script>
</body>
</html>