package fr.epsi.blog.servlets;

import fr.epsi.blog.dao.PersistenceManager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PingServlet
 */
@WebServlet("/Ping")
public class PingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("work !");
		response.getWriter().append("Ping: ").append(request.getContextPath());
		try {
			Connection connection = PersistenceManager.getConnection();
			System.out.println("BDD connecté");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("BDD erreur");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * @param request
	 * @param response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {

	}

}
