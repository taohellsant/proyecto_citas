-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Paciente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Paciente` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Paciente` (
  `PacIdentificacion` INT NOT NULL,
  `PacNombre` VARCHAR(45) NULL,
  `PacApellido` VARCHAR(45) NULL,
  `PacFecha_Nacimiento` DATETIME NULL,
  `PacSexo` VARCHAR(45) NULL,
  PRIMARY KEY (`PacIdentificacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Medico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Medico` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Medico` (
  `MedIdentificacion` INT NOT NULL,
  `MedNombre` VARCHAR(45) NULL,
  `MedApellido` VARCHAR(45) NULL,
  PRIMARY KEY (`MedIdentificacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Consultorio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Consultorio` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Consultorio` (
  `ConsCodigo` INT NOT NULL,
  `ConsNombre` VARCHAR(45) NULL,
  PRIMARY KEY (`ConsCodigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Citas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Citas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Citas` (
  `CitNumero` INT NOT NULL,
  `CitFecha` DATETIME NULL,
  `CitHora` VARCHAR(45) NULL,
  `CitObservaciones` VARCHAR(45) NULL,
  `CitEstado` VARCHAR(45) NULL,
  `Medico_MedIdentificacion` INT NOT NULL,
  `Consultorio_ConsCodigo` INT NOT NULL,
  `Paciente_PacIdentificacion` INT NOT NULL,
  PRIMARY KEY (`CitNumero`, `Medico_MedIdentificacion`, `Consultorio_ConsCodigo`, `Paciente_PacIdentificacion`),
  INDEX `fk_Citas_Medico_idx` (`Medico_MedIdentificacion` ASC) VISIBLE,
  INDEX `fk_Citas_Consultorio1_idx` (`Consultorio_ConsCodigo` ASC) VISIBLE,
  INDEX `fk_Citas_Paciente1_idx` (`Paciente_PacIdentificacion` ASC) VISIBLE,
  CONSTRAINT `fk_Citas_Medico`
    FOREIGN KEY (`Medico_MedIdentificacion`)
    REFERENCES `mydb`.`Medico` (`MedIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Consultorio1`
    FOREIGN KEY (`Consultorio_ConsCodigo`)
    REFERENCES `mydb`.`Consultorio` (`ConsCodigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Paciente1`
    FOREIGN KEY (`Paciente_PacIdentificacion`)
    REFERENCES `mydb`.`Paciente` (`PacIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tratamiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Tratamiento` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Tratamiento` (
  `TratCodigo` INT NOT NULL,
  `TratFecha_Asignacion` DATE NULL,
  `TratFecha_Inicio` DATE NULL,
  `TratFecha_Final` DATE NULL,
  `TratDescripcion` VARCHAR(45) NULL,
  `Paciente_PacIdentificacion` INT NOT NULL,
  PRIMARY KEY (`TratCodigo`, `Paciente_PacIdentificacion`),
  INDEX `fk_Tratamiento_Paciente1_idx` (`Paciente_PacIdentificacion` ASC) VISIBLE,
  CONSTRAINT `fk_Tratamiento_Paciente1`
    FOREIGN KEY (`Paciente_PacIdentificacion`)
    REFERENCES `mydb`.`Paciente` (`PacIdentificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
