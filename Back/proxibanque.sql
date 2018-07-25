-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 25 juil. 2018 à 13:16
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
-- Base de données :  `bdtemporaire`
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
  INDEX `idConseiller` (`idConseiller`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  INDEX `idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  INDEX `idClient` (`idClient`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
