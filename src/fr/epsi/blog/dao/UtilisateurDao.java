package fr.epsi.blog.dao;

import fr.epsi.blog.beans.Utilisateur;

import java.sql.*;

public class UtilisateurDao implements IUtilisateurDao {

    @Override
    public Utilisateur getUtilisateur(String email,String mdp) throws SQLException {

        Connection connection = PersistenceManager.getConnection();
        Utilisateur utilisateur=null;
        String requete = "SELECT id, nom, email, password, dateCreation,admin FROM user WHERE email =? AND  password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2,mdp);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
             utilisateur = new Utilisateur(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getBoolean(6));
        }

        return utilisateur;

    }

    @Override
    public void createUtilisateur(Utilisateur utilisateur) throws SQLException {

        Connection connection = PersistenceManager.getConnection();

        String requete = "INSERT INTO user(nom, email, password, dateCreation, admin) VALUES(?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(requete);
        preparedStatement.setString(1, utilisateur.getEmail());
        preparedStatement.setString(2, utilisateur.getNom());
        preparedStatement.setString(3, utilisateur.getPassword());
        preparedStatement.setDate(4, utilisateur.getDateCreation());
        preparedStatement.setBoolean(5, utilisateur.getAdmin());

        preparedStatement.executeUpdate();

    }

    @Override
    public void updateUtilisateur(Utilisateur utilisateur) throws SQLException {

    }

    @Override
    public void deleteUtilisateur(Utilisateur utilisateur) throws SQLException {

    }
}
