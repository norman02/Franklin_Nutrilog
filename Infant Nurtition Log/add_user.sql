INSERT INTO Person(id, FirstName, LastName)
VALUES (001, 'Maxine', 'Powers');

INSERT INTO AppUser (Person, Username, Password)
VALUES (001, 'MaxPower', 'strong');

SELECT * FROM Person;

SELECT * FROM AppUser;

SELECT
	Person.id, Person.FirstName, Person.LastName, AppUser.Username, AppUser.password
FROM
	Person
		LEFT JOIN
	AppUser ON Person.id = AppUser.Person
ORDER BY Person.id;
