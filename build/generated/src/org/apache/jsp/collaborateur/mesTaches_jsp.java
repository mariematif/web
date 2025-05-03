package org.apache.jsp.collaborateur;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import entities.User;
import entities.Tache;
import java.util.List;

public final class mesTaches_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("../login.jsp");
        return;
    }

    List<Tache> mesTaches = (List<Tache>) request.getAttribute("mesTaches");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"fr\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Mes Tâches</title>\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Segoe UI', sans-serif;\n");
      out.write("            background-color: #f4f4f9;\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("        }\n");
      out.write("        header {\n");
      out.write("            background: linear-gradient(to right, #5e35b1, #7e57c2);\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px 40px;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: space-between;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("        .logo {\n");
      out.write("            font-size: 24px;\n");
      out.write("            font-weight: bold;\n");
      out.write("        }\n");
      out.write("        nav a {\n");
      out.write("            color: white;\n");
      out.write("            margin-left: 20px;\n");
      out.write("            text-decoration: none;\n");
      out.write("            font-weight: 500;\n");
      out.write("        }\n");
      out.write("        nav a:hover {\n");
      out.write("            text-decoration: underline;\n");
      out.write("        }\n");
      out.write("        .container {\n");
      out.write("            padding: 40px;\n");
      out.write("        }\n");
      out.write("        h2 {\n");
      out.write("            margin-bottom: 30px;\n");
      out.write("            color: #5e35b1;\n");
      out.write("        }\n");
      out.write("        table {\n");
      out.write("            background-color: white;\n");
      out.write("            box-shadow: 0 4px 10px rgba(0,0,0,0.1);\n");
      out.write("        }\n");
      out.write("        th {\n");
      out.write("            background-color: #ede7f6;\n");
      out.write("            color: #5e35b1;\n");
      out.write("        }\n");
      out.write("        .no-data {\n");
      out.write("            text-align: center;\n");
      out.write("            padding: 40px;\n");
      out.write("            font-size: 18px;\n");
      out.write("            color: #777;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<header>\n");
      out.write("    <div class=\"logo\">Gestionnaire de Tâches</div>\n");
      out.write("    <nav>\n");
      out.write("        <a href=\"dashboard_collaborateur.jsp\">Accueil</a>\n");
      out.write("        <a href=\"mesTaches.jsp\">Mes Tâches</a>\n");
      out.write("        <a href=\"../LogoutServlet\">Déconnexion</a>\n");
      out.write("    </nav>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<div class=\"container\">\n");
      out.write("    <h2>👋 Bonjour ");
      out.print( user.getNom() );
      out.write(", voici vos tâches</h2>\n");
      out.write("\n");
      out.write("    ");

        if (mesTaches != null && !mesTaches.isEmpty()) {
    
      out.write("\n");
      out.write("        <table class=\"table table-bordered\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>#</th>\n");
      out.write("                    <th>Projet</th>\n");
      out.write("                    <th>Titre</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>État</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("            ");

                int i = 1;
                for (Tache t : mesTaches) {
            
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( i++ );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( t.getProjet() != null ? t.getProjet().getNom() : "N/A" );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( t.getTitre() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( t.getDescription() );
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( t.getEtat() );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    ");

        } else {
    
      out.write("\n");
      out.write("        <div class=\"no-data\">Aucune tâche assignée pour le moment.</div>\n");
      out.write("    ");

        }
    
      out.write("\n");
      out.write("</div>\n");
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
