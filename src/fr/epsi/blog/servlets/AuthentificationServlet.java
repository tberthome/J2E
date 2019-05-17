package fr.epsi.blog.servlets;

import fr.epsi.blog.beans.Blog;
import fr.epsi.blog.beans.Statut;
import fr.epsi.blog.beans.Utilisateur;
import fr.epsi.blog.dao.BlogDao;
import fr.epsi.blog.dao.UtilisateurDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class AuthentificationServlet
 */
@WebServlet("/Authentification")
public class AuthentificationServlet extends HttpServlet {
    static Utilisateur utilisateurCourant;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        UtilisateurDao utilisateurDao = new UtilisateurDao();
        String email = request.getParameter("utilisateur_getEmail");
        String mdp = request.getParameter("utilisateur_getPassword");

        try {
           utilisateurCourant = utilisateurDao.getUtilisateur(email,mdp);
            System.out.println(utilisateurCourant);
            if (utilisateurCourant.getEmail() != null || utilisateurCourant.getEmail().length() > 0) {

                BlogDao blogDao = new BlogDao();
                List<Blog> listBlogs = blogDao.getAllBlogs();
                List<Blog> listBlogsByUser = blogDao.getBlogs(utilisateurCourant);
                System.out.println(utilisateurCourant.getId());
                request.setAttribute("listBlogs", listBlogs);
                request.setAttribute("listBlogsByUser", listBlogsByUser);
                request.getRequestDispatcher("listBlogs.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Requete erroné !! Recupere un utilisateur");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
