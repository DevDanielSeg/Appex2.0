CREATE DATABASE `dbappex2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `dbappex2`.`ciiu` (
  `cod_ciiu` int NOT NULL COMMENT 'Código de la actividad económica de la empresa (CIIU).\nLongitud máxima 6 dígitos (Primary Key).\nEste campo es Foreign Key en la tabla ''empresas''.',
  `des_ciiu` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Descripción del código CIIU.',
  PRIMARY KEY (`cod_ciiu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dbappex2`.`empresa` (
  `id_empresa` int NOT NULL AUTO_INCREMENT COMMENT 'Identificador único que se asigna a las empresas una vez realizan el registro en la aplicación AppEx.\nEs un identificador de tipo autoincremento (Primary Key).',
  `nombre_empresa` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Nombre con el que está registrada legalmente la empresa.',
  `nit_empresa` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Número de identificación tributaria de la empresa (NIT).\\nUn NIT solo puede registrarse una única vez.',
  `nombre_representante` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Nombre del representante legal de la empresa. \\nSolo es permitido registrar un representante por empresa.',
  `documento_representante` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Documento de identidad del representante legal de la empresa.',
  `tipo_empresa` tinyint NOT NULL COMMENT 'Tipo de empresa.1= Natural,  0=Jurídica.',
  `cod_ciiu` int NOT NULL COMMENT 'Código de la actividad económica de la empresa (CIIU).\nLongitud máxima 6 dígitos.\nEste campo solo admite los códigos que se encuentren registrados en la tabla ''ciiu''.(Foreign Key).\n',
  `estado_empresa` tinyint NOT NULL COMMENT 'Estado en el que se encuentra la empresa.\n1=Activo, 0= Inactivo.\nCuando una empresa se crea, su estado es Activo.\nCuando una empresa se elimina, su estado es Inactivo.',
  `departamento` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Departamento de Colombia donde se encuentra ubicada la empresa.',
  `ciudad` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'Ciudad de Colombia donde se encuentra ubicada la empresa.',
  PRIMARY KEY (`id_empresa`),
  UNIQUE KEY `nit_empresa_UNIQUE` (`nit_empresa`),
  KEY `fk_cod_ciiu_idx` (`cod_ciiu`),
  CONSTRAINT `fk_cod_ciiu` FOREIGN KEY (`cod_ciiu`) REFERENCES `dbappex2`.`ciiu` (`cod_ciiu`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `dbappex2`.`ciiu`
(`cod_ciiu`,
`des_ciiu`)
VALUES
(2393,'Fabricación de otros productos de cerámica y porcelana');
