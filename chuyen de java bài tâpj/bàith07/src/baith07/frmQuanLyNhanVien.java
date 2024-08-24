package baith07;

import javax.swing.*;
import java.awt.*;

public class frmQuanLyNhanVien {

    private JFrame frm;
    private JTextField txtEmployeeId, txtName, txtBirthdate, txtAddress, txtPhone;
    private JButton btnSave, btnCancel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                frmQuanLyNhanVien window = new frmQuanLyNhanVien();
                window.frm.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the application.
     */
    public frmQuanLyNhanVien() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frm = new JFrame();
        frm.setTitle("Quản lý nhân viên");
        frm.setBounds(100, 100, 500, 400);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        txtEmployeeId = new JTextField();
        txtName = new JTextField();
        txtBirthdate = new JTextField();
        txtAddress = new JTextField();
        txtPhone = new JTextField();

        panel.add(new JLabel("Mã Nhân Viên:"));
        panel.add(txtEmployeeId);
        panel.add(new JLabel("Tên Nhân Viên:"));
        panel.add(txtName);
        panel.add(new JLabel("Ngày Sinh:"));
        panel.add(txtBirthdate);
        panel.add(new JLabel("Địa Chỉ:"));
        panel.add(txtAddress);
        panel.add(new JLabel("Số Điện Thoại:"));
        panel.add(txtPhone);

        btnSave = new JButton("Lưu");
        btnCancel = new JButton("Hủy");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnSave);
        buttonPanel.add(btnCancel);

        frm.add(panel, BorderLayout.CENTER);
        frm.add(buttonPanel, BorderLayout.SOUTH);
    }
}
