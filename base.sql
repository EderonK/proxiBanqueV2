-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 25 juil. 2018 à 14:57
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `proxibanque`
--
CREATE DATABASE IF NOT EXISTS `proxibanque` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proxibanque`;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `idClient` int(20) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `Adresse` varchar(50) NOT NULL,
  `email` varchar(30) NOT NULL,
  `idConseiller` varchar(20) NOT NULL,
  PRIMARY KEY (`idClient`),
  KEY `idConseiller` (`idConseiller`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `client`
--

INSERT INTO `client` (`idClient`, `Nom`, `Prenom`, `Adresse`, `email`, `idConseiller`) VALUES
(1, 'Martin', 'Jean', '5 chemin de la Crabe, 31200 Toulouse', 'jean.martin@objis.com', 'c1'),
(2, 'Alonzo', 'Helena', '12 place de la gare, Seville', 'helena.alonzo@sogeti.es', 'c1');

-- --------------------------------------------------------

--
-- Structure de la table `comptecourant`
--

DROP TABLE IF EXISTS `comptecourant`;
CREATE TABLE IF NOT EXISTS `comptecourant` (
  `numCompte` varchar(30) NOT NULL,
  `solde` float NOT NULL,
  `dateOuverture` varchar(10) NOT NULL,
  `carteBancaire` varchar(20) NOT NULL,
  `decouvertMax` float NOT NULL,
  `idClient` int(20) NOT NULL,
  PRIMARY KEY (`numCompte`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `comptecourant`
--

INSERT INTO `comptecourant` (`numCompte`, `solde`, `dateOuverture`, `carteBancaire`, `decouvertMax`, `idClient`) VALUES
('123', 1000, '01/02/16', '1200021', 2000, 2),
('d66d4', 23, '16/10/15', 'f444fe', 100, 1);

-- --------------------------------------------------------

--
-- Structure de la table `compteepargne`
--

DROP TABLE IF EXISTS `compteepargne`;
CREATE TABLE IF NOT EXISTS `compteepargne` (
  `numCompte` varchar(30) NOT NULL,
  `solde` float NOT NULL,
  `dateOuverture` varchar(10) NOT NULL,
  `carteBancaire` varchar(20) NOT NULL,
  `tauxRemuneration` float NOT NULL,
  `idClient` int(20) NOT NULL,
  PRIMARY KEY (`numCompte`),
  KEY `idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `compteepargne`
--

INSERT INTO `compteepargne` (`numCompte`, `solde`, `dateOuverture`, `carteBancaire`, `tauxRemuneration`, `idClient`) VALUES
('455', 32566, '30/09/10', 'sxdd08', 5, 2),
('mlls56', 5000, '23/06/18', 'j200jh', 4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

DROP TABLE IF EXISTS `conseiller`;
CREATE TABLE IF NOT EXISTS `conseiller` (
  `identifiant` varchar(20) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `motDePasse` varchar(20) NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `conseiller`
--

INSERT INTO `conseiller` (`identifiant`, `Nom`, `Prenom`, `motDePasse`) VALUES
('c1', 'Smith', 'Dan', 'monmotdepasse'),
('c2', 'Howard', 'Bill', 'mypassword');

-- --------------------------------------------------------

--
-- Structure de la table `gerant`
--

DROP TABLE IF EXISTS `gerant`;
CREATE TABLE IF NOT EXISTS `gerant` (
  `identifiant` varchar(20) NOT NULL,
  `Nom` varchar(30) NOT NULL,
  `Prenom` varchar(30) NOT NULL,
  `motDePasse` varchar(20) NOT NULL,
  PRIMARY KEY (`identifiant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gerant`
--

INSERT INTO `gerant` (`identifiant`, `Nom`, `Prenom`, `motDePasse`) VALUES
('5', 'Michel', 'Herve', 'supermdp');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `client_ibfk_1` FOREIGN KEY (`idConseiller`) REFERENCES `conseiller` (`identifiant`);

--
-- Contraintes pour la table `comptecourant`
--
ALTER TABLE `comptecourant`
  ADD CONSTRAINT `comptecourant_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);

--
-- Contraintes pour la table `compteepargne`
--
ALTER TABLE `compteepargne`
  ADD CONSTRAINT `compteepargne_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
