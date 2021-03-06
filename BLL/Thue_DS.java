/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import javax.swing.*;
import DAL.*;

public class Thue_DS {
    static ConnectionDB kn = new ConnectionDB();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = kn.getConnect();
    
    public static void themThue(String maThue, String tienThue, String loaiThue)
    {
        String sql="INSERT INTO dbo.THUE(MATHUE, TIENTHUE, LOAITHUE) values (?, ?, ?)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, maThue);
            pst.setString(2, tienThue);
            pst.setString(3, loaiThue);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void suaThue(String maThue, String tienThue, String loaiThue)
    {
        String sql = "UPDATE dbo.THUE SET TIENTHUE='"+tienThue+"', LOAITHUE = '"+loaiThue+"' where MATHUE='"+maThue+"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã sữa thành thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể sữa được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void xoaThue(String maThue)
    {
        String sql ="DELETE FROM dbo.THUE WHERE MATHUE = '"+ maThue +"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã xóa thành công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa xin kiểm tra lại!", "Thông báo",1);
        }
    }
}
