<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
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
<%@ include file="common/footer.jspf" %>