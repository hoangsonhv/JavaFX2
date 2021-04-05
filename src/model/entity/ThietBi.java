package model.entity;

public class ThietBi {
    String Id;
    String tenThietBi;
    String soLuong;
    String ngayNhap;

    public ThietBi(String id, String tenThietBi, String soLuong, String ngayNhap) {
        Id = id;
        this.tenThietBi = tenThietBi;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}

