package ru.antony;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class CheckboxesHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String[] selectedOptions = req.getParameterValues("options");
        ArrayList<String> selectedOptionLabels = null;
        if (selectedOptions != null) {
            selectedOptionLabels = new ArrayList<String>(selectedOptions.length);

            for (String option : selectedOptions) {

                if (option.equals("опция1")) {
                    selectedOptionLabels.add("Опция 1");
                }
                if (option.equals("опция2")) {
                    selectedOptionLabels.add("Опция 2");
                }
                if (option.equals("опция3")) {
                    selectedOptionLabels.add("Опция 3");
                }
            }
        }
        req.setAttribute("checkedLabels", selectedOptionLabels);

        try {
            req.getRequestDispatcher("confirmationservlet").forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
