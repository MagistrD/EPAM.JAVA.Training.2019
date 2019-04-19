-- table staff --
INSERT INTO `epam_hospital`.`t_staff` (`t_staff_first_name`, `t_staff_second_name`, `t_staff_surname`, `t_staff_specialization`) VALUES ('Ivan', 'Ivanov', 'Ivanovich', '3');
SELECT * FROM epam_hospital.t_staff;
UPDATE `epam_hospital`.`t_staff` SET `t_staff_second_name` = '2' WHERE (`idt_staff` = '2');
DELETE FROM `epam_hospital`.`t_staff` WHERE (`idt_staff` = '2');

-- table pacient --
INSERT INTO `epam_hospital`.`t_patients` (`t_patients_first_name`, `t_patients_second_name`, `t_patients_surname`) VALUES ('Petr', 'Petrov', 'Petrovich');
SELECT * FROM epam_hospital.t_patients;
UPDATE `epam_hospital`.`t_patients` SET `t_patients_first_name` = 'Petr' WHERE (`idt_patients` = '1');
DELETE FROM `epam_hospital`.`t_patients` WHERE (`idt_patients` = '3');

-- table medicine story --
INSERT INTO `epam_hospital`.`t_medical_history` (`t_medical_history_patient`, `t_medical_history_diagnosed`, `t_medical_history_executor`, `t_medical_history_date_of_receipt`, `t_medical_history_discharge_date`, `t_medical_history_diagnosis`, `t_medical_history_comment`, `t_medical_history_destination`) VALUES ('1', '1', '1', '2019-04-10', '2019-04-15', 'Headache', 'The patient is more alive than dead', '1');
SELECT * FROM epam_hospital.t_medical_history;
UPDATE `epam_hospital`.`t_medical_history` SET `t_medical_history_date_of_receipt` = '2019-04-09' WHERE (`idt_medical_history` = '1');
DELETE FROM `epam_hospital`.`t_medical_history` WHERE (`idt_medical_history` = '1');
