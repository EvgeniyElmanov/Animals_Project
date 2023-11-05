
DROP SCHEMA IF EXISTS Human_friends;
CREATE SCHEMA Human_friends;
USE Human_friends;

DROP TABLE IF EXISTS pets;
CREATE TABLE pets (
	id INT AUTO_INCREMENT PRIMARY KEY, 
   `name` VARCHAR(100) NOT NULL,
	animal VARCHAR(25) NOT NULL,
	birthday DATE, 
	commands TEXT
);


DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals (
	id INT AUTO_INCREMENT PRIMARY KEY, 
   `name` VARCHAR(100) NOT NULL,
	animal VARCHAR(25) NOT NULL,
	birthday DATE, 
	commands TEXT
);

INSERT INTO pets (name, animal, birthday, commands)
VALUES
("Fido", "Dog", '2020-01-01', "Sit, Stray, Fetch"),
("Whiskers", "Cat", '2019-05-15', "Sit, Pounce"),
('Hammy', 'Hamster', '2021-03-10', "Roll, Hide"),
('Buddy', 'Dog', '2018-12-10', "Sit, Paw, Bark"),
('Smudge', 'Cat', '2020-02-20', "Sit, Pounce, Scratch"),
('Peanut', 'Hamster', '2021-08-01', "Roll, Spin"),
('Bella', 'Dog', '2019-11-11', "Sit, Stray, Roll"),
('Oliver', 'Cat', '2020-06-30', "Sit, Stray, Fetch");

INSERT INTO pack_animals (name, animal, birthday, commands)
VALUES
("Thunder", "Horse", '2015-07-21', "Trot, Canter, Gallop"),
("Sandy", "Camel", '2016-11-03', "Walk, Carry Load"),
('Eeyore', 'Donkey', '2017-09-18', "Walk, Carry Load, Bray"),
('Storm', 'Horse', '2014-05-05', "Trot, Canter"),
('Dune', 'Camel', '2018-12-12', "Walk, Sit"),
('Burro', 'Donkey', '2019-01-23', "Walk, Bray, Kick"),
('Blaze', 'Horse', '2016-02-29', "Trot, Jump, Gallop"),
('Sahara', 'Camel', '2015-08-14', "Walk, Run");
   
DELETE pa
FROM pack_animals pa
JOIN (SELECT id FROM pack_animals WHERE Animal = 'Camel') temp
ON pa.id = temp.id;

DROP TABLE IF EXISTS young_animals;
CREATE TABLE young_animals AS
SELECT *,
       CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' лет ', 
              TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' месяцев') AS age
FROM pets
WHERE TIMESTAMPDIFF(YEAR, pets.birthday, CURDATE()) > 1
  AND TIMESTAMPDIFF(YEAR, pets.birthday, CURDATE()) < 3
UNION ALL
SELECT *,
       CONCAT(TIMESTAMPDIFF(YEAR, birthday, CURDATE()), ' лет ', 
              TIMESTAMPDIFF(MONTH, birthday, CURDATE()) % 12, ' месяцев') AS age
FROM pack_animals
WHERE TIMESTAMPDIFF(YEAR, pack_animals.birthday, CURDATE()) > 1
  AND TIMESTAMPDIFF(YEAR, pack_animals.birthday, CURDATE()) < 3;

DROP TABLE IF EXISTS all_animals;
CREATE TABLE all_animals AS
SELECT *
FROM pets
UNION ALL
SELECT *
FROM pack_animals;

CREATE TABLE all_animals AS
SELECT *, 'pets' AS source_table
FROM pets
UNION ALL
SELECT *, 'pack_animals' AS source_table
FROM pack_animals;