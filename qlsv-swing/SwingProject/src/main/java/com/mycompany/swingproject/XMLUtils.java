/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.swingproject;

/**
 *
 * @author van46
 */
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.beans.XMLDecoder;
import java.io.FileInputStream;

public class XMLUtils {
    public static void luuDuLieu(QLCB qlcb, String filePath) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(filePath);
             XMLEncoder encoder = new XMLEncoder(fos)) {
            encoder.writeObject(qlcb);
        }
    }
     public static QLCB docDuLieu(String filePath) throws Exception {
        try (FileInputStream fis = new FileInputStream(filePath);
             XMLDecoder decoder = new XMLDecoder(fis)) {
            return (QLCB) decoder.readObject();
        }
    }
}
