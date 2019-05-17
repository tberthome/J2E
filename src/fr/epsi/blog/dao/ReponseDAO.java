package fr.epsi.blog.dao;

import fr.epsi.blog.beans.Blog;
import fr.epsi.blog.beans.Reponse;
import fr.epsi.blog.beans.Utilisateur;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReponseDAO implements IReponseDAO {
    @Override
    public Reponse getReponse(Integer id) throws SQLException {
        Reponse reponse = null;
        Connection connection = PersistenceManager.getConnection();

        String requete = "SELECT commentaire,datePublication,user.nom,user.email,user.password,user.dateCreation,user.admin from commentaire INNER JOIN post ON commentaire.post=post.id INNER JOIN user ON commentaire.auteur=user.id;";

        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        ResultSet resultSet = preparedStatement.executeQuery();
        Utilisateur utilisateur = new Utilisateur(resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getBoolean(6));
        reponse = new Reponse(resultSet.getString(1), resultSet.getDate(2), utilisateur);
        return reponse;
    }



    @Override
    public void createReponse(Reponse reponse, Utilisateur user, Blog blog) throws SQLException {
        Connection connection = PersistenceManager.getConnection();

        String requete = "INSERT INTO commentaire(commentaire,datePublication,auteur,post) VALUES(?,?,?,?);";



        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, reponse.getCommentaire());
        preparedStatement.setDate(2,reponse.getPublication());
        preparedStatement.setInt(3,user.getId());
        preparedStatement.setInt(4,blog.getId());

        preparedStatement.executeUpdate();
    }

    @Override
    public void updateReponse(Reponse reponse) throws SQLException {

    }

    @Override
    public void deleteReponse(Reponse reponse) throws SQLException {

    }
}
