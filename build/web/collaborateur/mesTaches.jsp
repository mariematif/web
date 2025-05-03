<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Tache, entities.Collaborateur" %>
<%
Object userObj = session.getAttribute("user");
if (userObj == null || !(userObj instanceof Collaborateur)) {
response.sendRedirect("../login.jsp");
return;
}


Collaborateur collaborateur = (Collaborateur) userObj;
List<Tache> mesTaches = (List<Tache>) request.getAttribute("mesTaches");

int todo = 0, encours = 0, termine = 0;
if (mesTaches != null) {
    for (Tache t : mesTaches) {
        if (t.getEtat().equalsIgnoreCase("To Do")) todo++;
        else if (t.getEtat().equalsIgnoreCase("En cours")) encours++;
        else if (t.getEtat().equalsIgnoreCase("Termine")) termine++;
    }
}


%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>Mes Tâches</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f8f9fa;
        }
        header {
            background-color: #002f67;
            padding: 20px 40px;
            color: white;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        header nav a {
            color: white;
            margin-left: 20px;
            font-weight: 500;
            text-decoration: none;
        }
        header nav a:hover {
            text-decoration: underline;
        }
        .container {
            margin-top: 40px;
        }
        h3 {
            color: #002f67;
        }
        .table th {
            background-color: #002f67;
            color: white;
        }
        canvas {
            max-width: 100% !important;
            height: auto !important;
        }
    </style>
</head>
<body>

<header>
    <div><strong>👨‍💻 Espace Collaborateur</strong></div>
    <nav>
        <a href="${pageContext.request.contextPath}/CollaborateurMesTaches">📌 Mes Tâches</a>
        <a href="${pageContext.request.contextPath}/LogoutServlet">🚪 Déconnexion</a>
    </nav>
</header>

<div class="container">
    <h3>📋 Mes Tâches Assignées</h3>
 <div style="width: 300px; margin: auto;" class="mb-4">
        <canvas id="tacheChart"></canvas>
    </div>
<table class="table table-bordered">
    <thead>
    <tr>
      
        <th>Titre</th>
        <th>Description</th>
        <th>Projet</th>
        <th>Catégorie</th>
        <th>État</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (mesTaches != null && !mesTaches.isEmpty()) {
            for (Tache t : mesTaches) {
    %>
    <tr>
        <td><%= t.getTitre() %></td>
        <td><%= t.getDescription() %></td>
        <td><%= t.getProjet().getNom() %></td>
               
                <td><%= t.getCategorie().getNom() %></td>
        <td>
<select class="etat-select form-select form-select-sm" data-tache-id="<%= t.getId() %>">
    <option value="To Do" <%= "To Do".equals(t.getEtat()) ? "selected" : "" %>>To Do</option>
    <option value="En cours" <%= "En cours".equals(t.getEtat()) ? "selected" : "" %>>En cours</option>
    <option value="Termine" <%= "Termine".equals(t.getEtat()) ? "selected" : "" %>>Termine</option>
</select>


</td>


    </tr>
    <%
            }
        } else {
    %>
    <tr><td colspan="3">Aucune tâche assignée.</td></tr>
    <%
        }
    %>
</tbody>
</table>


</div>

<script>
    const ctx = document.getElementById('tacheChart').getContext('2d');
    const tacheChart = new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: ['To Do', 'En cours', 'Termine'],
            datasets: [{
                label: 'Répartition des tâches',
                data: [<%= todo %>, <%= encours %>, <%= termine %>],
                backgroundColor: [
                    'rgba(255, 193, 7, 0.8)',
                    'rgba(13, 202, 240, 0.8)',
                    'rgba(25, 135, 84, 0.8)'
                ],
                borderColor: [
                    'rgba(255, 193, 7, 1)',
                    'rgba(13, 202, 240, 1)',
                    'rgba(25, 135, 84, 1)'
                ],
                borderWidth: 1
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
</script>


</body>
</html>coriger 
