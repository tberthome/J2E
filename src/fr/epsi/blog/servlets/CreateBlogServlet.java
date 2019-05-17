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
@WebServlet("/Create_Blog")
public class CreateBlogServlet extends HttpServlet {


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {


        String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        Utilisateur user=AuthentificationServlet.utilisateurCourant;
        Statut statut=new Statut(1,"nn");

        Blog blog=new Blog(titre,description,user,statut);
        BlogDao blogDao = new BlogDao();

        try {
            blogDao.createBlog(blog,user);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Requete SQL creation utilisateur erroné !");
        }

    }
}
