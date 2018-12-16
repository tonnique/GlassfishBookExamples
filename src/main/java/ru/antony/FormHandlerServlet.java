package ru.antony;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FormHandlerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String enteredValue = req.getParameter("textValue");

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter pw;
        try {
            pw = resp.getWriter();
            pw.println("<p>");
            pw.print("Вы ввели: ");
            pw.print(enteredValue);
            pw.println("</p>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
