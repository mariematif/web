<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="entities.User, entities.Admin, entities.Collaborateur, java.util.List" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect("../login.jsp");
        return;
    }
    List<Collaborateur> collaborateurs = (List<Collaborateur>) request.getAttribute("collaborateurs");
    Collaborateur collaborateurToEdit = (Collaborateur) request.getAttribute("collaborateurToEdit");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion des Collaborateurs</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body { font-family: 'Segoe UI', sans-serif; background-color: #f8f9fa; }
        header {
            background-color: #002f67; color: white; padding: 20px;
            display: flex; justify-content: space-between; align-items: center;
        }
        nav a { color: white; text-decoration: none; margin-left: 20px; font-weight: 500; }
        nav a:hover { text-decoration: underline; }
        .container { margin-top: 40px; }
        .form-section {
            background-color: white; padding: 25px; border-radius: 10px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
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
    <div class="form-section mb-5">
        <h4><%= collaborateurToEdit != null ? "✏️ Modifier le collaborateur" : "➕ Ajouter un collaborateur" %></h4>
        <form action="${pageContext.request.contextPath}/CollaborateurServlet" method="post">
            <input type="hidden" name="id" value="<%= collaborateurToEdit != null ? collaborateurToEdit.getId() : "" %>">
            <div class="mb-3">
                <label class="form-label">Nom</label>
                <input type="text" class="form-control" name="nom" value="<%= collaborateurToEdit != null ? collaborateurToEdit.getNom() : "" %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Email</label>
                <input type="email" class="form-control" name="email" value="<%= collaborateurToEdit != null ? collaborateurToEdit.getEmail() : "" %>" required>
            </div>
            <div class="mb-3">
                <label class="form-label">
                    Mot de passe <%= collaborateurToEdit != null ? "(laisser vide pour garder l'ancien)" : "" %>
                </label>
                <input type="password" class="form-control" name="password" <%= collaborateurToEdit == null ? "required" : "" %>>
            </div>
            <button type="submit" class="btn btn-primary">
                <%= collaborateurToEdit != null ? "💾 Mettre à jour" : "➕ Ajouter" %>
            </button>
            <% if (collaborateurToEdit != null) { %>
                <a href="${pageContext.request.contextPath}/CollaborateurServlet" class="btn btn-secondary ms-2">Annuler</a>
            <% } %>
        </form>
    </div>

    <div class="form-section">
        <h4>📋 Liste des Collaborateurs</h4>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <% if (collaborateurs != null && !collaborateurs.isEmpty()) {
                    for (Collaborateur c : collaborateurs) {
                %>
                <tr>
                    <td><%= c.getNom() %></td>
                    <td><%= c.getEmail() %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/CollaborateurServlet?op=edit&id=<%= c.getId() %>" class="btn btn-warning btn-sm">✏️</a>
                        <a href="${pageContext.request.contextPath}/CollaborateurServlet?op=delete&id=<%= c.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('Confirmer la suppression ?')">🗑</a>
                    </td>
                </tr>
                <% } } else { %>
                <tr><td colspan="3" class="text-center">Aucun collaborateur trouvé.</td></tr>
                <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
