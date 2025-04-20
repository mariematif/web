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
    <title>Tableau de bord - Collaborateur</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        header {
            background: linear-gradient(to right, #5e35b1, #7e57c2);
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
            transition: 0.3s;
        }

        nav a:hover {
            text-decoration: underline;
        }

        .container {
            padding: 40px 60px;
        }

        h2 {
            color: #333;
        }

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

        th {
            background-color: #eee;
        }

        .btn {
            padding: 6px 12px;
            background-color: #673ab7;
            border: none;
            color: white;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
        }

        .btn:hover {
            background-color: #5e35b1;
        }

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
        <a href="dashboard_collaborateur.jsp">Accueil</a>
        <a href="#">Mes Tâches</a>
        <a href="#">Profil</a>
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
                <th>État</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody id="tacheTable">
            <tr>
                <td>Projet Java</td>
                <td>Connexion sécurisée</td>
                <td>Créer formulaire avec validation</td>
                <td id="etat-1">To Do</td>
                <td><button class="btn" onclick="changerEtat(1)">Changer</button></td>
            </tr>
            <tr>
                <td>Projet Web</td>
                <td>Dashboard collaborateur</td>
                <td>UI avec statistiques et AJAX</td>
                <td id="etat-2">En cours</td>
                <td><button class="btn" onclick="changerEtat(2)">Changer</button></td>
            </tr>
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
    // Exemple : graphique statique
    const ctx = document.getElementById('progressionChart').getContext('2d');
    const chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Projet Java', 'Projet Web'],
            datasets: [{
                label: '% Tâches Terminées',
                data: [40, 75],
                backgroundColor: ['#7e57c2', '#9575cd']
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true,
                    max: 100
                }
            }
        }
    });

    // AJAX simulé pour changer l'état
    function changerEtat(id) {
        const etat = document.getElementById('etat-' + id);
        const actuel = etat.innerText;

        const suivant = (actuel === 'To Do') ? 'En cours' :
                        (actuel === 'En cours') ? 'Terminé' : 'To Do';

        etat.innerText = suivant;

        // TODO: Implémenter un appel AJAX réel si besoin
        /*
        $.post("TacheEtatController", { id: id, nouvelEtat: suivant }, function(response) {
            // traitement après maj
        });
        */
    }
</script>

</body>
</html>
