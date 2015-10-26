-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 22-10-2015 a las 16:28:06
-- Versión del servidor: 5.6.23
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `bd_prueba`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `alumno`
-- 

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAlumno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `alumno`
-- 

INSERT INTO `alumno` VALUES (1, 'Ana', 'Ayala Gomez', 'anaayala@upeu.edu.pe', 'Alameda 1era Etapa Mz. L lote 1');
INSERT INTO `alumno` VALUES (2, 'Ruben', 'Minaya Perez', 'rubenmp@gmail.com', 'Huascata Mz M Lote 10');
INSERT INTO `alumno` VALUES (3, 'dfdf', 'dfdf', 'dfdf', 'dfdf');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `curso`
-- 

CREATE TABLE `curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `nom_curso` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

-- 
-- Volcar la base de datos para la tabla `curso`
-- 

INSERT INTO `curso` VALUES (1, 'Base de Datos 1');
INSERT INTO `curso` VALUES (2, 'Calculo 1');
INSERT INTO `curso` VALUES (3, 'Lenguaje de Programación I');
INSERT INTO `curso` VALUES (4, 'Sistemas Operativos');
INSERT INTO `curso` VALUES (5, 'Redes Informaticas I');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `detalle_curso`
-- 

CREATE TABLE `detalle_curso` (
  `idDetalle_Curso` int(11) NOT NULL AUTO_INCREMENT,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Curso_idCurso` int(11) NOT NULL,
  `nota1` int(11) DEFAULT NULL,
  `nota2` int(11) DEFAULT NULL,
  `nota3` int(11) DEFAULT NULL,
  `promedio` double DEFAULT NULL,
  PRIMARY KEY (`idDetalle_Curso`),
  KEY `fk_Detalle_Curso_Alumno_idx` (`Alumno_idAlumno`),
  KEY `fk_Detalle_Curso_Curso1_idx` (`Curso_idCurso`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- 
-- Volcar la base de datos para la tabla `detalle_curso`
-- 

INSERT INTO `detalle_curso` VALUES (1, 1, 1, 13, 14, 15, 14);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuario`
-- 

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nom_user` varchar(45) DEFAULT NULL,
  `clave` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `usuario`
-- 

INSERT INTO `usuario` VALUES (1, 'dreyna', '123');
INSERT INTO `usuario` VALUES (2, 'jonas', '12345');
INSERT INTO `usuario` VALUES (3, 'emiliano', '1234567');

-- 
-- Filtros para las tablas descargadas (dump)
-- 

-- 
-- Filtros para la tabla `detalle_curso`
-- 
ALTER TABLE `detalle_curso`
  ADD CONSTRAINT `fk_Detalle_Curso_Alumno` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Detalle_Curso_Curso1` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION;
