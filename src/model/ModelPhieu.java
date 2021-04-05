package model;
import java.sql.*;
import java.util.ArrayList;
import config.Connected;
import model.entity.Phieu;
import model.entity.NguoiDung;
import model.ModelNguoiDung;
import model.ModelThietBi;
import model.entity.ThietBi;

public class ModelPhieu implements DataPhieu<Phieu> {

    @Override
    public ArrayList<Phieu> listPM() {
        ArrayList<Phieu> arrayList = new ArrayList<>();
        try {
            Statement st = Connected.getInstance().getStatement();
            String sql = "SELECT * FROM phieu";
            ResultSet resultSet = st.executeQuery(sql);
            while (resultSet.next()){
                arrayList.add(new Phieu(resultSet.getInt("id"),resultSet.getString("tenthietbi"),resultSet.getInt("soluong"),resultSet.getString("ngay_muon"),resultSet.getString("ngay_tra"),resultSet.getInt("thietbi_id"),resultSet.getInt("user_id")));
            }
        }catch (Exception e){
        }
        return arrayList;
    }


    @Override
    public boolean create(Phieu phieu) {
        try {
            Statement stt = Connected.getInstance().getStatement();
            String txt = "insert into phieu(id,tenthietbi,soluong,ngay_muon,ngay_tra,thietbi_id,user_id) values(" +
                    ""+phieu.getId()+",'"+phieu.getTen()+"',"+phieu.getSoLuong()+",'"+phieu.getNgayMuon()+"','"+phieu.getNgayTra()+"','"+phieu.getTb_id()+"','"+phieu.getUs_id()+"')";
            stt.execute(txt);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Phieu phieu) {
        try {
            Statement st = Connected.getInstance().getStatement();
            String txt_sql = "UPDATE phieu SET tenthietbi='"+phieu.getTen()+"'"+",soluong="+phieu.getSoLuong()+",ngay_muon='"+phieu.getNgayMuon()+"'"+",ngay_tra='"+phieu.getNgayTra()+"',thietbi_id='"+phieu.getTb_id()+"',user_id='"+phieu.getUs_id()+"' where id="+phieu.getId();
            st.execute(txt_sql);
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean delete(Phieu phieu) {
        try {
            Statement st = Connected.getInstance().getStatement();
            String sql = "DELETE FROM phieu WHERE id="+phieu.getId();
            st.execute(sql);
        }catch (Exception e){
        }
        return false;
    }
}
