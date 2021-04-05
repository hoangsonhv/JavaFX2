package model;

import config.Connected;
import model.entity.ThietBi;
import model.entity.Phieu;
import model.ModelPhieu;
import java.sql.*;
import java.util.ArrayList;

public class ModelThietBi implements DataAccsessObject<ThietBi>{
    @Override
    public ArrayList<ThietBi> getList() {
        ArrayList<ThietBi> arrayList = new ArrayList<>();
        try {
            Statement st = Connected.getInstance().getStatement();
            String sql = "SELECT * FROM thietbi";
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()){
                arrayList.add(new ThietBi(resultSet.getString("id"),resultSet.getString("tenthietbi"),resultSet.getString("soluong"),resultSet.getString("ngaynhap")));
            }
            String sl = "select soluong from thietbi";
            String slp = "select soluong from phieu";
        }catch (Exception e){
        }
        return arrayList;
    }

    @Override
    public boolean create(ThietBi thietBi) {
        try {
            Statement stt = Connected.getInstance().getStatement();
            String txt = "insert into ThietBi(id,tenthietbi,soluong,ngaynhap) values(" +
                    ""+thietBi.getId()+",'"+thietBi.getTenThietBi()+"','"+thietBi.getSoLuong()+"','"+thietBi.getNgayNhap()+"')";
            stt.execute(txt);
            return true;
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean update(ThietBi thietBi) {
        try {
            Statement st = Connected.getInstance().getStatement();
            String txt_sql = "UPDATE thietbi SET tenthietbi='"+thietBi.getTenThietBi()+"'"+",soluong='"+thietBi.getSoLuong()+"'"+",ngaynhap='"+thietBi.getNgayNhap()+"' where id="+thietBi.getId();
            st.execute(txt_sql);
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean delete(ThietBi thietBi) {
        try {
            Statement st = Connected.getInstance().getStatement();
            String sql = "DELETE FROM thietbi WHERE id="+thietBi.getId();
            st.execute(sql);
        }catch (Exception e){
        }
        return false;
    }
}
