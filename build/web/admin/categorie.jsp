<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.CategorieTache" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des Catégories</title>
</head>
<body>
<h2>Catégories des tâches</h2>
<%
    List<CategorieTache> categories = (List<CategorieTache>) request.getAttribute("categories");
    if (categories != null) {
        for (CategorieTache cat : categories) {
%>
    <p><%= cat.getNom() %></p>
<%
        }
    }
%>
</body>
</html>
