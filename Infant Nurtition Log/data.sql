DROP DATABASE data;

CREATE DATABASE data;

USE data;

CREATE TABLE Person (
	Id INTEGER NOT NULL,
	FirstName VARCHAR(255),
	LastName VARCHAR(255) NOT NULL,
	Gender CHAR,
	PRIMARY KEY(Id)
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

CREATE TABLE Event(
	EventNumber INTEGER,
	TypeCode INTEGER
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

DESC PatientEvent;
