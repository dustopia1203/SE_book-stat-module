package view;

import dao.BorrowingDAO;
import model.BookStat;
import model.BorrowedBook;
import model.Borrowing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookDetailFrm extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JButton btnBack;
    private JTable tblBorrowing;
    private DefaultTableModel tblModel = new DefaultTableModel(null, new String[]{"Ngày", "Tên độc giả", "Ngày trả", "Tiền phạt"});
    private BookStat bookStat;
    private ArrayList<Borrowing> borrowings;
    private Date sd;
    private Date ed;

    public BookDetailFrm(BookStat bookStat, Date sd, Date ed) {
        this.bookStat = bookStat;
        setTitle("BookDetailFrm");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        tblBorrowing.setModel(tblModel);
        btnBack.addActionListener(this);
        btnBack.setFocusable(false);
        this.sd = sd;
        this.ed = ed;
        BorrowingDAO borrowingDAO = new BorrowingDAO();
        borrowings = borrowingDAO.getBorrowing(this.bookStat.getId(), sd, ed);
        for (Borrowing borrowing : borrowings) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            String borrowDate = sdf.format(borrowing.getBorrowDate());
            String reader = borrowing.getReader().getName();
            String payDate = "";
            float deposit = 0;
            for (BorrowedBook borrowedBook: borrowing.getBorrowedBooks()) {
                if (borrowedBook.getBook().getId() == bookStat.getId()) {
                    payDate = borrowedBook.getPayDate() != null ? sdf.format(borrowedBook.getPayDate()) : "";
                    deposit = borrowingDAO.getCompensate(borrowedBook);
                    break;
                }
            }
            tblModel.addRow(new Object[]{borrowDate, reader, payDate, deposit});
        }
        tblBorrowing.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    if (row != -1) {
                        new LoanTicketFrm(borrowings.get(row));
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            dispose();
        }
    }
}
