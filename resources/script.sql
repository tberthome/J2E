CREATE TABLE user (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nom VARCHAR(140) NOT NULL,
  email VARCHAR(200) NOT NULL UNIQUE,
  password VARCHAR(140) NOT NULL,
  dateCreation DATE NOT NULL,
  admin BOOLEAN NOT NULL
);

CREATE TABLE status (
  id INT PRIMARY KEY AUTO_INCREMENT,
  description VARCHAR(140) NOT NULL
);

CREATE TABLE post (
  id INT PRIMARY KEY AUTO_INCREMENT,
  titre VARCHAR(140) NOT NULL,
  description TEXT NOT NULL,
  status TINYINT NOT NULL,
  nbVue INT NOT NULL,
  dateCreation DATE NOT NULL,
  dateModification DATE,
  auteur INT NOT NULL,
  CONSTRAINT fk_post_auteur FOREIGN KEY (auteur) REFERENCES user(id)
);

CREATE TABLE commentaire (
  id INT PRIMARY KEY AUTO_INCREMENT,
  commentaire TEXT NOT NULL,
  datePublication DATE NOT NULL,
  auteur INT NOT NULL,
  post INT NOT NULL,
  CONSTRAINT fk_commentaire_user FOREIGN KEY (auteur) REFERENCES user(id),
  CONSTRAINT fk_commentaire_post FOREIGN KEY (post) REFERENCES post(id)
);