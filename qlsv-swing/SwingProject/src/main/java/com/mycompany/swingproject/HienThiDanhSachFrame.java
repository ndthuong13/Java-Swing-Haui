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
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class HienThiDanhSachFrame extends JFrame {
    private QLCB qlcb;

    public HienThiDanhSachFrame(QLCB qlcb) {
        this.qlcb = qlcb;

        setTitle("Danh Sách Cán Bộ");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Tạo bảng để hiển thị thông tin cán bộ
        String[] columnNames = {"Họ Tên", "Năm Sinh", "Giới Tính", "Địa Chỉ"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);

        // Lấy danh sách cán bộ và thêm vào bảng
        List<CanBo> danhSachCanBo = qlcb.getDanhSachCanBo();
        for (CanBo canBo : danhSachCanBo) {
            Object[] rowData = {canBo.getHoTen(), canBo.getNamSinh(), canBo.getGioiTinh(), canBo.getDiaChi()};
            tableModel.addRow(rowData);
        }

        // Thêm bảng vào giao diện
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Nút đóng cửa sổ
        JButton btnClose = new JButton("Đóng");
        btnClose.addActionListener(e -> dispose());
        add(btnClose, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Để cửa sổ xuất hiện ở giữa màn hình
    }
}
