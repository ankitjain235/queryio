/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.62
 * Generated at: 2016-09-27 10:45:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class popup_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!-- \n");
      out.write("<div id=\"modal\" style=\"border:3px solid black; background-color:#9999ff; padding:25px; font-size:150%; text-align:center; display:none;\">\n");
      out.write("\tThis is a modal popup!<br><br>\n");
      out.write("\t<input type=\"button\" value=\"OK\" onClick=\"Popup.hide('modal')\">\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<a href=\"#\" onclick=\"Popup.showModal('modal');return false;\">\n");
      out.write("\tShow Modal Popup\n");
      out.write("</a>\n");
      out.write("<br>\n");
      out.write("<a href=\"#\" onclick=\"Popup.showModal('modal',null,null,{'screenColor':'#99ff99','screenOpacity':.6});return false;\">\n");
      out.write("\tShow Modal Popup With A Custom Screen\n");
      out.write("</a>\n");
      out.write("-->\n");
      out.write("\n");
      out.write("<div id=\"host_operation\" class=\"lightbox\">\n");
      out.write("    <table id=\"host_operation_table\" class=\"outer\" style=\"\">\n");
      out.write("        <tbody>\n");
      out.write("        \t<tr>\n");
      out.write("            \t<td id=\"hdr_td\" style=\"padding: 0pt; \">\n");
      out.write("            \t\t<h4 style=\"font-weight: normal;\">Status</h4>\n");
      out.write("            \t</td>\n");
      out.write("        \t</tr>\n");
      out.write("        \t<tr>\n");
      out.write("            \t<td id=\"msg_td\">\n");
      out.write("                \t<div class=\"instructional\" style=\"text-align: center; width: 100%;\">\n");
      out.write("                \t\t<table align=\"center\" width=\"100%\" style=\"border-collapse: collapse; text-align: center;\">\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t\t<th><span id=\"popup.component\">Host</span></th>\n");
      out.write("\t\t\t\t\t\t\t\t<th><span id=\"popup.message\">Message</span></th>\n");
      out.write("\t\t\t\t\t\t\t\t<th><span id=\"popup.status\">Status</span></th>\n");
      out.write("\t\t\t\t\t\t\t\t<th><span id=\"popup.image\">\t</span></th>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr id=\"pop.pattern\" style=\"display:none;\">\n");
      out.write("\t\t\t\t\t\t\t\t<td><span id=\"popup.host\"></span></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td><span id=\"popup.message\"></span><br><div id=\"log_div\" style=\"display: none;\"></div></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td><span id=\"popup.status\"></span></td>\n");
      out.write("\t\t\t\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span id=\"popup.image.fail\" style=\"display:none;\"><img src=\"images/Fail_img.png\" style=\"height: 12pt; margin-right: 1pt; margin-top: 1pt;\"/></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span id=\"popup.image.success\" style=\"display:none;\"><img  src=\"images/Success_img.png\" style=\"height: 12pt; margin-right: 1pt; margin-top: 1pt;\"/></span>\n");
      out.write("\t\t\t\t\t\t\t\t\t<span id=\"popup.image.processing\"><img  src=\"images/process.gif\" style=\"height: 12pt; margin-right: 1pt; margin-top: 1pt;\"/></span>\n");
      out.write("\t\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"4\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"button\" disabled=\"true\"  class=\"buttonAdmin\" id=\"ok.popup\" value=\"Ok\" onclick=\"javascript:closePopUpBox();\">\n");
      out.write("\t\t\t\t\t\t\t\t<!-- <input type=\"button\" disabled=\"true\" class=\"buttonAdmin\" id=\"viewreason.popup\" value=\"Reason For Failure\" onclick=\"javascript:showReasonForFailure();\" style=\"margin: 0 0 0 10pt;\">-->\n");
      out.write("\t\t\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t\t</table>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("            \t</td>\n");
      out.write("        \t</tr>\n");
      out.write("        \t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\n");
      out.write("    \t</tbody>\n");
      out.write("\t</table>\n");
      out.write("\t<script type=\"text/javascript\">\n");
      out.write("\t\tfillPopUp(true);\n");
      out.write("\t\tloadGIF();\n");
      out.write("\t\tfunction loadGIF(){\n");
      out.write("\t\t\t$('#popup.image.processing').html('');\n");
      out.write("\t\t\t$('#popup.image.processing').html('<img  src=\"images/process.gif\" style=\"height: 12pt; margin-right: 1pt; margin-top: 1pt;\"/>');\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t//Navbar.changeTab('MapReduce','MapReduce', 'NodeManager');\n");
      out.write("\t\t}\n");
      out.write("\t</script>\n");
      out.write("</div>");
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