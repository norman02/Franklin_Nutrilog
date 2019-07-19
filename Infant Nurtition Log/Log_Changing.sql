INSERT INTO Person 
	(ID, FirstName, LastName, Gender, DOB)
VALUES 
	(0005, 'Edger', 'Early', 'M', '2019/7/05');

INSERT INTO Patient 
	(ID)
VALUES 
	(0005);

INSERT INTO Event
	(EventNum, ID, EventName, EventDate, Urine, Stool)
VALUES
	(5551, 0005, 'Changing', '2019/7/14', 1, 0);
	
INSERT INTO Event
	(EventNum, ID, EventName, EventDate, Urine, Stool)
VALUES
	(5552, 0005, 'Changing', '2019/7/14', 1, 1);

INSERT INTO Event
	(EventNum, ID, EventName, EventDate, Urine, Stool)
VALUES
	(5553, 0005, 'Changing', '2019/7/15', 0, 0);
	
SELECT
	Person.FirstName, Person.LastName, Event.EventName, Event.EventDate, Event.Urine, Event.Stool
FROM 
	Person
LEFT JOIN
	Event ON Person.id = event.id
ORDER BY Person.id;