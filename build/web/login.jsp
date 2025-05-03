<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String type = request.getParameter("type");
    String titre = "Connexion";
    if ("admin".equals(type)) {
        titre = "Connexion Administrateur";
    } else if ("collaborateur".equals(type)) {
        titre = "Connexion Collaborateur";
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title><%= titre %> - Gestionnaire de Tâches</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(to right, #002f67, #003a80);
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
            color: #002f67;
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
            background-color: #002f67;
            color: white;
            border: none;
            border-radius: 6px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .login-box input[type="submit"]:hover {
            background-color: #004488;
        }

        .error {
            color: red;
            text-align: center;
            margin-top: 15px;
        }

        .login-box .back-link {
            margin-top: 15px;
            text-align: center;
        }

        .login-box .back-link a {
            color: #002f67;
            text-decoration: none;
        }

        .login-box .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="login-box">
    <h2><%= titre %></h2>

    <form method="post" action="LoginServlet">
        <input type="hidden" name="type" value="<%= type != null ? type : "" %>">
        <input type="text" name="email" required placeholder="Email">
        <input type="password" name="password" required placeholder="Mot de passe">
        <input type="submit" value="Connexion">
    </form>

    <% if (request.getAttribute("error") != null) { %>
        <div class="error"><%= request.getAttribute("error") %></div>
    <% } %>

    <div class="back-link">
        <a href="index.jsp">← Retour à l’accueil</a>
    </div>
</div>

</body>
</html>
