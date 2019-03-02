<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Todos for ${name}</title>
    </head>
    <body>
        <h1>Your Todos</h1>
        <table>
            <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Done?</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.desc}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.isDone}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div>
            <a href="/add-todo">Add todo</a>
        </div>
    </body>
</html>