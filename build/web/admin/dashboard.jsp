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
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Gestionnaire de Tâches</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f4f9;
            margin: 0;
        }
        header {
            background: linear-gradient(to right, #5e35b1, #7e57c2);
            color: white;
            padding: 20px 40px;
        }
        header .logo {
            font-size: 24px;
            font-weight: bold;
        }
        nav a {
            color: white;
            margin-left: 20px;
            text-decoration: none;
            font-weight: 500;
        }
        nav a:hover {
            text-decoration: underline;
        }
        .welcome {
            padding: 30px 40px;
            font-size: 22px;
        }
        .dashboard-cards {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
            padding: 0 40px 40px;
            gap: 20px;
        }
        .card {
            flex: 1 1 250px;
            padding: 30px;
            border-radius: 10px;
            background-color: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .card h3 {
            margin-bottom: 10px;
            font-size: 20px;
            color: #5e35b1;
        }
        .card p {
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>

<header class="d-flex justify-content-between align-items-center">
    <div class="logo">Gestionnaire de Tâches</div>
    <nav>
        <a href="../ProjetController">Projets</a>
        <a href="../CategorieTacheController">Catégories</a>
        <a href="../TacheController">Tâches</a>
        <a href="../UserController">Utilisateurs</a>
        <a href="../LogoutServlet">Déconnexion</a>
    </nav>
</header>

<div class="welcome">
    Bonjour <strong><%= user.getNom() %></strong>, bienvenue dans votre espace Administrateur 👋
</div>

<div class="dashboard-cards">
    <div class="card">
        <h3>Projets</h3>
        <p>10</p>
    </div>
    <div class="card">
        <h3>Tâches</h3>
        <p>25</p>
    </div>
    <div class="card">
        <h3>Utilisateurs</h3>
        <p>5</p>
    </div>
</div>

</body>
</html>
