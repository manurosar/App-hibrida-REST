-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-03-2017 a las 23:24:26
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestion_pedido`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `apellido` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `telefono` int(11) DEFAULT NULL,
  `email` varchar(35) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `apellido`, `telefono`, `email`) VALUES
(1, 'PEPE', 'PEREZ LOPEZ', 953336660, 'NOTIENE@NOTIENE.COM'),
(2, 'MIGUEL', 'GARCIA LOPEZ', 655342345, 'NINGUNI@NINGUNO.ES'),
(3, 'MIGUEL', 'GARCIA LOPEZ', 655342345, 'NINGUNI@NINGUNO.ES'),
(4, 'ANA', 'FLORES HUERTAS', 696969690, 'NOTIENE@NOTIENE'),
(5, 'FELIPE', 'GUERRERO ALFEREZ', 953333356, 'NINGUNO@NINGUNO.COM'),
(7, 'pedro', 'Ramirez Bellido', 678666889, 'pedro@notiene.es'),
(9, 'fhksjfhkaf', 'fsdfhghjsaf', 34523662, 'fsahfj@jsdfafsuks');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desglose`
--

CREATE TABLE `desglose` (
  `pedido` int(11) NOT NULL,
  `producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `desglose`
--

INSERT INTO `desglose` (`pedido`, `producto`, `cantidad`, `precio`) VALUES
(1, 3, 5, 210),
(1, 5, 10, 60.25),
(2, 4, 6, 75),
(2, 5, 1, 60),
(3, 8, 3, 140);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `numpedido` int(11) NOT NULL,
  `cliente` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`numpedido`, `cliente`, `fecha`) VALUES
(1, 1, '2017-02-19'),
(2, 1, '2017-01-10'),
(3, 3, '2017-02-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `categoria` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `categoria`) VALUES
(3, 'TECLADO LOGITEC BLUETOOH', 'PERIFERICOS'),
(4, 'MONITOR DELL 21P', 'PANTALLA'),
(5, 'TECLADO LOGITEC BLUETOOH', 'PERIFERICOS'),
(6, 'PLACA BASE ASUS B150', 'PLACAS'),
(7, 'PLACA INTEL P345', 'PLACAS'),
(8, 'TAR GRAF NVIDIA G-FORCE', 'TARJETAS'),
(13, 'pppppppppp', 'aaaaaaaaaaaa'),
(14, 'fhgajshk', 'eeeer');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `desglose`
--
ALTER TABLE `desglose`
  ADD PRIMARY KEY (`pedido`,`producto`),
  ADD KEY `desglose_ibfk2` (`producto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`numpedido`),
  ADD KEY `cliente` (`cliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `numpedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `desglose`
--
ALTER TABLE `desglose`
  ADD CONSTRAINT `desglose_ibfk1` FOREIGN KEY (`pedido`) REFERENCES `pedido` (`numpedido`),
  ADD CONSTRAINT `desglose_ibfk2` FOREIGN KEY (`producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
