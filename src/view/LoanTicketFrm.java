package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanTicketFrm extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private JButton btnBack;
    private JTable tblLoanTicket;

    public LoanTicketFrm() {
        setTitle("LoanTicketFrm");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setContentPane(mainPanel);

        tblLoanTicket.setModel(new DefaultTableModel(null, new String[]{"Mã", "Tên sách", "Tác giả", "Đặt cọc"}));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
