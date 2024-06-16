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
                "    b.rentPerDay as RentPerDay,\n" +
                "    b.price as Price,\n" +
                "\tCOUNT(bb.id) AS BorrowCount,\n" +
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
                bs.setRentPerDay(rs.getFloat("RentPerDay"));
                bs.setPrice(rs.getFloat("Price"));
                bs.setTotalBorrowing(rs.getInt("BorrowCount"));
                bs.setStatus(rs.getString("BookErrors"));
                String subQuery = "SELECT \n" +
                        "    b.id AS BookID,\n" +
                        "    SUM(COALESCE(pt.compensate, 0)) AS TotalCompensation,\n" +
                        "    SUM(\n" +
                        "        CASE \n" +
                        "            WHEN pt.payDate IS NOT NULL THEN \n" +
                        "                b.rentPerDay * DATEDIFF(pt.payDate, br.borrowDate)\n" +
                        "            ELSE \n" +
                        "                b.rentPerDay * DATEDIFF(br.expectPayDate, br.borrowDate)\n" +
                        "        END\n" +
                        "    ) AS TotalRentalFee,\n" +
                        "    SUM(\n" +
                        "        CASE \n" +
                        "            WHEN pt.payDate IS NOT NULL AND pt.payDate > br.expectPayDate THEN \n" +
                        "                0.2 * b.price\n" +
                        "            WHEN pt.payDate IS NULL AND CURDATE() > br.expectPayDate THEN \n" +
                        "                0.2 * b.price\n" +
                        "            ELSE \n" +
                        "                0\n" +
                        "        END\n" +
                        "    ) AS TotalLateFee,\n" +
                        "    SUM(\n" +
                        "        COALESCE(pt.compensate, 0) + \n" +
                        "\t\tCASE \n" +
                        "            WHEN pt.payDate IS NOT NULL THEN \n" +
                        "                b.rentPerDay * DATEDIFF(pt.payDate, br.borrowDate)\n" +
                        "            ELSE \n" +
                        "                b.rentPerDay * DATEDIFF(br.expectPayDate, br.borrowDate)\n" +
                        "        END +\n" +
                        "        CASE \n" +
                        "            WHEN pt.payDate IS NOT NULL AND pt.payDate > br.expectPayDate THEN \n" +
                        "                0.2 * b.price\n" +
                        "            WHEN pt.payDate IS NULL AND CURDATE() > br.expectPayDate THEN \n" +
                        "                0.2 * b.price\n" +
                        "            ELSE \n" +
                        "                0\n" +
                        "        END\n" +
                        "    ) AS TotalRevenue\n" +
                        "FROM \n" +
                        "    tblBorrowedBook bb\n" +
                        "    JOIN tblBook b ON bb.idBook = b.id\n" +
                        "    JOIN tblBorrowing br ON bb.idBorrowing = br.id\n" +
                        "    LEFT JOIN tblPayTicket pt ON bb.idPayTicket = pt.id\n" +
                        "WHERE b.id = ?\n" +
                        "GROUP BY \n" +
                        "    b.id\n";
                PreparedStatement ps2 = CON.prepareStatement(subQuery);
                ps2.setInt(1, rs.getInt("BookID"));
                ResultSet rs2 = ps2.executeQuery();
                if (rs2.next()) {
                    bs.setTotalRevenue(rs2.getFloat("TotalRevenue"));
                }
                res.add(bs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
