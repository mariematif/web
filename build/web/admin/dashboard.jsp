<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.User" %>
<%@ page import="entities.Admin" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Dashboard Admin</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f4f4f4;
        }
        header {
            background-color: #002f67;
            color: white;
            padding: 20px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
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
            padding: 40px;
        }
        .card {
            border-radius: 10px;
            padding: 30px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: white;
            text-align: center;
        }
        .card h3 {
            color: #002f67;
        }
        .card p {
            font-size: 26px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header>
    <div class="logo">🗂️ Gestion des Tâches</div>
    <nav>
        <a href="${pageContext.request.contextPath}/admin/dashboard.jsp">🏠 Accueil</a>
        <a href="${pageContext.request.contextPath}/ProjetServlet">📁 Projets</a>
        <a href="${pageContext.request.contextPath}/CategorieTacheServlet">📂 Catégories</a>
        <a href="${pageContext.request.contextPath}/TachesServlet">📝 Tâches</a>
        <a href="${pageContext.request.contextPath}/CollaborateurServlet">👤 Collaborateurs</a>
        <a href="${pageContext.request.contextPath}/LogoutServlet">🚪 Déconnexion</a>
    </nav>
</header>

<div class="container">
    <h2 class="mb-4">Bienvenue <%= user.getNom() %> 👋</h2>
    <div class="row g-4">
        <div class="col-md-4">
            <div class="card">
                <h3>Projets</h3>
                <p>10</p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <h3>Tâches</h3>
                <p>25</p>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card">
                <h3>Utilisateurs</h3>
                <p>5</p>
            </div>
        </div>
    </div>

    <div class="mt-5 p-4 bg-white rounded shadow-sm">
        <h4>📊 Répartition des tâches par état</h4>
        <canvas id="tachesChart" width="400" height="200"></canvas>
    </div>
</div>

<script>
let chart;

function chargerStatsTaches() {
    fetch('${pageContext.request.contextPath}/StatistiquesServlet')
        .then(response => response.json())
        .then(data => {
            const ctx = document.getElementById('tachesChart').getContext('2d');
            chart = new Chart(ctx, {
                type: 'doughnut',
                data: {
                    labels: ['To Do', 'En cours', 'Terminé'],
                    datasets: [{
                        data: [data.todo, data.encours, data.termine],
                        backgroundColor: ['#ffc107', '#0dcaf0', '#198754']
                    }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: {
                            position: 'bottom'
                        }
                    }
                }
            });
        })
        .catch(err => {
            console.error("Erreur chargement stats :", err);
        });
}

window.onload = chargerStatsTaches;
</script>

</body>
</html>
