<%@ include file="common/header.jspf" %>
<%@ include file="common/nav.jspf" %>
        <div class="container">
            <form method="POST">
                <p style="color: red;">${errorMessage}</p>
                <label for="name">Name: </label>
                <input type="text" name="name" id="name">
                <label for="password">Password: </label>
                <input type="password" name="password" id="password">
                <button>Submit</button>
            </form>
            <p>Please login</p>
        </div>
<%@ include file="common/footer.jspf" %>