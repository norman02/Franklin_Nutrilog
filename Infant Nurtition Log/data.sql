DROP DATABASE data;

CREATE DATABASE data;

USE data;

CREATE TABLE Person (
	Id INTEGER,
	FirstName VARCHAR(50),
	LastName VARCHAR(50),
	Gender CHAR);

CREATE TABLE PatientEvent
	(Id INTEGER,
	EventNumber INTEGER,
	DateAndTime DATETIME);

CREATE TABLE Patient
	(Id INTEGER,
	Weight FLOAT,
	DOB DATE);

CREATE TABLE Event(
	EventNumber INTEGER,
	TypeCode INTEGER);

CREATE TABLE Feeding(
	TypeCode INTEGER,
	Aumount FLOAT,
	units FLOAT
	);

CREATE TABLE Weighing(
	TypeCode INTEGER,
	Weight FLOAT);

CREATE TABLE Changing(
	TypeCode INTEGER,
	urine FLOAT,
	stool FLOAT
	);

SHOW TABLES;

DESC person;

DESC Changing;
DESC Event;
DESC Feeding;
DESC Patient;
DESC PatientEvent;
DESC Weighing;
