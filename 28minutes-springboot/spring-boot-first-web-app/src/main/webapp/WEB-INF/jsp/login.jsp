<html>
    <head>
        <title>First Web Application</title>
    </head>
    <body>
        <form method="POST">
            <p style="color: red;">${errorMessage}</p>
            <label for="name">Name: </label>
            <input type="text" name="name" id="name">
            <label for="password">Password: </label>
            <input type="password" name="password" id="password">
            <button>Submit</button>
        </form>
        Please login
    </body>
</html>