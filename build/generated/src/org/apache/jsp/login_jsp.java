package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>Connexion - Gestionnaire de Tâches</title>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <style>\n");
      out.write("        body {\n");
      out.write("            margin: 0;\n");
      out.write("            padding: 0;\n");
      out.write("            font-family: 'Segoe UI', sans-serif;\n");
      out.write("            height: 100vh;\n");
      out.write("            background-image: url(\"assets/background.jpg\");\n");
      out.write("            background-size: cover;\n");
      out.write("            background-position: center;\n");
      out.write("            background-repeat: no-repeat;\n");
      out.write("            display: flex;\n");
      out.write("            justify-content: center;\n");
      out.write("            align-items: center;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box {\n");
      out.write("            background: rgba(255, 255, 255, 0.9);\n");
      out.write("            padding: 40px;\n");
      out.write("            border-radius: 10px;\n");
      out.write("            width: 400px;\n");
      out.write("            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box h2 {\n");
      out.write("            margin-bottom: 25px;\n");
      out.write("            text-align: center;\n");
      out.write("            color: #5e35b1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box input[type=\"text\"],\n");
      out.write("        .login-box input[type=\"password\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            margin: 10px 0;\n");
      out.write("            border: 1px solid #ccc;\n");
      out.write("            border-radius: 6px;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box input[type=\"submit\"] {\n");
      out.write("            width: 100%;\n");
      out.write("            padding: 12px;\n");
      out.write("            background-color: #673ab7;\n");
      out.write("            color: white;\n");
      out.write("            border: none;\n");
      out.write("            border-radius: 6px;\n");
      out.write("            font-weight: bold;\n");
      out.write("            cursor: pointer;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .login-box input[type=\"submit\"]:hover {\n");
      out.write("            background-color: #5e35b1;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        .error {\n");
      out.write("            color: red;\n");
      out.write("            text-align: center;\n");
      out.write("            margin-top: 10px;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"login-box\">\n");
      out.write("    <h2>Connexion</h2>\n");
      out.write("\n");
      out.write("    <form method=\"post\" action=\"LoginServlet\">\n");
      out.write("        <label>Email</label>\n");
      out.write("        <input type=\"text\" name=\"email\" required>\n");
      out.write("\n");
      out.write("        <label>Mot de passe</label>\n");
      out.write("        <input type=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("        <input type=\"submit\" value=\"Se connecter\">\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("    ");
 if (request.getAttribute("error") != null) { 
      out.write("\n");
      out.write("        <div class=\"error\">");
      out.print( request.getAttribute("error") );
      out.write("</div>\n");
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
