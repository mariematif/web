<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestionnaire de Tâches</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        :root {
            --bg-light: #ffffff;
            --bg-dark: #121212;
            --text-light: #212121;
            --text-dark: #f1f1f1;
            --primary-light: #673ab7;
            --primary-dark: #9575cd;
            --accent-light: #7e57c2;
            --accent-dark: #b39ddb;
        }

        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background-color: var(--bg-light);
            color: var(--text-light);
            transition: 0.3s;
        }

        body.dark-mode {
            background-color: var(--bg-dark);
            color: var(--text-dark);
        }

        header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 20px 50px;
            background: linear-gradient(to right, var(--primary-light), var(--accent-light));
            color: white;
        }

        body.dark-mode header {
            background: linear-gradient(to right, var(--primary-dark), var(--accent-dark));
        }

        .logo {
            font-size: 26px;
            font-weight: bold;
        }

        nav a {
            margin-left: 25px;
            text-decoration: none;
            color: white;
            font-weight: 500;
            transition: 0.3s;
        }

        nav a:hover {
            text-decoration: underline;
        }

        .dark-toggle {
            padding: 8px 16px;
            background-color: white;
            color: var(--primary-light);
            border-radius: 20px;
            font-weight: bold;
            cursor: pointer;
            border: none;
            margin-left: 25px;
        }

        body.dark-mode .dark-toggle {
            background-color: var(--primary-light);
            color: white;
        }

        .container {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 80px 60px;
            flex-wrap: wrap;
        }

        .left {
            width: 100%;
            max-width: 50%;
        }

        .left h1 {
            font-size: 42px;
        }

        .left p {
            margin: 20px 0;
            font-size: 18px;
        }

        .btn {
            display: inline-block;
            margin: 10px 15px 0 0;
            padding: 14px 26px;
            background-color: var(--primary-light);
            border: none;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border-radius: 6px;
            text-decoration: none;
        }

        .btn:hover {
            background-color: var(--accent-light);
        }

        body.dark-mode .btn {
            background-color: var(--primary-dark);
        }

        .right {
            width: 100%;
            max-width: 45%;
            text-align: center;
        }

        .right img {
            width: 100%;
            max-width: 450px;
            border-radius: 10px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }

        .features, .about, .contact {
            padding: 60px;
            text-align: center;
        }

        .features h2, .about h2, .contact h2 {
            color: var(--primary-light);
        }

        .feature-grid {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 30px;
            margin-top: 30px;
        }

        .feature {
            width: 240px;
            background: white;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }

        body.dark-mode .feature {
            background-color: #1e1e1e;
            color: var(--text-dark);
        }

        .contact-grid {
            display: flex;
            justify-content: space-around;
            flex-wrap: wrap;
            margin-top: 30px;
        }

        .contact-grid div {
            flex: 1;
            min-width: 220px;
            margin: 10px;
        }

        footer {
            text-align: center;
            padding: 20px;
            font-size: 14px;
            color: #888;
            background-color: #f2f2f2;
        }

        body.dark-mode footer {
            background-color: #1b1b1b;
            color: #bbb;
        }

        @media screen and (max-width: 900px) {
            .container {
                flex-direction: column;
                padding: 40px 20px;
                text-align: center;
            }

            .left, .right {
                max-width: 100%;
            }

            nav {
                display: none;
            }
        }
    </style>
</head>
<body>

<header>
    <div class="logo">Gestionnaire de Tâches</div>
    <nav>
        <a href="home.jsp">Accueil</a>
        <a href="#fonctionnalites">Fonctionnalités</a>
        <a href="#about">À propos</a>
        <a href="#contact">Contact</a>
        <button class="dark-toggle" onclick="toggleDarkMode()">🌙 Mode sombre</button>
    </nav>
</header>

<!-- Accueil -->
<div class="container">
    <div class="left">
        <h1>Organisateur des tâches</h1>
        <p>Organisez votre travail facilement grâce à notre application. Choisissez votre espace :</p>
        <a class="btn" href="login.jsp?type=admin">Connexion Admin</a>
        <a class="btn" href="login.jsp?type=collaborateur">Connexion Collaborateur</a>
    </div>
    <div class="right">
        <img src="assets/img.png" alt="Illustration" />
    </div>
</div>

<!-- Fonctionnalités -->
<section class="features" id="fonctionnalites">
    <h2>Fonctionnalités principales</h2>
    <div class="feature-grid">
        <div class="feature">
            <h4>📝 Gestion des tâches</h4>
            <p>Créez, assignez et suivez l’état des tâches.</p>
        </div>
        <div class="feature">
            <h4>📊 Statistiques</h4>
            <p>Visualisez l’avancement via des graphiques dynamiques.</p>
        </div>
        <div class="feature">
            <h4>👥 Espaces dédiés</h4>
            <p>Interfaces personnalisées pour admins et collaborateurs.</p>
        </div>
        <div class="feature">
            <h4>🔐 Sécurité</h4>
            <p>Connexion sécurisée avec validation d’identifiants.</p>
        </div>
    </div>
</section>

<!-- À propos -->
<section class="about" id="about">
    <h2>À propos</h2>
    <p>
        L'application <strong>Gestionnaire de Tâches</strong> vous aide à organiser et suivre vos projets de manière efficace.
        Conçue pour les équipes collaboratives et les administrateurs, elle propose une interface simple, intuitive et moderne.
    </p>
</section>

<!-- Contact -->
<section class="contact" id="contact">
    <h2>Contact</h2>
    <div class="contact-grid">
        <div>
            <h3>📧 Email</h3>
            <p>support@gestiontaches.com</p>
        </div>
        <div>
            <h3>📞 Téléphone</h3>
            <p>+212 6 00 00 00 00</p>
        </div>
        <div>
            <h3>📍 Adresse</h3>
            <p>ENSA Marrakech, Maroc</p>
        </div>
    </div>
</section>

<!-- Footer -->
<footer>
    &copy; 2025 Application Gestionnaire de Tâches. Tous droits réservés.
</footer>

<script>
    function toggleDarkMode() {
        document.body.classList.toggle('dark-mode');
    }
</script>

</body>
</html>
