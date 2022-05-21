CREATE DATABASE my_db;
USE  my_db;
CREATE TABLE `bank` (
  `idbank` int NOT NULL AUTO_INCREMENT,
  `pinNo` int DEFAULT NULL,
  `deposit` double DEFAULT NULL,
  `withdraw` double DEFAULT NULL,
  `balance` double DEFAULT NULL,
  PRIMARY KEY (`idbank`)
);

CREATE TABLE `login` (
  `pinNo` int NOT NULL,
  `cardNo` int DEFAULT NULL,
  `fullName` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `sinNumber` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pinNo`)
) 