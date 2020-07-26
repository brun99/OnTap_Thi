package vn.edu.ntu.vancuong.ontap_thi.model;

public class ThongTin {
    String ten, ngaysinh, sdt, diaChi, giohoc, khoahoc;

    public ThongTin() {
    }

    public ThongTin(String ten, String ngaysinh, String sdt, String diaChi, String giohoc, String khoahoc) {
        this.ten = ten;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.giohoc = giohoc;
        this.khoahoc = khoahoc;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGiohoc() {
        return giohoc;
    }

    public void setGiohoc(String giohoc) {
        this.giohoc = giohoc;
    }

    public String getKhoahoc() {
        return khoahoc;
    }

    public void setKhoahoc(String khoahoc) {
        this.khoahoc = khoahoc;
    }
}
