-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 10-05-2015 a las 09:21:04
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `catalogotienda`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `tbl_compras`
-- 

CREATE TABLE `tbl_compras` (
  `id_product` int(3) NOT NULL,
  `id_cliente` int(3) NOT NULL,
  `id_compra` int(3) NOT NULL auto_increment,
  PRIMARY KEY  (`id_compra`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `tbl_compras`
-- 

