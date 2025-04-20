package org.apache.jsp.collaborateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entities.User;

public final class dashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Tableau de bord - Collaborateur</title>\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Segoe UI', sans-serif;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            background-color: #f4f4f4;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        header {\n");
      out.write("            background: linear-gradient(to right, #5e35b1, #7e57c2);\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px 50px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .logo {\n");
      out.write("            font-size: 26px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav a {\n");
      out.write("            margin-left: 30px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            color: white;\n");
      out.write("            font-weight: 500;\n");
      out.write("            transition: 0.3s;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        nav a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .container {\n");
      out.write("            padding: 40px 60px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        h2 {\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        table {\n");
      out.write("            width: 100%;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("            margin-top: 30px;\n");
      out.write("            background: white;\n");
      out.write("            box-shadow: 0 2px 5px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th, td {\n");
      out.write("            padding: 14px;\n");
      out.write("            text-align: center;\n");
      out.write("            border-bottom: 1px solid #ddd;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        th {\n");
      out.write("            background-color: #eee;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn {\n");
      out.write("            padding: 6px 12px;\n");
      out.write("            background-color: #673ab7;\n");
      out.write("            border: none;\n");
      out.write("            color: white;\n");
      out.write("            font-weight: bold;\n");
      out.write("            border-radius: 5px;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .btn:hover {\n");
      out.write("            background-color: #5e35b1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .chart-container {\n");
      out.write("            margin-top: 60px;\n");
      out.write("            background: white;\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            box-shadow: 0 2px 10px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        footer {\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 20px;\n");
      out.write("            font-size: 13px;\n");
      out.write("            color: #777;\n");
      out.write("            background-color: #eee;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("    <div class=\"logo\">Gestionnaire de Tâches</div>\n");
      out.write("    <nav>\n");
      out.write("        <a href=\"dashboard_collaborateur.jsp\">Accueil</a>\n");
      out.write("        <a href=\"#\">Mes Tâches</a>\n");
      out.write("        <a href=\"#\">Profil</a>\n");
      out.write("        <a href=\"../LogoutServlet\">Déconnexion</a>\n");
      out.write("    </nav>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>Bienvenue ");
      out.print( user.getNom() );
      out.write(" 👋</h2>\n");
      out.write("\n");
      out.write("    <table>\n");
      out.write("        <thead>\n");
      out.write("            <tr>\n");
      out.write("                <th>Projet</th>\n");
      out.write("                <th>Titre</th>\n");
      out.write("                <th>Description</th>\n");
      out.write("                <th>État</th>\n");
      out.write("                <th>Action</th>\n");
      out.write("            </tr>\n");
      out.write("        </thead>\n");
      out.write("        <tbody id=\"tacheTable\">\n");
      out.write("            <tr>\n");
      out.write("                <td>Projet Java</td>\n");
      out.write("                <td>Connexion sécurisée</td>\n");
      out.write("                <td>Créer formulaire avec validation</td>\n");
      out.write("                <td id=\"etat-1\">To Do</td>\n");
      out.write("                <td><button class=\"btn\" onclick=\"changerEtat(1)\">Changer</button></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Projet Web</td>\n");
      out.write("                <td>Dashboard collaborateur</td>\n");
      out.write("                <td>UI avec statistiques et AJAX</td>\n");
      out.write("                <td id=\"etat-2\">En cours</td>\n");
      out.write("                <td><button class=\"btn\" onclick=\"changerEtat(2)\">Changer</button></td>\n");
      out.write("            </tr>\n");
      out.write("        </tbody>\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("    <div class=\"chart-container\">\n");
      out.write("        <h3>Progression des Tâches</h3>\n");
      out.write("        <canvas id=\"progressionChart\"></canvas>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<footer>\n");
      out.write("    &copy; 2025 Gestionnaire de Tâches. Tous droits réservés.\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("    // Exemple : graphique statique\n");
      out.write("    const ctx = document.getElementById('progressionChart').getContext('2d');\n");
      out.write("    const chart = new Chart(ctx, {\n");
      out.write("        type: 'bar',\n");
      out.write("        data: {\n");
      out.write("            labels: ['Projet Java', 'Projet Web'],\n");
      out.write("            datasets: [{\n");
      out.write("                label: '% Tâches Terminées',\n");
      out.write("                data: [40, 75],\n");
      out.write("                backgroundColor: ['#7e57c2', '#9575cd']\n");
      out.write("            }]\n");
      out.write("        },\n");
      out.write("        options: {\n");
      out.write("            scales: {\n");
      out.write("                y: {\n");
      out.write("                    beginAtZero: true,\n");
      out.write("                    max: 100\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("\n");
      out.write("    // AJAX simulé pour changer l'état\n");
      out.write("    function changerEtat(id) {\n");
      out.write("        const etat = document.getElementById('etat-' + id);\n");
      out.write("        const actuel = etat.innerText;\n");
      out.write("\n");
      out.write("        const suivant = (actuel === 'To Do') ? 'En cours' :\n");
      out.write("                        (actuel === 'En cours') ? 'Terminé' : 'To Do';\n");
      out.write("\n");
      out.write("        etat.innerText = suivant;\n");
      out.write("\n");
      out.write("        // TODO: Implémenter un appel AJAX réel si besoin\n");
      out.write("        /*\n");
      out.write("        $.post(\"TacheEtatController\", { id: id, nouvelEtat: suivant }, function(response) {\n");
      out.write("            // traitement après maj\n");
      out.write("        });\n");
      out.write("        */\n");
      out.write("    }\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
