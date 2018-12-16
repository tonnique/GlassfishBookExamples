package ru.antony;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ConfirmationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        try {
            PrintWriter pw;
            List<String> checkedLabels = (List<String>) req.getAttribute("checkedLabels");
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            pw = resp.getWriter();
            pw.println("<p>");
            pw.print("Были выбраны следующие опции: ");
            pw.println("<br/>");
            if (checkedLabels != null) {
                for (String label : checkedLabels) {
                    pw.print(label);
                    pw.println("<br/>");
                }
            } else {
                pw.println("Никаких опций выбрано не было.");
            }
            pw.println("</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
