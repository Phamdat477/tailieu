package phamvanthanhdat;

import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class Bai01 extends JFrame {
    DefaultMutableTreeNode root = null;
    JTree tree;
    private JTextField txtHoTen;

    public Bai01() {
        root = new DefaultMutableTreeNode("KCNTT");
        tree = new JTree(root);

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount() > 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    txtHoTen.setText(selectedNode.getUserObject().toString());
                }
            }
        });

        DefaultMutableTreeNode nodeKTPM = new DefaultMutableTreeNode("Ngành KTPM");
        root.add(nodeKTPM);

        DefaultMutableTreeNode nodeTTNT = new DefaultMutableTreeNode("Ngành TTNT");
        root.add(nodeTTNT);

        DefaultMutableTreeNode nodeKHDL = new DefaultMutableTreeNode("Ngành KHDL");
        root.add(nodeKHDL);

        tree.expandRow(0);

        JScrollPane sc = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel panelRight = new JPanel(new BorderLayout());
        panelRight.add(sc, BorderLayout.CENTER);

        JPanel panelLeft = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1));

        JButton btnThem = new JButton("Thêm");
        btnThem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount() > 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(txtHoTen.getText());
                    selectedNode.add(newNode);
                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    model.reload();
                    for (int i = 0; i < tree.getRowCount(); i++) {
                        tree.expandRow(i);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn Node !!!");
                }
            }
        });

        JButton btnCapNhat = new JButton("Cập Nhật");
        btnCapNhat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount() > 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    selectedNode.setUserObject(txtHoTen.getText());
                    DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                    model.reload();
                    for (int i = 0; i < tree.getRowCount(); i++) {
                        tree.expandRow(i);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn Node !!!");
                }
            }
        });

        JButton btnXoa = new JButton("Xoá");
        btnXoa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TreeSelectionModel smd = tree.getSelectionModel();
                if (smd.getSelectionCount() > 0) {
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    if (selectedNode != tree.getModel().getRoot()) {
                        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                        model.removeNodeFromParent(selectedNode);
                        model.reload();
                        for (int i = 0; i < tree.getRowCount(); i++) {
                            tree.expandRow(i);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Không được Xoá Node root nha !!!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Bạn chưa chọn Node !!!");
                }
            }
        });

        buttonPanel.add(btnThem);
        buttonPanel.add(btnCapNhat);
        buttonPanel.add(btnXoa);

        panelLeft.add(buttonPanel, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        JLabel lblNhapThongTin = new JLabel("Nhập Thông Tin");
        txtHoTen = new JTextField(20);

        inputPanel.add(lblNhapThongTin, BorderLayout.WEST);
        inputPanel.add(txtHoTen, BorderLayout.CENTER);

        panelLeft.add(inputPanel, BorderLayout.NORTH);

        JPanel pnMain = new JPanel(new BorderLayout());
        pnMain.add(panelLeft, BorderLayout.WEST);
        pnMain.add(panelRight, BorderLayout.CENTER);

        JLabel lblTitle = new JLabel("Thông tin các ngành học", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        JPanel panelTop = new JPanel();
        panelTop.add(lblTitle);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelTop, BorderLayout.NORTH);
        getContentPane().add(pnMain, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Bai01::new);
    }
}
