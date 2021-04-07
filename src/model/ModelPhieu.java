package model;
import java.sql.*;
import java.util.ArrayList;
import config.Connected;
import model.entity.Phieu;

public class ModelPhieu implements DataPhieu<Phieu> {

    @Override
    public ArrayList<Phieu> listPM() {
        ArrayList<Phieu> arrayList = new ArrayList<>();
        try {
            Statement st = Connected.getInstance().getStatement();
            String sql = "select * from phieu";
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()) {
                arrayList.add(new Phieu(resultSet.getInt("id"),
                        resultSet.getString("tenthietbi"),
                        resultSet.getString("soluong"),
                        resultSet.getString("ngay_muon"),
                        resultSet.getString("ngay_tra"),
                        resultSet.getInt("thietbi_id"),
                        resultSet.getInt("user_id")));
            }
        }catch (Exception e){
        }
        return arrayList;
    }

    @Override
    public boolean createP(Phieu phieu) {
        try {
            Statement stt = Connected.getInstance().getStatement();
            String txt = "insert into phieu(id,tenthietbi,soluong,ngay_muon,ngay_tra,thietbi_id,user_id) values(" +
                    ""+phieu.getId()+",'"+phieu.getTen()+"',"+phieu.getSoLuong()+",'"+phieu.getNgayMuon()+"','"+phieu.getNgayTra()+"','"+phieu.getTb_id()+"','"+phieu.getUs_id()+"')";
            stt.execute(txt);

            Statement stt1 = Connected.getInstance().getStatement();
            String so_luong_hien_tai = "select soluong from thietbi where id="+phieu.getTb_id();
            ResultSet rs = stt1.executeQuery(so_luong_hien_tai);
            Integer x = 0;
            while (rs.next()){
                x = rs.getInt("soluong");
            }
            Integer so_luong_tb_con = x - Integer.parseInt(phieu.getSoLuong());
            Statement stt3 = Connected.getInstance().getStatement();
            String txt3 = "UPDATE thietbi SET soluong='" + so_luong_tb_con + "' where id=" + phieu.getTb_id();
            stt3.execute(txt3);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateP(Phieu phieu) {
        try {
            Statement st1 = Connected.getInstance().getStatement();
            String txt_sql = "UPDATE phieu SET tenthietbi='"+phieu.getTen()+"'"+",soluong="+phieu.getSoLuong()+",ngay_muon='"+phieu.getNgayMuon()+"'"+",ngay_tra='"+phieu.getNgayTra()+"',thietbi_id='"+phieu.getTb_id()+"',user_id='"+phieu.getUs_id()+"' where id="+phieu.getId();
            st1.execute(txt_sql);
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean deleteP(Phieu phieu) {
        try {
            Statement stt1 = Connected.getInstance().getStatement();
            String sql = "DELETE FROM phieu WHERE id="+phieu.getId();
            stt1.execute(sql);
        }catch (Exception e){
        }
        return false;
    }
}
