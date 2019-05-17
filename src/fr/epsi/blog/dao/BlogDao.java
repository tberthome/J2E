package fr.epsi.blog.dao;

import fr.epsi.blog.beans.Blog;
import fr.epsi.blog.beans.Reponse;
import fr.epsi.blog.beans.Statut;
import fr.epsi.blog.beans.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao implements IBlogDao {
    @Override
    public Blog getBlog(Integer id) throws SQLException {

        Connection connection = PersistenceManager.getConnection();
        Blog blog=null;
        String requete = "SELECT p.id, p.titre, p.description, p.nbVue,p.dateCreation,p.dateModification,u.id, u.nom, u.email, u.password, u.dateCreation,u.admin,s.id,s.description FROM post p" +
                " INNER JOIN  user u ON u.id=p.auteur " +
                "INNER  JOIN status s ON s.id=p.status WHERE p.id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Utilisateur utilisateur=new Utilisateur(resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getDate(11),resultSet.getBoolean(12));
            Statut statut=new Statut(resultSet.getInt(13),resultSet.getString(14));
            blog = new Blog(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), utilisateur,resultSet.getDate(5), resultSet.getDate(6),statut);
        }

        return blog;

    }

    @Override
    public List<Blog> getBlogs(Utilisateur utilisateur) {
        return null;
    }

    @Override
    public List<Blog> getAllBlogs() throws SQLException {
        Connection connection = PersistenceManager.getConnection();
        List<Blog> lblog=new ArrayList<Blog>();
        Blog blog=null;
        String requete = "SELECT p.id, p.titre, p.description, p.nbVue,p.dateCreation,p.dateModification,u.id, u.nom, u.email, u.password, u.dateCreation,u.admin,s.id,s.description FROM post p" +
                " INNER JOIN  user u ON u.id=p.auteur " +
                "INNER  JOIN status s ON s.id=p.status";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Utilisateur utilisateur=new Utilisateur(resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getString(10),resultSet.getDate(11),resultSet.getBoolean(12));
            Statut statut=new Statut(resultSet.getInt(13),resultSet.getString(14));
            blog = new Blog(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), utilisateur,resultSet.getDate(5), resultSet.getDate(6),statut);
            lblog.add(blog);
        }

        return lblog;

    }

    @Override
    public void createBlog(Blog blog, Utilisateur user) throws SQLException {
        Connection connection = PersistenceManager.getConnection();

        String requete = "INSERT INTO post(titre, description, status, dateCreation,auteur,nbVue) VALUES(?,?,?,?,?,?);";



        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, blog.getTitre());
        preparedStatement.setString(2,blog.getDescription());
        preparedStatement.setInt(3,1);
        preparedStatement.setDate(4,blog.getDateCreation());
        preparedStatement.setInt(5,user.getId());
        preparedStatement.setInt(6,0);
        preparedStatement.executeUpdate();

    }

    @Override
    public void updateBlog(Blog blog) throws SQLException {

    }

    @Override
    public void deleteBlog(Blog blog) throws SQLException {

    }

    @Override
    public void addReponse(Blog blog, Reponse reponse) throws SQLException {

    }
}
