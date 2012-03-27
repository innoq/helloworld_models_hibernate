package guest;
 
import javax.persistence.*;
import javax.servlet.*;
 
public class GuestListener implements ServletContextListener {

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