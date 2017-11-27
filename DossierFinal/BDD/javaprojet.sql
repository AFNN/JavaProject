-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 27 nov. 2017 à 09:59
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `javaprojet`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `idClasse` int(11) NOT NULL AUTO_INCREMENT,
  `NomClasse` varchar(255) NOT NULL,
  `idMatiere1` int(11) NOT NULL,
  `idMatiere2` int(11) NOT NULL,
  `idMatiere3` int(11) NOT NULL,
  `idMatiere4` int(11) NOT NULL,
  PRIMARY KEY (`idClasse`),
  KEY `IDCLASSEINDEX` (`idClasse`) USING BTREE,
  KEY `FK_MAT2` (`idMatiere2`),
  KEY `FK_MAT3` (`idMatiere3`),
  KEY `FK_MAT4` (`idMatiere4`),
  KEY `FOREIGNKEYMATIERE` (`idMatiere1`,`idMatiere2`,`idMatiere3`,`idMatiere4`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`idClasse`, `NomClasse`, `idMatiere1`, `idMatiere2`, `idMatiere3`, `idMatiere4`) VALUES
(1, '6emeA', 5, 2, 3, 4),
(2, '5emeA', 5, 4, 1, 2),
(3, '4emeA', 1, 2, 5, 4),
(4, '3emeA', 2, 1, 4, 3),
(5, '6emeB', 1, 2, 3, 4),
(6, '5emeB', 1, 2, 3, 4),
(7, '4emeB', 1, 2, 3, 4),
(8, '3emeB', 1, 2, 3, 4);

-- --------------------------------------------------------

--
-- Structure de la table `coordonnees`
--

