package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SiteSelector extends HttpServlet {

  Vector<String> sites = new Vector<String>();
  Random random = new Random();

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    int siteIndex = Math.abs(random.nextInt()) % sites.size();
    String site = sites.get(siteIndex);

    res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
    res.setHeader("Location", site);
  }
  public void init() throws ServletException {
    sites.add("http://www.oreilly.com/catalog/jservlet");
    sites.add("http://www.servlets.com");
    sites.add("http://java.sun.com/products/servlet");
    sites.add("http://tw.yahoo.com");
  }
}
