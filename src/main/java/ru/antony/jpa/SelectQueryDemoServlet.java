package ru.antony.jpa;

import ru.antony.entity.UsState;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/jpqldemo"})
public class SelectQueryDemoServlet extends HttpServlet
{
    @PersistenceUnit(unitName = "customerPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                          throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter printWriter = response.getWriter();
        List<UsState> matchingStatesList;

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager
                .createQuery("SELECT s FROM UsState s WHERE s.usStateNm LIKE :name");

        query.setParameter("name", "New%");
        matchingStatesList = query.getResultList();

        printWriter.println("Следующие штаты соответствуют критерию:<br/>");
        for (UsState state : matchingStatesList) {
            printWriter.println(state.getUsStateNm() + "<br/>");
        }
    }
}

