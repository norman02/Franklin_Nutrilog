DROP DATABASE NutrilogDB;

CREATE DATABASE NutrilogDB;

USE NutrilogDB;

CREATE TABLE Person(
	Id INTEGER NOT NULL,
	FirstName VARCHAR(255)NOT NULL,
	LastName VARCHAR(255) NOT NULL,
	Gender CHAR,
	PRIMARY KEY(Id) 
);

CREATE TABLE AppUser(
	UserId INTEGER NOT NULL,
	UserName VARCHAR(255) NOT NULL,
	Password VARCHAR(255) NOT NULL,
	PRIMARY KEY (UserId),
	FOREIGN KEY (UserId) REFERENCES Person(Id)
);

CREATE TABLE Patient(
	PatientId INTEGER NOT NULL,
	DOB DATE NOT NULL,
	PRIMARY KEY (PatientId),
	FOREIGN KEY (PatientId) REFERENCES Person (Id)
);

CREATE TABLE PatientEvent(
	EventId INTEGER NOT NULL,
	PatientId INTEGER NOT NULL,
	EventCode INTEGER NOT NULL,
	EventDate DATETIME NOT NULL
);

CREATE TABLE Feeding(
	EventCode INTEGER NOT NULL,
	FoodUnit FLOAT,
	PRIMARY KEY (EventCode)
);

CREATE TABLE Changing(
	EventCode INTEGER NOT NULL,
	Urine BOOLEAN NOT NULL,
	Stool BOOLEAN NOT NULL,
	PRIMARY KEY (EventCode)
);

CREATE TABLE Weighing(
	EventCode INTEGER NOT NULL,
	Weight FLOAT NOT NULL,
	PRIMARY KEY (EventCode)
);





