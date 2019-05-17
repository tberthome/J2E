package fr.epsi.blog.beans;

import java.sql.Date;

public class Utilisateur {

	private int id;
	private String nom;
	private String email;
	private String password;
	private Date dateCreation;
	private Boolean admin;

	/**
	 * Constructeur pour création (enregistrement BDD)
	 * @param email
	 * @param nom
	 * @param password
	 * @param admin
	 */
	public Utilisateur(String email, String nom, String password, Boolean admin) {
		this.email = email;
		this.nom = nom;
		this.password = password;
		this.dateCreation =  new Date(System.currentTimeMillis());
		this.admin = admin;
	}

	/**
	 * Constructeur pour récupération depuis BDD
	 * @param id
	 * @param email
	 * @param nom
	 * @param password
	 * @param dateCreation
	 * @param admin
	 */
	public Utilisateur(int id, String email, String nom, String password, Date dateCreation, Boolean admin) {
		this.id = id;
		this.email = email;
		this.nom = nom;
		this.password = password;
		this.dateCreation = dateCreation;
		this.admin = admin;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String passord) {
		this.password = passord;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Utilisateur{" +
				"id=" + id +
				", email='" + email + '\'' +
				", nom='" + nom + '\'' +
				", password='" + password + '\'' +
				", dateCreation=" + dateCreation +
				", admin=" + admin +
				'}';
	}
}
