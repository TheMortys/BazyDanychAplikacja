-- MySQL Script generated by MySQL Workbench
-- Sat Jan 19 17:33:58 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bankaccountdatabase
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bankaccountdatabase
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bankaccountdatabase` DEFAULT CHARACTER SET utf8 ;
USE `bankaccountdatabase` ;

-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`adres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`adres` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Ulica` VARCHAR(255) NULL DEFAULT NULL,
  `Numer_domu` INT(10) NOT NULL,
  `Numer_lokalu` INT(10) NULL DEFAULT NULL,
  `Kod_pocztowy` CHAR(5) NOT NULL,
  `Miejscowość` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`bank`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`bank` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Nazwa` VARCHAR(255) NOT NULL,
  `Telefon` VARCHAR(12) NOT NULL,
  `E-mail` VARCHAR(255) NOT NULL,
  `AdresID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `idBank_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `Nazwa_UNIQUE` (`Nazwa` ASC) VISIBLE,
  INDEX `fk_Bank_Adres1_idx` (`AdresID` ASC) VISIBLE,
  CONSTRAINT `fk_Bank_Adres1`
    FOREIGN KEY (`AdresID`)
    REFERENCES `bankaccountdatabase`.`adres` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`klient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`klient` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Imię` VARCHAR(255) NOT NULL,
  `Nazwisko` VARCHAR(255) NOT NULL,
  `Login` VARCHAR(40) NOT NULL,
  `Hasło` VARCHAR(255) NOT NULL,
  `PESEL` CHAR(11) NOT NULL,
  `NIP` CHAR(10) NULL DEFAULT NULL,
  `Telefon` INT(12) NOT NULL,
  `E-mail` VARCHAR(255) NOT NULL,
  `Data_urodzenia` DATE NOT NULL,
  `AdresID` INT(11) NOT NULL,
  `BankID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `PESEL_UNIQUE` (`PESEL` ASC) VISIBLE,
  UNIQUE INDEX `Telefon_UNIQUE` (`Telefon` ASC) VISIBLE,
  UNIQUE INDEX `E-mail_UNIQUE` (`E-mail` ASC) VISIBLE,
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC) VISIBLE,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `NIP_UNIQUE` (`NIP` ASC) VISIBLE,
  INDEX `fk_Klient_Adres1_idx` (`AdresID` ASC) VISIBLE,
  INDEX `fk_Klient_Bank1_idx` (`BankID` ASC) VISIBLE,
  CONSTRAINT `fk_Klient_Adres1`
    FOREIGN KEY (`AdresID`)
    REFERENCES `bankaccountdatabase`.`adres` (`ID`),
  CONSTRAINT `fk_Klient_Bank1`
    FOREIGN KEY (`BankID`)
    REFERENCES `bankaccountdatabase`.`bank` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`pracownik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`pracownik` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Imię` VARCHAR(255) NOT NULL,
  `Nazwisko` VARCHAR(255) NOT NULL,
  `Login` VARCHAR(40) NOT NULL,
  `Hasło` VARCHAR(255) NOT NULL,
  `E-mail` VARCHAR(255) NULL DEFAULT NULL,
  `Telefon` VARCHAR(255) NULL DEFAULT NULL,
  `Stanowisko` VARCHAR(255) NOT NULL,
  `BankID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC) VISIBLE,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  UNIQUE INDEX `E-mail_UNIQUE` (`E-mail` ASC) VISIBLE,
  UNIQUE INDEX `Telefon_UNIQUE` (`Telefon` ASC) VISIBLE,
  INDEX `fk_pracownik_bank_bankID_idx` (`BankID` ASC) VISIBLE,
  CONSTRAINT `fk_pracownik_bank_bankID`
    FOREIGN KEY (`BankID`)
    REFERENCES `bankaccountdatabase`.`bank` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`konto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`konto` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Numer` CHAR(26) NOT NULL,
  `Saldo` FLOAT NOT NULL DEFAULT '0',
  `Data_utworzenia` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `KlientID` INT(11) NOT NULL,
  `PracownikID` INT(11) NOT NULL,
  `BankID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Numer_UNIQUE` (`Numer` ASC) VISIBLE,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_Konto_Klient1_idx` (`KlientID` ASC) VISIBLE,
  INDEX `fk_Konto_Pracownik1_idx` (`PracownikID` ASC) VISIBLE,
  INDEX `fk_Konto_Bank1_idx` (`BankID` ASC) VISIBLE,
  CONSTRAINT `fk_Konto_Bank1`
    FOREIGN KEY (`BankID`)
    REFERENCES `bankaccountdatabase`.`bank` (`ID`),
  CONSTRAINT `fk_Konto_Klient1`
    FOREIGN KEY (`KlientID`)
    REFERENCES `bankaccountdatabase`.`klient` (`ID`),
  CONSTRAINT `fk_Konto_Pracownik1`
    FOREIGN KEY (`PracownikID`)
    REFERENCES `bankaccountdatabase`.`pracownik` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`konto_oszczędnościowe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`konto_oszczędnościowe` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Oprocentowanie` FLOAT NOT NULL,
  `Kwota` FLOAT NOT NULL,
  `Data_utworzenia` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `KontoID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_Konto oszczędnościowe_Konto1_idx` (`KontoID` ASC) VISIBLE,
  CONSTRAINT `fk_Konto oszczędnościowe_Konto1`
    FOREIGN KEY (`KontoID`)
    REFERENCES `bankaccountdatabase`.`konto` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`log_transakcji`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`log_transakcji` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Typ` VARCHAR(45) NOT NULL,
  `Data` DATE NULL DEFAULT NULL,
  `Numer_konta_docelowego` VARCHAR(45) NULL DEFAULT NULL,
  `Numer_konta_źródłowego` VARCHAR(45) NULL DEFAULT NULL,
  `Kwota` FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`pożyczka`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`pożyczka` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Kwota` FLOAT NOT NULL,
  `Oprocentowanie` FLOAT NOT NULL,
  `Termin_spłaty` DATE NOT NULL,
  `Data_utworzenia` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `KontoID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_Pożyczka_Konto1_idx` (`KontoID` ASC) VISIBLE,
  CONSTRAINT `fk_Pożyczka_Konto1`
    FOREIGN KEY (`KontoID`)
    REFERENCES `bankaccountdatabase`.`konto` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bankaccountdatabase`.`transakcja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`transakcja` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Data` DATE NOT NULL,
  `Kwota` FLOAT NOT NULL,
  `Docelowy_nr_konta` CHAR(26) NULL DEFAULT NULL,
  `Tytuł` VARCHAR(255) NULL DEFAULT NULL,
  `Kategoria` VARCHAR(50) NULL DEFAULT NULL,
  `KontoID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_Transakcja_Konto1_idx` (`KontoID` ASC) VISIBLE,
  CONSTRAINT `fk_Transakcja_Konto1`
    FOREIGN KEY (`KontoID`)
    REFERENCES `bankaccountdatabase`.`konto` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8;

