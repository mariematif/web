package org.apache.jsp.admin;

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
      out.write("<html lang=\"fr\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Gestionnaire de Tâches</title>\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Roboto&display=swap\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            font-family: 'Roboto', sans-serif;\n");
      out.write("            background-color: #f4f4f9;\n");
      out.write("            margin: 0;\n");
      out.write("        }\n");
      out.write("        header {\n");
      out.write("            background: linear-gradient(to right, #5e35b1, #7e57c2);\n");
      out.write("            color: white;\n");
      out.write("            padding: 20px 40px;\n");
      out.write("        }\n");
      out.write("        header .logo {\n");
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
      out.write("        .welcome {\n");
      out.write("            padding: 30px 40px;\n");
      out.write("            font-size: 22px;\n");
      out.write("        }\n");
      out.write("        .dashboard-cards {\n");
      out.write("            display: flex;\n");
      out.write("            flex-wrap: wrap;\n");
      out.write("            justify-content: space-around;\n");
      out.write("            padding: 0 40px 40px;\n");
      out.write("            gap: 20px;\n");
      out.write("        }\n");
      out.write("        .card {\n");
      out.write("            flex: 1 1 250px;\n");
      out.write("            padding: 30px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            background-color: white;\n");
      out.write("            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        .card h3 {\n");
      out.write("            margin-bottom: 10px;\n");
      out.write("            font-size: 20px;\n");
      out.write("            color: #5e35b1;\n");
      out.write("        }\n");
      out.write("        .card p {\n");
      out.write("            font-size: 24px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            color: #333;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<header class=\"d-flex justify-content-between align-items-center\">\n");
      out.write("    <div class=\"logo\">Gestionnaire de Tâches</div>\n");
      out.write("    <nav>\n");
      out.write("        <a href=\"../ProjetController\">Projets</a>\n");
      out.write("        <a href=\"../CategorieTacheController\">Catégories</a>\n");
      out.write("        <a href=\"../TacheController\">Tâches</a>\n");
      out.write("        <a href=\"../UserController\">Utilisateurs</a>\n");
      out.write("        <a href=\"../LogoutServlet\">Déconnexion</a>\n");
      out.write("    </nav>\n");
      out.write("</header>\n");
      out.write("\n");
      out.write("<div class=\"welcome\">\n");
      out.write("    Bonjour <strong>");
      out.print( user.getNom() );
      out.write("</strong>, bienvenue dans votre espace Administrateur 👋\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div class=\"dashboard-cards\">\n");
      out.write("    <div class=\"card\">\n");
      out.write("        <h3>Projets</h3>\n");
      out.write("        <p>10</p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"card\">\n");
      out.write("        <h3>Tâches</h3>\n");
      out.write("        <p>25</p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"card\">\n");
      out.write("        <h3>Utilisateurs</h3>\n");
      out.write("        <p>5</p>\n");
      out.write("    </div>\n");
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
