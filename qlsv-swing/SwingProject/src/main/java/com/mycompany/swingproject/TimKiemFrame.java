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
import java.util.List;

public class TimKiemFrame extends JFrame {
    private QLCB qlcb;

    public TimKiemFrame(QLCB qlcb) {
        this.qlcb = qlcb;

        setTitle("Tìm Kiếm Cán Bộ");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Ví dụ về trường nhập liệu cho tìm kiếm
        JTextField txtHoTen = new JTextField(20);
        JButton btnTimKiem = new JButton("Tìm Kiếm");

        add(new JLabel("Nhập Họ Tên:"));
        add(txtHoTen);
        add(btnTimKiem);

        // Xử lý sự kiện tìm kiếm
        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hoTen = txtHoTen.getText();
                List<CanBo> ketQua = qlcb.timKiemTheoHoTen(hoTen);
                if (ketQua.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy cán bộ nào.");
                } else {
                    StringBuilder sb = new StringBuilder("Kết quả tìm kiếm:\n");
                    for (CanBo canBo : ketQua) {
                        sb.append(canBo).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, sb.toString());
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
