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
	
	EventCode INTEGER NOT NULL,
	
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
	
	urine FLOAT,
	
	stool FLOAT
);




