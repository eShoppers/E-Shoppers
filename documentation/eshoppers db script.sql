-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema eshoppersdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema eshoppersdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eshoppersdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `eshoppersdb` ;

-- -----------------------------------------------------
-- Table `eshoppersdb`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`admin` (
  `id` BIGINT(20) NOT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`cart` (
  `id` BIGINT(20) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `total_price` DOUBLE NOT NULL,
  `customer_cid` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK3f39bckrly1y7mqe13ijsy3m4` (`customer_cid` ASC),
  INDEX `FK3d704slv66tw6x5hmbm6p2x3u` (`product_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`catalog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`catalog` (
  `id` BIGINT(20) NOT NULL,
  `catalog_description` VARCHAR(255) NULL DEFAULT NULL,
  `catalog_name` VARCHAR(255) NULL DEFAULT NULL,
  `catalog_pic` LONGBLOB NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`customer` (
  `cid` BIGINT(20) NOT NULL,
  `card_expiration_date` DATE NOT NULL,
  `card_number` BIGINT(20) NOT NULL,
  `ccv` INT(11) NOT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `state` VARCHAR(255) NULL DEFAULT NULL,
  `street` VARCHAR(255) NOT NULL,
  `zipcode` INT(11) NOT NULL,
  PRIMARY KEY (`cid`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`customers` (
  `cid` BIGINT(20) NOT NULL,
  `card_expiration_date` DATE NULL DEFAULT NULL,
  `card_number` BIGINT(20) NOT NULL,
  `ccv` INT(11) NOT NULL,
  `city` VARCHAR(255) NULL DEFAULT NULL,
  `country` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `state` VARCHAR(255) NULL DEFAULT NULL,
  `street` VARCHAR(255) NOT NULL,
  `zipcode` INT(11) NOT NULL,
  PRIMARY KEY (`cid`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`orders` (
  `id` BIGINT(20) NOT NULL,
  `order_date` DATE NOT NULL,
  `order_id` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NOT NULL,
  `quantity` INT(11) NOT NULL,
  `customer_cid` BIGINT(20) NULL DEFAULT NULL,
  `product_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK7gxiyl0kgtj6svthkrd1dv57e` (`customer_cid` ASC),
  INDEX `FK787ibr3guwp6xobrpbofnv7le` (`product_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`product` (
  `id` BIGINT(20) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `product_name` VARCHAR(255) NULL DEFAULT NULL,
  `product_pic` LONGBLOB NULL DEFAULT NULL,
  `quantity` BIGINT(20) NOT NULL,
  `unit_price` DOUBLE NOT NULL,
  `catalog_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK8oaejqr5kmuivpskpr3fxcg1m` (`catalog_id` ASC))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`seq`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`seq` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`state`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`state` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `code` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `eshoppersdb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `eshoppersdb`.`user` (
  `id` BIGINT(20) NOT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
