package fr.epsi.blog.servlets;

import fr.epsi.blog.beans.Blog;
import fr.epsi.blog.beans.Utilisateur;
import fr.epsi.blog.dao.BlogDao;
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
import java.util.List;

/**
 * Servlet implementation class ListBlogsServlet
 */
@WebServlet("/ListBlogs")
public class ListBlogsServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BlogDao blogDao = new BlogDao();
        UtilisateurDao utilisateurDao = new UtilisateurDao();
        Utilisateur utilisateur = null;
        try {
            utilisateur = utilisateurDao.getUtilisateur("gregory", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Blog> listBlogs = blogDao.getBlogs(utilisateur);

        //request.set;

        request.getRequestDispatcher("listBlogs.jsp").forward(request, response);

    }

}
