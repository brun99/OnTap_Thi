package vn.edu.ntu.vancuong.ontap_thi.controller;

import java.util.List;

import vn.edu.ntu.vancuong.ontap_thi.model.ThongTin;

public interface IController {
    public List<ThongTin> getAllThongTin();
    public void add(ThongTin thongTin);
}
