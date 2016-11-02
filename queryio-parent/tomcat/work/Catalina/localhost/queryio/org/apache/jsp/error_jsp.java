/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.62
 * Generated at: 2016-09-27 06:09:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.queryio.common.EnvironmentalConstants;

public final class error_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");

if(request.getRemoteUser()!=null)	response.sendRedirect("index.jsp");

      out.write("\n");
      out.write("\t<head>\n");
      out.write("\t<title>Login</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"styles/global.css\" type=\"text/css\" />\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"styles/nav_bar.css\" type=\"text/css\" />\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"styles/surround_box.css\" type=\"text/css\" />\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"scripts/navbar.js\"></script>\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"scripts/jquery-1.7.2.min.js\"></script>\n");
      out.write("\t\t<script src=\"scripts/jquery-ui-1.8.20.custom.min.js\"></script>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<div id=\"main\">\n");
      out.write("\t\t<div id=\"nav_bar\" class=\"nav_bar\">\n");
      out.write("\t\t\t<div class=\"nav\"> \n");
      out.write("\t\t\t\t<p id=\"user_welcome\">\n");
      out.write("\t\t\t\t<span id=\"login_info\"><a href=\"javascript:Navbar.helpClicked();\">Help</a> | Welcome Guest </span>\n");
      out.write("\t\t\t\t<span id=\"logo\">\n");
      out.write("\t\t\t\t\t<a href=\"javascript:Navbar.changeTab('dashboard');\"><img src=\"images/queryio_logo.png\" style=\"width: 220px;height: 70px;\"></a>\n");
      out.write("\t\t\t\t</span>\n");
      out.write("\t\t\t\t</p>\n");
      out.write("<!-- \t\t\t\t<span style=\"font-size: 36px; color: #1d5867; padding-left: 40px;\" >Big Data Server</span> -->\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"surround_box_div\">\n");
      out.write("\t \t\t\t<div id=\"surround_box\">\n");
      out.write("\t \t\t\t\t<span id=\"header_row\" style=\"background: -webkit-gradient(linear, 0% 0%, 0% 80%, from(#579), to(#246));background-color:#135;color:white; \">\n");
      out.write("\t \t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t<span id=\"header\" class=\"full-height\"  style=\"margin-left : 50%\">\n");
      out.write("\t \t\t\t\t\t\tLogin\n");
      out.write("\t \t\t\t\t\t</span>\n");
      out.write("\t \t\t\t\t</span>\n");
      out.write("\t  \t\t\t<div>\n");
      out.write("  \t\t\t</div>\n");
      out.write("  \t\t\t<div id=\"main_box\" class=\"main_box\" style=\"border-bottom : 1px solid #DDD\">\n");
      out.write("  \t\t\t\n");
      out.write("\t\n");
      out.write("\t<div id = \"formdiv\"  style=\"margin-left : 43%\">\n");
      out.write("\t\n");
      out.write("\t");

		String message = String.valueOf(request.getSession().getAttribute("message"));
	
		System.out.println("message: " + message);
	
		if (EnvironmentalConstants.isDemoVersion() && (message != null) && !("null".equalsIgnoreCase(message)))
		{
	
      out.write("\n");
      out.write("\t\t\t<p style=\"font-size: 11px;\">");
      out.print(message );
      out.write("</p>\n");
      out.write("\t");

		}
	
      out.write("\n");
      out.write("\t<br />\n");
      out.write("\t<form method=\"post\" id=\"loginForm\" action=\"j_security_check\"  name=\"loginForm\" onsubmit=\"return validateAndStoreLoginDetail();\">\t\n");
      out.write("\t\t<span style = \"color : red; padding-left: 5px;\"> Invalid username / password. Please enter correct credentials to login.</span>\n");
      out.write("\t\t<table>\n");
      out.write("\t\t    <tr id=\"uname\">\n");
      out.write("\t\t       \t<td class=\"desc\" style=\"width: 50px;\">\n");
      out.write("\t\t            Username\n");
      out.write("\t\t   \t\t</td>\n");
      out.write("\t\t        <td>\n");
      out.write("\t\t        \t<input type=\"text\" class=\"text medium\" name=\"j_username\" id=\"j_username\" tabindex=\"1\" style=\"margin-bottom: 5px; width: 130px;\">\n");
      out.write("\t\t    \t</td>\n");
      out.write("\t\t    </tr>\n");
      out.write("\t\t\n");
      out.write("\t\t    <tr id=\"passwd\" style=\"margin-top: 5px;\">\n");
      out.write("\t\t        <td class=\"desc\" style=\"width: 50px;\">\n");
      out.write("\t\t            Password\n");
      out.write("\t\t        </td>\n");
      out.write("\t\t        <td>\n");
      out.write("\t\t        \t<input type=\"password\" class=\"text medium\" name=\"j_password\" id=\"j_password\" tabindex=\"2\" style=\"width: 130px;\">\n");
      out.write("\t\t    \t</td>\n");
      out.write("\t\t    </tr>\n");
      out.write("\t\t    <tr>\n");
      out.write("\t\t    \t<td colspan=\"2\" style=\"text-align: center;\">\n");
      out.write("\t\t\t\t\t<input type=\"submit\" class=\"button\" name=\"login\" value=\"Login\" tabindex=\"4\" style=\"margin-left: 10%; background: -webkit-gradient(linear, 0% 0%, 0% 80%, from(#579), to(#246) ); color: white; border-radius: 8px; background-color: #135;\">\n");
      out.write("\t\t\t");

				if (EnvironmentalConstants.isDemoVersion())
				{
			
      out.write("\n");
      out.write("\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"NewUser\" value=\"New User\" tabindex=\"4\" style=\"margin-left: 5%; background: -webkit-gradient(linear, 0% 0%, 0% 80%, from(#579), to(#246) ); color: white; border-radius: 8px; background-color: #135; padding: 5px 10px 6px;\">\n");
      out.write("\t\t\t");

				}
			
      out.write("\n");
      out.write("\t\t\t\t</td>\n");
      out.write("\t\t    </tr>\n");
      out.write("\t\t</table>\n");
      out.write("\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t\t\t\t\n");
      out.write("  \t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t</body>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("//\tcheckUrl();\n");
      out.write("\n");
      out.write("function validateAndStoreLoginDetail()\n");
      out.write("{\n");
      out.write("\t\t\n");
      out.write("\t   if( document.loginForm.j_username.value == \"\" )\n");
      out.write("\t   {\n");
      out.write("\t   \t document.getElementById(\"message\").text = \"Username was not provided. Please provide a valid username.\";\n");
      out.write("\t     document.loginForm.j_username.focus() ;\n");
      out.write("\t     return false;\n");
      out.write("\t   }\n");
      out.write("\t   else{\n");
      out.write("\t\t   //Util.setCookie(\"queryioUser\",document.loginForm.j_username.value,-1);\n");
      out.write("\t\t   Util.setCookie(\"queryioUser\",document.loginForm.j_username.value,100);\n");
      out.write("\t   }\n");
      out.write("\t   if(document.loginForm.j_password.value == \"\")\n");
      out.write("\t   {\n");
      out.write("\t\t   document.getElementById(\"message\").text = \"Password was not provided. Please provide a valid password for user.\"\n");
      out.write("\t\t   document.loginForm.j_password.focus() ;\n");
      out.write("\t     return false;\n");
      out.write("\t   }\t\n");
      out.write("\t   \n");
      out.write("\t   return true;\n");
      out.write("\t   \n");
      out.write("}\n");
      out.write("\n");
      out.write("\tfunction  checkUrl()\n");
      out.write("\t{\n");
      out.write("\t\tconsole.log('checkURL called.');\n");
      out.write("\t\tvar domain;\n");
      out.write("\t\tvar loginUrl = 'login.jsp'\n");
      out.write("\t\t\n");
      out.write("\t\tvar urLength , domainLength;\n");
      out.write("\t\tvar index;\n");
      out.write("\t\tvar url1 = document.URL;\n");
      out.write("\n");
      out.write("\t\turLength = url1.length;\n");
      out.write("\t\tdomainLength = url1.indexOf('j_secu');\n");
      out.write("\t\tif(domainLength != -1)\n");
      out.write("\t\t{\n");
      out.write("\t\t\tdomain = url1.substring(0 , domainLength);\n");
      out.write("\t\t\turl1 = url1.substring(domainLength , urLength);\n");
      out.write("\t\t\tif(url1=='j_security_check')\n");
      out.write("\t\t\t{\n");
      out.write("\t\t\t\tdomain = domain + loginUrl;\n");
      out.write("\t\t\t\twindow.location = ''+domain;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("\t$(window).bind('hashchange', function() {\n");
      out.write("\t checkUrl();\n");
      out.write("\t \n");
      out.write("\t});\n");
      out.write("\t\t\n");
      out.write("\t</script>\n");
      out.write("</html>\t");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
