<%--
  Created by IntelliJ IDEA.
  User: amirreza
  Date: 12/25/2024
  Time: 10:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>login-menu</title>
    <meta charset="UTF-8" />
    <meta name="viewport"
          content="width=device-width,
                   initial-scale=1,
                   shrink-to-fit=no" />
    <link rel="stylesheet"
          href=
                  "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
</head>
<body style="background: #a77bff">
<h1 class="text-center" style="color: #1a1d20">
    MaktabSharif
</h1>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <form action="/register" method="post">
                        <div class="from-group">
                            <label for="username">Username</label>
                            <input name="username" id="username">
                        </div>
                        <div class="from-group" >
                            <label for="password">Password</label>
                            <input name="password" type="password" id="password">
                        </div>
                        <button class="btn btn-danger">
                            Register
                        </button>
                        <p class="mt-3">
                           I Have already account =
                            <a href="./login.jsp">account</a>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>
