/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class BaiTap3 {
    private JFrame frmBaiTap3;
    private JTextArea txtNoiDung;

    public static void main(String[] args) {
        BaiTap3 window = new BaiTap3();
        window.initialize();
    }

    private void initialize() {
        frmBaiTap3 = new JFrame();
        frmBaiTap3.setBounds(100, 100, 450, 300);
        frmBaiTap3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtNoiDung = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtNoiDung);
        frmBaiTap3.getContentPane().add(scrollPane, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        frmBaiTap3.setJMenuBar(menuBar);

        JMenu mnTapTin = new JMenu("Tập Tin");
        mnTapTin.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnTapTin);

        JMenuItem mucMoTapTin = new JMenuItem("Mở Tập Tin");
        mucMoTapTin.setIcon(new ImageIcon("images/open.jfif"));
        mucMoTapTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAction();
            }
        });
        mnTapTin.add(mucMoTapTin);

        mnTapTin.addSeparator();

        JMenuItem mucketThuc = new JMenuItem("Kết Thúc");
        mucketThuc.setIcon(new ImageIcon("images/exit.png"));
        mucketThuc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mnTapTin.add(mucketThuc);

        JMenu mnCaiDat = new JMenu("Cài Đặt");
        mnCaiDat.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnCaiDat);

        JCheckBoxMenuItem mucChk = new JCheckBoxMenuItem("Hiện hộp thoại khi thoát");
        mucChk.setSelected(true);
        mnCaiDat.add(mucChk);

        mnCaiDat.addSeparator();

        JMenu mucMau = new JMenu("Màu Chữ");
        mnCaiDat.add(mucMau);

        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButtonMenuItem rdnDo = new JRadioButtonMenuItem("Đỏ");
        buttonGroup.add(rdnDo);
        mucMau.add(rdnDo);

        JRadioButtonMenuItem rdbXanhDuong = new JRadioButtonMenuItem("Xanh Dương");
        buttonGroup.add(rdbXanhDuong);
        mucMau.add(rdbXanhDuong);

        JRadioButtonMenuItem rdbXanhLaCay = new JRadioButtonMenuItem("Xanh Lá Cây");
        buttonGroup.add(rdbXanhLaCay);
        mucMau.add(rdbXanhLaCay);

        JMenu mnGiupDo = new JMenu("Giúp Đô");
        mnGiupDo.setFont(new Font("Segoe UI", Font.BOLD, 12));
        menuBar.add(mnGiupDo);

        JMenuItem mucGioiThieu = new JMenuItem("Giới Thiệu");
        mucGioiThieu.setFont(new Font("Segoe UI", Font.BOLD, 12));
        mnGiupDo.add(mucGioiThieu);

        JToolBar jtb = new JToolBar();

        JButton btnexit = new JButton(new ImageIcon("images/btnExit.jfif"));
        JButton btnsave = new JButton(new ImageIcon("images/save.jfif"));

        btnsave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveAction();
            }
        });

        jtb.add(btnexit);
        jtb.add(btnsave);

        frmBaiTap3.getContentPane().add(jtb, BorderLayout.NORTH);

        frmBaiTap3.setVisible(true);
    }

    private void openAction() {
        JFileChooser jfc = new JFileChooser();
        int ret = jfc.showOpenDialog(null);
        File f = null;
        if (ret == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
        } else {
            return;
        }
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String data = br.readLine();
            txtNoiDung.setText(data);
            fr.close();
            br.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    private void saveAction() {
        JFileChooser jfc = new JFileChooser();
        int ret = jfc.showSaveDialog(null);
        File f = null;
        if (ret == JFileChooser.APPROVE_OPTION) {
            f = jfc.getSelectedFile();
        } else {
            return;
        }
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(txtNoiDung.getText());
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(null, "Saved data successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}

