package Project;

public class ThietBi {
    String maThietBi;
    String tenThietBi;
    String trangThai;
    Integer soLuong;
    String ngayNhap;

    public ThietBi(String maThietBi, String tenThietBi, String trangThai, Integer soLuong, String ngayNhap) {
        this.maThietBi = maThietBi;
        this.tenThietBi = tenThietBi;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.ngayNhap = ngayNhap;
    }

    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