USE `bankaccountdatabase` ;

-- -----------------------------------------------------
-- Placeholder table for view `bankaccountdatabase`.`widok_tramsakcji`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bankaccountdatabase`.`widok_tramsakcji` (`Imię` INT, `Nazwisko` INT, `Numer` INT, `Docelowy_nr_konta` INT, `Data` INT, `Kwota` INT, `Kategoria` INT);

-- -----------------------------------------------------
-- procedure nowaLokata
-- -----------------------------------------------------

DELIMITER $$
USE `bankaccountdatabase`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `nowaLokata`(IN kwota INT, IN kontoId INT)
UPDATE Konto SET Saldo = Saldo - kwota WHERE id = kontoId$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure nowaPozyczka
-- -----------------------------------------------------

DELIMITER $$
USE `bankaccountdatabase`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `nowaPozyczka`(IN kwota INT, IN kontoId INT)
UPDATE Konto SET Saldo = Saldo + kwota WHERE id = kontoId$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure przelew
-- -----------------------------------------------------

DELIMITER $$
USE `bankaccountdatabase`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `przelew`(IN kwota float, IN kontoIdSource INT, IN kontoIdTarget INT)
BEGIN
	UPDATE Konto SET Saldo = Saldo + kwota WHERE id = kontoIdTarget;
	UPDATE Konto SET Saldo = Saldo - kwota WHERE id = kontoIdSource;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure przeliczLokaty
-- -----------------------------------------------------

DELIMITER $$
USE `bankaccountdatabase`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `przeliczLokaty`()
UPDATE Konto_oszczędnościowe k SET Kwota = Kwota + (Oprocentowanie/100 * Kwota) WHERE timestampdiff(YEAR, k.Data_utworzenia, NOW()) > 0 AND MONTH(k.Data_utworzenia) = MONTH(NOW()) AND DAY(k.Data_utworzenia) = DAY(NOW())$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure wplata
-- -----------------------------------------------------

DELIMITER $$
USE `bankaccountdatabase`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `wplata`(IN kwota INT, IN kontoId INT)
UPDATE Konto SET Saldo = Saldo + kwota WHERE id = kontoId$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure wyplata
-- -----------------------------------------------------

DELIMITER $$
USE `bankaccountdatabase`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `wyplata`(IN kwota INT, IN kontoId INT)
UPDATE Konto SET Saldo = Saldo - kwota WHERE id = kontoId$$

DELIMITER ;

-- -----------------------------------------------------
-- View `bankaccountdatabase`.`widok_tramsakcji`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bankaccountdatabase`.`widok_tramsakcji`;
USE `bankaccountdatabase`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `bankaccountdatabase`.`widok_tramsakcji` AS select `kl`.`Imię` AS `Imię`,`kl`.`Nazwisko` AS `Nazwisko`,`ko`.`Numer` AS `Numer`,`t`.`Docelowy_nr_konta` AS `Docelowy_nr_konta`,`t`.`Data` AS `Data`,`t`.`Kwota` AS `Kwota`,`t`.`Kategoria` AS `Kategoria` from ((`bankaccountdatabase`.`transakcja` `t` join `bankaccountdatabase`.`konto` `ko` on((`ko`.`ID` = `t`.`KontoID`))) join `bankaccountdatabase`.`klient` `kl` on((`kl`.`ID` = `ko`.`KlientID`)));
USE `bankaccountdatabase`;

