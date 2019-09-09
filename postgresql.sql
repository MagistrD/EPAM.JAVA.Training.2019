-- File name: C:\Users\magistr\Desktop\postgresql.sql
-- Created by DBConvert http://www.dbconvert.com


--
-- Table structure for table `t_appointments_type`
--

CREATE TABLE "t_appointments_type" (  "idt_appointments_type" BIGSERIAL NOT NULL ,
  "t_appointments_type_name" VARCHAR(45) NOT NULL ,
  PRIMARY KEY ("idt_appointments_type"),
  UNIQUE ("idt_appointments_type")
); 


--
-- Table structure for table `t_specialization`
--

CREATE TABLE "t_specialization" (  "idt_specialization" BIGSERIAL NOT NULL ,
  "t_specialization_name" VARCHAR(45) NOT NULL ,
  "t_specialization_type" VARCHAR(45) NOT NULL ,
  PRIMARY KEY ("idt_specialization"),
  UNIQUE ("idt_specialization"),
  UNIQUE ("t_specialization_name")
); 


--
-- Table structure for table `t_patients`
--

CREATE TABLE "t_patients" (  "idt_patients" BIGSERIAL NOT NULL ,
  "t_patients_first_name" VARCHAR(45) NOT NULL ,
  "t_patients_second_name" VARCHAR(45) NOT NULL ,
  "t_patients_surname" VARCHAR(45) NOT NULL ,
  PRIMARY KEY ("idt_patients"),
  UNIQUE ("idt_patients")
); 


--
-- Table structure for table `t_patient_users`
--

CREATE TABLE "t_patient_users" (  "idt_patient_users" BIGSERIAL NOT NULL ,
  "t_patient_users_username" VARCHAR(45) NOT NULL ,
  "t_patient_users_password" VARCHAR(45) NOT NULL ,
  "t_patient_users_patient_id" BIGINT NOT NULL ,
  PRIMARY KEY ("idt_patient_users"),
  UNIQUE ("idt_patient_users"),
  UNIQUE ("t_patient_users_username"),
  UNIQUE ("t_patient_users_patient_id"),FOREIGN KEY ("idt_patient_users") REFERENCES "t_patients" ( "idt_patients" ) ON UPDATE RESTRICT ON DELETE RESTRICT
); 


--
-- Table structure for table `t_staff`
--

CREATE TABLE "t_staff" (  "idt_staff" BIGSERIAL NOT NULL ,
  "t_staff_first_name" VARCHAR(45) NOT NULL ,
  "t_staff_second_name" VARCHAR(45) NOT NULL ,
  "t_staff_surname" VARCHAR(45) NOT NULL ,
  "t_staff_specialization" BIGINT NULL ,
  PRIMARY KEY ("idt_staff"),
  UNIQUE ("idt_staff"),FOREIGN KEY ("t_staff_specialization") REFERENCES "t_specialization" ( "idt_specialization" ) ON UPDATE RESTRICT ON DELETE RESTRICT
); 
CREATE INDEX "t_staff_t_staff_spec_idx" ON "t_staff" ("t_staff_specialization");


--
-- Table structure for table `t_staff_users`
--

CREATE TABLE "t_staff_users" (  "idt_staff_users" BIGSERIAL NOT NULL ,
  "t_staff_users_username" VARCHAR(45) NOT NULL ,
  "t_staff_users_password" VARCHAR(45) NOT NULL ,
  "t_staff_users_staff_id" BIGINT NOT NULL ,
  UNIQUE ("idt_staff_users"),
  UNIQUE ("t_staff_users_staff_id"),
  UNIQUE ("t_staff_users_username"),FOREIGN KEY ("t_staff_users_staff_id") REFERENCES "t_staff" ( "idt_staff" ) ON UPDATE RESTRICT ON DELETE RESTRICT
); 


--
-- Table structure for table `t_appointments`
--

