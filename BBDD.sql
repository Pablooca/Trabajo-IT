-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-05-2024 a las 20:29:40
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `trabajo_it`
--
CREATE DATABASE IF NOT EXISTS `trabajo_it` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `trabajo_it`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ascensos`
--

CREATE TABLE `ascensos` (
  `ID` int(11) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date DEFAULT NULL,
  `jefe_departamento` varchar(20) NOT NULL,
  `requisitos` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ascensos`
--

INSERT INTO `ascensos` (`ID`, `cargo`, `fecha_inicio`, `fecha_fin`, `jefe_departamento`, `requisitos`) VALUES
(1, 'Jefe de Proyecto', '2023-01-01', NULL, '12345678A', 'Experiencia previa en gestión de proyectos'),
(2, 'Jefe de RRHH', '2023-02-01', NULL, '87654321B', 'Conocimientos en legislación laboral');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `ID` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `gerente` varchar(20) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`ID`, `nombre`, `gerente`, `descripcion`) VALUES
(1, 'Desarrollo', '12345678A', 'Departamento encargado del desarrollo de software'),
(2, 'Recursos Humanos', '87654321B', 'Departamento encargado de la gestión del personal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `DNI` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `cargo` varchar(50) DEFAULT NULL,
  `departamento` int(11) DEFAULT NULL,
  `id_ascensos` int(11) DEFAULT NULL,
  `contrasena` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`DNI`, `nombre`, `apellidos`, `direccion`, `cargo`, `departamento`, `id_ascensos`, `contrasena`) VALUES
('12345678A', 'Juan', 'García Pérez', 'Calle Mayor 123', 'Desarrollador', 1, 1, 'contrasena123'),
('13579246C', 'Pedro', 'Ruiz Gómez', 'C/ Gran Vía 789', 'Gestor de Proyectos', 2, 2, 'clave789'),
('87654321B', 'María', 'López Martínez', 'Av. Libertad 456', 'Analista', 1, NULL, 'password456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion`
--

CREATE TABLE `evaluacion` (
  `ID` int(11) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  `anyo` int(11) NOT NULL,
  `companyerismo` int(11) NOT NULL,
  `eficiencia` int(11) NOT NULL,
  `iniciativa` int(11) NOT NULL,
  `liderazgo` int(11) NOT NULL,
  `nota_media` decimal(3,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `evaluacion`
--

INSERT INTO `evaluacion` (`ID`, `DNI`, `anyo`, `companyerismo`, `eficiencia`, `iniciativa`, `liderazgo`, `nota_media`) VALUES
(1, '12345678A', 2023, 4, 5, 4, 3, 4.00),
(2, '87654321B', 2023, 5, 4, 3, 5, 4.25),
(3, '13579246C', 2023, 3, 3, 4, 4, 3.50);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina`
--

CREATE TABLE `nomina` (
  `ID` int(11) NOT NULL,
  `salario` decimal(10,2) NOT NULL,
  `DNI` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `nomina`
--

INSERT INTO `nomina` (`ID`, `salario`, `DNI`) VALUES
(1, 2500.00, '12345678A'),
(2, 2800.00, '87654321B'),
(3, 2200.00, '13579246C');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacaciones`
--

CREATE TABLE `vacaciones` (
  `ID` int(11) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `motivo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `vacaciones`
--

INSERT INTO `vacaciones` (`ID`, `DNI`, `fecha_inicio`, `fecha_fin`, `motivo`) VALUES
(1, '12345678A', '2023-07-15', '2023-07-30', 'Vacaciones de verano'),
(2, '87654321B', '2023-08-01', '2023-08-15', 'Descanso anual'),
(3, '13579246C', '2023-09-10', '2023-09-20', 'Viaje familiar');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ascensos`
--
ALTER TABLE `ascensos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `jefe_departamento` (`jefe_departamento`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_departamento_gerente` (`gerente`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`DNI`),
  ADD KEY `FK_empleado_departamento` (`departamento`),
  ADD KEY `FK_empleado_ascenso` (`id_ascensos`);

--
-- Indices de la tabla `evaluacion`
--
ALTER TABLE `evaluacion`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `DNI` (`DNI`);

--
-- Indices de la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `DNI` (`DNI`);

--
-- Indices de la tabla `vacaciones`
--
ALTER TABLE `vacaciones`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `DNI` (`DNI`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ascensos`
--
ALTER TABLE `ascensos`
  ADD CONSTRAINT `ascensos_ibfk_1` FOREIGN KEY (`jefe_departamento`) REFERENCES `departamento` (`gerente`);

--
-- Filtros para la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD CONSTRAINT `FK_departamento_gerente` FOREIGN KEY (`gerente`) REFERENCES `empleado` (`DNI`);

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FK_empleado_ascenso` FOREIGN KEY (`id_ascensos`) REFERENCES `ascensos` (`ID`),
  ADD CONSTRAINT `FK_empleado_departamento` FOREIGN KEY (`departamento`) REFERENCES `departamento` (`ID`);

--
-- Filtros para la tabla `evaluacion`
--
ALTER TABLE `evaluacion`
  ADD CONSTRAINT `evaluacion_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `empleado` (`DNI`);

--
-- Filtros para la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD CONSTRAINT `nomina_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `empleado` (`DNI`);

--
-- Filtros para la tabla `vacaciones`
--
ALTER TABLE `vacaciones`
  ADD CONSTRAINT `vacaciones_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `empleado` (`DNI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
