<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Projet, entities.Admin, entities.User" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect("../login.jsp");
        return;
    }
    List<Projet> projets = (List<Projet>) request.getAttribute("projets");
    Projet projetToEdit = (Projet) request.getAttribute("projet");
%>
<%
    StringBuilder nomsProjets = new StringBuilder();
    StringBuilder nbTaches = new StringBuilder();
    for (Projet p : projets) {
        nomsProjets.append("\"").append(p.getNom()).append("\",");
        nbTaches.append((int) (Math.random() * 10)).append(","); // fictif, remplacer plus tard
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Projets</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
        body {
            background-color: #f5f7fa;
            font-family: 'Segoe UI', sans-serif;
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
        .container {
            margin-top: 40px;
        }
        .card {
            border: none;
            border-radius: 12px;
            box-shadow: 0 0 12px rgba(0, 0, 0, 0.05);
        }
        .table th {
            background-color: #002f67;
            color: white;
        }
        .form-control, .form-select {
            border-radius: 6px;
        }
        .btn-primary {
            background-color: #002f67;
            border: none;
        }
        .btn-primary:hover {
            background-color: #014494;
        }
        .btn-warning {
            background-color: #ffb300;
            border: none;
            color: black;
        }
        .btn-danger {
            background-color: #d32f2f;
            border: none;
        }
        .section-title {
            color: #002f67;
            margin-bottom: 25px;
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
    <div class="mb-5">
        <h4 class="section-title">Liste des Projets</h4>
        <div class="card p-4">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    if (projets != null && !projets.isEmpty()) {
                        for (Projet p : projets) {
                %>
                <tr>
                    <td><%= p.getId() %></td>
                    <td><%= p.getNom() %></td>
                    <td><%= p.getDescription() %></td>
                    <td>
                       <a href="${pageContext.request.contextPath}/ProjetServlet?op=edit&id=<%= p.getId() %>" class="btn btn-warning btn-sm">✏️ Modifier</a>
<a href="${pageContext.request.contextPath}/ProjetServlet?op=delete&id=<%= p.getId() %>" 
   class="btn btn-danger btn-sm" onclick="return confirm('Confirmer la suppression ?')">🗑 Supprimer</a>


                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4" class="text-center">Aucun projet trouvé.</td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        <h4 class="section-title"><%= (projetToEdit != null ? "✏️ Modifier le Projet" : "➕ Ajouter un Projet") %></h4>
        <div class="card p-4">
           <form method="post" action="${pageContext.request.contextPath}/ProjetServlet">

                <input type="hidden" name="id" value="<%= projetToEdit != null ? projetToEdit.getId() : "" %>">
                <div class="mb-3">
                    <label class="form-label">Nom du projet</label>
                    <input type="text" class="form-control" name="nom" required value="<%= projetToEdit != null ? projetToEdit.getNom() : "" %>">
                </div>
                <div class="mb-3">
                    <label class="form-label">Description</label>
                    <textarea class="form-control" name="description" rows="3" required><%= projetToEdit != null ? projetToEdit.getDescription() : "" %></textarea>
                </div>
                <button type="submit" class="btn btn-primary">
                    <%= projetToEdit != null ? "💾 Mettre à jour" : "➕ Ajouter" %>
                </button>
                <% if (projetToEdit != null) { %>
              <a href="${pageContext.request.contextPath}/ProjetServlet" class="btn btn-secondary ms-2">Annuler</a>

                <% } %>
            </form>
        </div>
    </div>
    <div class="mt-5">
        <h4 class="section-title">📊 Répartition fictive des tâches par projet</h4>
        <div class="card p-4">
            <canvas id="chartProjet"></canvas>
        </div>
    </div>
</div>
<script>
    const ctx = document.getElementById("chartProjet").getContext("2d");
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: [<%= nomsProjets.toString() %>],
            datasets: [{
                label: "Tâches par projet",
                data: [<%= nbTaches.toString() %>],
                backgroundColor: [
                    '#014494', '#ffc107', '#d32f2f', '#0dcaf0', '#198754'
                ],
                borderRadius: 5
            }]
        },
        options: {
            responsive: true,
            plugins: {
                legend: { display: false },
                title: {
                    display: true,
                    text: 'Répartition fictive des tâches par projet'
                }
            },
            scales: {
                y: { beginAtZero: true }
            }
        }
    });
</script>

</body>
</html>
