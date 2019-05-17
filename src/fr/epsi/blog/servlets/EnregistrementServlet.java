package fr.epsi.blog.servlets;

import fr.epsi.blog.beans.Utilisateur;
import fr.epsi.blog.dao.PersistenceManager;
import fr.epsi.blog.dao.UtilisateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Servlet implementation class EnregistrementServlet
 */
@WebServlet("/Enregistrement")
public class EnregistrementServlet extends HttpServlet {

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     * @param request
     * @param response
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("utilisateur_nom");
        String email = request.getParameter("utilisateur_email");
        String mdp = request.getParameter("utilisateur_mdp");
        System.out.println(request.getParameter("utilisateur_admin"));
        boolean admin = false;
        if (request.getParameter("utilisateur_admin") == "admin") {
            admin = true;
        }

        Utilisateur utilisateur = new Utilisateur(nom, email, mdp, admin);

        System.out.println(utilisateur);

        UtilisateurDao utilisateurDao = new UtilisateurDao();

        try {
            utilisateurDao.createUtilisateur(utilisateur);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Requete SQL creation utilisateur erroné !");
        }

        request.getRequestDispatcher("index.html").forward(request,response);

    }

}