CREATE TABLE "t_appointments" (  "idt_appointments" BIGSERIAL NOT NULL ,
  "t_appointments_description" VARCHAR(45) NOT NULL ,
  "t_appointments_appointment_date" DATE NOT NULL ,
  "t_appointments_date_of_execution" DATE NULL ,
  "t_appointments_type" BIGINT NOT NULL ,
  "t_appointments_staff" BIGINT NOT NULL ,
  PRIMARY KEY ("idt_appointments"),
  UNIQUE ("idt_appointments"),FOREIGN KEY ("t_appointments_staff") REFERENCES "t_staff" ( "idt_staff" ) ON UPDATE RESTRICT ON DELETE RESTRICT,FOREIGN KEY ("t_appointments_type") REFERENCES "t_appointments_type" ( "idt_appointments_type" ) ON UPDATE RESTRICT ON DELETE RESTRICT
); 
CREATE INDEX "t_appointments_type_of_appontment_idx" ON "t_appointments" ("t_appointments_type");
CREATE INDEX "t_appointments_t_appontments_staff_idx" ON "t_appointments" ("t_appointments_staff");


--
-- Table structure for table `t_medical_history`
--

CREATE TABLE "t_medical_history" (  "idt_medical_history" BIGSERIAL NOT NULL ,
  "t_medical_history_patient" BIGINT NOT NULL ,
  "t_medical_history_diagnosed" BIGINT NOT NULL ,
  "t_medical_history_date_of_receipt" DATE NOT NULL ,
  "t_medical_history_discharge_date" DATE NULL ,
  "t_medical_history_diagnosis" VARCHAR(45) NULL ,
  "t_medical_history_comment" VARCHAR(45) NULL ,
  "t_medical_history_appointment" BIGINT NULL ,
  PRIMARY KEY ("idt_medical_history"),
  UNIQUE ("idt_medical_history"),FOREIGN KEY ("t_medical_history_appointment") REFERENCES "t_appointments" ( "idt_appointments" ) ON UPDATE RESTRICT ON DELETE RESTRICT,FOREIGN KEY ("t_medical_history_diagnosed") REFERENCES "t_staff" ( "idt_staff" ) ON UPDATE RESTRICT ON DELETE RESTRICT,FOREIGN KEY ("t_medical_history_patient") REFERENCES "t_patients" ( "idt_patients" ) ON UPDATE RESTRICT ON DELETE RESTRICT
); 
CREATE INDEX "t_medical_history_t_medical_history_diagnosis_idx" ON "t_medical_history" ("t_medical_history_diagnosed");
CREATE INDEX "t_medical_history_t_medical_history_pat_idx" ON "t_medical_history" ("t_medical_history_patient");
CREATE INDEX "t_medical_history_t_medical_history_dest_idx" ON "t_medical_history" ("t_medical_history_appointment");


--
-- Dumping data for table `t_appointments_type`
--

INSERT INTO "t_appointments_type" ("idt_appointments_type","t_appointments_type_name") VALUES (1,'procedure');

INSERT INTO "t_appointments_type" ("idt_appointments_type","t_appointments_type_name") VALUES (2,'medicine');

INSERT INTO "t_appointments_type" ("idt_appointments_type","t_appointments_type_name") VALUES (3,'operation');

SELECT setval('public."t_appointments_type_idt_appointments_type_seq"', max("idt_appointments_type") ) FROM "t_appointments_type"; 


