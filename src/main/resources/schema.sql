CREATE TABLE IF NOT EXISTS Users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    created_at DATE,
    updated_at DATE
);

CREATE TABLE IF NOT EXISTS Expenses(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    amount DOUBLE(5, 2) NOT NULL,
    category varchar(255) NOT NULL,
    date DATE NOT NULL,
    created_at DATE,
    updated_at DATE
);