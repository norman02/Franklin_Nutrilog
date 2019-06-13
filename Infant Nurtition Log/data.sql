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
	EventNumber INTEGER NOT NULL,
	TypeCode INTEGER NOT NULL,
	PRIMARY KEY(EventNumber)
);

CREATE TABLE PatientEvent(
	Id INTEGER NOT NULL,
	EventNumber INTEGER,
	DateAndTime DATETIME
	);

CREATE TABLE Patient(
	Id INTEGER,
	Weight FLOAT,
	DOB DATE 	
);



CREATE TABLE Feeding(
	TypeCode INTEGER,
	Aumount FLOAT,
	units FLOAT
);

CREATE TABLE Weighing(
	TypeCode INTEGER,
	Weight FLOAT
);

CREATE TABLE Changing(
	TypeCode INTEGER,
	urine FLOAT,
	stool FLOAT
);


ALTER TABLE patient
ADD FOREIGN KEY (Id) REFERENCES Person (Id);

ALTER TABLE PatientEvent
ADD FOREIGN KEY (id) REFERENCES patient (Id);

ALTER TABLE PatientEvent
ADD FOREIGN KEY (EventNumber) REFERENCES Event (EventNumber);



