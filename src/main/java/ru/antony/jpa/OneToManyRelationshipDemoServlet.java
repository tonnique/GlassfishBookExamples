package ru.antony.jpa;

import ru.antony.entity.Customer;
import ru.antony.entity.Order;

import java.io.IOException;

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

@WebServlet(urlPatterns = {"/one2manydemo"})
public class OneToManyRelationshipDemoServlet extends HttpServlet
{
    @PersistenceUnit(unitName = "customerPersistenceUnit")
    private EntityManagerFactory entityManagerFactory;

    @Resource
    private UserTransaction userTransaction;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer;
        Order order1;
        Order order2;

        order1 = new Order();
        order1.setOrderId(1L);
        order1.setOrderNumber("SFX12345");
        order1.setOrderDescription("Незаполненый заказ.");

        order2 = new Order();
        order2.setOrderId(2L);
        order2.setOrderNumber("SFX23456");
        order2.setOrderDescription("Ещё один незаполненный заказ.");

        try {
            userTransaction.begin();

            customer = entityManager.find(Customer.class, 4L);

            order1.setCustomer(customer);
            order2.setCustomer(customer);

            entityManager.persist(order1);
            entityManager.persist(order2);

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
