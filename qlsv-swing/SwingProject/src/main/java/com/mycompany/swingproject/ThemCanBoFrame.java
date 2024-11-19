/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class ThemCanBoFrame extends JFrame {
    private QLCB qlcb;

    public ThemCanBoFrame(QLCB qlcb) {
        this.qlcb = qlcb;

        setTitle("Thêm Cán Bộ");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Tạo các trường nhập liệu cho việc thêm cán bộ
        JLabel lblHoTen = new JLabel("Họ Tên:");
        JTextField txtHoTen = new JTextField(20);

        JLabel lblNamSinh = new JLabel("Năm Sinh:");
        JTextField txtNamSinh = new JTextField(20);

        JLabel lblGioiTinh = new JLabel("Giới Tính:");
        JTextField txtGioiTinh = new JTextField(20);

        JLabel lblDiaChi = new JLabel("Địa Chỉ:");
        JTextField txtDiaChi = new JTextField(20);

        JButton btnLuu = new JButton("Lưu");
        JButton btnXoa = new JButton("Xóa");
        JButton btnXoaCanBo = new JButton("Xóa Cán Bộ");

        // Thêm các thành phần vào giao diện
        add(lblHoTen);
        add(txtHoTen);

        add(lblNamSinh);
        add(txtNamSinh);

        add(lblGioiTinh);
        add(txtGioiTinh);

        add(lblDiaChi);
        add(txtDiaChi);

        add(btnLuu);
        add(btnXoa);
        add(new JLabel());
        add(btnXoaCanBo);

        

        // Xử lý sự kiện lưu thông tin cán bộ
        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String hoTen = txtHoTen.getText();
                    int namSinh = Integer.parseInt(txtNamSinh.getText());
                    String gioiTinh = txtGioiTinh.getText();
                    String diaChi = txtDiaChi.getText();

                    if (hoTen.isEmpty() || gioiTinh.isEmpty() || diaChi.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
                    } else {
                        CanBo canBo = new CanBo(hoTen, namSinh, gioiTinh, diaChi);
                        qlcb.themCanBo(canBo);
                                                 JOptionPane.showMessageDialog(null, "Thêm cán bộ thành công!");
                        dispose(); // Đóng cửa sổ sau khi thêm
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Năm sinh phải là số nguyên!");
                }
            }
        });

        // Xử lý sự kiện xóa thông tin trong các trường nhập liệu
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtHoTen.setText("");
                txtNamSinh.setText("");
                txtGioiTinh.setText("");
                txtDiaChi.setText("");
            }
        });

        // Xử lý sự kiện xóa cán bộ khỏi danh sách
        btnXoaCanBo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoTen = txtHoTen.getText();
                if (!hoTen.isEmpty()) {
                    boolean isRemoved = qlcb.xoaCanBo(hoTen);
                    if (isRemoved) {
                         // Lưu danh sách cán bộ sau khi xóa
                        JOptionPane.showMessageDialog(null, "Xóa cán bộ thành công!");
                        txtHoTen.setText("");
                        txtNamSinh.setText("");
                        txtGioiTinh.setText("");
                        txtDiaChi.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Không tìm thấy cán bộ với tên đã nhập!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên để xóa!");
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Cửa sổ sẽ xuất hiện giữa màn hình
    }
}
