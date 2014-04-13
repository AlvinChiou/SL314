/*
    ����:   http://localhost:8081/SL314/PathServlet/1.txt?name1=peter1&name2=peter2
    ���`�N     (��1)�`�N�����Ψ�i�B�~���|��T�j�ɥ����ϥΡi�e�m���|�����j���]�w
    �P�ɪ`�N(��2)web.xml����<url-pattern>�O<url-pattern>/PathServlet/*</url-pattern>                               
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PathServlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
   
    res.setContentType("text/plain; charset=Big5");
    PrintWriter out = res.getWriter();

out.println("=======================request �����k for ���|��T===============================");    
    out.println("req.getScheme()="+req.getScheme());
    out.println("req.getServerName()="+req.getServerName());
    out.println("req.getServerPort()="+req.getServerPort());
    out.println("req.getContextPath()="+req.getContextPath());
    out.println("req.getServletPath()="+req.getServletPath());
    out.println("req.getPathInfo()=" + req.getPathInfo() );
    out.println("�ireq.getPathTranslated()=" + req.getPathTranslated()+"�j");
    out.println("req.getQueryString()="+req.getQueryString());
out.println();
    out.println("req.getRequestURI()="+ req.getRequestURI());
    out.println("�i�۷���req.getContextPath() + req.getServletPath() + req.getPathInfo()�j");
out.println();  
    out.println("req.getMethod()=" + req.getMethod());
    out.println("req.getProtocol()=" + req.getProtocol());
out.println();
     out.println("req.getHeader(\"Content-Type\")="+req.getHeader("Content-Type"));
     out.println("req.getContentType()="+req.getContentType());
     out.println("req.getContentLength()="+req.getContentLength());
out.println();
out.println("�i�Ѧ�:�jStringBuffer HttpUtils.getRequestURL(req)="+HttpUtils.getRequestURL(req));     
out.println();   
     out.println("�iDeprecated:�jreq.getRealPath(\"/xxx.gif\")= "+req.getRealPath("/xxx.gif"));
out.println(); 
out.println("=======================context �����k for ���|��T============================");    
out.println();  
    
     out.println("�i ������ ServletContext context = getServletContext();�j");
     ServletContext context = getServletContext();

     out.println("context.getRealPath(\"/xxx.gif\")= "+context.getRealPath("/xxx.gif"));
     
     out.println("context.getMimeType(\"/xxx.gif\")= "+context.getMimeType("/xxx.gif"));
     out.println("context.getMimeType(\"/xxx.jpg\")= "+context.getMimeType("/xxx.jpg"));
     out.println("context.getMimeType(\"/xxx.pdf\")= "+context.getMimeType("/xxx.pdf"));
     out.println("context.getMimeType(\"/xxx.doc\")= "+context.getMimeType("/xxx.doc"));
     out.println("context.getMimeType(\"/xxx.mp3\")= "+context.getMimeType("/xxx.mp3"));
     out.println("context.getMimeType(\"/xxx.avi\")= "+context.getMimeType("/xxx.avi"));

out.println("========================================================");
    
     
    }
	 
    
    public void doPost(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
      doGet(req,res);
    }
}