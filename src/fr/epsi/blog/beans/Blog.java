package fr.epsi.blog.beans;

import java.sql.Date;
import java.util.List;
import fr.epsi.blog.beans.Utilisateur;

public class Blog {

	private Integer id;
	private String titre;
	private String description;
	private Integer nbVue;
	private Utilisateur createur;
	private Date dateCreation;
	private Date dateModification;
	private Statut statut;
	//private List<Reponse> listOfReponses;


	public Blog(Integer id, String titre, String description, Integer nbVue, Utilisateur createur, Date dateCreation, Date dateModification, Statut statut) {
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.nbVue = nbVue;
		this.createur = createur;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.statut = statut;
	}

	public Blog(String titre, String description, Utilisateur createur, Statut statut) {
		this.titre = titre;
		this.description = description;
		this.nbVue = 0;
		this.createur = createur;
		this.dateCreation =  new Date(System.currentTimeMillis());
		this.dateModification = null;
		this.statut = statut;
	}

	//	public List<Reponse> getListOfReponses() {
//		return listOfReponses;
//	}
//	public void setListOfReponses(List<Reponse> listOfReponses) {
//		this.listOfReponses = listOfReponses;
//	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Utilisateur getCreateur() {
		return createur;
	}
	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Integer getNbVue() {
		return nbVue;
	}

	public void setNbVue(Integer nbVue) {
		this.nbVue = nbVue;
	}

	@Override
	public String toString() {
		return "Blog{" +
				"id=" + id +
				", titre='" + titre + '\'' +
				", description='" + description + '\'' +
				", nbVue=" + nbVue +
				", createur=" + createur +
				", dateCreation=" + dateCreation +
				", dateModification=" + dateModification +
				", statut=" + statut +
				'}';
	}
}
