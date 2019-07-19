DROP DATABASE NutrilogDB;

CREATE DATABASE NutrilogDB;

USE NutrilogDB;

CREATE TABLE Person(
	ID INTEGER NOT NULL,
	FirstName VARCHAR(255)NOT NULL,
	LastName VARCHAR(255) NOT NULL,
	Gender CHAR,
	DOB DATE,
	PRIMARY KEY(ID) 
);

CREATE TABLE AppUser(
	ID INTEGER NOT NULL,
	UserName VARCHAR(255) NOT NULL,
	Password VARCHAR(255) NOT NULL,
	PRIMARY KEY (ID),
	FOREIGN KEY (ID) REFERENCES Person(Id)
);

CREATE TABLE Patient(
	ID INTEGER NOT NULL,
	Weight FLOAT,
	PRIMARY KEY (ID),
	FOREIGN KEY (ID) REFERENCES Person (ID)
);



CREATE TABLE Event(
	EventNum INTEGER NOT NULL,
	ID INTEGER NOT NULL,
	EventName VARCHAR(255) NOT NULL,
	FoodUnit FLOAT,
	Urine BOOLEAN,
	Stool BOOLEAN,
	Weight FLOAT,
	EventDate DATE NOT NULL,
	PRIMARY KEY (EventNum),
	FOREIGN KEY (ID) REFERENCES Patient(ID)
);





