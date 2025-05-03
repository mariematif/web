<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.User" %>
<%@ page import="entities.Collaborateur" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Collaborateur)) {
        response.sendRedirect("../login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tableau de bord - Collaborateur</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0; padding: 0;
            background-color: #f4f4f4;
        }
        header {
            background: linear-gradient(to right, #002f67, #003a80);
            color: white;
            padding: 20px 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .logo { font-size: 26px; font-weight: bold; }
        nav a {
            margin-left: 30px;
            text-decoration: none;
            color: white;
            font-weight: 500;
            transition: 0.3s;
        }
        nav a:hover { text-decoration: underline; }
        .container { padding: 40px 60px; }
        h2 { color: #002f67; }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 30px;
            background: white;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }
        th, td {
            padding: 14px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th { background-color: #eee; }
        .btn {
            padding: 6px 12px;
            background-color: #002f67;
            border: none;
            color: white;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
        }
        .btn:hover { background-color: #004488; }
        .chart-container {
            margin-top: 60px;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        footer {
            text-align: center;
            padding: 20px;
            font-size: 13px;
            color: #777;
            background-color: #eee;
        }
    </style>
</head>
<body>

<header>
    <div class="logo">Gestionnaire de Tâches</div>
    <nav>
        <a href="home.jsp">Accueil</a>
        <a href="${pageContext.request.contextPath}/CollaborateurMesTaches">📌 Mes Tâches</a>
        <a href="profil.jsp">Profil</a>
        <a href="../LogoutServlet">Déconnexion</a>
    </nav>
</header>

<div class="container">
    <h2>Bienvenue <%= user.getNom() %> 👋</h2>

    <table>
        <thead>
            <tr>
                <th>Projet</th>
                <th>Titre</th>
                <th>Description</th>
                <th>Catégorie</th>
                <th>État</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody id="tacheTable">
            <!-- Les lignes seront remplies par AJAX -->
        </tbody>
    </table>

    <div class="chart-container">
        <h3>Progression des Tâches</h3>
        <canvas id="progressionChart"></canvas>
    </div>
</div>

<footer>
    &copy; 2025 Gestionnaire de Tâches. Tous droits réservés.
</footer>

<script>
function chargerTaches() {
    $.getJSON('${pageContext.request.contextPath}/CollaborateurTachesAPI', function(data) {
        let rows = '';
        data.taches.forEach(t => {
            rows += `
                <tr>
                    <td>${t.projet}</td>
                    <td>${t.titre}</td>
                    <td>${t.description}</td>
                    <td>${t.categorie}</td>
                    <td id="etat-${t.id}">${t.etat}</td>
                    <td><button class="btn" onclick="changerEtat(${t.id})">Changer</button></td>
                </tr>`;
        });
        $('#tacheTable').html(rows);
    });
}

function changerEtat(id) {
    const cell = document.getElementById('etat-' + id);
    const actuel = cell.innerText.trim();
    const suivant = (actuel === 'To Do') ? 'En cours' :
                    (actuel === 'En cours') ? 'Terminé' : 'To Do';
    cell.innerText = suivant;

    // Optionnel : envoie AJAX vers servlet (ex: TacheEtatServlet)
    /*
    $.post('TacheEtatServlet', { id: id, nouvelEtat: suivant }, function() {
        alert("État mis à jour !");
    });
    */
}

function chargerChart() {
    const ctx = document.getElementById('progressionChart').getContext('2d');
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Projet Java', 'Projet Web'],
            datasets: [{
                label: '% Tâches Terminées',
                data: [40, 75], // À rendre dynamique plus tard
                backgroundColor: ['#003a80', '#004488']
            }]
        },
        options: {
            scales: {
                y: { beginAtZero: true, max: 100 }
            }
        }
    });
}

$(document).ready(function () {
    chargerTaches();
    chargerChart();
});
</script>

</body>
</html>
