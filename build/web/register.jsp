<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription Administrateur</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(to right, #002f67, #003a80);
            font-family: 'Segoe UI', sans-serif;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }
        .form-box {
            background: white;
            padding: 35px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.15);
            width: 400px;
        }
        h3 {
            color: #002f67;
        }
        .btn-register {
            background-color: #002f67;
            border: none;
            font-weight: bold;
            color: white;
            padding: 12px;
            border-radius: 6px;
            width: 100%;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        .btn-register:hover {
            background-color: #014494;
            transform: scale(1.03);
            box-shadow: 0 4px 10px rgba(0,0,0,0.2);
        }
        .form-label {
            font-weight: 500;
        }
        .back-link a {
            text-decoration: none;
            color: #002f67;
        }
        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="form-box">
    <h3 class="mb-4 text-center">Créer un compte Admin</h3>
    <form method="post" action="RegisterServlet">
        <div class="mb-3">
            <label class="form-label">Nom</label>
            <input type="text" class="form-control" name="nom" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Email</label>
            <input type="email" class="form-control" name="email" required>
        </div>
        <div class="mb-3">
            <label class="form-label">Mot de passe</label>
            <input type="password" class="form-control" name="motDePasse" required>
        </div>
        <button type="submit" class="btn-register">S'inscrire</button>
    </form>
    <div class="text-center mt-3 back-link">
        <a href="login.jsp">← Retour à la connexion</a>
    </div>
</div>

</body>
</html>
