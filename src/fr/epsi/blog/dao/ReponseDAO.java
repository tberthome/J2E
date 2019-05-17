package fr.epsi.blog.dao;

import fr.epsi.blog.beans.Reponse;
import fr.epsi.blog.beans.Utilisateur;

import java.sql.SQLException;

public class ReponseDAO implements IReponseDAO {
    @Override
    public Reponse getReponse(Integer id) throws SQLException {
        return null;
    }

    @Override
    public void createReponse(Reponse reponse, Utilisateur User) throws SQLException {

    }

    @Override
    public void updateReponse(Reponse reponse) throws SQLException {

    }

    @Override
    public void deleteReponse(Reponse reponse) throws SQLException {

    }
}
