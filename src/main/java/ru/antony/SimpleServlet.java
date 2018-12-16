package ru.antony;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            PrintWriter pw = resp.getWriter();
            pw.println("<h2>");
            pw.println("Если вы читаете это, ваш сервер приложений работает нормально!");
            pw.println("</h2>");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
