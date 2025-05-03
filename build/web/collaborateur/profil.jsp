<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profil Collaborateur</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background-color: #002f67;
            color: white;
            padding: 20px 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 26px;
            font-weight: bold;
        }

        nav a {
            margin-left: 30px;
            text-decoration: none;
            color: white;
            font-weight: 500;
        }

        nav a:hover {
            text-decoration: underline;
        }

        .container {
            max-width: 600px;
            background-color: white;
            margin: 50px auto;
            padding: 40px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        h2 {
            color: #002f67;
            margin-bottom: 30px;
        }

        label {
            display: block;
            margin-top: 20px;
            font-weight: bold;
        }

        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .btn {
            background-color: #002f67;
            color: white;
            padding: 12px 24px;
            border: none;
            margin-top: 25px;
            border-radius: 6px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #004280;
        }
    </style>
</head>
<body>

<header>
    <div class="logo">Gestionnaire de Tâches</div>
    <nav>
        <a href="home.jsp">Accueil</a>
        <a href="dashboard.jsp">Mes tâches</a>
        <a href="profil.jsp">Profil</a>
        <a href="../LogoutServlet">Déconnexion</a>
    </nav>
</header>

<div class="container">
    <h2>👤 Mon Profil</h2>

    <p><strong>Nom :</strong> <%= user.getNom() %></p>
    <p><strong>Email :</strong> <%= user.getEmail() %></p>

 <form method="post" action="../ModifierMotDePasseServlet">

    <label>Nouveau mot de passe</label>
    <input type="password" name="nouveauMotDePasse" required>

    <label>Confirmer mot de passe</label>
    <input type="password" name="confirmerMotDePasse" required>

    <input class="btn" type="submit" value="Mettre à jour le mot de passe">
</form>

<% if (request.getAttribute("message") != null) { %>
    <p style="color: green;"><%= request.getAttribute("message") %></p>
<% } %>
<% if (request.getAttribute("erreur") != null) { %>
    <p style="color: red;"><%= request.getAttribute("erreur") %></p>
<% } %>

</div>

</body>
</html>
