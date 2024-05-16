CREATE DATABASE lib;
USE lib;
CREATE TABLE tblUser
(
	id INT NOT NULL,
    username VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    name VARCHAR(25) NOT NULL,
    role VARCHAR(25) NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblReader
(
	id INT NOT NULL,
    idCard VARCHAR(20) NOT NULL,
    name VARCHAR(25),
    address VARCHAR(255) NOT NULL,
    email VARCHAR(50),
    tel VARCHAR(20),
    note VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE tblBook
(
	id INT NOT NULL,
    name VARCHAR(25) NOT NULL,
    author VARCHAR(25) NOT NULL,
    gendre VARCHAR(20) NOT NULL,
    publisher VARCHAR(25) NOT NULL,
    publicYear INT NOT NULL,
    PRIMARY KEY (id)
);
CREATE TABLE tblBorrowing
(
	id INT NOT NULL,
    borrowDate DATE NOT NULL,
    expectPayDate DATE NOT NULL,
    note VARCHAR(255) NOT NULL,
    idReader INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idReader) REFERENCES tblReader(id)
);

CREATE TABLE tblPayTicket 
(
	id INT NOT NULL,
    payDate DATE NOT NULL,
    compensate FLOAT NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE tblBorrowedBook
(
	id INT NOT NULL,
    deposit FLOAT NOT NULL,
    note VARCHAR(255) NOT NULL,
    amount INT NOT NULL,
    idBook INT NOT NULL,
    idBorrowing INT NOT NULL,
    idPayTicket INT,
    PRIMARY KEY (id),
    FOREIGN KEY (idBook) REFERENCES tblBook(id),
    FOREIGN KEY (idBorrowing) REFERENCES tblBorrowing(id),
    FOREIGN KEY (idPayTicket) REFERENCES tblPayTicket(id)
);

CREATE TABLE tblBookError 
(
	id INT NOT NULL,
    bookError VARCHAR(255),
    idBorrowedBook INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idBorrowedBook) REFERENCES tblBorrowedBook(id)
);

