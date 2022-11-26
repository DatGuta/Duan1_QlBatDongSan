/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlbatdongsan.utils;

import com.mycompany.qlbatdongsan.Entity.NhanVien;



/**
 *
 * @author HO VAN DAT
 */
public class Auth {

    public static NhanVien user = null;

    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        boolean chucDanh;
        if (user.getChucDanh().equalsIgnoreCase("Nhân Viên")) {
            chucDanh = false;
        } else {
            chucDanh = true;
        }
        return Auth.isLogin() && chucDanh;
    }
}
