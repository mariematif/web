<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String type = request.getParameter("type");
    String titre = (type != null && type.equals("admin")) ? "Connexion Administrateur" : "Connexion Collaborateur";
%>
<!DOCTYPE html>
<html>
<head>
    <title><%= titre %> - Gestionnaire de Tâches</title>
    <meta charset="UTF-8">
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #673ab7, #9575cd);
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .login-box {
            background: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
            width: 400px;
        }

        .login-box h2 {
            margin-bottom: 20px;
            text-align: center;
            color: #673ab7;
        }

        .login-box input[type="text"],
        .login-box input[type="password"] {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        .login-box input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #673ab7;
            color: white;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-box input[type="submit"]:hover {
            background-color: #5e35b1;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="login-box">
    <h2><%= titre %></h2>

    <form method="post" action="LoginServlet">
        <input type="hidden" name="type" value="<%= type %>">

        <label>Email</label>
        <input type="text" name="email" placeholder="exemple@mail.com" required>

        <label>Mot de passe</label>
        <input type="password" name="password" placeholder="••••••••" required>

        <input type="submit" value="Se connecter">
    </form>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>
</div>

</body>
</html>
