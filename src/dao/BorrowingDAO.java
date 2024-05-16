package dao;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BorrowingDAO extends DAO {
    public BorrowingDAO() {
        super();
    }

    public ArrayList<Borrowing> getBorrowing(int idb, Date sd, Date ed) {
        ArrayList<Borrowing> res = new ArrayList<>();
        String query = "SELECT br.*\n" +
                "FROM tblBorrowing br\n" +
                "INNER JOIN tblBorrowedBook bb ON bb.idBorrowing = br.id\n" +
                "INNER JOIN tblBook b ON b.id = bb.idBook\n" +
                "WHERE b.id = ? AND br.borrowDate BETWEEN ? AND ?;";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = CON.prepareStatement(query);
            ps.setInt(1, idb);
            ps.setString(2, sdf.format(sd));
            ps.setString(3, sdf.format(ed));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Borrowing borrowing = new Borrowing();
                borrowing.setId(rs.getInt("id"));
                borrowing.setBorrowDate(rs.getDate("borrowDate"));
                borrowing.setExpectedPayDate(rs.getDate("expectPayDate"));
                borrowing.setNote(rs.getString("note"));
                String query1 = "SELECT reader.* " +
                        "FROM tblReader reader " +
                        "INNER JOIN tblBorrowing borrowing ON borrowing.idReader = reader.id " +
                        "WHERE borrowing.id = ?";
                PreparedStatement ps1 = CON.prepareStatement(query1);
                ps1.setInt(1, rs.getInt("id"));
                ResultSet rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    Reader reader = new Reader(rs1.getInt("id"),
                            rs1.getString("idCard"),
                            rs1.getString("name"),
                            rs1.getString("address"),
                            rs1.getString("email"),
                            rs1.getString("tel"),
                            rs1.getString("note"));
                    borrowing.setReader(reader);
                }
                ArrayList<BorrowedBook> borrowedBooks = new ArrayList<>();
                String query2 = "SELECT borrowedBook.*, book.* " +
                        "FROM tblBorrowedBook borrowedBook " +
                        "INNER JOIN tblBorrowing borrowing ON borrowing.id = borrowedBook.idBorrowing " +
                        "INNER JOIN tblBook book ON book.id = borrowedBook.idBook " +
                        "WHERE borrowing.id = ?";
                PreparedStatement ps2 = CON.prepareStatement(query2);
                ps2.setInt(1, rs.getInt("id"));
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next()) {
                    BorrowedBook borrowedBook = new BorrowedBook();
                    borrowedBook.setId(rs2.getInt("id"));
                    borrowedBook.setDeposit(rs2.getFloat("deposit"));
                    borrowedBook.setNote(rs2.getString("note"));
                    borrowedBook.setAmount(rs2.getInt("amount"));
                    Book book = new Book(rs2.getInt("idBook"),
                            rs2.getString("name"),
                            rs2.getString("author"),
                            rs2.getString("gendre"),
                            rs2.getString("publisher"),
                            rs2.getInt("publicYear"));
                    borrowedBook.setBook(book);
                    String query3 = "SELECT payDate \n" +
                            "FROM tblPayTicket pt \n" +
                            "INNER JOIN tblBorrowedBook bb ON pt.id = bb.idPayTicket\n" +
                            "WHERE bb.id = ?";
                    PreparedStatement ps3 = CON.prepareStatement(query3);
                    ps3.setInt(1, borrowedBook.getId());
                    ResultSet rs3 = ps3.executeQuery();
                    if (rs3.next()) borrowedBook.setPayDate(rs3.getDate("payDate"));
                    borrowedBooks.add(borrowedBook);
                }
                borrowing.setBorrowedBooks(borrowedBooks);
                res.add(borrowing);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;
    }

    public float getCompensate(BorrowedBook borrowedBook) {
        float compensate = 0;
        String query = "SELECT compensate " +
                "FROM tblPayTicket pt " +
                "RIGHT JOIN tblBorrowedBook bb ON bb.idPayTicket = pt.id " +
                "WHERE bb.id = ?";
        try {
            PreparedStatement ps = CON.prepareStatement(query);
            ps.setInt(1, borrowedBook.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                compensate = rs.getFloat("compensate");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return compensate;
    }
}
