/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swingproject;

/**
 *
 * @author van46
 */
public class CongNhan extends CanBo {
    private int bac;

    public CongNhan(String hoTen, int namSinh, String gioiTinh, String diaChi, int bac) {
        super(hoTen, namSinh, gioiTinh, diaChi);
        this.bac = bac;
    }

    public int getBac() { return bac; }
    public void setBac(int bac) { this.bac = bac; }

    @Override
    public String toString() {
        return super.toString() + ", Bậc: " + bac;
    }
}
