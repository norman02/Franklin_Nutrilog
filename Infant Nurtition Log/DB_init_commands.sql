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
	DateAndTime DATETIME,
	PRIMARY KEY(EventNumber)
);

CREATE TABLE PatientEvent(	
	Id INTEGER NOT NULL,	
	EventNumber INTEGER	
);

CREATE TABLE Patient(	
	Id INTEGER,	
	Weight FLOAT,	
	DOB DATE 	
);

CREATE TABLE Feeding(
	EventName VARCHAR(255),
	Aumount FLOAT,
	units FLOAT
);

CREATE TABLE Weighing(
	EventName VARCHAR(255),
	Weight FLOAT
);

CREATE TABLE Changing(
	EventName VARCHAR(255),
	urine VARCHAR(255),
	stool VARCHAR(255)
);

CREATE TABLE EventType(
	EventNumber INTEGER,
	EventName VARCHAR(255)
);

ALTER TABLE Patient
ADD FOREIGN KEY (id) REFERENCES Person (id);

ALTER TABLE PatientEvent
ADD FOREIGN KEY (id) REFERENCES Patient (Id);

ALTER TABLE PatientEvent
ADD FOREIGN KEY (EventNumber) REFERENCES Event (EventNumber);

ALTER TABLE EventType
ADD FOREIGN KEY (EventNumber) REFERENCES Event (EventNumber);

