INSERT INTO Person(id, FirstName, LastName)
VALUES (001, 'Maxine', 'Powers');

INSERT INTO AppUser (Userid, Username, Password)
VALUES (001, 'MaxPower', 'strong');

SELECT
	Person.id, Person.FirstName, Person.LastName, AppUser.Username, AppUser.password
FROM
	Person
		LEFT JOIN
	AppUser ON Person.id = AppUser.Userid
ORDER BY Person.id;