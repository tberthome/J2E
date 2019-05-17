package fr.epsi.blog.dao;

import fr.epsi.blog.beans.Blog;
import fr.epsi.blog.beans.Reponse;
import fr.epsi.blog.beans.Utilisateur;

import java.sql.SQLException;

public interface IReponseDAO {
    Reponse getReponse(Integer id) throws SQLException;
    void createReponse(Reponse reponse,Utilisateur User, Blog blog) throws SQLException;
    void updateReponse(Reponse reponse) throws SQLException;
    void deleteReponse(Reponse reponse) throws SQLException;
}
