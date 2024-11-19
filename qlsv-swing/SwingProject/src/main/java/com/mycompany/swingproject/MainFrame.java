/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.swingproject;

/**
 *
 * @author van46
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private QLCB qlcb = new QLCB();

    public MainFrame() {
        setTitle("Quản lý cán bộ");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tạo các nút
        JButton btnThemCanBo = new JButton("Thêm cán bộ");
        JButton btnTimKiem = new JButton("Tìm kiếm");
        JButton btnHienThi = new JButton("Hiển thị danh sách");
        JButton btnThoat = new JButton("Thoát");

        // Panel chứa nút
        JPanel panel = new JPanel();
        panel.add(btnThemCanBo);
        panel.add(btnTimKiem);
        panel.add(btnHienThi);
        panel.add(btnThoat);

        // Thêm các sự kiện
        btnThemCanBo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThemCanBoFrame(qlcb).setVisible(true);
            }
        });

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TimKiemFrame(qlcb).setVisible(true);
            }
        });

        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qlcb.hienThiDanhSach();
            }
        });
        btnHienThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HienThiDanhSachFrame(qlcb).setVisible(true);
            }
    });


        btnThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
