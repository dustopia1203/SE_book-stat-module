USE lib;
INSERT INTO tblUser(id, username, password, name, role)
VALUES (1, 'manager1', 'manager1', 'Manager 1', 'manager');
INSERT INTO tblReader(id, idCard, name, address, email, tel, note)
VALUES (1, 'R1', 'Reader 1', 'Address 1', 'reader1@mail.com', '0123456789', 'Note 1');
INSERT INTO tblReader(id, idCard, name, address, email, tel, note)
VALUES (2, 'R2', 'Reader 2', 'Address 2', 'reader2@mail.com', '0123456798', 'Note 2');
INSERT INTO tblReader(id, idCard, name, address, email, tel, note)
VALUES (3, 'R3', 'Reader 3', 'Address 3', 'reader3@mail.com', '0123456798', 'Note 3');
INSERT INTO tblBook(id, name, author, gendre, publisher, publicYear, rentPerDay, price)
VALUES (1, 'Book 1', 'Author 1', 'Gendre 1', 'Publisher 1', 2001, 5, 100);
INSERT INTO tblBook(id, name, author, gendre, publisher, publicYear, rentPerDay, price)
VALUES (2, 'Book 2', 'Author 2', 'Gendre 2', 'Publisher 2', 2002, 10, 110);
INSERT INTO tblBook(id, name, author, gendre, publisher, publicYear, rentPerDay, price)
VALUES (3, 'Book 3', 'Author 3', 'Gendre 3', 'Publisher 3', 2003, 15, 150);
INSERT INTO tblBorrowing(id, borrowDate, expectPayDate, note, idReader)
VALUES (1, '2011-01-01', '2011-01-10', 'Note 1', 1);
INSERT INTO tblBorrowing(id, borrowDate, expectPayDate, note, idReader)
VALUES (2, '2011-02-01', '2011-02-10', 'Note 2', 2);
INSERT INTO tblBorrowing(id, borrowDate, expectPayDate, note, idReader)
VALUES (3, '2011-03-01', '2011-03-10', 'Note 3', 3);
INSERT INTO tblPayTicket(id, payDate, compensate)
VALUES (1, '2011-01-05', 0.0);
INSERT INTO tblPayTicket(id, payDate, compensate)
VALUES (2, '2011-02-05', 30.0);
INSERT INTO tblBorrowedBook(id, deposit, note, amount, idBook, idBorrowing, idPayTicket)
VALUES (1, 0.0, 'Note 1', 1, 1, 1, 1);
INSERT INTO tblBorrowedBook(id, deposit, note, amount, idBook, idBorrowing, idPayTicket)
VALUES (2, 0.0, 'Note 2', 1, 1, 2, 2);
INSERT INTO tblBorrowedBook(id, deposit, note, amount, idBook, idBorrowing, idPayTicket)
VALUES (3, 3.0, 'Note 3', 2, 2, 2, 2);
INSERT INTO tblBorrowedBook(id, deposit, note, amount, idBook, idBorrowing, idPayTicket)
VALUES (4, 2.0, 'Note 4', 1, 3, 2, 2);
INSERT INTO tblBorrowedBook(id, deposit, note, amount, idBook, idBorrowing, idPayTicket)
VALUES (5, 1.0, 'Note 5', 1, 1, 3, null);
INSERT INTO tblBookError(id, bookError, idBorrowedBook)
VALUES (1, 'Page 1 torn.', 2);
INSERT INTO tblBookError(id, bookError, idBorrowedBook)
VALUES (2, 'Page 10 book 1 torn, page 3 book 2 torn.', 3);
INSERT INTO tblBookError(id, bookError, idBorrowedBook)
VALUES (3, 'Page 25 creasy.', 4);
