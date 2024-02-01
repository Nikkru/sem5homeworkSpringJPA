CREATE TABLE tasks (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    description varchar(5000) NOT NULL,
    status varchar(50),
    date_created TIMESTAMP
);