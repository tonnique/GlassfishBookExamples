package ru.antony;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CheckboxesHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] selectedOptions = req.getParameterValues("options");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        try {
            PrintWriter pw = resp.getWriter();
            pw.println("<p>");
            pw.print("Были выбраны следующие опции:");
            pw.println("<br/>");
            if (selectedOptions != null) {
                for (String option : selectedOptions) {
                    pw.print(option);
                    pw.println("<br/>");
                }
            } else {
                pw.print("Никаких опций выбрано не было.");
            }
            pw.print("</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
