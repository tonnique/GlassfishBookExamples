//http://keepjblog.blogspot.com/2015/01/jms-20-wildfly.html

package ru.antony.jms;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "service", urlPatterns = { "/jmsservice" })
public class ServiceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Inject
    Sender sender;

    public ServiceServlet() {}

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<html><body>");
        for (int i = 0; i < 3; i++) {
            String msg = "Message #" + i;
            out.print("<li>" + msg);
            sender.sendMessage(msg);
        }
        out.print("</body></html>");
        out.close();
    }
}