DROP TABLE IF EXISTS `coordonnees`;
CREATE TABLE IF NOT EXISTS `coordonnees` (
  `Adresse` varchar(255) CHARACTER SET latin1 NOT NULL,
  `CodePostal` int(11) NOT NULL,
  `Ville` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Teldom` varchar(11) NOT NULL,
  `Telmobile` varchar(11) NOT NULL,
  `Email` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Matricule` int(11) NOT NULL,
  UNIQUE KEY `INDEXMATRICULE` (`Matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `coordonnees`
--

INSERT INTO `coordonnees` (`Adresse`, `CodePostal`, `Ville`, `Teldom`, `Telmobile`, `Email`, `Matricule`) VALUES
('4 rue de paris', 75013, 'Paris', '0111111111', '060000000', 'fouillard.arnaud@gmail.com', 1),
('4 rue de montreuil', 75012, 'Paris', '0111111111', '060000000', '@gmail.com', 2),
('37 boulevard saint marcel', 75005, 'Paris', '0111111111', '060000000', '.@gmail.com', 3),
('34 boulevard saint marcel', 75005, 'Paris', '0111111111', '060000000', '.@gmail.com', 4),
('33 boulevard saint michel', 75005, 'Paris', '0111111111', '060000000', '.@gmail.com', 5),
('35 boulevard saint michel', 75005, 'Paris', '0111111111', '060000000', '.@gmail.com', 6),
('35 boulevard saint michel', 75005, 'Paris', '0111111111', '060000000', '.@gmail.com', 7),
('35 boulevard saint michel', 75005, 'Paris', '0111111111', '060000000', '.@gmail.com', 8);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `MATRICULE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) CHARACTER SET latin1 NOT NULL,
  `PRENOM` varchar(255) CHARACTER SET latin1 NOT NULL,
  `idClasse` int(11) NOT NULL,
  UNIQUE KEY `MATRICULE` (`MATRICULE`),
  KEY `INDEXETUDIANT` (`MATRICULE`,`idClasse`) USING BTREE,
  KEY `FK_Classe` (`idClasse`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`MATRICULE`, `NOM`, `PRENOM`, `idClasse`) VALUES
(1, 'Fouillard', 'Arnaud', 1),
(2, 'Nguyen', 'Nam', 2),
(3, 'Dupont', 'Claude', 3),
(4, 'Pierre', 'Jean', 4),
(5, 'Rouze', 'Desire', 4),
(6, 'Laprise', 'Nicolas', 1),
(7, 'Dumoulin', 'Nicolas', 1),
(8, 'Audet', 'Nicolas', 2);

-- --------------------------------------------------------

--
-- Structure de la table `identite`
--

DROP TABLE IF EXISTS `identite`;
CREATE TABLE IF NOT EXISTS `identite` (
  `DateNaissance` date NOT NULL,
  `VilleNaissance` varchar(255) CHARACTER SET latin1 NOT NULL,
  `PaysNaissance` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Sexe` varchar(255) CHARACTER SET latin1 NOT NULL,
  `DateInscription` date NOT NULL,
  `Etablissementpr` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Matricule` int(11) NOT NULL,
  UNIQUE KEY `IDENTITEINDEX` (`Matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `identite`
--

INSERT INTO `identite` (`DateNaissance`, `VilleNaissance`, `PaysNaissance`, `Sexe`, `DateInscription`, `Etablissementpr`, `Matricule`) VALUES
('2001-11-13', 'Chateaudun', 'France', 'Homme', '2013-09-14', '', 1),
('2001-11-14', 'Chartres', 'France', 'Homme', '2013-09-14', '', 2),
('2017-11-02', 'Paris', 'Frances', 'Homme', '2017-11-05', '', 3),
('2001-11-14', 'Melun', 'France', 'Homme', '2013-09-14', '', 4),
('2001-11-14', 'Villetaneuse', 'France', 'Femme', '2013-09-14', '', 5),
('2001-11-14', 'Neuilly', 'France', 'Homme', '2013-09-14', '', 6);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `idMatiere` int(11) NOT NULL,
  `nomMat` varchar(255) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`idMatiere`),
  UNIQUE KEY `INDEXMATIERE` (`idMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`idMatiere`, `nomMat`) VALUES
(1, 'Français'),
(2, 'Mathématiques'),
(3, 'Histoire'),
(4, 'EPS'),
(5, 'Anglais'),
(6, 'Espagnol');

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

DROP TABLE IF EXISTS `notes`;
CREATE TABLE IF NOT EXISTS `notes` (
  `moyenne` double NOT NULL,
  `Matricule` int(11) NOT NULL,
  `idMatiere` int(11) NOT NULL,
  UNIQUE KEY `NOTESINDEX` (`Matricule`,`idMatiere`),
  KEY `FK_MAT` (`idMatiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `notes`
--

INSERT INTO `notes` (`moyenne`, `Matricule`, `idMatiere`) VALUES
(18, 1, 2),
(17, 1, 3),
(17, 1, 4),
(17, 1, 5),
(10, 2, 1),
(16, 2, 2),
(16, 2, 4),
(16, 2, 5),
(17, 3, 1),
(16, 3, 2),
(16, 3, 4),
(16, 3, 5),
(17, 4, 1),
(17, 5, 1),
(15, 5, 2),
(16, 5, 3),
(14, 5, 4),
(11, 6, 2),
(11, 6, 3),
(11, 6, 4),
(11, 6, 5),
(11, 7, 2),
(11, 7, 3),
(11, 7, 4),
(11, 7, 5),
(16, 8, 1),
(16, 8, 2),
(16, 8, 4),
(16, 8, 5);

-- --------------------------------------------------------

--
-- Structure de la table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE IF NOT EXISTS `responsable` (
  `IdResponsable` int(11) NOT NULL AUTO_INCREMENT,
  `NomRes` varchar(255) CHARACTER SET latin1 NOT NULL,
  `PrenomRes` varchar(255) CHARACTER SET latin1 NOT NULL,
  `AdresseRes` varchar(255) CHARACTER SET latin1 NOT NULL,
  `TelephoneRes` varchar(11) NOT NULL,
  `EmailRes` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Matricule` int(11) NOT NULL,
  PRIMARY KEY (`IdResponsable`),
  UNIQUE KEY `INDEXRESPONSABLE` (`IdResponsable`,`Matricule`),
  KEY `FK_MATRICULE2` (`Matricule`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `responsable`
--

INSERT INTO `responsable` (`IdResponsable`, `NomRes`, `PrenomRes`, `AdresseRes`, `TelephoneRes`, `EmailRes`, `Matricule`) VALUES
(1, 'Fouillard', 'Guy', '3 rue du paradis', '680425283', 'fouillard.guy@hotmail.Fr', 1),
(2, 'Nguyen', 'Guy', '3 rue du paradis', '680425283', 'Nguyen.guy@hotmail.Fr', 2),
(3, 'Dupont', 'Guy', '3 rue du paradis', '680425283', 'Dupont.guy@hotmail.Fr', 3),
(4, 'Pierre', 'Guy', '3 rue du paradis', '680425283', 'Pierre.guy@hotmail.Fr', 4),
(5, 'Rouze', 'Guy', '3 rue du paradis', '680425283', 'Rouze.guy@hotmail.Fr', 5),
(6, 'Laprise', 'Mauricette', '3 rue du paradis', '680425283', 'Laprise.guy@hotmail.Fr', 6),
(7, 'Dumoulin', 'Guy', '3 rue du paradis', '680425283', 'Dumoulin.guy@hotmail.Fr', 7),
(8, 'Fouillard', 'jeanne', '3 rue du paradis 2', '680425283', 'fouillard.jeanne@hotmail.Fr', 1),
(9, 'Audet', 'Guy', '3 rue du paradis', '680425283', 'Audet.guy@hotmail.Fr', 8),
(10, 'Nguyen', 'Jeanette', '3 rue du paradis ', '0680425283', 'Nguyen.guy@hotmail.Fr', 2),
(11, 'Dupont', 'Jeanette', '3 rue du paradis', '0680425283', 'Dupont.guy@hotmail.Fr', 3),
(12, 'Pierre', 'Jeanne', '3 rue du paradis', '0680425283', 'Pierre.guy@hotmail.Fr', 4),
(13, 'Rouze', 'Lucette', '3 rue du paradis', '0680425283', 'Rouze.guy@hotmail.Fr', 5),
(14, 'Laprise', 'Guy', '3 rue du paradis', '0680425283', 'Laprise.guy@hotmail.Fr', 6),
(15, 'Dumoulin', 'Jeanne', '3 rue du paradis', '0680425283', 'Dumoulin.guy@hotmail.Fr', 7),
(16, 'Audet', 'Jeannette', '3 rue du paradis', '0680425283', 'Audet.guy@hotmail.Fr', 8);

-- --------------------------------------------------------

--
-- Structure de la table `sante`
--

DROP TABLE IF EXISTS `sante`;
CREATE TABLE IF NOT EXISTS `sante` (
  `MédecinTraitant` varchar(255) CHARACTER SET latin1 NOT NULL,
  `TelMedecin` varchar(11) NOT NULL,
  `Vaccinations` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Allergies` varchar(255) CHARACTER SET latin1 NOT NULL,
  `RemarquesMedicales` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `MATRICULE` int(11) NOT NULL,
  UNIQUE KEY `SANTEINDEX` (`MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `sante`
--

INSERT INTO `sante` (`MédecinTraitant`, `TelMedecin`, `Vaccinations`, `Allergies`, `RemarquesMedicales`, `MATRICULE`) VALUES
('Jean Claude', '0237464647', 'aucunes', 'aucunes', 'aucunes', 1),
('Jean Claude vendome', '0237464647', 'aucunes', 'aucunes', 'aucunes', 2),
('Jean Pierre Rouvre', '0237464647', 'aucunes', 'aucunes', 'aucunes', 3),
('Jean Claude Tonchan', '0237464647', 'aucunes', 'aucunes', 'aucunes', 4),
('Jean Claude Georges', '0237464647', 'aucunes', 'aucunes', 'aucunes', 5),
('Jean Claude Vendame', '0237464647', 'aucunes', 'aucunes', 'aucunes', 6),
('Jean Claude Troyes', '0237464647', 'aucunes', 'aucunes', 'aucunes', 7),
('Jean Claude Troyes', '0237464647', 'aucunes', 'aucunes', 'aucunes', 8);

-- --------------------------------------------------------

--
-- Structure de la table `userapplication`
--

DROP TABLE IF EXISTS `userapplication`;
CREATE TABLE IF NOT EXISTS `userapplication` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(25) CHARACTER SET latin1 NOT NULL,
  `PASSWORD` varchar(255) CHARACTER SET latin1 NOT NULL,
  `ADMIN` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `userapplication`
--

INSERT INTO `userapplication` (`id`, `LOGIN`, `PASSWORD`, `ADMIN`) VALUES
(1, 'root', 'root', 1),
(2, 'test', 'test', 1),
(3, 'TestConsult', 'test', 0),
(4, 'Admin', 'admin', 1),
(6, 'Jean', 'password', 0),
(7, 'Pierre', 'Password', 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FK_MAT1` FOREIGN KEY (`idMatiere1`) REFERENCES `matiere` (`idMatiere`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MAT2` FOREIGN KEY (`idMatiere2`) REFERENCES `matiere` (`idMatiere`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MAT3` FOREIGN KEY (`idMatiere3`) REFERENCES `matiere` (`idMatiere`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MAT4` FOREIGN KEY (`idMatiere4`) REFERENCES `matiere` (`idMatiere`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `coordonnees`
--
ALTER TABLE `coordonnees`
  ADD CONSTRAINT `FKMATRICULE` FOREIGN KEY (`Matricule`) REFERENCES `etudiant` (`MATRICULE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK_Classe` FOREIGN KEY (`idClasse`) REFERENCES `classe` (`idClasse`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `identite`
--
ALTER TABLE `identite`
  ADD CONSTRAINT `FK_MATRICULE` FOREIGN KEY (`Matricule`) REFERENCES `etudiant` (`MATRICULE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `FK_MAT` FOREIGN KEY (`idMatiere`) REFERENCES `matiere` (`idMatiere`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_MATRICULE1` FOREIGN KEY (`Matricule`) REFERENCES `etudiant` (`MATRICULE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `responsable`
--
ALTER TABLE `responsable`
  ADD CONSTRAINT `FK_MATRICULE2` FOREIGN KEY (`Matricule`) REFERENCES `etudiant` (`MATRICULE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `sante`
--
ALTER TABLE `sante`
  ADD CONSTRAINT `FK_MATRICULE3` FOREIGN KEY (`MATRICULE`) REFERENCES `etudiant` (`MATRICULE`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
