CREATE SCHEMA IF NOT EXISTS `phaseMaps`;
USE `phaseMaps` ;

CREATE TABLE IF NOT EXISTS `phaseMaps`.`User` (
  `userName` VARCHAR(50) NOT NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`userName`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `phaseMaps`.`Location` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `locationName` VARCHAR(50) NULL,
  `locationLongitude` DOUBLE NULL,
  `locationLatitude` DOUBLE NULL,
  `address` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `phaseMaps`.`Reveiw` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(200) NULL,
  `rating` INT NULL,
  `Location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Reveiw_Location1_idx` (`Location_id` ASC),
  CONSTRAINT `fk_Reveiw_Location1`
    FOREIGN KEY (`Location_id`)
    REFERENCES `phaseMaps`.`Location` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `phaseMaps`.`FavouritePlace` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `User_userName` VARCHAR(50) NOT NULL,
  `Location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_FavouritePlace_User1_idx` (`User_userName` ASC),
  INDEX `fk_FavouritePlace_Location1_idx` (`Location_id` ASC),
  CONSTRAINT `fk_FavouritePlace_User1`
    FOREIGN KEY (`User_userName`)
    REFERENCES `phaseMaps`.`User` (`userName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_FavouritePlace_Location1`
    FOREIGN KEY (`Location_id`)
    REFERENCES `phaseMaps`.`Location` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `phaseMaps`.`TravelLog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `dateTime` DATETIME NULL,
  `User_userName` VARCHAR(50) NOT NULL,
  `Location_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_TravelLog_User_idx` (`User_userName` ASC),
  INDEX `fk_TravelLog_Location1_idx` (`Location_id` ASC),
  CONSTRAINT `fk_TravelLog_User`
    FOREIGN KEY (`User_userName`)
    REFERENCES `phaseMaps`.`User` (`userName`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_TravelLog_Location1`
    FOREIGN KEY (`Location_id`)
    REFERENCES `phaseMaps`.`Location` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;
