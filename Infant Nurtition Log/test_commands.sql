#Register a baby

INSERT INTO Person (id, FirstName, LastName, Gender)
VALUES (1, "John", "Doe", 'M');

INSERT INTO Patient (id, Weight, DOB)
VALUES (1, 10, NULL);

#Search for a baby - By last name or By regitraition number

SELECT Person.id, Person.FirstName, Person.LastName, Person.Gender, Patient.Weight, Patient.DOB
FROM Person
LEFT JOIN Patient ON Person.id=Patient.id
WHERE LastName = 'Doe';

SELECT Person.id, Person.FirstName, Person.LastName, Person.Gender, Patient.Weight, Patient.DOB
FROM Person
LEFT JOIN Patient ON Person.id=Patient.id
WHERE Person.id = 1;

#Log an Event - feeding/ changing/ weighing
