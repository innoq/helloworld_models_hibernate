package com.innoq.helloworld.testservlet;
 
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;

import com.innoq.helloworld.models.Address;
import com.innoq.helloworld.models.Profile;
 
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a PersistenceManager instance:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Display the list of addresses:
            List<Profile> profileList =
                em.createQuery("SELECT p FROM Profile p", Profile.class).getResultList();
            request.setAttribute("profileList", profileList);
            request.getRequestDispatcher("/profiles.jsp").forward(request, response);
 
        } finally {
            // Close the PersistenceManager:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }

}