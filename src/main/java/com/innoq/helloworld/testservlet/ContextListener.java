package com.innoq.helloworld.testservlet;
 
import javax.persistence.*;
import javax.servlet.*;
 
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent e) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("defaultPU");
        e.getServletContext().setAttribute("emf", emf);
    }
 
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }
}