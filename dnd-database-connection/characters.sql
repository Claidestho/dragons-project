-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 26 sep. 2022 à 13:21
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `characters`
--
CREATE DATABASE IF NOT EXISTS `characters` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `characters`;

-- --------------------------------------------------------

--
-- Structure de la table `hero`
--

CREATE TABLE `hero` (
                        `id` int(11) NOT NULL,
                        `name` varchar(255) NOT NULL,
                        `hp` int(11) NOT NULL,
                        `type` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hero`
--

INSERT INTO `hero` (`id`, `name`, `hp`, `type`) VALUES
                                                    (1, 'string', 5, 'string'),
                                                    (2, 'string', 5, 'string');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `hero`
--
ALTER TABLE `hero`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `hero`
--
ALTER TABLE `hero`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
