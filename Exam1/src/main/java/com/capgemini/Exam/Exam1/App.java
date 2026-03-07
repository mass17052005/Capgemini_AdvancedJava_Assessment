package com.capgemini.Exam.Exam1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("myPersistenceUnit");

        EntityManager em = emf.createEntityManager();

        try {
        	em.getTransaction().begin();

            Employee employee = new Employee();
            employee.setName("John");
            employee.setEmail("john@example.com");

            IDCard card = new IDCard(null,"1234","1-2-24",employee);

            employee.setIdCard(card);
            card.setEmployee(employee);

            em.persist(employee);

            em.getTransaction().commit();
            System.out.println("Employee Created Successfully");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
