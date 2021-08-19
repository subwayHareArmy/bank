-- File to prepopulate the database. Cannot get it to work as of now.

CREATE TABLE billionaires (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

--CREATE TABLE accounts (
--  id INT PRIMARY KEY,
--  name VARCHAR(250) ,
--  address VARCHAR(250) ,
--  ifsc VARCHAR(250) ,
--  balance DOUBLE
--);


--INSERT INTO accounts ( id, name, address, ifsc, balance) VALUES
--  (1, 'a', 'Mumbai', 'ICICI', 300.0),
--  (2, 'asgfawegaw', 'shteherherh', 'ICICI', 45000.0),
--  (3, 'Ayush', 'Pune', 'ICICI', 36500.0);


INSERT INTO billionaires (first_name, last_name, career) VALUES
  ('sadasd', 'threebodyproblem', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');
