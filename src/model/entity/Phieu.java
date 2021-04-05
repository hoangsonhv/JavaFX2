package model.entity;

public class Phieu {
    Integer id;
    String ten;
    Integer soLuong;
    String ngayMuon;
    String ngayTra;
    Integer tb_id;
    Integer us_id;

    public Phieu(Integer id, String ten, Integer soLuong, String ngayMuon, String ngayTra, Integer tb_id, Integer us_id) {
        this.id = id;
        this.ten = ten;
        this.soLuong = soLuong;
        this.ngayMuon = ngayMuon;
        this.ngayTra = ngayTra;
        this.tb_id = tb_id;
        this.us_id = us_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Integer getTb_id() {
        return tb_id;
    }

    public void setTb_id(Integer tb_id) {
        this.tb_id = tb_id;
    }

    public Integer getUs_id() {
        return us_id;
    }

    public void setUs_id(Integer us_id) {
        this.us_id = us_id;
    }
}
