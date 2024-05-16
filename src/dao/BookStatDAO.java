package dao;

import model.BookStat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookStatDAO extends DAO {
    public BookStatDAO() {
        super();
    }

    public ArrayList<BookStat> getBookStat(Date sd, Date ed) {
        ArrayList<BookStat> res = new ArrayList<>();
        String query = "SELECT \n" +
                "\tb.id AS BookID,\n" +
                "\tb.name AS BookName,\n" +
                "\tb.author AS Author,\n" +
                "\tb.gendre AS Gendre,\n" +
                "\tb.publisher AS Publisher,\n" +
                "\tb.publicYear AS PublicYear,\n" +
                "\tCOUNT(bb.id) AS BorrowCount,\n" +
                "\tSUM(bt.compensate) AS TotalCompensate,\n" +
                "\tSUM(bb.deposit) AS TotalDeposit,\n" +
                "\tCOUNT(be.id) AS ErrorCount,\n" +
                "\tGROUP_CONCAT(DISTINCT be.bookError SEPARATOR '; ') AS BookErrors\n" +
                "FROM tblBorrowedBook bb\n" +
                "JOIN tblBook b ON bb.idBook = b.id\n" +
                "JOIN tblBorrowing br ON bb.idBorrowing = br.id\n" +
                "LEFT JOIN tblPayTicket bt ON bt.id = bb.idPayTicket\n" +
                "LEFT JOIN tblBookError be ON bb.id = be.idBorrowedBook\n" +
                "WHERE br.borrowDate BETWEEN ? AND ?\n" +
                "GROUP BY b.id, b.name, b.author\n" +
                "ORDER BY BorrowCount DESC;";
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            PreparedStatement ps = CON.prepareStatement(query);
            ps.setString(1, sdf.format(sd));
            ps.setString(2, sdf.format(ed));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookStat bs = new BookStat();
                bs.setId(rs.getInt("BookID"));
                bs.setName(rs.getString("BookName"));
                bs.setAuthor(rs.getString("Author"));
                bs.setGendre(rs.getString("Gendre"));
                bs.setPublisher(rs.getString("Publisher"));
                bs.setPublicYear(rs.getInt("PublicYear"));
                bs.setTotalBorrowing(rs.getInt("BorrowCount"));
                bs.setTotalRevenue(rs.getFloat("TotalCompensate"));
                bs.setStatus(rs.getString("BookErrors"));
                res.add(bs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
