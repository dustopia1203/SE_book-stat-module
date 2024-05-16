package view;

import model.Book;
import model.BorrowedBook;
import model.Borrowing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanTicketFrm extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JButton btnBack;
    private JTable tblLoanTicket;
    private Borrowing borrowing;
    private DefaultTableModel tblModel = new DefaultTableModel(null, new String[]{"Mã", "Tên sách", "Tác giả", "Đặt cọc"});

    public LoanTicketFrm(Borrowing borrowing) {
        this.borrowing = borrowing;
        setTitle("LoanTicketFrm");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);
        tblLoanTicket.setModel(tblModel);
        for (BorrowedBook borrowedBook : this.borrowing.getBorrowedBooks()) {
            Book book = borrowedBook.getBook();
            int id = book.getId();
            String name = book.getName();
            String author = book.getAuthor();
            float deposit = borrowedBook.getDeposit();
            tblModel.addRow(new Object[]{id, name, author, deposit});
        }
        btnBack.addActionListener(this);
        btnBack.setFocusable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBack) {
            dispose();
        }
    }
}
