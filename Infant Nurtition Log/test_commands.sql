

INSERT INTO Person (id, FirstName, LastName, Gender)
VALUES (1, "John", "Doe", 'M');

INSERT INTO Person (id, FirstName, LastName, Gender)
VALUES (2, "Jane", "Doe", 'F');

INSERT INTO Person (id, FirstName, LastName, Gender)
VALUES (3, "Jessica", "Jones", 'F');

INSERT INTO Person (id, FirstName, LastName, Gender)
VALUES (4, "Luke", "Cage", 'M');

SELECT * FROM Person;

INSERT INTO Event(id, EventType, PersonId, Units)
VALUES (1, 'Feeding', 1, 4);

INSERT INTO Event(id, EventType, PersonId, Urine, Stool)
VALUES (2, 'Changing', 2, True, false);

INSERT INTO Event(id, EventType, PersonId, Weight)
VALUES (3, 'Wheighing', 3, 50);

SELECT 
	Person.*, Event.*
FROM
	Event
	LEFT JOIN
	Person ON Person.id = Event.PersonId;