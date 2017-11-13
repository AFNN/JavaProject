-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 13 nov. 2017 à 07:44
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
  UNIQUE KEY `FOREIGNKEYMATIERE` (`idMatiere1`,`idMatiere2`,`idMatiere3`,`idMatiere4`),
  KEY `IDCLASSEINDEX` (`idClasse`) USING BTREE,
  KEY `FK_MAT2` (`idMatiere2`),
  KEY `FK_MAT3` (`idMatiere3`),
  KEY `FK_MAT4` (`idMatiere4`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`idClasse`, `NomClasse`, `idMatiere1`, `idMatiere2`, `idMatiere3`, `idMatiere4`) VALUES
(1, 'testClasse', 1, 2, 3, 4);

-- --------------------------------------------------------

--
-- Structure de la table `coordonnees`
--

DROP TABLE IF EXISTS `coordonnees`;
CREATE TABLE IF NOT EXISTS `coordonnees` (
  `Adresse` varchar(255) CHARACTER SET latin1 NOT NULL,
  `CodePostal` int(11) NOT NULL,
  `Ville` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Teldom` int(11) NOT NULL,
  `Telmobile` int(11) NOT NULL,
  `Email` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Matricule` int(11) NOT NULL,
  PRIMARY KEY (`Matricule`),
  UNIQUE KEY `INDEXMATRICULE` (`Matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  UNIQUE KEY `INDEXETUDIANT` (`MATRICULE`,`idClasse`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`MATRICULE`, `NOM`, `PRENOM`, `idClasse`) VALUES
(2, 'Fouillard', 'Arnaud', 2),
(3, 'NGUYEN', 'Nam', 2);

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
(5, 'Anglais');

-- --------------------------------------------------------

--
-- Structure de la table `notes`
--

DROP TABLE IF EXISTS `notes`;
CREATE TABLE IF NOT EXISTS `notes` (
  `moyenne` double NOT NULL,
  `Matricule` int(11) NOT NULL,
  `idMatière` int(11) NOT NULL,
  UNIQUE KEY `NOTESINDEX` (`Matricule`,`idMatière`),
  KEY `FK_MAT` (`idMatière`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE IF NOT EXISTS `responsable` (
  `IdResponsable` int(11) NOT NULL,
  `Nom` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Prenom` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Adresse` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Telephone` int(11) NOT NULL,
  `Email` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Matricule` int(11) NOT NULL,
  PRIMARY KEY (`IdResponsable`),
  UNIQUE KEY `INDEXRESPONSABLE` (`IdResponsable`,`Matricule`),
  KEY `FK_MATRICULE2` (`Matricule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `sante`
--

DROP TABLE IF EXISTS `sante`;
CREATE TABLE IF NOT EXISTS `sante` (
  `MédecinTraitant` varchar(255) CHARACTER SET latin1 NOT NULL,
  `TelMedecin` int(11) NOT NULL,
  `Vaccinations` varchar(255) CHARACTER SET latin1 NOT NULL,
  `Allergies` varchar(255) CHARACTER SET latin1 NOT NULL,
  `RemarquesMedicales` varchar(255) CHARACTER SET latin1 DEFAULT NULL,
  `MATRICULE` int(11) NOT NULL,
  UNIQUE KEY `SANTEINDEX` (`MATRICULE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
-- Contraintes pour la table `identite`
--
ALTER TABLE `identite`
  ADD CONSTRAINT `FK_MATRICULE` FOREIGN KEY (`Matricule`) REFERENCES `etudiant` (`MATRICULE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `FK_MAT` FOREIGN KEY (`idMatière`) REFERENCES `matiere` (`idMatiere`) ON DELETE CASCADE ON UPDATE CASCADE,
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
