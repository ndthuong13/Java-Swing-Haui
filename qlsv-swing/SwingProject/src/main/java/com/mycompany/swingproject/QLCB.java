/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swingproject;

/**
 *
 * @author van46
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QLCB {
    private List<CanBo> danhSachCanBo = new ArrayList<>();

    // Thêm cán bộ
    public void themCanBo(CanBo canBo) {
        danhSachCanBo.add(canBo);
    }

    // Tìm kiếm theo họ tên
    public List<CanBo> timKiemTheoHoTen(String hoTen) {
        List<CanBo> ketQua = new ArrayList<>();
        for (CanBo canBo : danhSachCanBo) {
            if (canBo.getHoTen().equalsIgnoreCase(hoTen)) {
                ketQua.add(canBo);
            }
        }
        return ketQua;
    }

    // Hiển thị danh sách
    public void hienThiDanhSach() {
        for (CanBo canBo : danhSachCanBo) {
            System.out.println(canBo);
        }
    }
    //Hiển thị danh sách trong UI
    public List<CanBo> getDanhSachCanBo() {
        return danhSachCanBo;
    }
    
        // Phương thức xóa cán bộ dựa trên họ tên
    public boolean xoaCanBo(String hoTen) {
        for (CanBo canBo : danhSachCanBo) {
            if (canBo.getHoTen().equalsIgnoreCase(hoTen)) {
                danhSachCanBo.remove(canBo);
                return true; // Xóa thành công
            }
        }
        return false; // Không tìm thấy cán bộ cần xóa
    }
    
     public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(danhSachCanBo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
         // Thêm phương thức tải danh sách cán bộ từ file
    @SuppressWarnings("unchecked")
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            danhSachCanBo = (List<CanBo>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
