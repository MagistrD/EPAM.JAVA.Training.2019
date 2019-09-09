-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema epam_hospital
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema epam_hospital
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `epam_hospital` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
USE `epam_hospital` ;

-- -----------------------------------------------------
-- Table `epam_hospital`.`t_specialization`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_specialization` (
  `idt_specialization` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_specialization_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `t_specialization_type` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  PRIMARY KEY (`idt_specialization`),
  UNIQUE INDEX `idt_specialization_UNIQUE` (`idt_specialization` ASC),
  UNIQUE INDEX `t_specialization_name_UNIQUE` (`t_specialization_name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 50
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `epam_hospital`.`t_staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_staff` (
  `idt_staff` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_staff_first_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `t_staff_second_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `t_staff_surname` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `t_staff_specialization` INT(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`idt_staff`),
  UNIQUE INDEX `idt_staff_UNIQUE` (`idt_staff` ASC),
  INDEX `t_staff_spec_idx` (`t_staff_specialization` ASC),
  CONSTRAINT `t_staff_spec`
    FOREIGN KEY (`t_staff_specialization`)
    REFERENCES `epam_hospital`.`t_specialization` (`idt_specialization`))
ENGINE = InnoDB
AUTO_INCREMENT = 47
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `epam_hospital`.`t_appointments_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_appointments_type` (
  `idt_appointments_type` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_appointments_type_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  PRIMARY KEY (`idt_appointments_type`),
  UNIQUE INDEX `idt_appontments_type_UNIQUE` (`idt_appointments_type` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `epam_hospital`.`t_appointments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_appointments` (
  `idt_appointments` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_appointments_description` VARCHAR(45) NOT NULL,
  `t_appointments_appointment_date` DATE NOT NULL,
  `t_appointments_date_of_execution` DATE NULL DEFAULT NULL,
  `t_appointments_type` INT(11) UNSIGNED NOT NULL,
  `t_appointments_staff` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`idt_appointments`),
  UNIQUE INDEX `idt_appontments_UNIQUE` (`idt_appointments` ASC),
  INDEX `type_of_appontment_idx` (`t_appointments_type` ASC),
  INDEX `t_appontments_staff_idx` (`t_appointments_staff` ASC),
  CONSTRAINT `t_appontments_staff`
    FOREIGN KEY (`t_appointments_staff`)
    REFERENCES `epam_hospital`.`t_staff` (`idt_staff`),
  CONSTRAINT `t_appontments_type`
    FOREIGN KEY (`t_appointments_type`)
    REFERENCES `epam_hospital`.`t_appointments_type` (`idt_appointments_type`))
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `epam_hospital`.`t_patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_patients` (
  `idt_patients` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_patients_first_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `t_patients_second_name` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  `t_patients_surname` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NOT NULL,
  PRIMARY KEY (`idt_patients`),
  UNIQUE INDEX `idt_patients_UNIQUE` (`idt_patients` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `epam_hospital`.`t_medical_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_medical_history` (
  `idt_medical_history` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_medical_history_patient` INT(11) UNSIGNED NOT NULL,
  `t_medical_history_diagnosed` INT(11) UNSIGNED NOT NULL,
  `t_medical_history_date_of_receipt` DATE NOT NULL,
  `t_medical_history_discharge_date` DATE NULL DEFAULT NULL,
  `t_medical_history_diagnosis` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `t_medical_history_comment` VARCHAR(45) CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_0900_ai_ci' NULL DEFAULT NULL,
  `t_medical_history_appointment` INT(11) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`idt_medical_history`),
  UNIQUE INDEX `idt_medical_history_UNIQUE` (`idt_medical_history` ASC),
  INDEX `t_medical_history_diagnosis_idx` (`t_medical_history_diagnosed` ASC),
  INDEX `t_medical_history_pat_idx` (`t_medical_history_patient` ASC),
  INDEX `t_medical_history_dest_idx` (`t_medical_history_appointment` ASC),
  CONSTRAINT `t_medical_history_dest`
    FOREIGN KEY (`t_medical_history_appointment`)
    REFERENCES `epam_hospital`.`t_appointments` (`idt_appointments`),
  CONSTRAINT `t_medical_history_diag`
    FOREIGN KEY (`t_medical_history_diagnosed`)
    REFERENCES `epam_hospital`.`t_staff` (`idt_staff`),
  CONSTRAINT `t_medical_history_pat`
    FOREIGN KEY (`t_medical_history_patient`)
    REFERENCES `epam_hospital`.`t_patients` (`idt_patients`))
ENGINE = InnoDB
AUTO_INCREMENT = 36
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `epam_hospital`.`t_patient_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_patient_users` (
  `idt_patient_users` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_patient_users_username` VARCHAR(45) NOT NULL,
  `t_patient_users_password` VARCHAR(45) NOT NULL,
  `t_patient_users_patient_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`idt_patient_users`),
  UNIQUE INDEX `idt_patient_users_UNIQUE` (`idt_patient_users` ASC),
  UNIQUE INDEX `t_patient_users_username_UNIQUE` (`t_patient_users_username` ASC),
  UNIQUE INDEX `t_patient_users_patient_id_UNIQUE` (`t_patient_users_patient_id` ASC),
  CONSTRAINT `t_patient_users_patient_id`
    FOREIGN KEY (`idt_patient_users`)
    REFERENCES `epam_hospital`.`t_patients` (`idt_patients`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `epam_hospital`.`t_staff_users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epam_hospital`.`t_staff_users` (
  `idt_staff_users` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `t_staff_users_username` VARCHAR(45) NOT NULL,
  `t_staff_users_password` VARCHAR(45) NOT NULL,
  `t_staff_users_staff_id` INT(10) UNSIGNED NOT NULL,
  UNIQUE INDEX `idt_staff_users_UNIQUE` (`idt_staff_users` ASC),
  UNIQUE INDEX `t_staff_users_staff_id_UNIQUE` (`t_staff_users_staff_id` ASC),
  UNIQUE INDEX `t_staff_userscol_UNIQUE` (`t_staff_users_username` ASC),
  CONSTRAINT `t_staff_users_staff_id`
    FOREIGN KEY (`t_staff_users_staff_id`)
    REFERENCES `epam_hospital`.`t_staff` (`idt_staff`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
