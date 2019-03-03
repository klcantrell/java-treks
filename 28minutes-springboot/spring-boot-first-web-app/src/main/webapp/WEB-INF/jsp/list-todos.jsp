<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Todos for ${name}</title>
        <link href="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
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
                            <td>${todo.targetDate}</td>
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

        <script src="/webjars/jquery/1.9.1/jquery.min.js"></script>
        <script src="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>