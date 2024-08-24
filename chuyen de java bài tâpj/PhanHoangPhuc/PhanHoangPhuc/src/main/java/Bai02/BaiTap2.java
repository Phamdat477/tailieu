/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BaiTap2 extends JFrame {
    private JLabel imageLabel;
    private JPopupMenu popupMenu;

    public BaiTap2() {
        setTitle("Giao Diện Java Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo panel chứa nút đóng cửa số
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());

        JButton closeButton = new JButton("Đóng cửa số");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(closeButton);
        buttonPanel.add(Box.createHorizontalGlue());

        add(buttonPanel, BorderLayout.NORTH);

        ImageIcon defaultImage = new ImageIcon("..//PhanHoangPhuc/src/main/java/Bai02/Hinh/ruongbacthang.jpg");
        imageLabel = new JLabel(defaultImage);
        add(imageLabel, BorderLayout.CENTER);

        popupMenu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("1/Nha Trang");
        JMenuItem menuItem2 = new JMenuItem("2/Đà Lạt");
        JMenuItem menuItem3 = new JMenuItem("3/Phố Cổ Nghệ An");
        JMenuItem menuItem4 = new JMenuItem("4/Vũng Tàu");
        JMenuItem menuItem5 = new JMenuItem("5/Vịnh Hạ Long");
        JMenuItem menuItem6 = new JMenuItem("6/Cố Đô Huế");
        menuItem1.addActionListener(new MenuItemListener("..//PhanHoangPhuc/src/main/java/Bai02/Hinh/nhatrang.jpg"));
        menuItem2.addActionListener(new MenuItemListener("..//PhanHoangPhuc/src/main/java/Bai02/Hinh/dalat.jpg"));
        menuItem3.addActionListener(new MenuItemListener("..//PhanHoangPhuc/src/main/java/Bai02/Hinh/phoconghean.jpg"));
        menuItem4.addActionListener(new MenuItemListener("..//PhanHoangPhuc/src/main/java/Bai02/Hinh/vungtau.jpg"));
        menuItem5.addActionListener(new MenuItemListener("..//PhanHoangPhuc/src/main/java/Bai02/Hinh/vinhhalong.jpg"));
        menuItem6.addActionListener(new MenuItemListener("..//PhanHoangPhuc/src/main/java/Bai02/Hinh/codohue.jpg"));
        popupMenu.add(menuItem1);
        popupMenu.add(menuItem2);
        popupMenu.add(menuItem3);
        popupMenu.add(menuItem4);
        popupMenu.add(menuItem5);
        popupMenu.add(menuItem6);

        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    popupMenu.show(imageLabel, e.getX(), e.getY());
                }
            }
        });

        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private class MenuItemListener implements ActionListener {
        private String imageName;

        public MenuItemListener(String imageName) {
            this.imageName = imageName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ImageIcon newImage = new ImageIcon(imageName);
            imageLabel.setIcon(newImage);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BaiTap2();
            }
        });
    }
}
