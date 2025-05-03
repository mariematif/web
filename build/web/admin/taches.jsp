<%@page import="entities.Admin"%>
<%@page import="entities.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Tache, entities.Projet, entities.Collaborateur, entities.CategorieTache" %>
<%
     User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect("../login.jsp");
        return;
    }
    List<Tache> taches = (List<Tache>) request.getAttribute("taches");
    List<Projet> projets = (List<Projet>) request.getAttribute("projets");
    List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("collaborateurs");
    List<CategorieTache> categories = (List<CategorieTache>) request.getAttribute("categories");
    int todo = 0, encours = 0, termine = 0;
    for (Tache t : taches) {
        if (t.getEtat().equals("To Do")) todo++;
        else if (t.getEtat().equals("En cours")) encours++;
        else if (t.getEtat().equals("Terminé")) termine++;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Tâches</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f8f9fa;
            padding: 20px;
        }
        header {
            background: #002f67;
            color: white;
            padding: 20px 40px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        nav a {
            color: white;
            text-decoration: none;
            margin-left: 20px;
            font-weight: 500;
        }
        nav a:hover {
            text-decoration: underline;
        }
        h2 {
            color: #002f67;
        }
        .table th {
            background-color: #002f67;
            color: white;
        }
        .btn-primary { background-color: #002f67; }
        .btn-warning, .btn-danger {
            padding: 4px 10px;
            font-size: 0.9rem;
        }
        .form-select, .form-control {
            border-radius: 6px;
        }
        .form-section {
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            margin-bottom: 30px;
        }
         canvas {
            max-width: 100% !important;
            height: auto !important;
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
   

    <div class="form-section">
       <form method="post" action="${pageContext.request.contextPath}/TachesServlet">

            <input type="hidden" name="op" value="create">
            <div class="row mb-3">
                <div class="col-md-6">
                    <label class="form-label">Titre</label>
                    <input type="text" class="form-control" name="titre" required>
                </div>
                <div class="col-md-6">
                    <label class="form-label">État</label>
                    <select class="form-select" name="etat">
                        <option value="To Do">To Do</option>
                        <option value="En cours">En cours</option>
                        <option value="Termine">Termine</option>
                    </select>
                </div>
            </div>

            <div class="mb-3">
                <label class="form-label">Description</label>
                <textarea class="form-control" name="description" rows="3"></textarea>
            </div>

            <div class="row mb-3">
                <div class="col-md-4">
                    <label class="form-label">Projet</label>
                    <select class="form-select" name="projetId">
                        <% for (Projet p : projets) { %>
                            <option value="<%= p.getId() %>"><%= p.getNom() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Collaborateur</label>
                    <select class="form-select" name="collaborateurId">
                        <% for (Collaborateur c : collaborateurs) { %>
                            <option value="<%= c.getId() %>"><%= c.getNom() %></option>
                        <% } %>
                    </select>
                </div>
                <div class="col-md-4">
                    <label class="form-label">Catégorie</label>
                    <select class="form-select" name="categorieId">
                        <% for (CategorieTache ct : categories) { %>
                            <option value="<%= ct.getId() %>"><%= ct.getNom() %></option>
                        <% } %>
                    </select>
                </div>
            </div>

            <button type="submit" class="btn btn-primary">➕ Ajouter la Tâche</button>
        </form>
    </div>

    <h4 class="mt-5">📊 Répartition des tâches</h4>
   <div style="width: 300px; margin: auto;" class="mb-4">
        <canvas id="tacheChart"></canvas>
    </div>

    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>#</th>
            <th>Titre</th>
            <th>Description</th>
            <th>Projet</th>
            <th>Collaborateur</th>
            <th>Catégorie</th>
            <th>État</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <% if (taches != null) {
            for (Tache t : taches) { %>
            <tr>
                <td><%= t.getId() %></td>
                <td><%= t.getTitre() %></td>
                <td><%= t.getDescription() %></td>
                <td><%= t.getProjet().getNom() %></td>
                <td><%= t.getCollaborateur().getNom() %></td>
                <td><%= t.getCategorie().getNom() %></td>
                <td><%= t.getEtat() %></td>
                <td>
                    <a href="../TachesServlet?op=edit&id=<%= t.getId() %>" class="btn btn-warning">✏️</a>
                    <a href="../TachesServlet?op=delete&id=<%= t.getId() %>" class="btn btn-danger" onclick="return confirm('Supprimer cette tâche ?')">🗑</a>
                </td>
            </tr>
        <% } } %>
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
</html>
