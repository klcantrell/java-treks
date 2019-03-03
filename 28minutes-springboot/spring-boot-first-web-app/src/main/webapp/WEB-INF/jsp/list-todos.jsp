<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
        <div class="container">
            <table class="table table-striped">
                <h1>Your Todos</h1>
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>Done?</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.desc}</td>
                            <td><fmt:formatDate value="${todo.targetDate}" pattern="MM/dd/yyyy"/></td>
                            <td>${todo.isDone}</td>
                            <td>
                                <a href="/update-todo/${todo.id}" class="btn btn-success">Edit</button>
                            </td>
                            <td>
                                <form method="POST">
                                    <button formaction="/delete-todo/${todo.id}" type="submit" class="btn btn-danger">X</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div>
                <a class="btn" href="/add-todo">Add todo</a>
            </div>
        <div/>
<%@ include file="common/footer.jspf" %>