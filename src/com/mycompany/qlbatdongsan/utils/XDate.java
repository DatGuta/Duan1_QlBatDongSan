/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlbatdongsan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HO VAN DAT
 */
public class XDate {
    static SimpleDateFormat formater = new  SimpleDateFormat();
    public static java.sql.Date toDate(String date, String pattern){
        try {
            formater.applyPattern(pattern);
            java.util.Date  uDate = formater.parse(date);
            java.sql.Date sDate = convertUtilToSql(uDate);
            return sDate;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static String toString(Date date, String pattern){
        formater.applyPattern(pattern);
        return formater.format(date);
    }
    public static Date addDays(Date date, long days){
        date.setTime(date.getTime()+days*24*60*60*1000);
        return date;
    }
//    public static void main(String[] args) {
//        java.util.Date uDate = new java.util.Date();
//        System.out.println("Time in java.util.Date is : " + uDate);
//        java.sql.Date sDate = convertUtilToSql(uDate);
//        System.out.println("Time in java.sql.Date is : " + sDate);
//        DateFormat df = new SimpleDateFormat("dd/MM/YYYY - hh:mm:ss");
//        System.out.println("Using a dateFormat date is : " + df.format(uDate));
//    }
 
    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
