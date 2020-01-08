-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mer 08 Janvier 2020 à 11:41
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `bdd_banque`
--
CREATE DATABASE IF NOT EXISTS `bdd_banque` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bdd_banque`;

-- --------------------------------------------------------

--
-- Structure de la table `carte`
--

CREATE TABLE IF NOT EXISTS `carte` (
  `id_carte` int(11) NOT NULL AUTO_INCREMENT,
  `libelle_carte` varchar(50) NOT NULL,
  `num_carte` int(11) NOT NULL,
  `annee_carte` int(11) NOT NULL,
  `mois_carte` int(11) NOT NULL,
  `verification_carte` int(11) NOT NULL,
  PRIMARY KEY (`id_carte`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `carte`
--

INSERT INTO `carte` (`id_carte`, `libelle_carte`, `num_carte`, `annee_carte`, `mois_carte`, `verification_carte`) VALUES
(1, 'VISA', 505, 2020, 1, 996);

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` int(11) NOT NULL AUTO_INCREMENT,
  `prenom_client` varchar(50) NOT NULL,
  `nom_client` varchar(50) NOT NULL,
  `email_client` varchar(50) NOT NULL,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`id_client`, `prenom_client`, `nom_client`, `email_client`) VALUES
(1, 'yassine', 'faiq', 'yassine@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE IF NOT EXISTS `compte` (
  `id_compte` int(11) NOT NULL AUTO_INCREMENT,
  `montant_compte` double NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_carte` int(11) NOT NULL,
  PRIMARY KEY (`id_compte`),
  KEY `fk_compte1` (`id_carte`),
  KEY `fk_compte2` (`id_client`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `compte`
--

INSERT INTO `compte` (`id_compte`, `montant_compte`, `id_client`, `id_carte`) VALUES
(1, 2780, 1, 1);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `fk_compte2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`),
  ADD CONSTRAINT `fk_compte1` FOREIGN KEY (`id_carte`) REFERENCES `carte` (`id_carte`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
