DROP DATABASE data;



CREATE DATABASE data;



USE data;



CREATE TABLE Person (
	Id INTEGER(9) NOT NULL,
	FirstName VARCHAR(255),
	LastName VARCHAR(255) NOT NULL,
	Gender CHAR,
	PRIMARY KEY(Id)
);



CREATE TABLE Event(
	EventCode INTEGER NOT NULL,
	EventNumber INTEGER NOT NULL,
	PRIMARY KEY(EventCode)
);

CREATE TABLE PatientEvent(	
	Id INTEGER NOT NULL,	
	EventCode INTEGER,	
	DateAndTime DATETIME	
);

CREATE TABLE Patient(	
	Id INTEGER,	
	Weight FLOAT,	
	DOB DATE 	
);

CREATE TABLE Feeding(
	EventCode INTEGER,
	Aumount FLOAT,
	units FLOAT
);

CREATE TABLE Weighing(
	EventCode INTEGER,
	Weight FLOAT
);

CREATE TABLE Changing(
	EventCode INTEGER,
	urine VARCHAR(255),
	stool VARCHAR(255)
);

ALTER TABLE Patient
ADD FOREIGN KEY (id) REFERENCES Person (id);

ALTER TABLE PatientEvent
ADD FOREIGN KEY (id) REFERENCES Patient (Id);

ALTER TABLE PatientEvent
ADD FOREIGN KEY (EventCode) REFERENCES Event (EventCode);