DELIMITER $$
USE `bankaccountdatabase`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bankaccountdatabase`.`Transakcja_AFTER_INSERT`
AFTER INSERT ON `bankaccountdatabase`.`transakcja`
FOR EACH ROW
BEGIN
	IF NEW.Kategoria = 'Spłata_kredytu' THEN
        UPDATE Pożyczka SET Kwota = Kwota - NEW.Kwota WHERE KontoID = NEW.KontoID;
        UPDATE Konto SET Saldo = Saldo - NEW.Kwota WHERE ID = NEW.KontoID;
    END IF;
END$$

USE `bankaccountdatabase`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `bankaccountdatabase`.`Transakcja_BEFORE_INSERT`
BEFORE INSERT ON `bankaccountdatabase`.`transakcja`
FOR EACH ROW
BEGIN
	IF NEW.Kategoria = 'Przelew' THEN
		INSERT INTO Log_transakcji (Typ, Data, Numer_konta_docelowego, Numer_konta_źródłowego, Kwota) VALUES (NEW.Kategoria, NEW.Data, NEW.Docelowy_nr_konta, (SELECT Numer FROM Konto WHERE ID = NEW.KontoID), NEW.Kwota);
    ELSEIF NEW.Kategoria = 'Wpłata' THEN
		INSERT INTO Log_transakcji (Typ, Data, Numer_konta_docelowego, Kwota) VALUES (NEW.Kategoria, NEW.Data, (SELECT Numer FROM Konto WHERE ID = NEW.KontoID), NEW.Kwota);
    ELSEIF NEW.Kategoria = 'Wypłata' THEN
		INSERT INTO Log_transakcji (Typ, Data, Numer_konta_źródłowego, Kwota) VALUES (NEW.Kategoria, NEW.Data, (SELECT Numer FROM Konto WHERE ID = NEW.KontoID), NEW.Kwota);
    ELSEIF NEW.Kategoria = 'Spłata_kredytu' THEN
		INSERT INTO Log_transakcji (Typ, Data, Numer_konta_docelowego, Kwota) VALUES (NEW.Kategoria, NEW.Data, (SELECT Numer FROM Konto WHERE ID = NEW.KontoID), NEW.Kwota);
    END IF;
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
