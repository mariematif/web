package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import entities.Projet;
import entities.Admin;
import entities.User;

public final class projets_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");

    User user = (User) session.getAttribute("user");
    if (user == null || !(user instanceof Admin)) {
        response.sendRedirect("../login.jsp");
        return;
    }
    List<Projet> projets = (List<Projet>) request.getAttribute("projets");
    Projet projetToEdit = (Projet) request.getAttribute("projet");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Gestion des Projets</title>\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/chart.js\"></script>\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            background-color: #f5f7fa;\n");
      out.write("            font-family: 'Segoe UI', sans-serif;\n");
      out.write("        }\n");
      out.write("        header {\n");
      out.write("            background: #002f67;\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px 40px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        nav a {\n");
      out.write("            color: white;\n");
      out.write("            text-decoration: none;\n");
      out.write("            margin-left: 20px;\n");
      out.write("            font-weight: 500;\n");
      out.write("        }\n");
      out.write("        nav a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            margin-top: 40px;\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 12px;\n");
      out.write("            box-shadow: 0 0 12px rgba(0, 0, 0, 0.05);\n");
      out.write("        }\n");
      out.write("        .table th {\n");
      out.write("            background-color: #002f67;\n");
      out.write("            color: white;\n");
      out.write("        }\n");
      out.write("        .form-control, .form-select {\n");
      out.write("            border-radius: 6px;\n");
      out.write("        }\n");
      out.write("        .btn-primary {\n");
      out.write("            background-color: #002f67;\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("        .btn-primary:hover {\n");
      out.write("            background-color: #014494;\n");
      out.write("        }\n");
      out.write("        .btn-warning {\n");
      out.write("            background-color: #ffb300;\n");
      out.write("            border: none;\n");
      out.write("            color: black;\n");
      out.write("        }\n");
      out.write("        .btn-danger {\n");
      out.write("            background-color: #d32f2f;\n");
      out.write("            border: none;\n");
      out.write("        }\n");
      out.write("        .section-title {\n");
      out.write("            color: #002f67;\n");
      out.write("            margin-bottom: 25px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<header>\n");
      out.write("    <h3 class=\"m-0\">📁 Gestion des Projets</h3>\n");
      out.write("    <nav>\n");
      out.write("       <a href=\"dashboard.jsp\">Accueil</a>\n");
      out.write("<a href=\"../ProjetServlet\">Projets</a>\n");
      out.write("<a href=\"../CategorieTacheServlet\">Catégories</a>\n");
      out.write("<a href=\"../TachesServlet\">Tâches</a> <!-- ✅ Correction ici -->\n");
      out.write("<a href=\"../UserController\">Utilisateurs</a>\n");
      out.write("<a href=\"../LogoutServlet\">Déconnexion</a>\n");
      out.write("\n");
      out.write("    </nav>\n");
      out.write("</header>\n");
      out.write("<div class=\"container\">\n");
      out.write("    <div class=\"mb-5\">\n");
      out.write("        <h4 class=\"section-title\">Liste des Projets</h4>\n");
      out.write("        <div class=\"card p-4\">\n");
      out.write("            <table class=\"table table-hover\">\n");
      out.write("                <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>#</th>\n");
      out.write("                    <th>Nom</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>Actions</th>\n");
      out.write("                </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                ");

                    if (projets != null && !projets.isEmpty()) {
                        for (Projet p : projets) {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( p.getId() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getNom() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( p.getDescription() );
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <a href=\"../ProjetServlet?op=edit&id=");
      out.print( p.getId() );
      out.write("\" class=\"btn btn-warning btn-sm\">✏️ Modifier</a>\n");
      out.write("                        <a href=\"../ProjetServlet?op=delete&id=");
      out.print( p.getId() );
      out.write("\" class=\"btn btn-danger btn-sm\" onclick=\"return confirm('Confirmer la suppression ?')\">🗑 Supprimer</a>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                        }
                    } else {
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td colspan=\"4\" class=\"text-center\">Aucun projet trouvé.</td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("        <h4 class=\"section-title\">");
      out.print( (projetToEdit != null ? "✏️ Modifier le Projet" : "➕ Ajouter un Projet") );
      out.write("</h4>\n");
      out.write("        <div class=\"card p-4\">\n");
      out.write("            <form method=\"post\" action=\"../ProjetServlet\">\n");
      out.write("                <input type=\"hidden\" name=\"id\" value=\"");
      out.print( projetToEdit != null ? projetToEdit.getId() : "" );
      out.write("\">\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label class=\"form-label\">Nom du projet</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nom\" required value=\"");
      out.print( projetToEdit != null ? projetToEdit.getNom() : "" );
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"mb-3\">\n");
      out.write("                    <label class=\"form-label\">Description</label>\n");
      out.write("                    <textarea class=\"form-control\" name=\"description\" rows=\"3\" required>");
      out.print( projetToEdit != null ? projetToEdit.getDescription() : "" );
      out.write("</textarea>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"submit\" class=\"btn btn-primary\">\n");
      out.write("                    ");
      out.print( projetToEdit != null ? "💾 Mettre à jour" : "➕ Ajouter" );
      out.write("\n");
      out.write("                </button>\n");
      out.write("                ");
 if (projetToEdit != null) { 
      out.write("\n");
      out.write("                <a href=\"../ProjetServlet\" class=\"btn btn-secondary ms-2\">Annuler</a>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"mt-5\">\n");
      out.write("        <h4 class=\"section-title\">📊 Répartition fictive des tâches par projet</h4>\n");
      out.write("        <div class=\"card p-4\">\n");
      out.write("            <canvas id=\"chartProjet\"></canvas>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<script>\n");
      out.write("    const ctx = document.getElementById(\"chartProjet\").getContext(\"2d\");\n");
      out.write("    new Chart(ctx, {\n");
      out.write("        type: 'bar',\n");
      out.write("        data: {\n");
      out.write("            labels: [\"Projet 1\", \"Projet 2\", \"Projet 3\"],\n");
      out.write("            datasets: [{\n");
      out.write("                label: \"Tâches\",\n");
      out.write("                data: [5, 8, 3],\n");
      out.write("                backgroundColor: [\"#014494\", \"#ffc107\", \"#d32f2f\"]\n");
      out.write("            }]\n");
      out.write("        },\n");
      out.write("        options: {\n");
      out.write("            responsive: true,\n");
      out.write("            plugins: {\n");
      out.write("                legend: { display: false },\n");
      out.write("                title: { display: true, text: 'Tâches par Projet' }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("</script>\n");
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
