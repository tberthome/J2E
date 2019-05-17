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
/*
        UtilisateurDao utilisateurDao = new UtilisateurDao();
        BlogDao blogDao=new BlogDao();

        String email = request.getParameter("utilisateur_getEmail");
        String mdp = request.getParameter("utilisateur_getPassword");
        Statut st=new Statut(1,"creer");
        try {
            utilisateurCourant = utilisateurDao.getUtilisateur(email,mdp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Blog blog=new Blog(5, "yy","tt",0,utilisateurCourant,st);
        try {

            System.out.println(utilisateurCourant);
           blogDao.createBlog(blog,utilisateurCourant);


            if (utilisateurCourant.getEmail() != null || utilisateurCourant.getEmail().length() > 0) {

                //response.sendRedirect("http://localhost:8080/fr_epsi_blog_war_exploded/ListBlogs");
                //request.getRequestDispatcher("listBlogs.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Requete erroné !! Recupere un utilisateur");
      }
//      catch (IOException e) {
//            e.printStackTrace();
//        }
*/
    }

}
