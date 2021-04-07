package model;

import config.Connected;
import model.entity.NguoiDung;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ModelNguoiDung implements  DataNguoiDung<NguoiDung>{

    @Override
    public ArrayList<NguoiDung> listND() {
        ArrayList<NguoiDung> arrayList = new ArrayList<>();
        try {
            Statement st = Connected.getInstance().getStatement();
            String sql = "SELECT * FROM user";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()){
                arrayList.add(new NguoiDung(rs.getInt("id"),rs.getString("ten"),rs.getInt("tuoi"),rs.getString("gioi_tinh"),rs.getString("ghi_chu")));
            }
        }catch (Exception e){
        }
        return arrayList;
    }

    @Override
    public boolean create(NguoiDung nguoiDung) {
        try {
            Statement stt = Connected.getInstance().getStatement();
            String txt = "insert into user(id,ten,tuoi,gioi_tinh,ghi_chu) values(" +
                    ""+nguoiDung.getId()+",'"+nguoiDung.getTen()+"',"+nguoiDung.getTuoi()+",'"+nguoiDung.getGioiTinh()+"','"+nguoiDung.getGhiChu()+"')";
            stt.execute(txt);
            return true;
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean update(NguoiDung nguoiDung) {
        try {
            Statement st = Connected.getInstance().getStatement();
            String txt_sql = "UPDATE user SET ten='"+nguoiDung.getTen()+"'"+",tuoi="+nguoiDung.getTuoi()+",gioi_tinh='"+nguoiDung.getGioiTinh()+"'"+",ghi_chu='"+nguoiDung.getGhiChu()+"' where id="+nguoiDung.getId();
            st.execute(txt_sql);
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean delete(NguoiDung nguoiDung) {
        try {
            Statement st = Connected.getInstance().getStatement();
            String sql = "DELETE FROM user WHERE id="+nguoiDung.getId();
            st.execute(sql);
        }catch (Exception e){
        }
        return false;
    }
}
