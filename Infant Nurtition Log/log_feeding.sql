INSERT INTO Person (ID, FirstName, LastName, Gender, DOB)
VALUES (0003, 'Carl', 'Craig', 'M', '2000/4/04');

INSERT INTO Patient(ID, Weight)
VALUES (0003, 185.6);

SELECT 
	Person.ID, Person.LastName, Patient.Weight
FROM
	Person
	
LEFT JOIN
	Patient ON Person.id = Patient.id
ORDER BY Person.id;

INSERT INTO Event (EventNum, ID, EventName, EventDate, Weight)
VALUES (1000, 0003, 'Weighing', '2014/1/21', 208.75);

UPDATE Patient
SET
	Weight = 208.75
WHERE
	ID = 0003;

SELECT 
	Person.ID, Person.LastName, Patient.Weight
FROM
	Person
LEFT JOIN
	Patient ON Person.id = Patient.id
ORDER BY Person.id;

INSERT INTO Event (EventNum, ID, EventName, EventDate, Weight)
VALUES (1001, 0003, 'Weighing', '2015/3/15', 295.75);

UPDATE Patient
SET
	Weight = 295.75
WHERE
	ID = 0003;
	
INSERT INTO Event (EventNum, ID, EventName, EventDate, Weight)
VALUES (1007, 0003, 'Weighing', '2016/7/18', 276);

UPDATE Patient
SET
	Weight = 208.75
WHERE
	ID = 0003;
	
SELECT
	Person.FirstName, Person.LastName, Event.EventName, Event.EventDate, Event.Weight
FROM 
	Person
LEFT JOIN
	Event ON Person.id = event.id
ORDER BY Person.id;