--
-- Dumping data for table `t_specialization`
--

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (1,'admin','adm');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (2,'nurse','nur');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (3,'dentist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (4,'urologist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (5,'neurologist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (6,'psychiatrist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (7,'otolaryngologist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (8,'dermatologist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (9,'cardiologist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (10,'endocrinologist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (11,'allergist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (12,'gastroenterologist','doc');

INSERT INTO "t_specialization" ("idt_specialization","t_specialization_name","t_specialization_type") VALUES (13,'therapist','doc');

SELECT setval('public."t_specialization_idt_specialization_seq"', max("idt_specialization") ) FROM "t_specialization"; 


--
-- Dumping data for table `t_patients`
--

INSERT INTO "t_patients" ("idt_patients","t_patients_first_name","t_patients_second_name","t_patients_surname") VALUES (1,'test','test','test');

INSERT INTO "t_patients" ("idt_patients","t_patients_first_name","t_patients_second_name","t_patients_surname") VALUES (2,'test1','test1','test1');

INSERT INTO "t_patients" ("idt_patients","t_patients_first_name","t_patients_second_name","t_patients_surname") VALUES (6,'123','123','123');

INSERT INTO "t_patients" ("idt_patients","t_patients_first_name","t_patients_second_name","t_patients_surname") VALUES (7,'123','123','123');

INSERT INTO "t_patients" ("idt_patients","t_patients_first_name","t_patients_second_name","t_patients_surname") VALUES (8,'12','123','123');

INSERT INTO "t_patients" ("idt_patients","t_patients_first_name","t_patients_second_name","t_patients_surname") VALUES (9,'111','111','111');

SELECT setval('public."t_patients_idt_patients_seq"', max("idt_patients") ) FROM "t_patients"; 


--
-- Dumping data for table `t_patient_users`
--

INSERT INTO "t_patient_users" ("idt_patient_users","t_patient_users_username","t_patient_users_password","t_patient_users_patient_id") VALUES (1,'123','123',8);

INSERT INTO "t_patient_users" ("idt_patient_users","t_patient_users_username","t_patient_users_password","t_patient_users_patient_id") VALUES (2,'111','111',9);

SELECT setval('public."t_patient_users_idt_patient_users_seq"', max("idt_patient_users") ) FROM "t_patient_users"; 


--
-- Dumping data for table `t_staff`
--

INSERT INTO "t_staff" ("idt_staff","t_staff_first_name","t_staff_second_name","t_staff_surname","t_staff_specialization") VALUES (11,'Vasukova','Valeriya','Genad''evna',2);

INSERT INTO "t_staff" ("idt_staff","t_staff_first_name","t_staff_second_name","t_staff_surname","t_staff_specialization") VALUES (31,'Chernyak','Dima','Vasil''evich',6);

INSERT INTO "t_staff" ("idt_staff","t_staff_first_name","t_staff_second_name","t_staff_surname","t_staff_specialization") VALUES (41,'Petrov123','Petr','Petrovich',3);

INSERT INTO "t_staff" ("idt_staff","t_staff_first_name","t_staff_second_name","t_staff_surname","t_staff_specialization") VALUES (42,'Petrov','Petr','Petrovich',5);

INSERT INTO "t_staff" ("idt_staff","t_staff_first_name","t_staff_second_name","t_staff_surname","t_staff_specialization") VALUES (45,'1','2','3',2);

INSERT INTO "t_staff" ("idt_staff","t_staff_first_name","t_staff_second_name","t_staff_surname","t_staff_specialization") VALUES (46,'Alexandr','Lapatkov','Mihailovich',11);

SELECT setval('public."t_staff_idt_staff_seq"', max("idt_staff") ) FROM "t_staff"; 


--
-- Dumping data for table `t_staff_users`
--

INSERT INTO "t_staff_users" ("idt_staff_users","t_staff_users_username","t_staff_users_password","t_staff_users_staff_id") VALUES (8,'nur','123',11);

INSERT INTO "t_staff_users" ("idt_staff_users","t_staff_users_username","t_staff_users_password","t_staff_users_staff_id") VALUES (9,'doc','123',31);

SELECT setval('public."t_staff_users_idt_staff_users_seq"', max("idt_staff_users") ) FROM "t_staff_users"; 


--
-- Dumping data for table `t_appointments`
--

INSERT INTO "t_appointments" ("idt_appointments","t_appointments_description","t_appointments_appointment_date","t_appointments_date_of_execution","t_appointments_type","t_appointments_staff") VALUES (3,'test','2019-08-28 00:00:00','2019-08-29 00:00:00',1,11);

INSERT INTO "t_appointments" ("idt_appointments","t_appointments_description","t_appointments_appointment_date","t_appointments_date_of_execution","t_appointments_type","t_appointments_staff") VALUES (4,'test2','2019-08-28 00:00:00','2019-08-28 00:00:00',3,11);

INSERT INTO "t_appointments" ("idt_appointments","t_appointments_description","t_appointments_appointment_date","t_appointments_date_of_execution","t_appointments_type","t_appointments_staff") VALUES (5,'','2019-08-28 00:00:00','2019-08-29 00:00:00',1,45);

INSERT INTO "t_appointments" ("idt_appointments","t_appointments_description","t_appointments_appointment_date","t_appointments_date_of_execution","t_appointments_type","t_appointments_staff") VALUES (6,'','2019-08-29 00:00:00','2019-08-30 00:00:00',1,45);

INSERT INTO "t_appointments" ("idt_appointments","t_appointments_description","t_appointments_appointment_date","t_appointments_date_of_execution","t_appointments_type","t_appointments_staff") VALUES (7,'РќР°РґРѕ РїРёС‚СЊ Р»РµРєР°СЂСЃС‚РІР°','2019-08-30 00:00:00','2019-08-31 00:00:00',2,45);

INSERT INTO "t_appointments" ("idt_appointments","t_appointments_description","t_appointments_appointment_date","t_appointments_date_of_execution","t_appointments_type","t_appointments_staff") VALUES (8,'jsgfsjfk','2019-12-31 00:00:00','2020-01-01 00:00:00',1,45);

SELECT setval('public."t_appointments_idt_appointments_seq"', max("idt_appointments") ) FROM "t_appointments"; 


--
-- Dumping data for table `t_medical_history`
--

INSERT INTO "t_medical_history" ("idt_medical_history","t_medical_history_patient","t_medical_history_diagnosed","t_medical_history_date_of_receipt","t_medical_history_discharge_date","t_medical_history_diagnosis","t_medical_history_comment","t_medical_history_appointment") VALUES (31,8,41,'2019-09-03 00:00:00',NULL,NULL,NULL,3);

INSERT INTO "t_medical_history" ("idt_medical_history","t_medical_history_patient","t_medical_history_diagnosed","t_medical_history_date_of_receipt","t_medical_history_discharge_date","t_medical_history_diagnosis","t_medical_history_comment","t_medical_history_appointment") VALUES (32,8,41,'2019-09-03 00:00:00',NULL,NULL,NULL,4);

INSERT INTO "t_medical_history" ("idt_medical_history","t_medical_history_patient","t_medical_history_diagnosed","t_medical_history_date_of_receipt","t_medical_history_discharge_date","t_medical_history_diagnosis","t_medical_history_comment","t_medical_history_appointment") VALUES (33,8,41,'2019-09-04 00:00:00',NULL,NULL,NULL,NULL);

INSERT INTO "t_medical_history" ("idt_medical_history","t_medical_history_patient","t_medical_history_diagnosed","t_medical_history_date_of_receipt","t_medical_history_discharge_date","t_medical_history_diagnosis","t_medical_history_comment","t_medical_history_appointment") VALUES (34,8,41,'2019-09-12 00:00:00',NULL,NULL,NULL,NULL);

INSERT INTO "t_medical_history" ("idt_medical_history","t_medical_history_patient","t_medical_history_diagnosed","t_medical_history_date_of_receipt","t_medical_history_discharge_date","t_medical_history_diagnosis","t_medical_history_comment","t_medical_history_appointment") VALUES (35,9,31,'2019-09-06 00:00:00',NULL,NULL,NULL,NULL);

SELECT setval('public."t_medical_history_idt_medical_history_seq"', max("idt_medical_history") ) FROM "t_medical_history"; 

