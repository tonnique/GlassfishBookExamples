package ru.antony.jpa;

import ru.antony.entity.Item;
import ru.antony.entity.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@WebServlet(urlPatterns = {"/many2manydemo"})
public class ManyToManyRelationshipDemoServlet extends HttpServlet
{
    @PersistenceUnit(unitName = "customerPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                           throws ServletException, IOException  {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Order order;
        Collection<Item> items = new ArrayList<Item>();
        Item item1 = new Item();
        Item item2 = new Item();

        item1.setItemId(1L);
        item1.setItemNumber("BCD1234");
        item1.setItemShortDesc("Переносной компьютер");
        item1.setItemLongDesc("64-битный, четырёх ядерный ЦП, 4ГБ памяти");

        item2.setItemId(2L);
        item2.setItemNumber("CDF2345");
        item2.setItemShortDesc("Беспроводная мышь");
        item2.setItemLongDesc("Три кнопки, инфрактасный порт, "
                + "колесо прокрутки по горизонтали и вертикали");

        items.add(item1);
        items.add(item2);

        try {
            userTransaction.begin();

            entityManager.persist(item1);
            entityManager.persist(item2);

            order = entityManager.find(Order.class, 1L);
            order.setItems(items);

            entityManager.persist(order);

            userTransaction.commit();

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().println("База данных успешно обновлена.");
        } catch (NotSupportedException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (RollbackException e) {
            e.printStackTrace();
        } catch (HeuristicMixedException e) {
            e.printStackTrace();
        } catch (HeuristicRollbackException e) {
            e.printStackTrace();
        }
    }
}
