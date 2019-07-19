INSERT INTO Person 
	(ID, FirstName, LastName, Gender, DOB)
VALUES 
	(0004, 'Diana', 'Door', 'F', '2018/8/01');

INSERT INTO Patient 
	(ID)
VALUES 
	(0004);

INSERT INTO Event
	(EventNum, ID, EventName, EventDate, FoodUnit)
VALUES
	(4441, 0004, 'Feeding', '2018/8/03', 14);
	
INSERT INTO Event
	(EventNum, ID, EventName, EventDate, FoodUnit)
VALUES
	(4442, 0004, 'Feeding', '2018/8/04', 10);
	
INSERT INTO Event
	(EventNum, ID, EventName, EventDate, FoodUnit)
VALUES
	(4443, 0004, 'Feeding', '2018/8/05', 16);
	
SELECT
	Person.FirstName, Person.LastName, Event.EventName, Event.EventDate, Event.FoodUnit
FROM 
	Person
LEFT JOIN
	Event ON Person.id = event.id
ORDER BY Person.id;
